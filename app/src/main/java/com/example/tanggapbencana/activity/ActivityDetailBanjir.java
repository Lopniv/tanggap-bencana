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

public class ActivityDetailBanjir extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropTandaBanjir;
    private ImageButton btnDropHujanBesar, btnDropSungaiMeluap, btnDropBadai, btnDropBendunganRusak;
    private TextView descTandaBanjir;
    private TextView descHujanBesar, descSungaiMeluap, descBadai, descBendunganRusak;

    private boolean isButtonDescTandaBanjir = true;
    private boolean isButtonDescHujanBesar = true;
    private boolean isButtonDescSungaiMeluap = true;
    private boolean isButtonDescBadai = true;
    private boolean isButtonDescBendunganRusak = true;

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
        setContentView(R.layout.activity_detail_banjir);

        btnDropTandaBanjir = findViewById(R.id.btn_dropdown_desc_tanda_banjir);

        btnDropHujanBesar = findViewById(R.id.btn_dropdown_desc_hujan_besar);
        btnDropSungaiMeluap = findViewById(R.id.btn_dropdown_desc_sungai_meluap);
        btnDropBadai = findViewById(R.id.btn_dropdown_desc_badai);
        btnDropBendunganRusak = findViewById(R.id.btn_dropdown_desc_bendungan_rusak);

        descTandaBanjir = findViewById(R.id.desc_tanda_banjir);

        descHujanBesar = findViewById(R.id.desc_hujan_besar);
        descSungaiMeluap = findViewById(R.id.desc_sungai_meluap);
        descBadai = findViewById(R.id.desc_lereng_badai);
        descBendunganRusak = findViewById(R.id.desc_bendungan_rusak);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnDropTandaBanjir.setOnClickListener(this);
        btnDropHujanBesar.setOnClickListener(this);
        btnDropSungaiMeluap.setOnClickListener(this);
        btnDropBadai.setOnClickListener(this);
        btnDropBendunganRusak.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_tanda_banjir:
                if(isButtonDescTandaBanjir){
                    btnDropTandaBanjir.setImageResource(R.drawable.ic_arrow_up);
                    descTandaBanjir.setVisibility(View.VISIBLE);
                    isButtonDescTandaBanjir =false;
                }else{
                    btnDropTandaBanjir.setImageResource(R.drawable.ic_arrow_down);
                    descTandaBanjir.setVisibility(View.GONE);
                    isButtonDescTandaBanjir =true;
                }
                break;
            case R.id.btn_dropdown_desc_hujan_besar:
                if(isButtonDescHujanBesar){
                    btnDropHujanBesar.setImageResource(R.drawable.ic_arrow_up);
                    descHujanBesar.setVisibility(View.VISIBLE);
                    isButtonDescHujanBesar =false;
                }else{
                    btnDropHujanBesar.setImageResource(R.drawable.ic_arrow_down);
                    descHujanBesar.setVisibility(View.GONE);
                    isButtonDescHujanBesar =true;
                }
                break;
            case R.id.btn_dropdown_desc_sungai_meluap:
                if(isButtonDescSungaiMeluap){
                    btnDropSungaiMeluap.setImageResource(R.drawable.ic_arrow_up);
                    descSungaiMeluap.setVisibility(View.VISIBLE);
                    isButtonDescSungaiMeluap =false;
                }else{
                    btnDropSungaiMeluap.setImageResource(R.drawable.ic_arrow_down);
                    descSungaiMeluap.setVisibility(View.GONE);
                    isButtonDescSungaiMeluap =true;
                }
                break;
            case R.id.btn_dropdown_desc_badai:
                if(isButtonDescBadai){
                    btnDropBadai.setImageResource(R.drawable.ic_arrow_up);
                    descBadai.setVisibility(View.VISIBLE);
                    isButtonDescBadai =false;
                }else{
                    btnDropBadai.setImageResource(R.drawable.ic_arrow_down);
                    descBadai.setVisibility(View.GONE);
                    isButtonDescBadai =true;
                }
                break;
            case R.id.btn_dropdown_desc_bendungan_rusak:
                if(isButtonDescBendunganRusak){
                    btnDropBendunganRusak.setImageResource(R.drawable.ic_arrow_up);
                    descBendunganRusak.setVisibility(View.VISIBLE);
                    isButtonDescBendunganRusak =false;
                }else{
                    btnDropBendunganRusak.setImageResource(R.drawable.ic_arrow_down);
                    descBendunganRusak.setVisibility(View.GONE);
                    isButtonDescBendunganRusak =true;
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
