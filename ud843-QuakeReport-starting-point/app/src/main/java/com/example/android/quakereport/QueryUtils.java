package com.example.android.quakereport;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.example.android.quakereport.EarthquakeActivity.LOG_TAG;

/**
 * Helper methods related to requesting and receiving earthquake data from USGS.
 */
public final class QueryUtils {

    /** Sample JSON response for a USGS query */
    private static final String SAMPLE_JSON_RESPONSE ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    /**
     * Create a private constructor because no one should ever create a {@link QueryUtils} object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly from the class name QueryUtils (and an object instance of QueryUtils is not needed).
     */
    private QueryUtils() {
    }
    public static Generic fetchEarthquakeData(String requestUrl) {
        // Create URL object
        URL url = createUrl(requestUrl);

        // Perform HTTP request to the URL and receive a JSON response back
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        // Extract relevant fields from the JSON response and create an {@link Event} object
        Generic earthquake = extractFeatureFromJson(jsonResponse);

        // Return the {@link Event}
        return earthquake;
    }
    private static URL createUrl(String stringUrl) //helper method for creating url
    {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error with creating URL ", e);
        }
        return url;
    }
    /**
     * Return a list of {@link Generic} objects that has been built up from
     * parsing a JSON response.
     */
    public static ArrayList<Generic> extractEarthquakes() {


        // Create an empty ArrayList that we can start adding earthquakes to
        ArrayList<Generic> earthquakes = new ArrayList<>();


    }
        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        private static String makeHttpRequest(URL url) throws IOException {
            String jsonResponse = "";

            // If the URL is null, then return early.
            if (url == null) {
                return jsonResponse;
            }

            HttpURLConnection urlConnection = null;
            InputStream inputStream = null;
            try {
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(10000 /* milliseconds */);
                urlConnection.setConnectTimeout(15000 /* milliseconds */);
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // If the request was successful (response code 200),
                // then read the input stream and parse the response.
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                    jsonResponse = readFromStream(inputStream);
                } else {
                    Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Problem retrieving the earthquake JSON results.", e);
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
            return jsonResponse;
        }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

    private static Generic extractFeatureFromJson(String SAMPLE_JSON_RESPONSE) {
        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(SAMPLE_JSON_RESPONSE)) {
            return null;
        }


        try {
            JSONObject jsonObject = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray jsonArray = jsonObject.getJSONArray("features");

            for (int i =0; i<jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                JSONObject properties = obj.getJSONObject("properties");
               double magi= Double.parseDouble(properties.getString("mag"));
                String citytemp= properties.getString("place");

                String city1;
                String city2;
                if (citytemp.contains("of")) {                      // splitting of string
                    String[] parts = citytemp.split("of");
                    city1 = parts[0] + "of";
                    city2 = parts[1];
                }
                else {
                    city1 = "Near by";
                    city2 = citytemp;
                }

                Long date = Long.parseLong(properties.getString("time"));
                Date dateObject = new Date(date);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy, HH:MM a", Locale.getDefault());
                dateFormatter.setTimeZone(TimeZone.getTimeZone("IST"));
                String dateToDisplay = dateFormatter.format(dateObject);
                Generic generic = new Generic(magi,city1,city2,dateToDisplay);
                earthquakes.add(generic);
            }

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and

            // build up a list of Generic objects with the corresponding data.

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        // Return the list of earthquakes
        return earthquakes;
    }


}