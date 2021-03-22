package com.example.tanggapbencana.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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

public class ActivityDetailTsunami extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropKondisiAir, btnDropSuaraGemuruh, btnDropTingkahHewan, btnDropGempa, btnDropGelombangLaut, btnDropAwan;
    private ImageButton btnDropGempaLaut, btnDropGunungApi, btnDropLongsorLaut, btnDropMeteor, btnDropManusia;
    private TextView descKondisiAirLaut, descSuara, descHewan, descGempa, descGelombang, descAwan;
    private TextView descGempaLaut, descGunungApi, descLongsorLaut, descMeteor, descManusia;

    private boolean isButtonDescKondisiAir = true;
    private boolean isButtonDescSuara = true;
    private boolean isButtonDescHewan = true;
    private boolean isButtonDescGempa = true;
    private boolean isButtonDescGelombang = true;
    private boolean isButtonDescAwan = true;
    private boolean isButtonDescGempaLaut = true;
    private boolean isButtonDescGunungApi = true;
    private boolean isButtonDescLongsorLaut = true;
    private boolean isButtonDescMeteor = true;
    private boolean isButtonDescManusia = true;

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
        setContentView(R.layout.activity_detail_tsunami);

        btnDropKondisiAir = findViewById(R.id.btn_dropdown_desc_kondisi_air_laut);
        btnDropSuaraGemuruh = findViewById(R.id.btn_dropdown_desc_suaru_gemuruh);
        btnDropTingkahHewan = findViewById(R.id.btn_dropdown_desc_tingkah_hewan);
        btnDropGempa = findViewById(R.id.btn_dropdown_desc_gempa_pengiring);
        btnDropGelombangLaut = findViewById(R.id.btn_dropdown_desc_gelombang_laut);
        btnDropAwan = findViewById(R.id.btn_dropdown_desc_keadaan_awan);

        btnDropGempaLaut = findViewById(R.id.btn_dropdown_desc_gempa_bumi_laut);
        btnDropGunungApi = findViewById(R.id.btn_dropdown_desc_gunung_berapi);
        btnDropLongsorLaut = findViewById(R.id.btn_dropdown_desc_longsor_laut);
        btnDropMeteor= findViewById(R.id.btn_dropdown_desc_hantaman_meteor);
        btnDropManusia = findViewById(R.id.btn_dropdown_desc_manusia);

        descKondisiAirLaut = findViewById(R.id.desc_kondisi_air_laut);
        descSuara = findViewById(R.id.desc_suaru_gemuruh);
        descHewan = findViewById(R.id.desc_tingkah_hewan);
        descGempa = findViewById(R.id.desc_gempa_pengiring);
        descGelombang = findViewById(R.id.desc_gelombang_laut);
        descAwan = findViewById(R.id.desc_keadaan_awan);

        descGempaLaut = findViewById(R.id.desc_gempa_bumi_laut);
        descGunungApi = findViewById(R.id.desc_gunung_berapi);
        descLongsorLaut = findViewById(R.id.desc_longsor_laut);
        descMeteor = findViewById(R.id.desc_hantaman_meteor);
        descManusia = findViewById(R.id.desc_manusia);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnDropKondisiAir.setOnClickListener(this);
        btnDropSuaraGemuruh.setOnClickListener(this);
        btnDropTingkahHewan.setOnClickListener(this);
        btnDropGempa.setOnClickListener(this);
        btnDropGelombangLaut.setOnClickListener(this);
        btnDropAwan.setOnClickListener(this);
        btnDropGempaLaut.setOnClickListener(this);
        btnDropGunungApi.setOnClickListener(this);
        btnDropLongsorLaut.setOnClickListener(this);
        btnDropMeteor.setOnClickListener(this);
        btnDropManusia.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_kondisi_air_laut:
                if(isButtonDescKondisiAir){
                    btnDropKondisiAir.setImageResource(R.drawable.ic_arrow_up);
                    descKondisiAirLaut.setVisibility(View.VISIBLE);
                    isButtonDescKondisiAir=false;
                }else{
                    btnDropKondisiAir.setImageResource(R.drawable.ic_arrow_down);
                    descKondisiAirLaut.setVisibility(View.GONE);
                    isButtonDescKondisiAir=true;
                }
                break;
            case R.id.btn_dropdown_desc_suaru_gemuruh:
                if(isButtonDescSuara){
                    btnDropSuaraGemuruh.setImageResource(R.drawable.ic_arrow_up);
                    descSuara.setVisibility(View.VISIBLE);
                    isButtonDescSuara=false;
                }else{
                    btnDropSuaraGemuruh.setImageResource(R.drawable.ic_arrow_down);
                    descSuara.setVisibility(View.GONE);
                    isButtonDescSuara=true;
                }
                break;
            case R.id.btn_dropdown_desc_tingkah_hewan:
                if(isButtonDescHewan){
                    btnDropTingkahHewan.setImageResource(R.drawable.ic_arrow_up);
                    descHewan.setVisibility(View.VISIBLE);
                    isButtonDescHewan=false;
                }else{
                    btnDropTingkahHewan.setImageResource(R.drawable.ic_arrow_down);
                    descHewan.setVisibility(View.GONE);
                    isButtonDescHewan=true;
                }
                break;
            case R.id.btn_dropdown_desc_gempa_pengiring:
                if(isButtonDescGempa){
                    btnDropGempa.setImageResource(R.drawable.ic_arrow_up);
                    descGempa.setVisibility(View.VISIBLE);
                    isButtonDescGempa=false;
                }else{
                    btnDropGempa.setImageResource(R.drawable.ic_arrow_down);
                    descGempa.setVisibility(View.GONE);
                    isButtonDescGempa=true;
                }
                break;
            case R.id.btn_dropdown_desc_gelombang_laut:
                if(isButtonDescGelombang){
                    btnDropGelombangLaut.setImageResource(R.drawable.ic_arrow_up);
                    descGelombang.setVisibility(View.VISIBLE);
                    isButtonDescGelombang=false;
                }else{
                    btnDropGelombangLaut.setImageResource(R.drawable.ic_arrow_down);
                    descGelombang.setVisibility(View.GONE);
                    isButtonDescGelombang=true;
                }
                break;
            case R.id.btn_dropdown_desc_keadaan_awan:
                if(isButtonDescAwan){
                    btnDropAwan.setImageResource(R.drawable.ic_arrow_up);
                    descAwan.setVisibility(View.VISIBLE);
                    isButtonDescAwan=false;
                }else{
                    btnDropAwan.setImageResource(R.drawable.ic_arrow_down);
                    descAwan.setVisibility(View.GONE);
                    isButtonDescAwan=true;
                }
                break;
            case R.id.btn_dropdown_desc_gempa_bumi_laut:
                if(isButtonDescGempaLaut){
                    btnDropGempaLaut.setImageResource(R.drawable.ic_arrow_up);
                    descGempaLaut.setVisibility(View.VISIBLE);
                    isButtonDescGempaLaut=false;
                }else{
                    btnDropGempaLaut.setImageResource(R.drawable.ic_arrow_down);
                    descGempaLaut.setVisibility(View.GONE);
                    isButtonDescGempaLaut=true;
                }
                break;
            case R.id.btn_dropdown_desc_gunung_berapi:
                if(isButtonDescGunungApi){
                    btnDropGunungApi.setImageResource(R.drawable.ic_arrow_up);
                    descGunungApi.setVisibility(View.VISIBLE);
                    isButtonDescGunungApi=false;
                }else{
                    btnDropGunungApi.setImageResource(R.drawable.ic_arrow_down);
                    descGunungApi.setVisibility(View.GONE);
                    isButtonDescGunungApi=true;
                }
                break;
            case R.id.btn_dropdown_desc_longsor_laut:
                if(isButtonDescLongsorLaut){
                    btnDropLongsorLaut.setImageResource(R.drawable.ic_arrow_up);
                    descLongsorLaut.setVisibility(View.VISIBLE);
                    isButtonDescLongsorLaut=false;
                }else{
                    btnDropLongsorLaut.setImageResource(R.drawable.ic_arrow_down);
                    descLongsorLaut.setVisibility(View.GONE);
                    isButtonDescLongsorLaut=true;
                }
                break;
            case R.id.btn_dropdown_desc_hantaman_meteor:
                if(isButtonDescMeteor){
                    btnDropMeteor.setImageResource(R.drawable.ic_arrow_up);
                    descMeteor.setVisibility(View.VISIBLE);
                    isButtonDescMeteor=false;
                }else{
                    btnDropMeteor.setImageResource(R.drawable.ic_arrow_down);
                    descMeteor.setVisibility(View.GONE);
                    isButtonDescMeteor=true;
                }
                break;
            case R.id.btn_dropdown_desc_manusia:
                if(isButtonDescManusia){
                    btnDropManusia.setImageResource(R.drawable.ic_arrow_up);
                    descManusia.setVisibility(View.VISIBLE);
                    isButtonDescManusia=false;
                }else{
                    btnDropManusia.setImageResource(R.drawable.ic_arrow_down);
                    descManusia.setVisibility(View.GONE);
                    isButtonDescManusia=true;
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
