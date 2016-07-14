package sdkd.com.ec.service;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.dao.impl.*;
import sdkd.com.ec.model.*;
import sdkd.com.ec.util.PageUtil;

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

    public List<EbProduct> getAllBargainProductList() {
        List<EbProduct> all = getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for (EbProduct x : all) {
            if (x.getEpBargain().compareTo("" + 1) == 0) {
                res.add(x);
            }
        }
        return res;
    }

    public EbNews getNewsByEnId(String EnId) {
        return new EbNewsDao().getNewByEnId(EnId);
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

    /////插入新公告
    public boolean insertNotice(String notice_title, String notice_content) {
        return new EbNoticeDao().insertNotice(notice_title, notice_content);
    }

    ////通过创建时间删除公告
    public boolean deleteNoticeByNoticeCreateTime(String NoticeCreateTime) {
        return new EbNoticeDao().deleteNoticeByNoticeCreateTime(NoticeCreateTime);
    }

    ////////更新修改过的公告
    public boolean updateNoticeByNoticeId(String NoticeId, String NoticeTitle, String NoticeContent) {
        return new EbNoticeDao().UpdateNoticeByNoticeId(NoticeId, NoticeTitle, NoticeContent);
    }

    /////////
    public EbNotice getNoticeByNoticeTime(String NoticeTime) {
        return new EbNoticeDao().getNoticeByNoticeTime(NoticeTime);
    }

    public EbNotice getNoticeByNoticeId(String NoitceId) {
        return new EbNoticeDao().getNoticeByNoticeId(NoitceId);
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
        return new EbProductDao().ViewProductForOneTime(id);
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

    public boolean insertOneProductIntoCart(String userName, String ProductId, String ProductCount) {
        String userId = new EbUserDao().getUserIdByName(userName);
        List<EbViewCartDetail> pre = getCart(userName);
        for (EbViewCartDetail x : pre) {
            if (x.getEcaProductId().equals(ProductId)) {
                new EbCartDao().IncCartQuantityUserId(new EbUserDao().getUserIdByName(userName),ProductId);
                return true;  // 该用户已经添加了该商品，商品的数量加1
            }
        }
        return new EbCartDao().insertCart(userId, ProductId, ProductCount);
    }

    public List<EbViewCartDetail> getCart(String userName) {
        return new EbViewCartDetailDao().getCartByUserName(userName);
    }

    public String getCartCost(String userName) {
        List<EbViewCartDetail> all = this.getCart(userName);
        int money = 0;
        for (EbViewCartDetail x : all) {
            money += Integer.valueOf(x.getCostByQuantity());
        }
        return String.valueOf(money);
    }

    /*
    提交订单功能，
                  1 对应商品数量减少
                  2 要先创建一个新的订单 ,
                  3 并将购物车里的商品添加到OrderDetail表格中，
                  4 并清空该用户的购物车
    */
    public boolean CommitOrderByCart(String userName) {
        List<EbViewCartDetail> all = getCart(userName);
        for (EbViewCartDetail x : all) {
            if (this.getProductStockByEpId(x.getEcaProductId()) < Integer.valueOf(x.getEcaProductCount()))
                return false;
            //库存不够返回false
        }
        for (EbViewCartDetail x : all) {
            if (this.updateProductStockByEpId(x.getEcaProductId(), -1 * Integer.valueOf(x.getEcaProductCount())) == false)
                return false;
            //更改商品库存失败时返回false
        }
        String OrderId = new EbOrderDao().createNewOrderByUserId(new EbUserDao().getUserIdByName(userName), getCartCost(userName));
        for (EbViewCartDetail x : all) {
            new EbOrderDetailDao().insertOrderDetail(OrderId, x.getEcaProductId(), x.getEcaProductCount());
        }
        new EbCartDao().clearCartbyuserId(new EbUserDao().getUserIdByName(userName));
        return true;
    }

    /*
        用于更新商品库存的函数，当change（可正可负） 使得stock小于零是返回false
    */
    public boolean updateProductStockByEpId(String EpId, int change) {
        EbProduct te = new EbProductDao().getProductByEpId(EpId);
        Integer stock = Integer.valueOf(te.getEpStock()) + change;
        if (stock < 0) return false;
        List<String> columnName = new ArrayList<String>();
        List<String> params = new ArrayList<String>();
        columnName.add("ep_stock");
        params.add(stock.toString());
        columnName.add("ep_id");
        params.add(EpId);
        return new EbProductDao().updateProductByEpId(columnName, params);
    }

    public int getProductStockByEpId(String EpId) {
        EbProduct te = new EbProductDao().getProductByEpId(EpId);
        return Integer.valueOf(te.getEpStock());
    }

    public boolean ReplyComment(String EcId, String Reply) {
        return new EbCommentDao().UpdateReplyByEcId(EcId, Reply);
    }

    public boolean DeleteCommentReply(String EcId) {
        return new EbCommentDao().UpdateReplyByEcId(EcId, "null");
    }

    public EbComment getCommentByEcId(String EcId) {
        return new EbCommentDao().getCommentByEcId(EcId);
    }

    public boolean deleteCommentByEcId(String EcId) {
        return new EbCommentDao().deleteCommentByEcId(EcId);
    }

    public boolean deleteNewsByEnId(String EnCreateTime) {
        return new EbNewsDao().deleteNewsByEnId(EnCreateTime);
    }

    public boolean updateNewsByEnId(String EnCreateTime, String EnTitle, String EnContent) {
        return new EbNewsDao().UpdateNewsByEnId(EnCreateTime, EnTitle, EnContent);
    }

    public boolean insertNews(String EnTitle, String EnContent) {
        return new EbNewsDao().insertNews(EnTitle, EnContent);
    }

    public EbOrderView getOrderViewByOrderID(String OrderId) {
        return new EbOrderViewDao().getOrderViewByOrderId(OrderId);
    }

    public List<EbOrderView> getOrderViews() {
        return new EbOrderViewDao().getOrderViews();
    }

    public boolean deleteOrderByEoId(String OrderId) {
        return new EbOrderDao().deleteOrderByOrderId(OrderId);
    }

    public boolean updateOrderByEoId(String EoId, String EoStatus) {
        return new EbOrderDao().updateOrderByOrderId(EoId, EoStatus);
    }

    public boolean InsertUser(List<String> columnName, List<String> params) {
        return new EbUserDao().InsertUser(columnName, params);
    }

    public boolean updateUserByUserId(String UserId, List<String> params) {
        return new EbUserDao().updateUserByUserId(UserId, params);
    }

    public boolean deleteUserByEuUserId(String EuUserId) {
        return new EbUserDao().deleteUserByEuUserId(EuUserId);
    }

    public EbUser getUserByUserId(String EuUserId) {
        return new EbUserDao().getUserByUserId(EuUserId);
    }

    public boolean insertProductCategory(String EpcName, String EpcParentId) {
        return new EbProductCategoryDao().insertProductCategory(EpcName, EpcParentId);
    }

    public boolean updateProductCategoryByEpcId(String EpcId, String EpcName, String EpcParentId) {
        return new EbProductCategoryDao().updateProductCategoryByEpcId(EpcId, EpcName, EpcParentId);
    }

    public boolean deleteProductCategoryByEpcId(String EpcId) {
        return new EbProductCategoryDao().deleteProductCategoryByEpcId(EpcId);
    }

    public EbProductCategory getProductCategory(String EpcId) {
        return new EbProductCategoryDao().getProductCategoryByEpcId(EpcId);
    }

    //  获取所有的根分类，根分类即其父分类为0
    public List<EbProductCategory> getRootProductCategory() {
        List<EbProductCategory> all = this.getProductCategoryTable();
        List<EbProductCategory> res = new ArrayList<EbProductCategory>();
        for (EbProductCategory x : all) {
            if (x.getEpcParentId().compareTo("0") == 0) {
                res.add(x);
                // System.out.println(x.getEpcName() + " *** ");
            }
        }
        return res;
    }

    public boolean deleteProductByEpId(String EpId) {
        return new EbProductDao().deleteProductByEpId(EpId);
    }

    public EbProduct getProductByEpId(String EpId) {
        return new EbProductDao().getProductByEpId(EpId);
    }

    public boolean insertProduct(List<String> ColumnList, List<String> params) {
        return new EbProductDao().insertProduct(ColumnList, params);
    }

    public boolean updateProduct(List<String> ColumnList, List<String> params) {
        return new EbProductDao().updateProductByEpId(ColumnList, params);
    }

    public boolean RecordBrowse(String userName, String EpId) {
        if (userName == null) return false;
        String userId = new EbUserDao().getUserIdByName(userName);
        EbProduct te = new EbProductDao().getProductByEpId(EpId);
        return new EbRecentBrowseDao().insertNewBrowse(userId, te.getEpId(), te.getEpName(), te.getEpProductIcon());
    }

    public List<EbRecentBrowse> getRecentBrowseList(String userName) {
        String userId = new EbUserDao().getUserIdByName(userName);
        return new EbRecentBrowseDao().getRecentBrowseByUserId(userId, "desc");
    }

    public EbUser getUserByUserName(String userName) {
        return this.getUserByUserId(new EbUserDao().getUserIdByName(userName));
    }

    public boolean isManager(String userName) {
        if (userName == null) return false;
        EbUser user = this.getUserByUserName(userName);
        return (Integer.valueOf(user.getEuRole()) == 1);
    }

    public List<EbProduct> getProductListByCategoryInSpecificPage(String EpcId, int page) {
        PageUtil<EbProduct> util = new PageUtil<EbProduct>();
        return util.getSpecificPageList(this.getProductListByCategory(EpcId), page);
    }

    public int getProductListPageCountByCategory(String EpcId) {
        PageUtil<EbProduct> util = new PageUtil<EbProduct>();
        return util.getPageCount(this.getProductListByCategory(EpcId));
    }

    public String getUserIdByUserName(String userName) {
        if (userName == null) return null;
        return new EbUserDao().getUserIdByName(userName);
    }

    public List<EbOrderView> getOrderViewByEoId(String EoId) {
        EbOrderView te = this.getOrderViewByOrderID(EoId);
        List<EbOrderView> all = new ArrayList<EbOrderView>();
        all.add(te);
        return all;
    }

    public List<EbOrderView> getOrderViewByUserId(String UserId) {
        return new EbOrderViewDao().getOrderViewByUserId(UserId);
    }

    public EbNotice getNoticeByEnId(String EnId) {
        List<EbNotice> all = this.getNoticeTable();
        for (EbNotice x : all) {
            if (x.getNoticeId().compareTo(EnId) == 0)
                return x;
        }
        return null;
    }
    public List<EbProduct> searchProductByKeyWord(String keyWord){
        List<EbProduct> all = this.getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for(EbProduct x : all){
              if(x.getEpName().indexOf(keyWord) != -1 || (x.getEpDescription() != null && x.getEpDescription().indexOf(keyWord) != -1))
                   res.add(x);
        }
        return res;
    }
    public List<EbProduct> getProductListByEpName(String keyWord){
        List<EbProduct> all = this.getProductTable();
        List<EbProduct> res = new ArrayList<EbProduct>();
        for(EbProduct x : all){
            if(x.getEpName().indexOf(keyWord) != -1)
                res.add(x);
        }
        return res;
    }
    public List<EbComment> getCommentListByEcNickName(String EcNickName){
        List<EbComment> all = getCommentTable();
        List<EbComment> res = new ArrayList<EbComment>();
        for(EbComment x : all){
              if(x.getEcNickName().compareTo(EcNickName) == 0){
                     res.add(x);
              }
        }
        return res;
    }
    public boolean IncCartQuantityByUserName(String userName , String EpId){
            return new EbCartDao().IncCartQuantityUserId(new EbUserDao().getUserIdByName(userName),EpId);
    }
    public boolean DeleteCartByUserName(String userName ,String EpId){
            return new EbCartDao().deleteCartByUserId(new EbUserDao().getUserIdByName(userName),EpId);
    }
}
