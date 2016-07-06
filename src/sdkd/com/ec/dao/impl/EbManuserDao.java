package sdkd.com.ec.dao.impl;
import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by sdust on 2016/7/7.
 */
    /*
    eu_user_id
eu_user_name
eu_password
eu_sex
eu_birthday
eu_identity_code
eu_email
eu_mobile
eu_address
eu_status

    */
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
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }
}
