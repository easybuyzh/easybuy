package sdkd.com.ec.util;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
public class Utils {
    /*来自Jsp页面的中文数据乱码问题，需要借助该甘薯format一下*/
    public static String JspStringFormat(String x) {
        if(x == null) return null;
       // return x;
        try {
            return new String(x.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getNowTimeInMysqlFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return sdf.format(now);
    }
    public static  boolean CheckInt(String val){
          for(int i = 0 ; i<val.length() ; i++){
                 if(val.charAt(i) < '0' || val.charAt(i) > '9') return false;
          }
          return true;
    }
}
