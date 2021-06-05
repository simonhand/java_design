package cn.zhangle.untils;

/**
 * @Classname StringUtils
 * @Description TODO
 * @Date 2020/12/17 18:55
 * @Created by zl363
 * 仙人保佑，阿乐代码永无bug
 */
public class StringUtils {
    public static boolean isEmpty(String str){
        if (str==null || str.trim().length()==0){
            return true;
        }
        else {
            return false;
        }
    }
}
