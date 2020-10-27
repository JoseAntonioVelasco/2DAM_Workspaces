package t6a5_adaptador;

import android.widget.CheckBox;

public class Datos {
    private String texto1;
    private String texto2;
    private String texto_ckbox;
    public Datos(String texto1, String texto2,String ckbox){
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto_ckbox = ckbox;
    }
    public String getTexto1(){
        return texto1;
    }
    public String getTexto2(){
        return texto2;
    }
    public String getTexto_Ckbox(){
        return texto_ckbox;
    }
}
