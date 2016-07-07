package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
public class EbProductCategoryDao extends BaseDao {
    public List<EbProductCategory> getProductCatagreys() {
        String sql = "select * from easybuy_product_category";
        ResultSet rs = this.executeSearch(sql, null);
        List<EbProductCategory> all = new ArrayList<EbProductCategory>();
        try {
            while (rs.next()) {
                EbProductCategory te = new EbProductCategory();
                te.setEpcId(rs.getString("epc_id"));
                te.setEpcName(rs.getString("epc_name"));
                te.setEpcParentId(rs.getString("epc_parent_id"));
                all.add(te);
            }
            return all;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
