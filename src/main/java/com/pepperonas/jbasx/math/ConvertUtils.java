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

import com.pepperonas.jbasx.base.Constants;

/**
 * The type Convert utils.
 */
public class ConvertUtils {

    /**
     * Millisecond to minute long.
     *
     * @param millis the millis
     * @return the long
     */
    public static long millisecondToMinute(long millis) {
        return (millis * 1000L * 60L);
    }


    /**
     * Hour to millisecond long.
     *
     * @param millis the millis
     * @return the long
     */
    public static long hourToMillisecond(long millis) {
        return (millis * 1000L * 60L * 60L);
    }


    /**
     * Minute to second long.
     *
     * @param sec the sec
     * @return the long
     */
    public static long minuteToSecond(long sec) {
        return (sec * 60L);
    }


    /**
     * Hour to second long.
     *
     * @param sec the sec
     * @return the long
     */
    public static long hourToSecond(long sec) {
        return (sec * 60L * 60L);
    }


    /**
     * Meter per second to kmh float.
     *
     * @param velocityInMeterPerSecond the velocity in meter per second
     * @return the float
     */
    public static float meterPerSecondToKmh(float velocityInMeterPerSecond) {
        return (velocityInMeterPerSecond * 3.6f);
    }


    /**
     * Meter per second to mph float.
     *
     * @param velocityInMeterPerSecond the velocity in meter per second
     * @return the float
     */
    public static float meterPerSecondToMph(float velocityInMeterPerSecond) {
        return (velocityInMeterPerSecond * 2.23694f);
    }


    /**
     * Kmh to meter per second float.
     *
     * @param velocityInKmh the velocity in kmh
     * @return the float
     */
    public static float kmhToMeterPerSecond(float velocityInKmh) {
        return velocityInKmh / 3.6f;
    }


    /**
     * Mph to meter per second float.
     *
     * @param velocityInMph the velocity in mph
     * @return the float
     */
    public static float mphToMeterPerSecond(float velocityInMph) {
        return velocityInMph / 2.23694f;
    }


    /**
     * Celsius to fahrenheit double.
     *
     * @param celsius the celsius
     * @return the double
     */
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 1.8d) + 32.d;
    }


    /**
     * Celsius to kelvin double.
     *
     * @param celsius the celsius
     * @return the double
     */
    public static double celsiusToKelvin(double celsius) {
        return celsius - Constants.KELVIN_ZERO_CELSIUS;
    }


    /**
     * Fahrenheit to celsius double.
     *
     * @param fahrenheit the fahrenheit
     * @return the double
     */
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32d) / 1.8d;
    }


    /**
     * Fahrenheit to kelvin double.
     *
     * @param fahrenheit the fahrenheit
     * @return the double
     */
    public static double fahrenheitToKelvin(double fahrenheit) {
        return ((fahrenheit - 32d) / 1.8d) - Constants.KELVIN_ZERO_CELSIUS;
    }


    /**
     * Kelvin to celsius double.
     *
     * @param kelvin the kelvin
     * @return the double
     */
    public static double kelvinToCelsius(double kelvin) {
        return kelvin + Constants.KELVIN_ZERO_CELSIUS;
    }


    /**
     * Kelvin to fahrenheit double.
     *
     * @param kelvin the kelvin
     * @return the double
     */
    public static double kelvinToFahrenheit(double kelvin) {
        return ((kelvin + Constants.KELVIN_ZERO_CELSIUS) * 1.8d) + 32.d;
    }

}
