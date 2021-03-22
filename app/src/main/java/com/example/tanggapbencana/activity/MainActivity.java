package com.example.tanggapbencana.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.tanggapbencana.R;
import com.example.tanggapbencana.fragment.AlertFragment;
import com.example.tanggapbencana.fragment.HomeFragment;
import com.example.tanggapbencana.fragment.PhoneFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bnv);

        showHome();
        bottomNavigationView.setSelectedItemId(R.id.menu_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                showHome();
                return true;
            case R.id.menu_alert:
                showAlert();
                return true;
            case R.id.menu_phone:
                showPhone();
                return true;
        }
        return false;
    }

    private void showHome() {
        Fragment fragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void showAlert() {
        Fragment fragment = new AlertFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }

    private void showPhone() {
        Fragment fragment = new PhoneFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
    }
}
