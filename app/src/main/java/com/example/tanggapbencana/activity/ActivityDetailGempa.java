package com.example.tanggapbencana.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tanggapbencana.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class ActivityDetailGempa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropTandaGempa;
    private ImageButton btnDropVulkanik, btnDropTektonik, btnDropRuntuhan;
    private ImageButton btnDropLangkahPenyelamatan;
    private TextView descTandaGempa;
    private TextView descVulkanik, descTektonik, descRuntuhan;
    private TextView descLangkahPenyelamatan;

    private boolean isButtonDescTandaGempa = true;
    private boolean isButtonDescVulkanik = true;
    private boolean isButtonDescTektonik = true;
    private boolean isButtonDescRuntuhan = true;
    private boolean isButtonDescLangkahPenyelamatan = true;

    private MapView mapView;
    private GoogleMap googleMap;
    private int MY_PERMISSION_LOCATION;
    private Marker manggadua;
    private Marker pegadungan;
    private Marker cibubur;
    private Marker rawamangun;
    private Marker pejaten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gempa);
        btnDropTandaGempa = findViewById(R.id.btn_dropdown_desc_tanda_gempa);

        btnDropVulkanik = findViewById(R.id.btn_dropdown_desc_gempa_vulkanik);
        btnDropTektonik = findViewById(R.id.btn_dropdown_desc_gempa_tektonik);
        btnDropRuntuhan = findViewById(R.id.btn_dropdown_desc_gempa_runtuhan);

        btnDropLangkahPenyelamatan = findViewById(R.id.btn_dropdown_desc_langkah_penyelamatan_gempa);

        descTandaGempa = findViewById(R.id.desc_tanda_gempa);

        descVulkanik = findViewById(R.id.desc_gempa_vulkanik);
        descTektonik = findViewById(R.id.desc_gempa_tektonik);
        descRuntuhan = findViewById(R.id.desc_lereng_gempa_runtuhan);

        descLangkahPenyelamatan = findViewById(R.id.desc_langkah_penyelamatan_gempa);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnDropTandaGempa.setOnClickListener(this);
        btnDropVulkanik.setOnClickListener(this);
        btnDropTektonik.setOnClickListener(this);
        btnDropRuntuhan.setOnClickListener(this);
        btnDropLangkahPenyelamatan.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_tanda_gempa:
                if(isButtonDescTandaGempa){
                    btnDropTandaGempa.setImageResource(R.drawable.ic_arrow_up);
                    descTandaGempa.setVisibility(View.VISIBLE);
                    isButtonDescTandaGempa =false;
                }else{
                    btnDropTandaGempa.setImageResource(R.drawable.ic_arrow_down);
                    descTandaGempa.setVisibility(View.GONE);
                    isButtonDescTandaGempa =true;
                }
                break;
            case R.id.btn_dropdown_desc_gempa_vulkanik:
                if(isButtonDescVulkanik){
                    btnDropVulkanik.setImageResource(R.drawable.ic_arrow_up);
                    descVulkanik.setVisibility(View.VISIBLE);
                    isButtonDescVulkanik =false;
                }else{
                    btnDropVulkanik.setImageResource(R.drawable.ic_arrow_down);
                    descVulkanik.setVisibility(View.GONE);
                    isButtonDescVulkanik =true;
                }
                break;
            case R.id.btn_dropdown_desc_gempa_tektonik:
                if(isButtonDescTektonik){
                    btnDropTektonik.setImageResource(R.drawable.ic_arrow_up);
                    descTektonik.setVisibility(View.VISIBLE);
                    isButtonDescTektonik =false;
                }else{
                    btnDropTektonik.setImageResource(R.drawable.ic_arrow_down);
                    descTektonik.setVisibility(View.GONE);
                    isButtonDescTektonik =true;
                }
                break;
            case R.id.btn_dropdown_desc_gempa_runtuhan:
                if(isButtonDescRuntuhan){
                    btnDropRuntuhan.setImageResource(R.drawable.ic_arrow_up);
                    descRuntuhan.setVisibility(View.VISIBLE);
                    isButtonDescRuntuhan =false;
                }else{
                    btnDropRuntuhan.setImageResource(R.drawable.ic_arrow_down);
                    descRuntuhan.setVisibility(View.GONE);
                    isButtonDescRuntuhan =true;
                }
                break;
            case R.id.btn_dropdown_desc_langkah_penyelamatan_gempa:
                if(isButtonDescLangkahPenyelamatan){
                    btnDropLangkahPenyelamatan.setImageResource(R.drawable.ic_arrow_up);
                    descLangkahPenyelamatan.setVisibility(View.VISIBLE);
                    isButtonDescLangkahPenyelamatan =false;
                }else{
                    btnDropLangkahPenyelamatan.setImageResource(R.drawable.ic_arrow_down);
                    descLangkahPenyelamatan.setVisibility(View.GONE);
                    isButtonDescLangkahPenyelamatan =true;
                }
                break;
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        googleMap = gMap;

        try {
            MapsInitializer.initialize(this.getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        gpsPermissionCheck();

        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-6.21462, 106.84513), 10));

        manggadua = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.141970, 106.828178))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        pegadungan = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.132363, 106.705841))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        cibubur = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.356591, 106.882706))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        rawamangun = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.193144, 106.881557))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        pejaten = googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.271584, 106.837923))
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

        gMap.setOnMarkerClickListener(this);
    }

    private void gpsPermissionCheck() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && this.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_LOCATION);
        } else {
            googleMap.setMyLocationEnabled(true);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
