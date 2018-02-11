package bill.edu.excise;

/**
 * Created by Bill on 2018/2/11.
 */

public class MedalItem  {

    int idIcon;
    String name;
    String got;
    public MedalItem(String name, int icon, String got){
        this.idIcon = icon;
        this.name = name;
        this.got = got;
    }

    public int getIdIcon() {
        return idIcon;
    }

    public void setIdIcon(int idIcon) {
        this.idIcon = idIcon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGot() {
        return got;
    }

    public void setGot(String got) {
        this.got = got;
    }
}
