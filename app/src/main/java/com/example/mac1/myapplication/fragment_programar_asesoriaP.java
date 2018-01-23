package com.example.mac1.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import static com.example.mac1.myapplication.R.array.Opciones;
import static com.example.mac1.myapplication.R.layout.support_simple_spinner_dropdown_item;


public class fragment_programar_asesoriaP extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Spinner materias;
        final View view = inflater.inflate(R.layout.fragment_fragment_programar_asesoria, container,
                false);
        materias = (Spinner)view.findViewById(R.id.spinner);

        ArrayAdapter adapter =  ArrayAdapter.createFromResource(getActivity(),R.array.Opciones,R.layout.support_simple_spinner_dropdown_item);
         adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        materias.setAdapter(adapter);

        materias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                    if(position>=0){
                        final Toast toast = null;
                        toast.makeText(getContext(), "Usted selecciono  : " + materias.getSelectedItem(), Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;


    }



}
