package menuCapas.vista;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import menuCapas.Vista;

public class Alta extends JPanel{
    public Alta(Vista v) {
        
        JPanel pA = new JPanel();
        JPanel pC = new JPanel();
        JPanel pP = new JPanel();
        
        JLabel lA = new JLabel("Articulo");
        JLabel lC = new JLabel("Cliente");
        JLabel lP = new JLabel("Pedido");
        
        pA.add(lA);
        pC.add(lC);
        pP.add(lP);
        
        JTabbedPane jtp = new JTabbedPane();
        jtp.add("Articulo", pA);
        jtp.add("Cliente", pC);
        jtp.add("Pedido", pP);
        
        this.setLayout(new CardLayout());
        this.add(jtp);
    }
}
