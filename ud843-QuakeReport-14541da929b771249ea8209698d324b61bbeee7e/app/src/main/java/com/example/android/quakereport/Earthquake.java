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
package com.example.android.quakereport;

/**
 * An {@link Earthquake} object contains information related to a single earthquake.
 */
public class Earthquake {

    /** Magnitude of the earthquake */
    private String mUniversity;

    /** Location of the earthquake */
    private String mcollege;
    /** Time of the earthquake */
    private String mcollegeType;
    /** Website URL of the earthquake */
    private String mState;

    private String mDistrict;

    public Earthquake(String university, String college, String collegeType, String state, String district) {
        mUniversity = university;
        mcollege = college;
        mcollegeType = collegeType;
        mState = state;
        mDistrict = district;
    }

    /**
     * Returns the magnitude of the earthquake.
     */
    public String getuniversity() {
        return mUniversity;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getcollege() {
        return mcollege;
    }

    /**
     * Returns the time of the earthquake.
     */
    public String getcollegetype() {
        return mcollegeType;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getstate() {
        return mState;
    }

    public String getdistrict () {
        return mDistrict;
    }
}
