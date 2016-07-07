package sdkd.com.ec.model;

/**
 * Created by zhaoshuai on 2016/7/7.
 */
public class EbProductCategory {
    String EpcId;
    String EpcName;
    String EpcParentId;

    public String getEpcId() {
        return EpcId;
    }

    public void setEpcId(String epcId) {
        EpcId = epcId;
    }

    public String getEpcName() {
        return EpcName;
    }

    public void setEpcName(String epcName) {
        EpcName = epcName;
    }

    public String getEpcParentId() {
        return EpcParentId;
    }

    public void setEpcParentId(String epcParentId) {
        EpcParentId = epcParentId;
    }
}
