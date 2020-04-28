package studios.luxurious.kenya47counties.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import studios.luxurious.kenya47counties.R;
import studios.luxurious.kenya47counties.models.County;

public class CountiesAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflter;

    private ArrayList<County> countyArrayList;
    private boolean showCountyNumber;
    private  boolean showCountyFlag;

    public CountiesAdapter(Context applicationContext, ArrayList<County> countyArrayList, boolean showCountyNumber,  boolean showCountyFlag ) {
        this.context = applicationContext;
        inflter = (LayoutInflater.from(applicationContext));
        this.countyArrayList = countyArrayList;
        this.showCountyNumber = showCountyNumber;
        this.showCountyFlag = showCountyFlag;
    }

    @Override
    public int getCount() {
        return countyArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        County county = countyArrayList.get(i);

        view = inflter.inflate(R.layout.county_layout_kenya, null);
        ImageView icon = view.findViewById(R.id.imageView);
        TextView countyName = view.findViewById(R.id.countyName);
        TextView countyNumber = view.findViewById(R.id.countyNumber);
        countyName.setText(county.getName());

        if (showCountyFlag){
            icon.setImageResource(county.getFlag());
            icon.setVisibility(View.VISIBLE);
        }else {
            icon.setVisibility(View.GONE);
        }

        if (showCountyNumber) {
            countyNumber.setText(county.getFormattedCountyNumber());
            countyNumber.setVisibility(View.VISIBLE);
        }else {
            countyNumber.setVisibility(View.GONE);
        }
        return view;
    }

}
