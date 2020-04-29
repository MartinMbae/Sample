package studios.luxurious.sample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import studios.luxurious.kenya47counties.activities.Kenya47Counties;
import studios.luxurious.kenya47counties.models.County;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ShowCounties(View view) {

        County selectedCounty = Kenya47Counties.showAllCountiesDialog(MainActivity.this,"Title",true, true,false);

        Toast.makeText(this, "Selection"+ selectedCounty.getName(), Toast.LENGTH_SHORT).show();

    }
}
