package studios.luxurious.kenya47counties.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import studios.luxurious.kenya47counties.R;
import studios.luxurious.kenya47counties.adapters.CountiesAdapter;
import studios.luxurious.kenya47counties.models.County;

public class Kenya47Counties extends AppCompatActivity {


    private static ArrayList<County> countyArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_kenya_counties);
        Button selectBtn = findViewById(R.id.selectCountyBtn);

        selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAllCountiesDialog(Kenya47Counties.this, "Select County", true, true, true);
            }
        });
    }

    private static County returnCounty;
    public static County showAllCountiesDialog(final Context context, String listTitle, boolean showCountyNumber, boolean showCountyFlag, boolean sortAlphabetically) {

        returnCounty = null;

        countyArrayList = new ArrayList<>();

        countyArrayList.add(new County(1, "Mombasa", R.drawable.mombasa));
        countyArrayList.add(new County(2, "Kwale", R.drawable.kwale));
        countyArrayList.add(new County(3, "Kilifi", R.drawable.kilifi));
        countyArrayList.add(new County(4, "Tana River", R.drawable.tana_river));
        countyArrayList.add(new County(5, "Lamu", R.drawable.lamu));
        countyArrayList.add(new County(6, "Taita Taveta", R.drawable.taita_taveta));
        countyArrayList.add(new County(7, "Garissa", R.drawable.garissa));
        countyArrayList.add(new County(8, "Wajir", R.drawable.wajir));
        countyArrayList.add(new County(9, "Mandera", R.drawable.mandera));
        countyArrayList.add(new County(10, "Marsabit", R.drawable.marsabit));
        countyArrayList.add(new County(11, "Isiolo", R.drawable.isiolo));
        countyArrayList.add(new County(12, "Meru", R.drawable.meru));
        countyArrayList.add(new County(13, "Tharaka Nithi", R.drawable.tharaka_nitji));
        countyArrayList.add(new County(14, "Embu", R.drawable.embu));
        countyArrayList.add(new County(15, "Kitui", R.drawable.kitui));
        countyArrayList.add(new County(16, "Machakos", R.drawable.machakos));
        countyArrayList.add(new County(17, "Makueni", R.drawable.makueni));
        countyArrayList.add(new County(18, "Nyandarua", R.drawable.nyandarua));
        countyArrayList.add(new County(19, "Nyeri", R.drawable.nyeri));
        countyArrayList.add(new County(20, "Kirinyaga", R.drawable.kirinyaga));
        countyArrayList.add(new County(21, "Murang’a", R.drawable.muramga));
        countyArrayList.add(new County(22, "Kiambu", R.drawable.kiambu));
        countyArrayList.add(new County(23, "Turkana", R.drawable.turkana));
        countyArrayList.add(new County(24, "West Pokot", R.drawable.west_pokot));
        countyArrayList.add(new County(25, "Samburu", R.drawable.samburu));
        countyArrayList.add(new County(26, "Uasin Gishu", R.drawable.uashin_gidhu));
        countyArrayList.add(new County(27, "Trans-Nzoia", R.drawable.transzoia));
        countyArrayList.add(new County(28, "Elgeyo-Marakwet", R.drawable.elgeyo_marakwet));
        countyArrayList.add(new County(29, "Nandi", R.drawable.nandi));
        countyArrayList.add(new County(30, "Baringo", R.drawable.baringo));
        countyArrayList.add(new County(31, "Laikipia", R.drawable.laikipia));
        countyArrayList.add(new County(32, "Nakuru", R.drawable.nakuru));
        countyArrayList.add(new County(33, "Narok", R.drawable.narok));
        countyArrayList.add(new County(34, "Kajiado", R.drawable.kajiado));
        countyArrayList.add(new County(35, "Kericho", R.drawable.kericho));
        countyArrayList.add(new County(36, "Bomet", R.drawable.bomet));
        countyArrayList.add(new County(37, "Kakamega", R.drawable.kakamega));
        countyArrayList.add(new County(38, "Vihiga", R.drawable.vihiga));
        countyArrayList.add(new County(39, "Bungoma", R.drawable.bungoma));
        countyArrayList.add(new County(40, "Busia", R.drawable.busia));
        countyArrayList.add(new County(41, "Siaya", R.drawable.siaya));
        countyArrayList.add(new County(42, "Kisumu", R.drawable.kisumu));
        countyArrayList.add(new County(43, "Homa Bay", R.drawable.homabay));
        countyArrayList.add(new County(44, "Migori", R.drawable.migori));
        countyArrayList.add(new County(45, "Kisii", R.drawable.kisii));
        countyArrayList.add(new County(46, "Nyamira", R.drawable.nyamira));
        countyArrayList.add(new County(47, "Nairobi", R.drawable.nairobi));


        if (sortAlphabetically) Collections.sort(countyArrayList, new MyComparator());
        CountiesAdapter customAdapter = new CountiesAdapter(context, countyArrayList, showCountyNumber, showCountyFlag);

        new AlertDialog.Builder(context)
                .setTitle(listTitle)
                .setAdapter(customAdapter, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        returnCounty = countyArrayList.get(which);
                        dialog.dismiss();
                    }
                }).create().show();

        return returnCounty;
    }

    static class MyComparator implements Comparator<County> {

        @Override
        public int compare(County o1, County o2) {

            return o1.getName().compareTo(o2.getName());

        }
    }

}
