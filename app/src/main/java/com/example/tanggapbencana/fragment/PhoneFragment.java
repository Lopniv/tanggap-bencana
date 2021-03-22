package com.example.tanggapbencana.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.tanggapbencana.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhoneFragment extends Fragment implements View.OnClickListener {

    private CardView btnCallKepolisian, btnCallDarurat, btnCallAmbulan, btnCallAmb118, btnCallAmb119, btnCallPosko, btnCallPMI;
    private ImageButton  btnDropAmbulan;

    private boolean isButtonAmbulan = true;

    public PhoneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_phone, container, false);

        btnCallKepolisian = view.findViewById(R.id.btn_call_kepolisian);
        btnCallDarurat = view.findViewById(R.id.btn_call_darurat);
        btnCallAmbulan = view.findViewById(R.id.btn_call_ambulan);
        btnCallAmb118 = view.findViewById(R.id.btn_call_ambulan_118);
        btnCallAmb119 = view.findViewById(R.id.btn_call_ambulan_119);
        btnCallPosko = view.findViewById(R.id.btn_call_posko);
        btnCallPMI = view.findViewById(R.id.btn_call_pmi);
        btnDropAmbulan = view.findViewById(R.id.btn_dropdown_ambulan_call);

        btnDropAmbulan.setOnClickListener(this);
        btnCallKepolisian.setOnClickListener(this);
        btnCallDarurat.setOnClickListener(this);
        btnCallAmbulan.setOnClickListener(this);
        btnCallAmb118.setOnClickListener(this);
        btnCallAmb119.setOnClickListener(this);
        btnCallPosko.setOnClickListener(this);
        btnCallPMI.setOnClickListener(this);

        return view;
    }

    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_call_ambulan:
                if(isButtonAmbulan){
                    btnDropAmbulan.setImageResource(R.drawable.ic_arrow_up);
                    btnCallAmb118.setVisibility(View.VISIBLE);
                    btnCallAmb119.setVisibility(View.VISIBLE);
                    isButtonAmbulan=false;
                }else{
                    btnDropAmbulan.setImageResource(R.drawable.ic_arrow_down);
                    btnCallAmb118.setVisibility(View.GONE);
                    btnCallAmb119.setVisibility(View.GONE);
                    isButtonAmbulan=true;
                }
                break;
            case R.id.btn_call_kepolisian:
                String kepolisian = "110" ;
                Intent panggilKepolisian = new Intent(Intent. ACTION_DIAL);
                panggilKepolisian.setData(Uri. fromParts("tel",kepolisian,null));
                startActivity(panggilKepolisian);
                break;
            case R.id.btn_call_darurat:
                String darurat = "112" ;
                Intent panggilDarurat = new Intent(Intent. ACTION_DIAL);
                panggilDarurat.setData(Uri. fromParts("tel",darurat,null));
                startActivity(panggilDarurat);
                break;
            case R.id.btn_call_ambulan_118:
                String ambulan118 = "118" ;
                Intent panggilAmbulan118 = new Intent(Intent. ACTION_DIAL);
                panggilAmbulan118.setData(Uri. fromParts("tel",ambulan118,null));
                startActivity(panggilAmbulan118);
                break;
            case R.id.btn_call_ambulan_119:
                String ambulan119 = "119" ;
                Intent panggilAmbulan119 = new Intent(Intent. ACTION_DIAL);
                panggilAmbulan119.setData(Uri. fromParts("tel",ambulan119,null));
                startActivity(panggilAmbulan119);
                break;
            case R.id.btn_call_posko:
                String posko = "129" ;
                Intent panggilPosko = new Intent(Intent. ACTION_DIAL);
                panggilPosko.setData(Uri. fromParts("tel",posko,null));
                startActivity(panggilPosko);
                break;
            case R.id.btn_call_pmi:
                String pmi = "0214207051" ;
                Intent panggilpmi = new Intent(Intent. ACTION_DIAL);
                panggilpmi.setData(Uri. fromParts("tel",pmi,null));
                startActivity(panggilpmi);
                break;
        }
    }
}
