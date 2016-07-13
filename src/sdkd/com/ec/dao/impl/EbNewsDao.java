package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbNews;
import sdkd.com.ec.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SDUST-132 on 2016/7/6.
 */
public class EbNewsDao extends BaseDao {
    public List<EbNews> getNews() {
        List<EbNews> newsList = new ArrayList<EbNews>();
        String sql = "select * from easybuy_news order by en_create_time desc limit 0,7";
        try {
            ResultSet rs = this.executeSearch(sql, null);
            while (rs.next()) {
                EbNews news = new EbNews();
                news.setEnId(rs.getString("en_id"));
                news.setEnTitle(rs.getString("en_title"));
                news.setEnContent(rs.getString("en_content"));
                news.setEnCreateTime(rs.getString("en_create_time"));
                newsList.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newsList;
    }

    public boolean deleteNewsByEnId(String EnId) {
        String sql = "delete from easybuy_news where en_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EnId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public boolean UpdateNewsByEnId(String EnId, String EnTitle, String EnContent) {
        String sql = "update easybuy_news set en_title = ? ,en_content = ?  where en_id = ?";
        List<String> params = new ArrayList<String>();
        params.add(EnTitle);
        params.add(EnContent);
        params.add(EnId);
        int res = this.exeucteModify(sql, params);
        return (res > 0);
    }

    public EbNews getNewByEnId(String EnId) {
        List<EbNews> all = this.getNews();
        for (EbNews x : all) {
            if (Integer.valueOf(x.getEnId()) == Integer.valueOf(EnId)){
                return x;
            }
        }
        return null;
    }

    public boolean insertNews(String EnTitle, String EnContent) {
        String sql = "insert into easybuy_news(en_create_time , en_title , en_content) values (?,?,?)";
        List<String> params = new ArrayList<String>();
        params.add(Utils.getNowTimeInMysqlFormat());
        params.add(EnTitle);
        params.add(EnContent);
        int res = this.exeucteModify(sql , params);
        return (res > 0);
    }
}
