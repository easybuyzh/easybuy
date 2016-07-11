package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbRecentBrowse;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/11.
 */
public class EbRecentBrowseDao extends BaseDao {
    private int MaxMumRecentBrowseCount = Integer.valueOf(getPro("MaxMumRecentBrowseCount"));

    public List<EbRecentBrowse> getRecentBrowseByUserId(String userId) {
        String sql = "select * from easybuy_recent_browse where er_user_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(userId);
        ResultSet rs = this.executeSearch(sql, null);
        List<EbRecentBrowse> all = new ArrayList<EbRecentBrowse>();
        try {
            while (rs.next()) {
                EbRecentBrowse te = new EbRecentBrowse();
                te.setErId(rs.getString("er_id"));
                te.setErUserId(rs.getString("er_user_id"));
                te.setErProdcutId(rs.getString("er_product_id"));
                te.setErProductName(rs.getString("er_product_name"));
                te.setErProductIcon(rs.getString("er_product_icon"));
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public boolean insertNewBrowse(String userId, String EpId) {
        List<EbRecentBrowse> all = this.getRecentBrowseByUserId(userId);
        for (EbRecentBrowse x : all) {
            if (x.getErProdcutId().compareTo(EpId) == 0)
                return true;
            //代表该商品已经在最近浏览记录中了
        }
       // int minId = 0;
       // for(int i =1 ; i<=new )
        return true;
    }
}
