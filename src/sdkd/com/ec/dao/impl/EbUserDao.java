package sdkd.com.ec.dao.impl;


import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbUser;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EbUserDao extends BaseDao {
    public List<EbUser> getEbUsers() {
        List<EbUser> all = new ArrayList<EbUser>();
        String sql = "select * from easybuy_user";
        ResultSet rs = this.executeSearch(sql, null);
        try {
            while (rs.next()) {
                EbUser te = new EbUser();
                te.setEuUserName(rs.getString("eu_user_name"));
                te.setEuPassword(rs.getString("eu_password"));
                te.setEuUserId(rs.getString("eu_user_id"));
                te.setEuPassword(rs.getString("eu_password"));
                te.setEuAddress(rs.getString("eu_address"));
                te.setEuEmail(rs.getString("eu_email"));
                te.setEuSex(rs.getString("eu_sex"));
                te.setEuMobile(rs.getString("eu_mobile"));
                te.setEuRole(rs.getString("eu_role"));
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    /*
       判定特定的验证用户名和密码
       如果存在返回真， 否则返回假
    */
    public boolean CheckUser(String EuUserName, String EuPassword) {
        List<EbUser> all = new ArrayList<EbUser>();
        String sql = "select * from easybuy_user where eu_user_name = ? and eu_password = ?";
        List<String> params = new ArrayList<String>();
        params.add(EuUserName);
        params.add(EuPassword);
        ResultSet rs = this.executeSearch(sql, params);
        try {
            if (rs.next())
                return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getUserIdByName(String EuUserName) {
        List<EbUser> all = new ArrayList<EbUser>();
        String sql = "select * from easybuy_user where eu_user_name = ?";
        List<String> params = new ArrayList<String>();
        params.add(EuUserName);
        ResultSet rs = this.executeSearch(sql, params);
        try {
            if (rs.next())
                return rs.getString("eu_user_id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean InsertUser(String EuUserName, String EuPassword) {
        if(getUserIdByName(EuUserName) != null)  //该用户名已存在注册失败
                return false;
        String sql = "insert into easybuy_user (eu_user_name,eu_password) values(?,?)";
        List<String> params = new ArrayList<String>();
        params.add(EuUserName);
        params.add(EuPassword);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean InsertUser(List<String> columnName, List<String> params) {
        String src = "";
        for (int i = 0; i < columnName.size(); i++) {
            if (i == 0) src += "(";
            if (i > 0) src += ",";
            src += columnName.get(i);
            if (i == params.size() - 1) src += ")";
        }
        String str = "";
        for (int i = 0; i < params.size(); i++) {
            if (i == 0) str += "(";
            if (i > 0) str += ",";
            str += "?";
            if (i == params.size() - 1) str += ")";
        }
        String sql = "insert into easybuy_user " + src + " values " + str;
        int res = this.exeucteModify(sql,params);
        return (res > 0);
    }

    public boolean deleteUserByEuUserId(String EuUserId) {
        String sql = "delete from easybuy_user where eu_user_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EuUserId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean updateUserByUserId(String EuUserId, List<String> params) {
        String sql = "update easybuy_user set eu_user_name = ? ,eu_password = ? " +
                ",eu_sex = ? ,eu_birthday = ?,eu_mobile = ? ," +
                "eu_email = ? ,eu_address = ? where eu_user_id = ?";

        params.add(EuUserId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public EbUser getUserByUserId(String EuUserId) {
        List<EbUser> all = this.getEbUsers();
        for (EbUser x : all) {
            if (x.getEuUserId().compareTo(EuUserId) == 0) {
                return x;
            }
        }
        return null;
    }
}