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
 * @author Martin Pfeffer
 *         <a href="mailto:martin.pfeffer@celox.io">martin.pfeffer@celox.io</a>
 * @see <a href="https://celox.io">https://celox.io</a>
 */
public class GeographicUtils {

    /**
     * Nmea to degree double.
     *
     * @param nmea the nmea
     * @return the double
     */
    public static double nmeaToDegree(double nmea) {
        return Math.floor(nmea / 100d) + (nmea / 100d - Math.floor(nmea / 100d)) / 60d * 100d;
    }

    /**
     * Degree to nmea double.
     *
     * @param degree the degree
     * @return the double
     */
    public static double degreeToNmea(double degree) {
        return (Math.floor(degree) + (degree - Math.floor(degree)) * 60d / 100d) * 100d;
    }

    /**
     * Distance between 2 geo positions in meters double.
     *
     * @param latA the lat a
     * @param lngA the lng a
     * @param latB the lat b
     * @param lngB the lng b
     * @return the double
     */
    public static double distanceBetweenGeoPositionsInMeters(double latA, double lngA, double latB, double lngB) {
        double earthRadius = 6371;
        double dLat = Math.toRadians(latB - latA);
        double dLng = Math.toRadians(lngB - lngA);
        double a = Math.sin(dLat / 2)
                * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(latA))
                * Math.cos(Math.toRadians(latB))
                * Math.sin(dLng / 2)
                * Math.sin(dLng / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (int) (earthRadius * c * 1000);
    }

    /**
     * Bearing as coord string.
     *
     * @param bearing the bearing
     * @return the string
     */
    public static String bearingAsCoord(int bearing) {
        String coordNames[] = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW", "N"};
        double directions = Math.round(bearing / 22.5);
        if (directions < 0) {
            directions = directions + 16;
        }
        return coordNames[(int) directions];
    }

}
