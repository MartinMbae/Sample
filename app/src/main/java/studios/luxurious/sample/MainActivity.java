package studios.luxurious.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import studios.luxurious.kenya47counties.activities.Kenya47Counties;
import studios.luxurious.kenya47counties.activities.CountyReturned;
import studios.luxurious.kenya47counties.models.County;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void ShowCounties(View view) {

        Kenya47Counties.showAllCountiesDialog(MainActivity.this, "Title", true, true, false, new CountyReturned() {

            @Override
            public void onSelectedCounty(County selectedCounty) {

                Toast.makeText(MainActivity.this, "You've selected "+ selectedCounty.getName(), Toast.LENGTH_SHORT).show();
            }
        });


    }


}
