package cn.zhangle.untils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * @Classname RandUtils
 * @Description TODO
 * @Date 2020/12/17 19:17
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class RandUtils {
    //当前时间 + 随机数
    public static String createActive(){

        return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
    }
    public static String getTime(){
        return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
    }
    //生成订单编号
    public static String createOrderId(){
        return getTime();
    }
}
