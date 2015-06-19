package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class MapaVista extends JPanel {

	public MapaVista(ObjetoPosicionable mapa){
		setForeground(new Color(0, 0, 0));
		setLayout(new GridLayout(50,50));
		
	}
}
