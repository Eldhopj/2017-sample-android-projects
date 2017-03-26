package com.example.android.quakereport;


public class Generic {
    private double mMag;


    private String mCity1;
    private  String mCity2;


    private String mDate;




    public Generic(double mag , String city1 , String city2, String date)
    {
        mMag = mag;
        mCity1 = city1;
        mCity2 = city2;
        mDate = date;


    }


    public String getCity1() {
        return mCity1;
    }

    public String getCity2() {
        return mCity2;
    }


    public double getMag() {
        return mMag;
    }

    public String getDate () {
        return mDate;

}

}
