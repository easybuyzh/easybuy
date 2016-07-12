package sdkd.com.ec.service.impl;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by zhaoshuai on 2016/7/11.
 */
public class UploadService {
    public static  String PREPATH = "C:\\Users\\zhaoshuai\\Desktop\\easybuy\\web\\images\\product\\";
    public String readFile(String path,String storepath){
        File file = new File(path);
        if(file.exists() == false) return null;
        try {
            BufferedInputStream bis= new BufferedInputStream(new FileInputStream(new File(path)));
            StringBuilder all = new StringBuilder("");

            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(storepath)));
            int len ;
            byte[] buf = new byte[1024];
            while((len = bis.read(buf)) != -1){
                bos.write(buf,0,len);
            }
            bos.flush();
            bos.close();
            bis.close();
            return all.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean uploadPicture(String path){
          File te = new File(path);
          if(!te.exists()) return false;
          String storepath = PREPATH + te.getName();
          this.readFile(path,storepath);
          return true;
    }
}
