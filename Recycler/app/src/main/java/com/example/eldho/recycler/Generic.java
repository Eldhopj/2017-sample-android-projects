package com.example.eldho.recycler;

public class Generic {

        private String mText3;


        private String mText2;

        // Drawable resource ID
        private int mImageResourceId;

        private String mTest1;

        /*
        * Create a new Generic object.
        *
        * @param text3
        * @param test2
        * @param image
        * */
        public Generic(String text3 , String text1 , String test2, int imageResourceId)
        {
            mText3 = text3;
            mTest1 = text1;
            mText2 = test2;
            mImageResourceId = imageResourceId;
        }

        /**
         * Get the name of the Android version
         */
        public String getText3() {
            return mText3;
        }

        /**
         * Get the Android version number
         */
        public String getText2() {
            return mText2;
        }

        /**
         * Get the image resource ID
         */
        public int getImageResourceId() {
            return mImageResourceId;
        }

        public String getText1(){ return mTest1;}


    }
