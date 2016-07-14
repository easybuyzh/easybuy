package sdkd.com.ec.util;

import sdkd.com.ec.dao.BaseDao;
import sdkd.com.ec.model.EbProduct;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/13.
 * 与page.jsp 配套的类， url为点击页面跳转到的位置
 */
public class PageUtil<T> {
    Integer val; // 代表一页里面要显示的数据条数
    public PageUtil(){
        val = Integer.valueOf(new BaseDao().getPro("ProductListPageMaxMumShowNumber"));
    }
    public PageUtil(int v){
         val = v;
    }
    public int getPageCount(List<T> all) {
        int size = all.size();
        int res = size / val;
        if (size % val != 0) res += 1;
        return Math.max(1, res); //必须有一个页面用于显示
    }

    public List<T> getSpecificPageList(List<T> all, int page) {
        int start_pos = (page - 1) * val;
        int end_pos = Math.min(start_pos + val, all.size());
        List<T> res = new ArrayList<T>();
        for (int i = start_pos; i < end_pos; i++) {
            res.add(all.get(i));
        }
        return res;
    }
}
