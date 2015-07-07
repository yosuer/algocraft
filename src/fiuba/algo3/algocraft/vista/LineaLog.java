package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LineaLog extends JPanel {

	private static final long serialVersionUID = 1L;

	public final static String newline = "\n";

	private Font fuenteLog;
	private JLabel log;

	public LineaLog() {
		fuenteLog = new Font("Verdana", Font.ITALIC, 12);
		log = new JLabel("_");
		log.setFont(fuenteLog);
		log.setForeground(Color.WHITE);
		setBackground(Color.BLACK);
		add(log);
	}

}
