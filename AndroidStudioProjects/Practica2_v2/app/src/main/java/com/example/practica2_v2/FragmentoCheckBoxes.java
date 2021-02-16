package com.example.practica2_v2;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
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
        fab.setImageDrawable(ContextCompat.getDrawable(getContext(), android.R.drawable.ic_input_add));
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Al crear un checkbox nos salta un dialogo personalizado que es lo siguiente
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
                        String id = genId(0);

                        Checkbox new_ck = new Checkbox(id,contenido,false);
                        bd.insertarCheckbox(new_ck);
                        checkboxes = bd.getCheckboxes();
                        adaptadorLista.updateList(checkboxes);
                    }
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        //LISTA CHECKBOXES
        crearAdaptador();
        lista.setAdapter(adaptadorLista);


    }
    public AdaptadorLista crearAdaptador(){
        adaptadorLista = new AdaptadorLista(checkboxes, R.layout.checkbox, getContext()) {
            @Override
            public void onEntrada(Object entrada, View view) {
                CheckBox ck = view.findViewById(R.id.checkbox_meat);

                ImageButton bt = view.findViewById(R.id.button);

                Checkbox entr = (Checkbox) entrada;
                ck.setText(entr.getContenido());

                //listener para el checkbox
                ck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                        Checkbox ck_amod;
                        if (isChecked){
                            ck_amod = new Checkbox(entr.getId(), entr.getContenido(), true);
                        }else{
                            ck_amod = new Checkbox(entr.getId(), entr.getContenido(), false);
                        }
                        bd.modificarCheckbox(ck_amod);
                        checkboxes = bd.getCheckboxes();
                        //adaptadorLista.updateList(bd.getCheckboxes());
                    }
                });
                ck.setChecked(entr.getTerminado());

                //Listener para el boton que aparece a la derecha que despliega un menu con la opcion de borrar checkbox
                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        PopupMenu popup = new PopupMenu(view.getContext(), v);
                        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                Toast.makeText(view.getContext(), "Eliminado: " +entr.getContenido(), Toast.LENGTH_SHORT).show();
                                switch (item.getItemId()) {
                                    case R.id.elim:
                                        Checkbox ck_adel = new Checkbox(entr.getId(),entr.getContenido(),null);
                                        bd.borrarCheckbox(ck_adel);
                                        checkboxes = bd.getCheckboxes();
                                        adaptadorLista.updateList(bd.getCheckboxes());
                                        return true;
                                    default:
                                        return false;
                                }
                            }
                        });
                        popup.inflate(R.menu.menu_checkbox);
                        popup.show();
                    }
                });


            }
        };
        return adaptadorLista;
    }
    //Clase que genera un id unico para que la base de datos se mantenga integra
    private String genId(Integer depth){
        String id = String.valueOf(checkboxes.size()+depth);
        for(int i=0; i<checkboxes.size(); i++){
            if(checkboxes.get(i).getId().equals(id)){
                id=genId(depth+1);
            }
        }
        return id;
    }
}
