package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbRecentBrowse;
import sdkd.com.ec.model.EbUser;
import sdkd.com.ec.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/11.
 */
public class EbRecentBrowseDao extends BaseDao {
    private int MaxMumRecentBrowseCount = Integer.valueOf(getPro("MaxMumRecentBrowseCount"));

    public List<EbRecentBrowse> getRecentBrowseByUserId(String userId ,String way) {
        String sql = "select * from easybuy_recent_browse where er_user_id = ? ORDER BY er_id" ;
        if(way != null && "desc".compareTo(way) == 0)   sql += " desc";
        List<String> params = new ArrayList<String>();
        params.add(userId);
        ResultSet rs = this.executeSearch(sql, params);
        List<EbRecentBrowse> all = new ArrayList<EbRecentBrowse>();
        try {
            while (rs.next()) {
                EbRecentBrowse te = new EbRecentBrowse();
                te.setErId(rs.getString("er_id"));
                te.setErUserId(rs.getString("er_user_id"));
                te.setErProductId(rs.getString("er_product_id"));
                te.setErProductName(rs.getString("er_product_name"));
                te.setErProductIcon(rs.getString("er_product_icon"));
                //System.out.println(te.getErProductName() + "^^^^^^^&& **** ");
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
    public boolean deleteBrowseByErId(String ErId){
        String sql = "delete from easybuy_recent_browse where er_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(ErId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
    public boolean insertNewBrowse(String userId, String EpId, String EpName,String EpProductIcon) {
        List<EbRecentBrowse> all = this.getRecentBrowseByUserId(userId,null);
        for (EbRecentBrowse x : all) {
            if (x.getErProductId().compareTo(EpId) == 0)
                return true;
            //代表该商品已经在最近浏览记录中了
        }
        String sql = "insert into easybuy_recent_browse " +
                "(er_user_id , er_product_id , er_product_name , er_product_icon) " +
                "values (?,?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(userId);
        params.add(EpId);
        params.add(EpName);
        params.add(EpProductIcon);
        int res = this.exeucteModify(sql , params);
        if(res == 0) return false;
        all = this.getRecentBrowseByUserId(userId,null);
        //当当前收录的记录高于最大值，那么清除最早浏览的几条记录
        if(all.size() > MaxMumRecentBrowseCount){
                for(int i = 0 ; i < all.size() - MaxMumRecentBrowseCount ; i++){
                       this.deleteBrowseByErId(all.get(i).getErId());
                }
        }
        return true;
    }
}
