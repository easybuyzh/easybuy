package sdkd.com.ec.util;

/**
 * Created by zhaoshuai on 2016/7/13.
 */
public class Pair {
    String name;
    boolean selected;

    public Pair(String na , boolean se){
        name = na;
        selected = se;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
