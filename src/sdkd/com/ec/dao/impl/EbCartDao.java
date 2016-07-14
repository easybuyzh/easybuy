package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbCart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/8.
 */
public class EbCartDao extends BaseDao {
    public boolean insertCart(String UserId, String ProductId, String ProductCount) {
        String sql = "insert into easybuy_cart(eca_user_id,eca_product_id,eca_product_count) values (?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(UserId);
        params.add(ProductId);
        params.add(ProductCount);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean IncCartQuantityUserId(String UserId,String EpProductId) {
        String sql = "update easybuy_cart set eca_product_count = eca_product_count + 1 " +
                "where eca_user_id = ? and eca_product_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(UserId);
        params.add(EpProductId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean clearCartbyuserId(String UserId) {
        String sql = "delete from easybuy_cart where eca_user_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(UserId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
    public boolean deleteCartByUserId(String UserId , String EpId){
        String sql = "delete from easybuy_cart " +
                "where eca_user_id = ? and eca_product_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(UserId);
        params.add(EpId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
}
