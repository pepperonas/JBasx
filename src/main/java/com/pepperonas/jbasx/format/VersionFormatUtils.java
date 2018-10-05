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

package com.pepperonas.jbasx.format;

/**
 * The type Version format utils.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class VersionFormatUtils {


    /**
     * Format version code string.
     *
     * @param versionCode the version code
     * @return the string
     */
    public static String formatVersionCode(String versionCode) {
        String res = "";
        int number = Integer.parseInt(versionCode);

        if (number < 10) {
            versionCode = "00" + versionCode;
        } else if (number < 100) {
            versionCode = "0" + versionCode;
        }

        for (int i = 0; i < versionCode.length(); i++) {
            res += (res.length() == 0 ? "" : ".") + versionCode.charAt(i);
        }

        return res;
    }

}
