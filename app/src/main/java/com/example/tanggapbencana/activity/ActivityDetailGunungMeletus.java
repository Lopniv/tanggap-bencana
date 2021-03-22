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

public class ActivityDetailGunungMeletus extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropSuhuKawah, btnDropBinatangHutan, btnDropSumberAir, btnDropTumbuhan, btnDropVulkanik, btnDropSuaraGemuruh, btnDropAwanPanas, btnDropHujanAbu;
    private ImageButton btnDropPenyebab;
    private ImageButton btnDropSebelum, btnDropSaat, btnDropSesudah;
    private TextView descSuhuKawah, descBinatangHutan, descSumberAir, descTumbuhan, descVulkanik, descSuaraGemuruh, descAwanPanas, descHujanAbu;
    private TextView descPenyebab;
    private TextView descSebelum, descSaat, descSesudah;

    private boolean isButtonDescSuhuKawah = true;
    private boolean isButtonDescBinatangHutan = true;
    private boolean isButtonDescSumberAir = true;
    private boolean isButtonDescTumbuhan = true;
    private boolean isButtonDescVulkanik = true;
    private boolean isButtonDescSuaraGemuruh = true;
    private boolean isButtonDescAwanPanas = true;
    private boolean isButtonDescHujanAbu = true;
    private boolean isButtonDescPenyebab = true;
    private boolean isButtonDescSebelum = true;
    private boolean isButtonDescSaat = true;
    private boolean isButtonDescSesudah = true;

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
        setContentView(R.layout.activity_detail_gunung_meletus);

        btnDropSuhuKawah = findViewById(R.id.btn_dropdown_desc_suhu_gunung_meningkat);
        btnDropBinatangHutan = findViewById(R.id.btn_dropdown_desc_hewan_turun_gunung);
        btnDropSumberAir = findViewById(R.id.btn_dropdown_desc_air_mengering);
        btnDropTumbuhan = findViewById(R.id.btn_dropdown_desc_tumbuhan_layu);
        btnDropVulkanik = findViewById(R.id.btn_dropdown_desc_ada_gempa_vulkanik);
        btnDropSuaraGemuruh = findViewById(R.id.btn_dropdown_desc_suara_gemuruh_gunung);
        btnDropAwanPanas = findViewById(R.id.btn_dropdown_desc_awan_panas);
        btnDropHujanAbu = findViewById(R.id.btn_dropdown_desc_hujan_abu);

        btnDropPenyebab = findViewById(R.id.btn_dropdown_desc_penyebab_gunung);

        btnDropSebelum = findViewById(R.id.btn_dropdown_desc_sebelum_erupsi);
        btnDropSaat = findViewById(R.id.btn_dropdown_desc_saat_gunung_berapi_meletus);
        btnDropSesudah = findViewById(R.id.btn_dropdown_desc_setelah_erupsi);

        descSuhuKawah = findViewById(R.id.desc_suhu_gunung_meningkat);
        descBinatangHutan = findViewById(R.id.desc_hewan_turun_gunung);
        descSumberAir = findViewById(R.id.desc_air_mengering);
        descTumbuhan = findViewById(R.id.desc_tumbuhan_layu);
        descVulkanik = findViewById(R.id.desc_ada_gempa_vulkanik);
        descSuaraGemuruh = findViewById(R.id.desc_suara_gemuruh_gunung);
        descAwanPanas = findViewById(R.id.desc_awan_panas);
        descHujanAbu = findViewById(R.id.desc_hujan_abu);

        descPenyebab = findViewById(R.id.desc_penyebab_gunung);

        descSebelum = findViewById(R.id.desc_sebelum_erupsi);
        descSaat = findViewById(R.id.desc_saat_gunung_berapi_meletus);
        descSesudah = findViewById(R.id.desc_setelah_erupsi);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnDropSuhuKawah.setOnClickListener(this);
        btnDropBinatangHutan.setOnClickListener(this);
        btnDropSumberAir.setOnClickListener(this);
        btnDropTumbuhan.setOnClickListener(this);
        btnDropVulkanik.setOnClickListener(this);
        btnDropSuaraGemuruh.setOnClickListener(this);
        btnDropAwanPanas.setOnClickListener(this);
        btnDropHujanAbu.setOnClickListener(this);
        btnDropPenyebab.setOnClickListener(this);
        btnDropSebelum.setOnClickListener(this);
        btnDropSaat.setOnClickListener(this);
        btnDropSesudah.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_suhu_gunung_meningkat:
                if(isButtonDescSuhuKawah){
                    btnDropSuhuKawah.setImageResource(R.drawable.ic_arrow_up);
                    descSuhuKawah.setVisibility(View.VISIBLE);
                    isButtonDescSuhuKawah =false;
                }else{
                    btnDropSuhuKawah.setImageResource(R.drawable.ic_arrow_down);
                    descSuhuKawah.setVisibility(View.GONE);
                    isButtonDescSuhuKawah =true;
                }
                break;
            case R.id.btn_dropdown_desc_hewan_turun_gunung:
                if(isButtonDescBinatangHutan){
                    btnDropBinatangHutan.setImageResource(R.drawable.ic_arrow_up);
                    descBinatangHutan.setVisibility(View.VISIBLE);
                    isButtonDescBinatangHutan =false;
                }else{
                    btnDropBinatangHutan.setImageResource(R.drawable.ic_arrow_down);
                    descBinatangHutan.setVisibility(View.GONE);
                    isButtonDescBinatangHutan =true;
                }
                break;
            case R.id.btn_dropdown_desc_air_mengering:
                if(isButtonDescSumberAir){
                    btnDropSumberAir.setImageResource(R.drawable.ic_arrow_up);
                    descSumberAir.setVisibility(View.VISIBLE);
                    isButtonDescSumberAir =false;
                }else{
                    btnDropSumberAir.setImageResource(R.drawable.ic_arrow_down);
                    descSumberAir.setVisibility(View.GONE);
                    isButtonDescSumberAir =true;
                }
                break;

            case R.id.btn_dropdown_desc_tumbuhan_layu:
                if(isButtonDescTumbuhan){
                    btnDropTumbuhan.setImageResource(R.drawable.ic_arrow_up);
                    descTumbuhan.setVisibility(View.VISIBLE);
                    isButtonDescTumbuhan =false;
                }else{
                    btnDropTumbuhan.setImageResource(R.drawable.ic_arrow_down);
                    descTumbuhan.setVisibility(View.GONE);
                    isButtonDescTumbuhan =true;
                }
                break;
            case R.id.btn_dropdown_desc_ada_gempa_vulkanik:
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
            case R.id.btn_dropdown_desc_suara_gemuruh_gunung:
                if(isButtonDescSuaraGemuruh){
                    btnDropSuaraGemuruh.setImageResource(R.drawable.ic_arrow_up);
                    descSuaraGemuruh.setVisibility(View.VISIBLE);
                    isButtonDescSuaraGemuruh =false;
                }else{
                    btnDropSuaraGemuruh.setImageResource(R.drawable.ic_arrow_down);
                    descSuaraGemuruh.setVisibility(View.GONE);
                    isButtonDescSuaraGemuruh =true;
                }
                break;
            case R.id.btn_dropdown_desc_awan_panas:
                if(isButtonDescAwanPanas){
                    btnDropAwanPanas.setImageResource(R.drawable.ic_arrow_up);
                    descAwanPanas.setVisibility(View.VISIBLE);
                    isButtonDescAwanPanas =false;
                }else{
                    btnDropAwanPanas.setImageResource(R.drawable.ic_arrow_down);
                    descAwanPanas.setVisibility(View.GONE);
                    isButtonDescAwanPanas =true;
                }
                break;
            case R.id.btn_dropdown_desc_hujan_abu:
                if(isButtonDescHujanAbu){
                    btnDropHujanAbu.setImageResource(R.drawable.ic_arrow_up);
                    descHujanAbu.setVisibility(View.VISIBLE);
                    isButtonDescHujanAbu =false;
                }else{
                    btnDropHujanAbu.setImageResource(R.drawable.ic_arrow_down);
                    descHujanAbu.setVisibility(View.GONE);
                    isButtonDescHujanAbu =true;
                }
                break;
            case R.id.btn_dropdown_desc_penyebab_gunung:
                if(isButtonDescPenyebab){
                    btnDropPenyebab.setImageResource(R.drawable.ic_arrow_up);
                    descPenyebab.setVisibility(View.VISIBLE);
                    isButtonDescPenyebab =false;
                }else{
                    btnDropPenyebab.setImageResource(R.drawable.ic_arrow_down);
                    descPenyebab.setVisibility(View.GONE);
                    isButtonDescPenyebab =true;
                }
                break;
            case R.id.btn_dropdown_desc_sebelum_erupsi:
                if(isButtonDescSebelum){
                    btnDropSebelum.setImageResource(R.drawable.ic_arrow_up);
                    descSebelum.setVisibility(View.VISIBLE);
                    isButtonDescSebelum =false;
                }else{
                    btnDropSebelum.setImageResource(R.drawable.ic_arrow_down);
                    descSebelum.setVisibility(View.GONE);
                    isButtonDescSebelum =true;
                }
                break;
            case R.id.btn_dropdown_desc_saat_gunung_berapi_meletus:
                if(isButtonDescSaat){
                    btnDropSaat.setImageResource(R.drawable.ic_arrow_up);
                    descSaat.setVisibility(View.VISIBLE);
                    isButtonDescSaat =false;
                }else{
                    btnDropSaat.setImageResource(R.drawable.ic_arrow_down);
                    descSaat.setVisibility(View.GONE);
                    isButtonDescSaat =true;
                }
                break;
            case R.id.btn_dropdown_desc_setelah_erupsi:
                if(isButtonDescSesudah){
                    btnDropSesudah.setImageResource(R.drawable.ic_arrow_up);
                    descSesudah.setVisibility(View.VISIBLE);
                    isButtonDescSesudah =false;
                }else{
                    btnDropSesudah.setImageResource(R.drawable.ic_arrow_down);
                    descSesudah.setVisibility(View.GONE);
                    isButtonDescSesudah =true;
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
