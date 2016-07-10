package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbProduct;
import sdkd.com.ec.model.EbProductCategory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/6.
 */
public class EbProductDao extends BaseDao {
    public List<EbProduct> getProducts() {
        List<EbProduct> all = new ArrayList<EbProduct>();
        String sql = "select * from easybuy_product order by ep_view_count desc";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbProduct te = new EbProduct();
                te.setEpId(rs.getString("ep_id"));
                te.setEpName(rs.getString("ep_name"));
                te.setEpDescription(rs.getString("ep_description"));
                te.setEpPrice(rs.getString("ep_price"));
                te.setEpStock(rs.getString("ep_stock"));
                te.setEpProductIcon(rs.getString("ep_product_icon"));
                te.setEpBaPrice(rs.getString("ep_ba_price"));
                te.setEpBargain(rs.getString("ep_bargain"));
                te.setEpViewCount(rs.getString("ep_view_count"));
                te.setEpcId(rs.getString("epc_id"));
                te.setEpBarCode(rs.getString("ep_bar_code"));
                //System.out.println();
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public boolean ViewProductForOneTime(String id) {
        String sql = "update easybuy_product set ep_view_count = ep_view_count + 1 where ep_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(id);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean deleteProductByEpId(String EpId) {
        String sql = "delete from easybuy_product where ep_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EpId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public EbProduct getProductByEpId(String EpId) {
        List<EbProduct> all = this.getProducts();
        for (EbProduct x : all) {
            if (x.getEpId().compareTo(EpId) == 0)
                return x;
        }
        return null;
    }

    //传递过来列表的最后一个参数为EpId;
    public boolean updateProductByEpId(List<String> columnList, List<String> params) {
        String str = "";
        for (int i = 0; i < columnList.size() - 1; i++) {
            if (i > 0) str += " , ";
            str += columnList.get(i) + "=?";
        }
        String sql = "update easybuy_product set " + str + " where ep_id = ?";
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean insertProduct(List<String> columnList, List<String> params) {
        String src = "";
        for (int i = 0; i < columnList.size(); i++) {
            if (i == 0) src += "(";
            if (i > 0) src += ",";
            src += columnList.get(i);
            if (i == params.size() - 1) src += ")";
        }
        String str = "";
        for (int i = 0; i < params.size(); i++) {
            if (i == 0) str += "(";
            if (i > 0) str += ",";
            str += "?";
            if (i == params.size() - 1) str += ")";
        }
        String sql = "insert into easybuy_product " + src + " values " + str;
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
}
