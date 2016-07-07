package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNotice;

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
        String sql = "select * from easybuy_notice limit 0,5";
        ResultSet res = this.executeSearch(sql,null);
        try {
            while(res.next())
            {
                EbNotice ebn =new EbNotice();
                //ebn.getNoticeId();
                ebn.setNoticeId(res.getString("notice_id"));
                ebn.setNoticeContent(res.getString("notice_content"));
                ebn.setNoticeTitle(res.getString("notice_title"));
                ebn.setNoticeTime(res.getString("notice_time"));
                list.add(ebn);
                System.out.println(ebn.getNoticeContent() + " ****** ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;


    }

}
