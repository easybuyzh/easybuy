package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbCart;
import sdkd.com.ec.model.EbViewCartDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/8.
 */
public class EbViewCartDetailDao extends BaseDao{
    public List<EbViewCartDetail> getCartByUserName(String UserName){
        List<EbViewCartDetail> all = new ArrayList<EbViewCartDetail>();
        String EuUserId = new EbUserDao().getUserIdByName(UserName);
        if(EuUserId == null) {
            return all;
        }
        String sql ="select * from cartdetail where eca_user_id=?";
        List<String> params = new ArrayList<String>();
        params.add(EuUserId);
        ResultSet rs = this.executeSearch(sql , params);
        try {
            while(rs.next()){
                EbViewCartDetail te = new EbViewCartDetail();
                te.setEcaUserId(rs.getString("eca_user_id"));
                te.setEcaProductId(rs.getString("eca_product_id"));
                te.setEcaProductCount(rs.getString("eca_product_count"));
                te.setEpName(rs.getString("ep_name"));
                te.setEpDescription(rs.getString("ep_description"));
                te.setEpPrice(rs.getString("ep_price"));
                te.setEpStock(rs.getString("ep_stock"));
                te.setEpProductIcon(rs.getString("ep_product_icon"));
                te.setEpBaPrice(rs.getString("ep_ba_price"));
                te.setEpBargain(rs.getString("ep_bargain"));
                te.setEpViewCount(rs.getString("ep_view_count"));
                te.setEpcId(rs.getString("epc_id"));
                all.add(te);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
