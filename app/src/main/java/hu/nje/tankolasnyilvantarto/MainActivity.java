package hu.nje.tankolasnyilvantarto;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        // **************************
        // toolbar beállítása
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Tank app");
        // **************************
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fomenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_fooldal) {
            //showMessage("Főoldal");
            loadFragment(new Kezdolap(), "Fooldal");
        } else if (id == R.id.action_elozo_tankolasok) {
            //showMessage("Beállítások");
            loadFragment(new ElozoTankolasok(), "ElozoTankolasok");
        }else if (id == R.id.action_fogyasztasi_adatok) {
            //showMessage("Beállítások");
            //loadFragment(new Categories_fragment(), "FogyasztasiAdatok");
        }

        return true;
    }

    public void UjTankolasFragment(){
        loadFragment(new UjTankolas(), "ujtankolas");
    }

    public void UjElozoTankolasokFragment()
    {
        loadFragment(new ElozoTankolasok(), "elozo");
    }

    private void loadFragment(Fragment fragment, String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentContainerView, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }
}