package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
public class EbOrderDao extends BaseDao {
    public String createNewOrderByUserId(String UserId, String Cost) {
        String sql = "insert into easybuy_order(eo_user_id , eo_create_time , eo_cost) values (?,?,?)";
        List<String> params = new ArrayList<String>();

        params.add(UserId);
        params.add(Utils.getNowTimeInMysqlFormat());
        params.add(Cost);
        int res = this.exeucteModify(sql, params);
        if (res > 0) {
             List<EbOrder> all = this.getOrderByUserId(UserId);
             int max_ = 0;
             for(EbOrder x : all){
                  max_ = Math.max(max_ , Integer.valueOf(x.getEoId()));
             }
             return String.valueOf(max_);
        }
        return null;
    }

    public List<EbOrder> getOrderByUserId(String userId) {
        List<EbOrder> all = this.getOrders();
        List<EbOrder> res = new ArrayList<EbOrder>();
        for(EbOrder x : all){
              if(x.getEoUserId().compareTo(userId) == 0){
                     res.add(x);
              }
        }
        return res;
    }

    public List<EbOrder> getOrders() {
        String sql = "select * from easybuy_order";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbOrder> all = new ArrayList<EbOrder>();
        try {
            while (rs.next()) {
                EbOrder te = new EbOrder();
                te.setEoId(rs.getString("eo_id"));
                te.setEoUserId(rs.getString("eo_user_id"));
                te.setEoCreateTime(rs.getString("eo_create_time"));
                te.setEoCost(rs.getString("eo_cost"));
                all.add(te);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteOrderByOrderId(String OrderId) {
        String sql = "delete from easybuy_order where eo_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(OrderId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean updateOrderByOrderId(String EoId, String EoStatus) {
        String sql = "update easybuy_order set eo_status = ?  where eo_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EoStatus);
        params.add(EoId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
}
