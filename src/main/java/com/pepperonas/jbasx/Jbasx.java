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

package com.pepperonas.jbasx;

import com.pepperonas.jbasx.io.IoUtils;

import java.io.File;

/**
 * The type Jbasx.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class Jbasx {

    /**
     * The constant TAG.
     */
    public static final String TAG = "Jbasx";

    /**
     * The constant BUILD_NUMBER.
     */
    public static final String BUILD_NUMBER = "16";

    private static final String LIBRARY_NAME = "jbasx";

    private static String mLogFilePath = new File(System.getProperty("user.home")).getPath();
    private static String mLogFileName = "jbasx.log";
    private static boolean mFileLog = false;
    private static boolean mTimestamp = true;
    private static String mUid = "";


    /**
     * Gets unique log id.
     *
     * @return the unique log id
     */
    public static String getUniqueLogId() {
        return mUid;
    }


    /**
     * Write log boolean.
     *
     * @return the boolean
     */
    public static boolean writeLog() {
        return mFileLog;
    }


    /**
     * Write log with stamp boolean.
     *
     * @return the boolean
     */
    public static boolean writeLogWithStamp() {
        return mTimestamp;
    }


    /**
     * Gets log file name.
     *
     * @return the log file name
     */
    public static String getLogFileName() {
        return mLogFileName;
    }


    /**
     * Gets log file path.
     *
     * @return the log file path
     */
    public static String getLogFilePath() {
        return mLogFilePath;
    }


    /**
     * The enum Log mode.
     */
    public enum LogMode {
        /**
         * None log mode.
         */
        NONE(-1), /**
         * Default log mode.
         */
        DEFAULT(0), /**
         * All log mode.
         */
        ALL(3);

        private final int mode;


        /**
         * Instantiates a new Log mode.
         *
         * @param i the
         */
        LogMode(int i) {this.mode = i;}
    }


    /**
     * The constant mLog.
     */
    public static LogMode mLog = LogMode.DEFAULT;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println(Version.getVersion());
    }


    /**
     * Set the log behaviour.
     *
     * @param logMode the log mode
     * @see LogMode
     */
    public static void setLog(LogMode logMode) {
        mLog = logMode;
    }


    /**
     * Write the log to a text file.
     *
     * @param path      where the file should be stored.
     * @param fileName  The filename of the text file.
     * @param timestamp Whenever a timestamp should be set or not.
     */
    public static void setLogWriter(String path, String fileName, boolean timestamp) {
        Jbasx.setLog(LogMode.ALL);
        mLogFilePath = path;
        mLogFileName = fileName;
        mFileLog = true;
        mTimestamp = timestamp;
    }


    /**
     * Sets unique identifier.
     *
     * @param uniqueIdentifier the unique identifier
     */
    public static void setUniqueIdentifier(String uniqueIdentifier) {
        mUid = uniqueIdentifier;
    }


    /**
     * The type Version.
     */
    public static class Version {

        /**
         * Gets version.
         *
         * @return the version
         */
        public static String getVersion() {
            return getVersionNumber() + "." + getBuildNumber();
        }


        /**
         * Gets version number.
         *
         * @return the version number
         */
        public static String getVersionNumber() {
            String content = IoUtils.readFast("pom.xml");
            return content.split("<version\\.number>")[1].split("\n")[0].replace("</version.number>", "");
        }


        /**
         * Gets build number.
         *
         * @return the build number
         */
        public static String getBuildNumber() {
            String content = IoUtils.readFast("pom.xml");
            return content.split("<build\\.number>")[1].split("\n")[0].replace("</build.number>", "");
        }


        /**
         * Gets license.
         *
         * @return the license text.
         */
        public static String getLicense() {
            return "Copyright (c) 2017 Martin Pfeffer\n" +
                   " \n" +
                   "Licensed under the Apache License, Version 2.0 (the \"License\");\n" +
                   "you may not use this file except in compliance with the License.\n" +
                   "You may obtain a copy of the License at\n" +
                   " \n" +
                   "     http://www.apache.org/licenses/LICENSE-2.0\n" +
                   " \n" +
                   "Unless required by applicable law or agreed to in writing, software\n" +
                   "distributed under the License is distributed on an \"AS IS\" BASIS,\n" +
                   "WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" +
                   "See the License for the specific language governing permissions and\n" +
                   "limitations under the License.";
        }
    }

}
