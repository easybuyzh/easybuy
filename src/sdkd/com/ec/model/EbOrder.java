package sdkd.com.ec.model;

/**
 * Created by zhaoshuai on 2016/7/9.
 */
public class EbOrder {
       String EoId ;
       String EoUserId;
       String EoCreateTime;
       String EoCost;
       String EoStatus;
       String EoType;

    public String getEoCreateTime() {
        return EoCreateTime;
    }

    public void setEoCreateTime(String eoCreateTime) {
        EoCreateTime = eoCreateTime;
    }

    public String getEoId() {
        return EoId;
    }

    public void setEoId(String eoId) {
        EoId = eoId;
    }

    public String getEoUserId() {
        return EoUserId;
    }

    public void setEoUserId(String eoUserId) {
        EoUserId = eoUserId;
    }


    public String getEoCost() {
        return EoCost;
    }

    public void setEoCost(String eoCost) {
        EoCost = eoCost;
    }

    public String getEoStatus() {
        return EoStatus;
    }

    public void setEoStatus(String eoStatus) {
        EoStatus = eoStatus;
    }

    public String getEoType() {
        return EoType;
    }

    public void setEoType(String eoType) {
        EoType = eoType;
    }
}
