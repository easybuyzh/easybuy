package sdkd.com.ec.service;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.*;
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

    public List<EbProductCategory> getProductCategoryTable() {
        return new EbProductCategoryDao().getProductCatagreys();
    }

    public List<EbNotice> getNoticeTable() {
        return new EbNoticeDao().getNotice();
    }

    public List<EbProduct> getBargainProductList() {
        List<EbProduct> all = getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for (EbProduct x : all) {
            if (x.getEpBargain().compareTo("" + 1) == 0) {
                res.add(x);
                if (res.size() == Integer.valueOf(getPro("BargainProductMaxmumShowNumber")))
                    break;
            }
        }
        return res;
    }

    public List<EbProduct> getHotProductList() {
        List<EbProduct> all = getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        int lim = Math.min(all.size(), Integer.valueOf(getPro("HotProductMaxmumShowNumber")));
        for (int i = 0; i < lim; i++) {
            res.add(all.get(i));
        }
        return res;
    }

    public List<EbProduct> getProductListByCategory(String id) {
        List<EbProduct> all = this.getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for (EbProduct x : all) {
            if (x.getEpcId().compareTo(id) == 0) {
                res.add(x);
            }
        }
        return res;
    }

    public boolean insertComment(String guestName, String guestContent, String nowTime) {
        EbCommentDao te = new EbCommentDao();
        return te.InsertComment(guestName, guestContent, nowTime);
    }

    public boolean IsUserExists(String name, String password) {
        return new EbUserDao().CheckUser(name, password);
    }

    public boolean RegisterUser(String name, String password) {
        return new EbUserDao().InsertUser(name, password);
    }

    public boolean ViewProductForOneTime(String id) {
       return  new EbProductDao().ViewProductForOneTime(id);
    }

    public EbProduct getProductById(String id) {
        EbProductDao productDao = new EbProductDao();
        List<EbProduct> list = productDao.getProducts();
        EbProduct ebp = null;
        for (EbProduct ebp1 : list) {
            if (ebp1.getEpId().equals("" + id)) {
                ebp = ebp1;
                break;
            }
        }
        return ebp;
    }
    public boolean insertOneProductIntoCart(String userName , String ProductId,String ProductCount){
              String userId = new EbUserDao().getUserIdByName(userName);
              List<EbViewCartDetail> pre = getCart(userName);
              for(EbViewCartDetail x : pre){
                      if(x.getEcaProductId().equals(ProductId))
                              return true;  // 该用户已经被用过了
              }
              return new EbCartDao().insertCart(userId,ProductId,ProductCount);
    }
    public List<EbViewCartDetail> getCart(String userName){
              return new EbViewCartDetailDao().getCartByUserName(userName);
    }
    public String getCartCost(String userName){
        List<EbViewCartDetail> all = this.getCart(userName);
        int money = 0;
        for(EbViewCartDetail x : all){
               money += Integer.valueOf(x.getCostByQuantity());
        }
        return String.valueOf(money);
    }
    /*
    提交订单功能，要先创建一个新的订单 , 并将购物车里的商品添加到OrderDetail表格中，并清空该用户的购物车
    */
    public void CommitOrderByCart(String userName){
           String OrderId = new EbOrderDao().createNewOrderByUserId(new EbUserDao().getUserIdByName(userName) , getCartCost(userName));
           List<EbViewCartDetail> all = getCart(userName);
           for(EbViewCartDetail x : all){
                 new EbOrderDetailDao().insertOrderDetail(OrderId , x.getEcaProductId() , x.getEcaProductCount());
           }
           new EbCartDao().clearCartbyuserId(new EbUserDao().getUserIdByName(userName));
    }
}
