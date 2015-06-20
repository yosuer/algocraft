package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.modelo.Estatico;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class VistaMapa extends SuperficiePanel {

	private IMapa mapa;
	
	public VistaMapa() {
		setBounds(120, 10, 900, 700);
		setForeground(new Color(0, 0, 0));
	}
	
	public void setModelo(IMapa mapa, GameLoop gameLoop) throws IOException{
		//setLayout(new GridLayout(50,50));
		this.mapa = mapa;
		for (int x=1; x<=mapa.ancho(); x++){
			for(int y=1; y<=mapa.largo();y++){
				Estatico elemento = (Estatico)mapa.getElemento(x, y, 0);
				gameLoop.agregar(elemento);
				Imagen imagen = new VistaIElemento(elemento);
				gameLoop.agregar(imagen);
			}
		}
	}
}
