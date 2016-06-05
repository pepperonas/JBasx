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

package com.pepperonas.jbasx.network;

import com.pepperonas.jbasx.Jbasx;
import com.pepperonas.jbasx.log.Log;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * The type Network base utils.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class NetworkBaseUtils {

    private static final String TAG = "NetworkBaseUtils";


    /**
     * Gets ip address.
     *
     * @param useIpV4 the use ip v 4
     * @return the ip address
     */
    public static String getIpAddress(boolean useIpV4) {
        String ip = "";
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        ip = addr.getHostAddress();
                        boolean isIPv4 = ip.indexOf(':') < 0;
                        if (useIpV4) {
                            if (isIPv4) {
                                return ip;
                            }
                        } else {
                            if (!isIPv4) {
                                int delim = ip.indexOf('%');
                                return delim < 0 ? ip.toUpperCase() : ip.substring(0, delim).toUpperCase();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "getIpAddress: " + e);
        }
        return ip;
    }


    /**
     * Collect network addresses.
     * Requires android.Manifest.permission#INTERNET
     *
     * @param onlyIps Whenever only IP-addresses should be shown.
     * @return {@link List<String>} containing network addresses.
     */
    public static List<String> getNetworkAddresses(boolean onlyIps) {
        List<String> ipList = new ArrayList<>();
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
                NetworkInterface nwInterface = en.nextElement();
                for (Enumeration<InetAddress> ipAddress = nwInterface.getInetAddresses(); ipAddress.hasMoreElements(); ) {
                    String ip;
                    if (onlyIps) {
                        ip = ipAddress.nextElement().toString().replace("/", "");
                        if (ip.contains(".")) {
                            ipList.add(ip);
                        }
                    } else {
                        ip = ipAddress.nextElement().toString();
                        ipList.add(ip);
                    }
                }
            }
        } catch (SocketException e) {
            if (Jbasx.mLog == Jbasx.LogMode.ALL) {
                Log.e(TAG, "getNetworkAddresses - Retrieving network interfaces failed.");
                e.printStackTrace();
            }
        }
        return ipList;
    }


    /**
     * Check hosts.
     *
     * @param subnet  the subnet
     * @param timeout the timeout
     * @return the list
     */
    public List<String> getHosts(String subnet, int timeout) {
        List<String> hosts = new ArrayList<>();
        for (int i = 1; i < 255; i++) {
            String host = subnet + "." + i;
            try {
                if (InetAddress.getByName(host).isReachable(timeout)) {
                    hosts.add(host);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hosts;
    }

}
