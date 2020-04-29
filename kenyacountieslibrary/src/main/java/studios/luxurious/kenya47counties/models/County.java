package studios.luxurious.kenya47counties.models;

import android.graphics.drawable.Drawable;

public class County {
    private int id;
    private String name;
    private Drawable flag;

    public County(int id, String name, Drawable flag) {
        this.id = id;
        this.name = name;
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Drawable getFlag() {
        return flag;
    }

    public String getFormattedCountyNumber(){
        String idString = String.valueOf(id);
        if (idString.length() == 1){
            return "00"+id;
        }else{
            return "0"+id;
        }
    }

}
