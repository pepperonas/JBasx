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

package com.pepperonas.jbasx.security;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * The type Crypt utils.
 *
 * @author Martin Pfeffer (pepperonas)
 */
public class CryptUtils {

    private static final String TAG = "CryptUtils";


    /**
     * Aes encrypt string.
     *
     * @param password the password
     * @param text     the text
     * @param iv       the iv
     * @return the string
     */
    public static String aesEncrypt(String password, String text, long iv) {
        Cipher cipher = null;
        SecretKeySpec key;
        AlgorithmParameterSpec spec;
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (digest != null) digest.update(password.getBytes());
        byte[] keyBytes = new byte[32];
        if (digest != null) System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        key = new SecretKeySpec(keyBytes, "AES");
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putLong(0, iv);
        byte[] _iv = bb.array();
        spec = new IvParameterSpec(_iv);
        try {
            if (cipher != null) {
                cipher.init(Cipher.ENCRYPT_MODE, key, spec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] encrypted = new byte[0];
        try {
            if (cipher != null) {
                encrypted = cipher.doFinal(text.getBytes("UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String encryptedText = null;
        try {
            encryptedText = new String(com.pepperonas.jbasx.android.Base64.encode(encrypted, com.pepperonas.jbasx.android.Base64.NO_WRAP), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }


    /**
     * Aes decrypt string.
     *
     * @param password    the password
     * @param cryptedText the crypted text
     * @param iv          the iv
     * @return the string
     */
    public static String aesDecrypt(String password, String cryptedText, long iv) {
        Cipher cipher = null;
        SecretKeySpec key;
        AlgorithmParameterSpec spec;
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (digest != null) digest.update(password.getBytes());
        byte[] keyBytes = new byte[32];
        if (digest != null) System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        } catch (Exception e) {
            e.printStackTrace();
        }
        key = new SecretKeySpec(keyBytes, "AES");
        ByteBuffer bb = ByteBuffer.allocate(16);
        bb.putLong(0, iv);
        byte[] _iv = bb.array();
        spec = new IvParameterSpec(_iv);
        try {
            if (cipher != null) {
                cipher.init(Cipher.DECRYPT_MODE, key, spec);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte[] bytes = com.pepperonas.jbasx.android.Base64.decode(cryptedText, com.pepperonas.jbasx.android.Base64.DEFAULT);
        byte[] decrypted = new byte[0];
        try {
            if (cipher != null) {
                decrypted = cipher.doFinal(bytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String decryptedText = null;
        try {
            decryptedText = new String(decrypted, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decryptedText;
    }

}