/*
 * Copyright (c) 2016 Martin Pfeffer
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

/**
 * The type Version format utils.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class VersionFormatUtils {

    /**
     * Format build number string.
     *
     * @param buildNumber the build number
     * @return the string
     */
    public static String formatBuildNumber(String buildNumber) {
        String res = "";
        int number = Integer.parseInt(buildNumber);

        if (number < 10) {
            buildNumber = "00" + buildNumber;
        } else if (number < 100) {
            buildNumber = "0" + buildNumber;
        }

        for (int i = 0; i < buildNumber.length(); i++) {
            res += (res.length() == 0 ? "" : ".") + buildNumber.charAt(i);
        }

        return res;
    }

}
