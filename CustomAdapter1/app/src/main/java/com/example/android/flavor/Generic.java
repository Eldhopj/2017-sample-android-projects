/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.flavor;


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
