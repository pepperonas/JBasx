/*
 *    Copyright (c) 2018 Martin Pfeffer
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.pepperonas.jbasx.math;

import com.pepperonas.jbasx.log.Log;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The type Convert utils test.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class ConvertUtilsTest {

    private static final String TAG = "ConvertUtilsTest";


    /**
     * Test ms to kmh.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMsToKmh() throws Exception {
        float v = ConvertUtils.meterPerSecondToKmh(100f);
        Log.d(TAG, "testMsToKmh " + v);
        Assert.assertEquals(360.0f, v);
    }


    /**
     * Test ms to kmh double.
     *
     * @throws Exception the exception
     */
    @Test
    public void testMsToKmh_double() throws Exception {
        double v = ConvertUtils.meterPerSecondToKmh(20.33f);
        Log.d(TAG, "testMsToKmh_double " + v);
        Assert.assertEquals(73.18799591064453, v);
    }


    /**
     * Test celsius to fahrenheit.
     *
     * @throws Exception the exception
     */
    @Test
    public void testCelsiusToFahrenheit() throws Exception {
        double v = ConvertUtils.celsiusToFahrenheit(223.874d);
        Log.d(TAG, "testCelsiusToFahrenheit " + v);
        Assert.assertEquals(434.9732d, v, 0.000001d);
    }


    /**
     * Test fahrenheit to celsius.
     *
     * @throws Exception the exception
     */
    @Test
    public void testFahrenheitToCelsius() throws Exception {
        double v = ConvertUtils.fahrenheitToCelsius(87);
        Log.d(TAG, "testFahrenheitToCelsius " + v);
        Assert.assertEquals(30.555556d, v, 0.000001d);
    }

}
