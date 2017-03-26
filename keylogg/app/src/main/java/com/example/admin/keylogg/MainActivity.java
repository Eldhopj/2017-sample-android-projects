package com.example.admin.keylogg;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        Button b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanQR(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void scanQR(View v) {

        try {

            //start the scanning activity from the com.google.zxing.client.android.SCAN intent

            Intent intent = new Intent(ACTION_SCAN);

            intent.putExtra("SCAN_MODE", "QR_CODE_MODE");

            startActivityForResult(intent, 0);

        } catch (ActivityNotFoundException anfe) {

            showDialog(this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();

        }


    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if (requestCode == 0) {

            if (resultCode == RESULT_OK) {

                //get the extras that are returned from the intent

                String contents = intent.getStringExtra("SCAN_RESULT");

                String format = intent.getStringExtra("SCAN_RESULT_FORMAT");

                //Toast toast = Toast.makeText(this, "Content:" + contents + " Format:" + format, Toast.LENGTH_LONG);

                //toast.show();
                //if(contents.charAt(0)=='1') {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("QR", contents);
                    startActivity(i);
               // }
            }

        }

    }
    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {

        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);

        downloadDialog.setTitle(title);

        downloadDialog.setMessage(message);

        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {

                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);

                try {

                    act.startActivity(intent);

                } catch (ActivityNotFoundException anfe) {



                }

            }

        });

        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialogInterface, int i) {

            }

        });

        return downloadDialog.show();

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.admin.keylogg/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.admin.keylogg/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
