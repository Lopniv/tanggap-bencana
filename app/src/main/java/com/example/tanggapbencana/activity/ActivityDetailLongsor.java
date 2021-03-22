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

public class ActivityDetailLongsor extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropCurahHujan, btnDropErosi, btnDropLereng, btnDropGundul;
    private ImageButton btnDropRetakan, btnDropMataAir, btnDropGenangan, btnDropTanaman, btnDropTiang, btnDropGemuruh;
    private ImageButton btnDropSebelum, btnDropSaat, btnDropSesudah;
    private TextView descCurahHujan, descErosi, descLereng, descGundul;
    private TextView descRetakan, descMataAir, descGenangan, descTanaman, descTiang, descGemuruh;
    private TextView descSebelum, descSaat, descSesudah;

    private boolean isButtonDescCurahHujan = true;
    private boolean isButtonDescErosi = true;
    private boolean isButtonDescLereng = true;
    private boolean isButtonDescGundul = true;
    private boolean isButtonDescRetakan = true;
    private boolean isButtonDescMataAir = true;
    private boolean isButtonDescGenangan = true;
    private boolean isButtonDescTanaman = true;
    private boolean isButtonDescTiang = true;
    private boolean isButtonDescGemuruh = true;
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
        setContentView(R.layout.activity_detail_longsor);

        btnDropCurahHujan = findViewById(R.id.btn_dropdown_desc_tinggi_curah_hujan);
        btnDropErosi = findViewById(R.id.btn_dropdown_desc_erosi_tanah);
        btnDropLereng = findViewById(R.id.btn_dropdown_desc_lereng_tebing_terjal);
        btnDropGundul = findViewById(R.id.btn_dropdown_desc_hutan_gundul);

        btnDropRetakan = findViewById(R.id.btn_dropdown_desc_retakan_lereng);
        btnDropMataAir = findViewById(R.id.btn_dropdown_desc_mata_air_baru);
        btnDropGenangan = findViewById(R.id.btn_dropdown_desc_genangan_air);
        btnDropTanaman = findViewById(R.id.btn_dropdown_desc_tanaman_miring);
        btnDropTiang = findViewById(R.id.btn_dropdown_desc_tiang_tidak_tegak);
        btnDropGemuruh = findViewById(R.id.btn_dropdown_desc_gemuruh);

        btnDropSebelum = findViewById(R.id.btn_dropdown_desc_sebelum_longsor);
        btnDropSaat = findViewById(R.id.btn_dropdown_desc_saat_longsor);
        btnDropSesudah = findViewById(R.id.btn_dropdown_desc_setelah_longsor);

        descCurahHujan = findViewById(R.id.desc_tinggi_curah_hujan);
        descErosi = findViewById(R.id.desc_erosi_tanah);
        descLereng = findViewById(R.id.desc_lereng_tebing_terjal);
        descGundul = findViewById(R.id.desc_hutan_gundul);

        descRetakan = findViewById(R.id.desc_retakan_lereng);
        descMataAir = findViewById(R.id.desc_mata_air_baru);
        descGenangan = findViewById(R.id.desc_genangan_air);
        descTanaman = findViewById(R.id.desc_tanaman_miring);
        descTiang = findViewById(R.id.desc_tiang_tidak_tegak);
        descGemuruh = findViewById(R.id.desc_gemuruh);

        descSebelum = findViewById(R.id.desc_sebelum_longsor);
        descSaat = findViewById(R.id.desc_saat_longsor);
        descSesudah = findViewById(R.id.desc_setelah_longsor);

        btnDropCurahHujan.setOnClickListener(this);
        btnDropErosi.setOnClickListener(this);
        btnDropLereng.setOnClickListener(this);
        btnDropGundul.setOnClickListener(this);
        btnDropRetakan.setOnClickListener(this);
        btnDropMataAir.setOnClickListener(this);
        btnDropGenangan.setOnClickListener(this);
        btnDropTanaman.setOnClickListener(this);
        btnDropTiang.setOnClickListener(this);
        btnDropGemuruh.setOnClickListener(this);
        btnDropSebelum.setOnClickListener(this);
        btnDropSaat.setOnClickListener(this);
        btnDropSesudah.setOnClickListener(this);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_retakan_lereng:
                if(isButtonDescRetakan){
                    btnDropRetakan.setImageResource(R.drawable.ic_arrow_up);
                    descRetakan.setVisibility(View.VISIBLE);
                    isButtonDescRetakan=false;
                }else{
                    btnDropRetakan.setImageResource(R.drawable.ic_arrow_down);
                    descRetakan.setVisibility(View.GONE);
                    isButtonDescRetakan=true;
                }
                break;
            case R.id.btn_dropdown_desc_genangan_air:
                if(isButtonDescGenangan){
                    btnDropGenangan.setImageResource(R.drawable.ic_arrow_up);
                    descGenangan.setVisibility(View.VISIBLE);
                    isButtonDescGenangan=false;
                }else{
                    btnDropGenangan.setImageResource(R.drawable.ic_arrow_down);
                    descGenangan.setVisibility(View.GONE);
                    isButtonDescGenangan=true;
                }
                break;
            case R.id.btn_dropdown_desc_tanaman_miring:
                if(isButtonDescTanaman){
                    btnDropTanaman.setImageResource(R.drawable.ic_arrow_up);
                    descTanaman.setVisibility(View.VISIBLE);
                    isButtonDescTanaman=false;
                }else{
                    btnDropTanaman.setImageResource(R.drawable.ic_arrow_down);
                    descTanaman.setVisibility(View.GONE);
                    isButtonDescTanaman=true;
                }
                break;
            case R.id.btn_dropdown_desc_tiang_tidak_tegak:
                if(isButtonDescTiang){
                    btnDropTiang.setImageResource(R.drawable.ic_arrow_up);
                    descTiang.setVisibility(View.VISIBLE);
                    isButtonDescTiang=false;
                }else{
                    btnDropTiang.setImageResource(R.drawable.ic_arrow_down);
                    descTiang.setVisibility(View.GONE);
                    isButtonDescTiang=true;
                }
                break;
            case R.id.btn_dropdown_desc_gemuruh:
                if(isButtonDescGemuruh){
                    btnDropGemuruh.setImageResource(R.drawable.ic_arrow_up);
                    descGemuruh.setVisibility(View.VISIBLE);
                    isButtonDescGemuruh=false;
                }else{
                    btnDropGemuruh.setImageResource(R.drawable.ic_arrow_down);
                    descGemuruh.setVisibility(View.GONE);
                    isButtonDescGemuruh=true;
                }
                break;
            case R.id.btn_dropdown_desc_mata_air_baru:
                if(isButtonDescMataAir){
                    btnDropMataAir.setImageResource(R.drawable.ic_arrow_up);
                    descMataAir.setVisibility(View.VISIBLE);
                    isButtonDescMataAir=false;
                }else{
                    btnDropMataAir.setImageResource(R.drawable.ic_arrow_down);
                    descMataAir.setVisibility(View.GONE);
                    isButtonDescMataAir=true;
                }
                break;
            case R.id.btn_dropdown_desc_tinggi_curah_hujan:
                if(isButtonDescCurahHujan){
                    btnDropCurahHujan.setImageResource(R.drawable.ic_arrow_up);
                    descCurahHujan.setVisibility(View.VISIBLE);
                    isButtonDescCurahHujan=false;
                }else{
                    btnDropCurahHujan.setImageResource(R.drawable.ic_arrow_down);
                    descCurahHujan.setVisibility(View.GONE);
                    isButtonDescCurahHujan=true;
                }
                break;
            case R.id.btn_dropdown_desc_erosi_tanah:
                if(isButtonDescErosi){
                    btnDropErosi.setImageResource(R.drawable.ic_arrow_up);
                    descErosi.setVisibility(View.VISIBLE);
                    isButtonDescErosi=false;
                }else{
                    btnDropErosi.setImageResource(R.drawable.ic_arrow_down);
                    descErosi.setVisibility(View.GONE);
                    isButtonDescErosi=true;
                }
                break;
            case R.id.btn_dropdown_desc_lereng_tebing_terjal:
                if(isButtonDescLereng){
                    btnDropLereng.setImageResource(R.drawable.ic_arrow_up);
                    descLereng.setVisibility(View.VISIBLE);
                    isButtonDescLereng=false;
                }else{
                    btnDropLereng.setImageResource(R.drawable.ic_arrow_down);
                    descLereng.setVisibility(View.GONE);
                    isButtonDescLereng=true;
                }
                break;
            case R.id.btn_dropdown_desc_hutan_gundul:
                if(isButtonDescGundul){
                    btnDropGundul.setImageResource(R.drawable.ic_arrow_up);
                    descGundul.setVisibility(View.VISIBLE);
                    isButtonDescGundul=false;
                }else{
                    btnDropGundul.setImageResource(R.drawable.ic_arrow_down);
                    descGundul.setVisibility(View.GONE);
                    isButtonDescGundul=true;
                }
                break;
            case R.id.btn_dropdown_desc_sebelum_longsor:
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
            case R.id.btn_dropdown_desc_saat_longsor:
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
            case R.id.btn_dropdown_desc_setelah_longsor:
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
