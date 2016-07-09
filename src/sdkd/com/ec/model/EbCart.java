package sdkd.com.ec.model;

/**
 * Created by zhaoshuai on 2016/7/8.
 */
public class EbCart {
      String EcaUserId;
      String EcaProductId;
      String EcaProductCount;

    public String getEcaUserId() {
        return EcaUserId;
    }

    public void setEcaUserId(String ecaUserId) {
        EcaUserId = ecaUserId;
    }

    public String getEcaProductId() {
        return EcaProductId;
    }

    public void setEcaProductId(String ecaProductId) {
        EcaProductId = ecaProductId;
    }

    public String getEcaProductCount() {
        return EcaProductCount;
    }

    public void setEcaProductCount(String ecaProductCount) {
        EcaProductCount = ecaProductCount;
    }
}
