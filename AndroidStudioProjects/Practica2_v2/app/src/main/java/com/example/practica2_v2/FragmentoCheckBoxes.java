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

        //CREAR CHECKBOX
        FloatingActionButton fab = getView().findViewById(R.id.fab_check);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(getView().getContext()).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Alert message to be shown");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });

        //LISTA CHECKBOXES
        checkboxes = bd.getCheckboxes();
        lista = (ListView)getView().findViewById(R.id.lista);
        CheckBox ck = getView().findViewById(R.id.checkbox);
        lista.setAdapter(new AdaptadorLista(checkboxes,R.layout.checkbox,getContext()) {
            @Override
            public void onEntrada(Object entrada, View view) {
                Checkbox entr = (Checkbox) entrada;
                ck.setText(entr.getContenido());
                ck.setSelected(entr.getTerminado());
            }

        });


    }
}
