package studios.luxurious.kenya47counties.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import studios.luxurious.kenya47counties.R;
import studios.luxurious.kenya47counties.adapters.CountiesAdapter;
import studios.luxurious.kenya47counties.models.County;

public class Kenya47Counties extends AppCompatActivity{


    private static ArrayList<County> countyArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kenya_counties);


    }

    public static void showAllCountiesDialog(final Context context, String listTitle, boolean showCountyNumber, boolean showCountyFlag, boolean sortAlphabetically, final CountyReturned countyReturned) {

        countyArrayList = new ArrayList<>();

        countyArrayList.add(new County(1, "Mombasa",  context.getDrawable(R.drawable.mombasa)));
        countyArrayList.add(new County(2, "Kwale", context.getDrawable(R.drawable.kwale)));
        countyArrayList.add(new County(3, "Kilifi", context.getDrawable(R.drawable.kilifi)));
        countyArrayList.add(new County(4, "Tana River", context.getDrawable(R.drawable.tana_river)));
        countyArrayList.add(new County(5, "Lamu", context.getDrawable(R.drawable.lamu)));
        countyArrayList.add(new County(6, "Taita Taveta", context.getDrawable(R.drawable.taita_taveta)));
        countyArrayList.add(new County(7, "Garissa", context.getDrawable(R.drawable.garissa)));
        countyArrayList.add(new County(8, "Wajir", context.getDrawable(R.drawable.wajir)));
        countyArrayList.add(new County(9, "Mandera", context.getDrawable(R.drawable.mandera)));
        countyArrayList.add(new County(10, "Marsabit", context.getDrawable(R.drawable.marsabit)));
        countyArrayList.add(new County(11, "Isiolo", context.getDrawable(R.drawable.isiolo)));
        countyArrayList.add(new County(12, "Meru", context.getDrawable(R.drawable.meru)));
        countyArrayList.add(new County(13, "Tharaka Nithi", context.getDrawable(R.drawable.tharaka_nitji)));
        countyArrayList.add(new County(14, "Embu", context.getDrawable(R.drawable.embu)));
        countyArrayList.add(new County(15, "Kitui", context.getDrawable(R.drawable.kitui)));
        countyArrayList.add(new County(16, "Machakos", context.getDrawable(R.drawable.machakos)));
        countyArrayList.add(new County(17, "Makueni", context.getDrawable(R.drawable.makueni)));
        countyArrayList.add(new County(18, "Nyandarua", context.getDrawable(R.drawable.nyandarua)));
        countyArrayList.add(new County(19, "Nyeri", context.getDrawable(R.drawable.nyeri)));
        countyArrayList.add(new County(20, "Kirinyaga", context.getDrawable(R.drawable.kirinyaga)));
        countyArrayList.add(new County(21, "Murang’a", context.getDrawable(R.drawable.muramga)));
        countyArrayList.add(new County(22, "Kiambu", context.getDrawable(R.drawable.kiambu)));
        countyArrayList.add(new County(23, "Turkana", context.getDrawable(R.drawable.turkana)));
        countyArrayList.add(new County(24, "West Pokot", context.getDrawable(R.drawable.west_pokot)));
        countyArrayList.add(new County(25, "Samburu", context.getDrawable(R.drawable.samburu)));
        countyArrayList.add(new County(26, "Uasin Gishu", context.getDrawable(R.drawable.uashin_gidhu)));
        countyArrayList.add(new County(27, "Trans-Nzoia", context.getDrawable(R.drawable.transzoia)));
        countyArrayList.add(new County(28, "Elgeyo-Marakwet", context.getDrawable(R.drawable.elgeyo_marakwet)));
        countyArrayList.add(new County(29, "Nandi", context.getDrawable(R.drawable.nandi)));
        countyArrayList.add(new County(30, "Baringo", context.getDrawable(R.drawable.baringo)));
        countyArrayList.add(new County(31, "Laikipia", context.getDrawable(R.drawable.laikipia)));
        countyArrayList.add(new County(32, "Nakuru", context.getDrawable(R.drawable.nakuru)));
        countyArrayList.add(new County(33, "Narok", context.getDrawable(R.drawable.narok)));
        countyArrayList.add(new County(34, "Kajiado", context.getDrawable(R.drawable.kajiado)));
        countyArrayList.add(new County(35, "Kericho", context.getDrawable(R.drawable.kericho)));
        countyArrayList.add(new County(36, "Bomet", context.getDrawable(R.drawable.bomet)));
        countyArrayList.add(new County(37, "Kakamega", context.getDrawable(R.drawable.kakamega)));
        countyArrayList.add(new County(38, "Vihiga", context.getDrawable(R.drawable.vihiga)));
        countyArrayList.add(new County(39, "Bungoma", context.getDrawable(R.drawable.bungoma)));
        countyArrayList.add(new County(40, "Busia", context.getDrawable(R.drawable.busia)));
        countyArrayList.add(new County(41, "Siaya", context.getDrawable(R.drawable.siaya)));
        countyArrayList.add(new County(42, "Kisumu", context.getDrawable(R.drawable.kisumu)));
        countyArrayList.add(new County(43, "Homa Bay", context.getDrawable(R.drawable.homabay)));
        countyArrayList.add(new County(44, "Migori", context.getDrawable(R.drawable.migori)));
        countyArrayList.add(new County(45, "Kisii", context.getDrawable(R.drawable.kisii)));
        countyArrayList.add(new County(46, "Nyamira", context.getDrawable(R.drawable.nyamira)));
        countyArrayList.add(new County(47, "Nairobi", context.getDrawable(R.drawable.nairobi)));


        if (sortAlphabetically) Collections.sort(countyArrayList, new MyComparator());
        CountiesAdapter customAdapter = new CountiesAdapter(context, countyArrayList, showCountyNumber, showCountyFlag);

        new AlertDialog.Builder(context)
                .setTitle(listTitle)
                .setAdapter(customAdapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        countyReturned.onSelectedCounty(countyArrayList.get(which));
                        dialog.dismiss();
                    }
                }).create().show();

    }

    static class MyComparator implements Comparator<County> {

        @Override
        public int compare(County o1, County o2) {

            return o1.getName().compareTo(o2.getName());

        }
    }

}
