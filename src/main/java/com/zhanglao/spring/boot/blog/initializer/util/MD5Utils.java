package com.zhanglao.spring.boot.blog.initializer.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MD5Utils {
	
    
    private static MessageDigest messagedigest = null;
    
    static{
        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
    }
    
    
    public static String getStreamMD5String(InputStream input) {
        try {
            byte[] buffer = new byte[8192];
            int length;
            while ((length = input.read(buffer)) != -1) {
                messagedigest.update(buffer, 0, length);
            }
            return new String(Hex.encodeHex(messagedigest.digest()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getMD5String(String s){
        return DigestUtils.md5Hex(s);
    }

    public static String getMD5String(byte[] bytes) {
        return DigestUtils.md5Hex(bytes);
    }
    
    public static boolean checkPassword(String password, String md5PwdStr){
        String s = getMD5String(password);
        return s.equals(md5PwdStr);
    }

}
