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

public class ActivityDetailAnginTopan extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, View.OnClickListener {

    private ImageButton btnDropSuhu, btnDropHewan, btnDropAnginCpt, btnDropAwanTiba;
    private ImageButton btnDropTekanan, btnDropUdaraPanas, btnDropPenguapan, btnDropPusaranAngin, btnDropCuacaRumit;
    private TextView descSuhu, descHewan, descAnginCepat, descAwanTiba;
    private TextView descTekanan, descUdaraPanas, descPenguapan, descPusaranAngin, descCuacaRumit;

    private boolean isButtonDescSuhu = true;
    private boolean isButtonDescHewan = true;
    private boolean isButtonDescAnginCepat = true;
    private boolean isButtonDescAwanTiba = true;
    private boolean isButtonDescTekanan = true;
    private boolean isButtonDescUdaraPanas = true;
    private boolean isButtonDescPenguapan = true;
    private boolean isButtonDescPusaranAngin = true;
    private boolean isButtonDescCuacaRumit = true;

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
        setContentView(R.layout.activity_detail_angin_topan);

        btnDropSuhu = findViewById(R.id.btn_dropdown_desc_peningkatan_suhu);
        btnDropHewan = findViewById(R.id.btn_dropdown_desc_burung_dan_binatang);
        btnDropAnginCpt = findViewById(R.id.btn_dropdown_desc_angin_cepat);
        btnDropAwanTiba = findViewById(R.id.btn_dropdown_desc_awan_tiba);

        btnDropTekanan = findViewById(R.id.btn_dropdown_desc_perbedaan_tekanan);
        btnDropUdaraPanas = findViewById(R.id.btn_dropdown_desc_suhu_udara_panas);
        btnDropPenguapan = findViewById(R.id.btn_dropdown_desc_penguapan_air_laut);
        btnDropPusaranAngin = findViewById(R.id.btn_dropdown_desc_pusaran_angin);
        btnDropCuacaRumit = findViewById(R.id.btn_dropdown_desc_kerumitan_cuaca);

        descSuhu = findViewById(R.id.desc_peningkatan_suhu);
        descHewan = findViewById(R.id.desc_burung_dan_binatang);
        descAnginCepat = findViewById(R.id.desc_angin_cepat);
        descAwanTiba = findViewById(R.id.desc_awan_tiba);

        descTekanan = findViewById(R.id.desc_perbedaan_tekanan);
        descUdaraPanas = findViewById(R.id.desc_suhu_udara_panas);
        descPenguapan = findViewById(R.id.desc_penguapan_air_laut);
        descPusaranAngin = findViewById(R.id.desc_pusaran_angin);
        descCuacaRumit = findViewById(R.id.desc_kerumitan_cuaca);

        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        btnDropSuhu.setOnClickListener(this);
        btnDropHewan.setOnClickListener(this);
        btnDropAnginCpt.setOnClickListener(this);
        btnDropAwanTiba.setOnClickListener(this);
        btnDropTekanan.setOnClickListener(this);
        btnDropUdaraPanas.setOnClickListener(this);
        btnDropPenguapan.setOnClickListener(this);
        btnDropPusaranAngin.setOnClickListener(this);
        btnDropCuacaRumit.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_dropdown_desc_peningkatan_suhu:
                if(isButtonDescSuhu){
                    btnDropSuhu.setImageResource(R.drawable.ic_arrow_up);
                    descSuhu.setVisibility(View.VISIBLE);
                    isButtonDescSuhu =false;
                }else{
                    btnDropSuhu.setImageResource(R.drawable.ic_arrow_down);
                    descSuhu.setVisibility(View.GONE);
                    isButtonDescSuhu =true;
                }
                break;
            case R.id.btn_dropdown_desc_burung_dan_binatang:
                if(isButtonDescHewan){
                    btnDropHewan.setImageResource(R.drawable.ic_arrow_up);
                    descHewan.setVisibility(View.VISIBLE);
                    isButtonDescHewan=false;
                }else{
                    btnDropHewan.setImageResource(R.drawable.ic_arrow_down);
                    descHewan.setVisibility(View.GONE);
                    isButtonDescHewan=true;
                }
                break;
            case R.id.btn_dropdown_desc_angin_cepat:
                if(isButtonDescAnginCepat){
                    btnDropAnginCpt.setImageResource(R.drawable.ic_arrow_up);
                    descAnginCepat.setVisibility(View.VISIBLE);
                    isButtonDescAnginCepat =false;
                }else{
                    btnDropAnginCpt.setImageResource(R.drawable.ic_arrow_down);
                    descAnginCepat.setVisibility(View.GONE);
                    isButtonDescAnginCepat =true;
                }
                break;

            case R.id.btn_dropdown_desc_awan_tiba:
                if(isButtonDescAwanTiba){
                    btnDropAwanTiba.setImageResource(R.drawable.ic_arrow_up);
                    descAwanTiba.setVisibility(View.VISIBLE);
                    isButtonDescAwanTiba =false;
                }else{
                    btnDropAwanTiba.setImageResource(R.drawable.ic_arrow_down);
                    descAwanTiba.setVisibility(View.GONE);
                    isButtonDescAwanTiba =true;
                }
                break;
            case R.id.btn_dropdown_desc_perbedaan_tekanan:
                if(isButtonDescTekanan){
                    btnDropTekanan.setImageResource(R.drawable.ic_arrow_up);
                    descTekanan.setVisibility(View.VISIBLE);
                    isButtonDescTekanan =false;
                }else{
                    btnDropTekanan.setImageResource(R.drawable.ic_arrow_down);
                    descTekanan.setVisibility(View.GONE);
                    isButtonDescTekanan =true;
                }
                break;
            case R.id.btn_dropdown_desc_suhu_udara_panas:
                if(isButtonDescUdaraPanas){
                    btnDropUdaraPanas.setImageResource(R.drawable.ic_arrow_up);
                    descUdaraPanas.setVisibility(View.VISIBLE);
                    isButtonDescUdaraPanas =false;
                }else{
                    btnDropUdaraPanas.setImageResource(R.drawable.ic_arrow_down);
                    descUdaraPanas.setVisibility(View.GONE);
                    isButtonDescUdaraPanas =true;
                }
                break;
            case R.id.btn_dropdown_desc_penguapan_air_laut:
                if(isButtonDescPenguapan){
                    btnDropPenguapan.setImageResource(R.drawable.ic_arrow_up);
                    descPenguapan.setVisibility(View.VISIBLE);
                    isButtonDescPenguapan =false;
                }else{
                    btnDropPenguapan.setImageResource(R.drawable.ic_arrow_down);
                    descPenguapan.setVisibility(View.GONE);
                    isButtonDescPenguapan =true;
                }
                break;
            case R.id.btn_dropdown_desc_pusaran_angin:
                if(isButtonDescPusaranAngin){
                    btnDropPusaranAngin.setImageResource(R.drawable.ic_arrow_up);
                    descPusaranAngin.setVisibility(View.VISIBLE);
                    isButtonDescPusaranAngin =false;
                }else{
                    btnDropPusaranAngin.setImageResource(R.drawable.ic_arrow_down);
                    descPusaranAngin.setVisibility(View.GONE);
                    isButtonDescPusaranAngin =true;
                }
                break;
            case R.id.btn_dropdown_desc_kerumitan_cuaca:
                if(isButtonDescCuacaRumit){
                    btnDropCuacaRumit.setImageResource(R.drawable.ic_arrow_up);
                    descCuacaRumit.setVisibility(View.VISIBLE);
                    isButtonDescCuacaRumit =false;
                }else{
                    btnDropCuacaRumit.setImageResource(R.drawable.ic_arrow_down);
                    descCuacaRumit.setVisibility(View.GONE);
                    isButtonDescCuacaRumit =true;
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
