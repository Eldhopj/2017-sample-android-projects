package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;




public class CustomAdapter extends ArrayAdapter<Generic> {
    private static final String LOG_TAG = CustomAdapter.class.getSimpleName();



    public CustomAdapter(Activity context, ArrayList<Generic> generics) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, generics);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Generic currentGeneric = getItem(position);
        TextView maginitue = (TextView) listItemView.findViewById(R.id.magnitue);
        String magvalue = maginitue.getText().toString();


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) maginitue.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentGeneric.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);







        maginitue.setText(Double.toString(currentGeneric.getMag()));

        double temp = currentGeneric.getMag();

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView city1TextView = (TextView) listItemView.findViewById(R.id.city1);
        // Get the version number from the current Generic object and
        // set this text on the number TextView
        city1TextView.setText(currentGeneric.getCity1());

        TextView city2TextView = (TextView) listItemView.findViewById(R.id.city2);

        city2TextView.setText(currentGeneric.getCity2());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon


        TextView testView = (TextView) listItemView.findViewById(R.id.date);

        testView.setText(currentGeneric.getDate());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;


    }
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}

