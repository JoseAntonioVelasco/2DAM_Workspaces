package com.example.practica2_v2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.practica2_v2.FragmentoPrincipal.bd;

public class FragmentoCheckBoxes extends Fragment{
    private ListView lista;
    private ArrayList<Checkbox> checkboxes;
    private AdaptadorLista adaptadorLista;

    private static Integer RECARGAR_CHECKBOXES = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_checkboxes,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        checkboxes = bd.getCheckboxes();
        lista = (ListView)getView().findViewById(R.id.lista);

        //CREAR CHECKBOX
        FloatingActionButton fab = getView().findViewById(R.id.fab_check);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create an alert builder
                AlertDialog.Builder builder = new AlertDialog.Builder(getView().getContext());
                builder.setTitle("Tarea");
                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.dialog_createcheck, null);
                builder.setView(customLayout);
                // add a button
                builder.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // send data from the AlertDialog to the Activity
                        EditText editText = customLayout.findViewById(R.id.ck_cont);
                        String contenido = editText.getText().toString();
                        String id = String.valueOf(checkboxes.size());

                        Checkbox new_ck = new Checkbox(id,contenido,false);
                        bd.insertarCheckbox(new_ck);
                        checkboxes.add(new_ck);
                        lista.setAdapter(crearAdaptador());
                    }
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        //LISTA CHECKBOXES
        lista.setAdapter(crearAdaptador());


    }
    public AdaptadorLista crearAdaptador(){
        adaptadorLista = new AdaptadorLista(checkboxes, R.layout.checkbox, getContext()) {
            @Override
            public void onEntrada(Object entrada, View view) {
                CheckBox ck = view.findViewById(R.id.checkbox_meat);
                Checkbox entr = (Checkbox) entrada;
                ck.setText(entr.getContenido());
                ck.setChecked(entr.getTerminado());

                ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        if (isChecked){
                            // perform logic
                            Checkbox ck_amod = new Checkbox(entr.getId(),entr.getContenido(),true);
                            bd.modificarCheckbox(ck_amod);
                        }else{
                            Checkbox ck_amod = new Checkbox(entr.getId(),entr.getContenido(),false);
                            bd.modificarCheckbox(ck_amod);
                        }
                    }
                });

            }
        };
        return adaptadorLista;
    }

}
