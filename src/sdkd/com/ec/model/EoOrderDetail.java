package sdkd.com.ec.model;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
public class EoOrderDetail {
      String EoId;
      String EpId;
      String EodQuantity;
      String EodCost;

    public String getEoId() {
        return EoId;
    }

    public void setEoId(String eoId) {
        EoId = eoId;
    }

    public String getEpId() {
        return EpId;
    }

    public void setEpId(String epId) {
        EpId = epId;
    }

    public String getEodQuantity() {
        return EodQuantity;
    }

    public void setEodQuantity(String eodQuantity) {
        EodQuantity = eodQuantity;
    }

    public String getEodCost() {
        return EodCost;
    }

    public void setEodCost(String eodCost) {
        EodCost = eodCost;
    }
}
