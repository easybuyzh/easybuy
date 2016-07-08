package sdkd.com.ec.dao.impl;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class EbManuserDao extends BaseDao{
    public List<EbUser> EbManuserDao() {
        List<EbUser> all = new ArrayList<EbUser>();
        String sql = "select * from easybuy_user";
        ResultSet rs = this.executeSearch(sql, null);
        try {
            while (rs.next()) {
                EbUser te = new EbUser();
                te.setEuUserId(rs.getString("eu_user_id"));
                te.setEuUserName(rs.getString("eu_user_name"));
                te.setEuSex(rs.getString("eu_sex"));
                te.setEuEmail(rs.getString("eu_email"));
                te.setEuSex(rs.getString("eu_sex"));
                te.setEuEmail(rs.getString("eu_email"));
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
