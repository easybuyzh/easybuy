package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProductCategory;
import sdkd.com.ec.util.Utils;

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

    public boolean insertProductCategory(String EpcName, String EpcParentId) {
        String sql = "insert into easybuy_product_category (epc_name,epc_parent_id) values (?,?)";
        List<String> params = new ArrayList<String>();
        params.add(EpcName);
        params.add(EpcParentId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean updateProductCategoryByEpcId(String EpcId, String EpcName, String EpcParentId) {
        String sql = "update easybuy_product_category set epc_name = ? ,epc_parent_id = ?  where epc_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EpcName);
        params.add(EpcParentId);
        params.add(EpcId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean deleteProductCategoryByEpcId(String EpcId) {
        String sql = "delete from easybuy_product_category where epc_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EpcId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public EbProductCategory getProductCategoryByEpcId(String EpcId){
        List<EbProductCategory> all = this.getProductCatagreys();
        for(EbProductCategory x : all){
                if(x.getEpcId().compareTo(EpcId) == 0)
                       return x;
        }
        return null;
    }
}
