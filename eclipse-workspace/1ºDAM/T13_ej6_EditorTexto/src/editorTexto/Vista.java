package editorTexto;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Vista extends JFrame{
	public Vista() {
		super("TextPane Example");
		
		JPanel panel = new JPanel();
		JTextPane p_tex = new JTextPane();
	
		SimpleAttributeSet red = new SimpleAttributeSet();
        StyleConstants.setForeground(red, Color.red);

        SimpleAttributeSet bold = new SimpleAttributeSet();
        StyleConstants.setBold(bold, true);

        SimpleAttributeSet cursiv = new SimpleAttributeSet();
        StyleConstants.setItalic(cursiv, true);
		
		
		
		ImageIcon img = new ImageIcon("twitter.png");
		Image image = img.getImage().getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
		ImageIcon img_resized = new ImageIcon(image);
		p_tex.insertIcon(img_resized);
		

		try {
            Document doc = p_tex.getDocument();
            doc.insertString(doc.getLength(), "\nTexto en color rojo\n\n", red);
            doc.insertString(doc.getLength(), "Texto en negrita\n", bold);
            doc.insertString(doc.getLength(), "Texto en cursiva\n", cursiv);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
		
		JButton boton= new JButton("Pulsame");
		boton.setAlignmentX(CENTER_ALIGNMENT);
		boton.addActionListener(new GestorPulsar());
		
		panel.add(p_tex);
		panel.add(boton);
		this.setContentPane(panel);
		this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
		this.pack();
	}
	public static void main(String[] args) {
		Vista v = new Vista();
		v.setVisible(true);
	}
}
