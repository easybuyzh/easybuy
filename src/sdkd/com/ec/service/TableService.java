package sdkd.com.ec.service;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.EbCommentDao;
import sdkd.com.ec.dao.impl.EbNewsDao;
import sdkd.com.ec.dao.impl.EbProductDao;
import sdkd.com.ec.dao.impl.EbUserDao;
import sdkd.com.ec.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
public class TableService extends BaseDao {
    public List<EbComment> getCommentTable() {
        return new EbCommentDao().getComments();
    }

    public List<EbNews> getNewsTable() {
        return new EbNewsDao().getNews();
    }

    public List<EbProduct> getProductTable() {
        return new EbProductDao().getProducts();
    }

    public List<EbUser> getUserTable() {
        return new EbUserDao().getEbUsers();
    }

    public List<EbProduct> getHotProductList(){
        List<EbProduct> all = getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for(EbProduct x : all){
               if(x.getEpBargain().compareTo("" + 1) == 0){
                      res.add(x);
               }
        }
        return res;
    }
}
