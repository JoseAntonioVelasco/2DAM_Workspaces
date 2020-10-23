package t6a5_adaptador;

import android.widget.CheckBox;

public class Datos {
    private String texto1;
    private String texto2;
    private CheckBox ckbox;
    public Datos(String texto1, String texto2,CheckBox ckbox){
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.ckbox = ckbox;
    }
    public String getTexto1(){
        return texto1;
    }
    public String getTexto2(){
        return texto2;
    }
    public CheckBox getCkbox(){
        return ckbox;
    }
}
