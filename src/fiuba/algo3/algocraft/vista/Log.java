package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Log extends JPanel {

	private static final long serialVersionUID = 1L;

	public final static String newline = "\n";

	private Font fuenteLog;
	private static JLabel log;

	public Log() {
		fuenteLog = new Font("Verdana", Font.ITALIC, 12);
		log = new JLabel("_");
		log.setFont(fuenteLog);
		log.setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		add(log);
	}

	public static void loguear(String text) {
		log.setText(text);
	}

	public static void limpiar() {
		log.setText("_");
	}

}
