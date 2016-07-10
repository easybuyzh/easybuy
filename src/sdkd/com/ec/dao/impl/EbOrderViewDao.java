package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbOrder;
import sdkd.com.ec.model.EbOrderView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/10.
 */
public class EbOrderViewDao extends BaseDao {
    public List<EbOrderView> getOrderViews() {
        String sql = "select * from orderView";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbOrderView> all = new ArrayList<EbOrderView>();
        try {
            while (rs.next()) {
                EbOrderView te = new EbOrderView();
                te.setEoId(rs.getString("eo_id"));
                te.setEoUserId(rs.getString("eo_user_id"));
                te.setEoCreateTime(rs.getString("eo_create_time"));
                te.setEoCost(rs.getString("eo_cost"));
                te.setEoStatus(rs.getString("eo_status"));

                te.setEuUserName(rs.getString("eu_user_name"));
                te.setEuSex(rs.getString("eu_sex"));
                te.setEuEmail(rs.getString("eu_email"));
                te.setEuSex(rs.getString("eu_sex"));
                te.setEuEmail(rs.getString("eu_email"));
                te.setEuAddress(rs.getString("eu_address"));
                all.add(te);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public EbOrderView getOrderViewByOrderId(String OrderId) {
        List<EbOrderView> all = this.getOrderViews();
        for (EbOrderView x : all) {
            if (x.getEoId().compareTo(OrderId) == 0)
                return x;
        }
        return null;
    }
}
