package cn.zhangle.untils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Classname Md5Utils
 * @Description TODO
 * @Date 2020/12/17 18:30
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class Md5Utils {

    public static void main(String[] args) {
        String s = md5("123456");
        System.out.println(s);
    }

    public static String md5(String str){

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("utf-8"));
            byte[] digest = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1,digest);
            String secret = bigInteger.toString(16);
            return secret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
