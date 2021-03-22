package com.example.tanggapbencana.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.tanggapbencana.R;
import com.example.tanggapbencana.activity.ActivityDetailAnginTopan;
import com.example.tanggapbencana.activity.ActivityDetailBanjir;
import com.example.tanggapbencana.activity.ActivityDetailGunungMeletus;
import com.example.tanggapbencana.activity.ActivityDetailGempa;
import com.example.tanggapbencana.activity.ActivityDetailLongsor;
import com.example.tanggapbencana.activity.ActivityDetailTsunami;
import com.example.tanggapbencana.adapter.SliderAdapterExample;
import com.example.tanggapbencana.model.SliderItem;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private SliderView sliderView;
    private SliderAdapterExample adapter;
    private ArrayList<SliderItem> sliderItems = new ArrayList<>();

    private CardView btnBanjir, btnTsunami, btnGunungMeletus, btnGempa, btnLongsor, btnAnginTopan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.imageSlider);

        adapter = new SliderAdapterExample(getContext());
        sliderItems.add(new SliderItem(R.drawable.slider_item1));
        sliderItems.add(new SliderItem(R.drawable.slider_item2));
        sliderItems.add(new SliderItem(R.drawable.slider_item3));
        adapter.setmSliderItems(sliderItems);
        sliderView.setSliderAdapter(adapter);

        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        btnBanjir = view.findViewById(R.id.cv_banjir);
        btnTsunami = view.findViewById(R.id.cv_tsunami);
        btnGunungMeletus = view.findViewById(R.id.cv_gunung_meletus);
        btnGempa = view.findViewById(R.id.cv_gempa);
        btnLongsor = view.findViewById(R.id.cv_longsor);
        btnAnginTopan = view.findViewById(R.id.cv_angin_topan);

        btnBanjir.setOnClickListener(this);
        btnTsunami.setOnClickListener(this);
        btnGunungMeletus.setOnClickListener(this);
        btnGempa.setOnClickListener(this);
        btnLongsor.setOnClickListener(this);
        btnAnginTopan.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cv_banjir:
                Intent intentBanjir = new Intent(getActivity(), ActivityDetailBanjir.class);
                startActivity(intentBanjir);
                break;
            case R.id.cv_tsunami:
                Intent intentTsunami = new Intent(getActivity(), ActivityDetailTsunami.class);
                startActivity(intentTsunami);
                break;
            case R.id.cv_gunung_meletus:
                Intent intentGunungMeletus = new Intent(getActivity(), ActivityDetailGunungMeletus.class);
                startActivity(intentGunungMeletus);
                break;
            case R.id.cv_gempa:
                Intent intentGempa = new Intent(getActivity(), ActivityDetailGempa.class);
                startActivity(intentGempa);
                break;
            case R.id.cv_longsor:
                Intent intentLongsor = new Intent(getActivity(), ActivityDetailLongsor.class);
                startActivity(intentLongsor);
                break;
            case R.id.cv_angin_topan:
                Intent intentAnginTopan = new Intent(getActivity(), ActivityDetailAnginTopan.class);
                startActivity(intentAnginTopan);
                break;
        }
    }
}
