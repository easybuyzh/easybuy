package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbComment;
import sdkd.com.ec.model.EbNews;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/6.
 */
public class EbCommentDao extends BaseDao {

    public List<EbComment> getComments() {
        List<EbComment> all = new ArrayList<EbComment>();
        String sql = "select * from easybuy_comment";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbComment te = new EbComment();
                te.setEcId(rs.getString("ec_id"));
                te.setEcReply(rs.getString("ec_reply"));
                te.setEcContent(rs.getString("ec_content"));
                te.setEcCreateTime(rs.getString("ec_create_time"));
                te.setEcReplyTime(rs.getString("ec_reply_time"));
                te.setEcNickName(rs.getString("ec_nick_name"));
                if(te.getEcReply() == null || "null".compareTo(te.getEcReply()) == 0)
                        te.setEcReply(null);
                System.out.println(te.getEcNickName() + " ---  ");
                //添加到集合中
                all.add(te);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    public boolean InsertComment(String name, String content, String datetime) {
        String sql = "insert into easybuy_comment (ec_content , ec_nick_name , ec_create_time) values(?,?,?)";
        ArrayList<String> params = new ArrayList<String>();
        params.add(content);
        params.add(name);
        params.add(datetime);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean UpdateReplyByEcId(String EcId, String Reply) {
        String sql = "update easybuy_comment set ec_reply = ? where ec_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(Reply);
        params.add(EcId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public EbComment getCommentByEcId(String EcId) {
        String sql = "select * from easybuy_comment where ec_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EcId);
        ResultSet rs = this.executeSearch(sql, params);
        try {
            if (!rs.next())
                return null;
            EbComment te = new EbComment();
            te.setEcId(rs.getString("ec_id"));
            te.setEcReply(rs.getString("ec_reply"));
            te.setEcContent(rs.getString("ec_content"));
            te.setEcCreateTime(rs.getString("ec_create_time"));
            te.setEcReplyTime(rs.getString("ec_reply_time"));
            te.setEcNickName(rs.getString("ec_nick_name"));
            if(te.getEcReply() == null || "null".compareTo(te.getEcReply()) == 0 )
                te.setEcReply(null);
            return te;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean deleteCommentByEcId(String EcId) {
        String sql = "delete from easybuy_comment where ec_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EcId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
}
