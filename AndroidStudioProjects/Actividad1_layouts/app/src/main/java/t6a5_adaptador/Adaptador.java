package t6a5_adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.progmultimedia.actividad1_layouts.R;

import org.w3c.dom.Text;


public class Adaptador extends ArrayAdapter {
    private Datos[] datos;
    public Adaptador(Context context, Datos[] datos) {
        super(context, R.layout.t6a5_vistadatos, datos);
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent){
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        View elemento = mostrado.inflate(R.layout.t6a5_vistadatos, parent, false);
        TextView texto1 = (TextView) elemento.findViewById(R.id.textView7);
        texto1.setText(datos[position].getTexto1());
        TextView texto2 = (TextView) elemento.findViewById(R.id.textView8);
        texto2.setText(datos[position].getTexto2());
        return elemento;
    }
}
