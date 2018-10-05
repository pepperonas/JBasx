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

/**
 * The type Calculation utils.
 */
public class CalculationUtils {

    private static final String TAG = "CalculationUtils";

    /**
     * Percent double.
     *
     * @param percentageValue the percentage value
     * @param basicValue      the basic value
     * @return the double
     */
    public static double percent(double percentageValue, double basicValue) {
        return (percentageValue * (double) 100 / basicValue);
    }


    /**
     * Round to half float.
     *
     * @param x the x
     * @return the float
     */
    public static float roundToHalf(float x) {
        return (float) (Math.ceil(x * 2) / 2);
    }


    /**
     * Find max int.
     *
     * @param values the values
     * @return the int
     */
    public static int findMax(int... values) {
        int max = Integer.MIN_VALUE;
        for (int i : values) {
            if (i > max) max = i;
        }
        return max;
    }

}
