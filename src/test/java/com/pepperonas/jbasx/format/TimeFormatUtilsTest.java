/*
 * Copyright (c) 2017 Martin Pfeffer
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

package com.pepperonas.jbasx.format;

import com.pepperonas.jbasx.log.Log;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Date;

/**
 * The type Time format utils test.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class TimeFormatUtilsTest {

    private static final String TAG = "TimeFormatUtilsTest";


    /**
     * Test utc to local.
     *
     * @throws Exception the exception
     */
    @Test
    public void testUtcToLocal() throws Exception {
        String s = TimeFormatUtils.utcToLocal(new Date(1449919103945L));
        Log.d(TAG, "testUtcToLocal  " + s);
        Assert.assertEquals("2015-12-12 12:18:23", s);
    }


    /**
     * Test get timestamp lexical.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTimestampLexical() throws Exception {
        /*will fail if year >= 2100*/
        String s = TimeFormatUtils.getTimestampLexical(true);
        Assert.assertTrue(s.length() == 14 && s.substring(0, 2).equals("20"));
        Log.d(TAG, "testGetTimestampLexical (incl. sec.)    " + s);

        s = TimeFormatUtils.getTimestampLexical(false);
        Assert.assertTrue(s.length() == 12 && s.substring(0, 2).equals("20"));
        Log.d(TAG, "testGetTimestampLexical (no sec.)       " + s);
    }


    /**
     * Test get timestamp.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTimestamp() throws Exception {
        /*will fail if year >= 2100*/
        String s = TimeFormatUtils.getTimestamp(TimeFormatUtils.Format.NONE);
        Assert.assertTrue(s.length() > 10 && s.substring(4, 6).equals("20"));
        Log.d(TAG, "testGetTimestamp (NONE)          " + s);

        s = TimeFormatUtils.getTimestamp(TimeFormatUtils.Format.FILE_SHOW_SEC);
        Assert.assertTrue(s.length() > 10 && s.substring(6, 8).equals("20"));
        Log.d(TAG, "testGetTimestamp (FILE_SHOW_SEC) " + s);

        s = TimeFormatUtils.getTimestamp(TimeFormatUtils.Format.GUI);
        Assert.assertTrue(s.length() > 10 && s.substring(6, 8).equals("20"));
        Log.d(TAG, "testGetTimestamp (GUI)           " + s);
    }


    /**
     * Test get timestamp millis.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetTimestampMillis() throws Exception {
        /*will fail if year >= 2100*/
        String s = TimeFormatUtils.getTimestampMillis();
        Assert.assertTrue(s.length() == 17 && s.substring(0, 2).equals("20"));
        Log.d(TAG, "testGetTimestampMillis  " + s);
    }


    /**
     * Test get daytime.
     *
     * @throws Exception the exception
     */
    @Test
    public void testGetDaytime() throws Exception {
        TimeFormatUtils.Daytime daytime = TimeFormatUtils.getDaytime();
        System.out.println(daytime);
        Assert.assertTrue(daytime.toString().equals("Morning")
                          || daytime.toString().equals("Afternoon")
                          || daytime.toString().equals("Evening")
                          || daytime.toString().equals("Night"));
    }


    /**
     * Test to time string.
     *
     * @throws Exception the exception
     */
    @Test
    public void testToTimeString() throws Exception {
        String timeString = TimeFormatUtils.toTimeString(60L * 60L * 1000L, false, false);
        System.out.println(timeString);

        timeString = TimeFormatUtils.toTimeString(60L * 60L * 1000L, false, true);
        System.out.println(timeString);

        timeString = TimeFormatUtils.toTimeString(60L * 60L * 100L, false, false);
        System.out.println(timeString);

        timeString = TimeFormatUtils.toTimeString(60L * 60L * 10L, false, false);
        System.out.println(timeString);

        timeString = TimeFormatUtils.toTimeString(60L * 60L * 10L, true, false);
        System.out.println(timeString);

        timeString = TimeFormatUtils.toTimeString(60L * 60L * 10L, true, true);
        System.out.println(timeString);

    }
}