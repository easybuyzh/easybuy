package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.model.EbNotice;
import sdkd.com.ec.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangjiwen on 2016/7/7.
 */
/*notice_id
        notice_title
        notice_content
        notice_time*/

public class EbNoticeDao extends BaseDao {
    public List<EbNotice> getNotice() {
        List<EbNotice> list = new ArrayList<EbNotice>();
        String sql = "select * from easybuy_notice limit 0,11";
        ResultSet res = this.executeSearch(sql,null);
        try {
            while(res.next())
            {
                EbNotice ebn =new EbNotice();
                ebn.setNoticeId(res.getString("notice_id"));
                ebn.setNoticeContent(res.getString("notice_content"));
                ebn.setNoticeTitle(res.getString("notice_title"));
                ebn.setNoticeTime(res.getString("notice_time"));
                list.add(ebn);
               // System.out.println(ebn.getNoticeContent() + " ****** ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;


    }
    public boolean insertNotice(String notice_title, String notice_content) {
        String sql = "insert into easybuy_notice(notice_time , notice_title , notice_content) values (?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(Utils.getNowTimeInMysqlFormat());
        params.add(notice_title);
        params.add(notice_content);
        int res = this.exeucteModify(sql , params);
        return (res > 0);
    }
    public boolean deleteNoticeByNoticeCreateTime(String notice_time) {
        String sql = "delete from easybuy_notice where notice_time = ?";
        List<String> params = new ArrayList<String>();
        params.add(notice_time);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
    //UpdateNoticeByNoticeTime(NoticeTime, NoticeTitle, NoticeContent)
    public boolean UpdateNoticeByNoticeId(String NoticeId, String NoticeTitle, String NoticeContent) {
        String sql = "update easybuy_notice set notice_title = ? ,notice_content = ?  where notice_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(NoticeTitle);
        params.add(NoticeContent);
        params.add(NoticeId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }
    public EbNotice getNoticeByNoticeTime(String NoticeTime) {
        List<EbNotice> all = this.getNotice();
        for (EbNotice x : all) {
            if (x.getNoticeTime().compareTo(NoticeTime) == 0)
                return x;
        }
        return null;
    }
    public EbNotice getNoticeByNoticeId(String NoticeId){
        List<EbNotice> all = this.getNotice();
        for(EbNotice x : all){
            if(x.getNoticeId().compareTo(NoticeId) == 0)
                //System.out.println(x.getNoticeId()+"______"+x.getNoticeTitle());
                return  x;


        }
        return null;
    }
}
