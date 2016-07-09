package sdkd.com.ec.dao.impl;

import sdkd.com.ec.dao.BaseDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
public class EbOrderDetailDao extends BaseDao{
        public boolean insertOrderDetail(String OrderId, String EpId, String EpQuantity ){
              String sql = "insert into easybuy_order_detail(eo_id,ep_id,ep_quantity) values (?,?,?)";
              List<String> params  = new ArrayList<String>();
              params.add(OrderId);
              params.add(EpId);
              params.add(EpQuantity);
              int res = this.exeucteModify(sql , params);
              return (res > 0);
        }
}
