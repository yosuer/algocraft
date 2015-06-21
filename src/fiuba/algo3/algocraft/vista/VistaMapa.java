package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.IOException;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.IMapa;
import fiuba.algo3.titiritero.dibujables.Imagen;
import fiuba.algo3.titiritero.dibujables.SuperficiePanel;
import fiuba.algo3.titiritero.modelo.GameLoop;

public class VistaMapa extends SuperficiePanel {

	private IMapa mapa;
	
	public VistaMapa() {
		setBounds(120, 10, 900, 700);
		setForeground(new Color(0, 0, 0));
	}
	
	public void setModelo(IMapa mapa, GameLoop gameLoop) throws IOException{
		setLayout(new GridLayout(mapa.ancho(),mapa.alto()));
		this.mapa = mapa;
		for (int x=1; x<=mapa.ancho(); x++){
			for(int y=1; y<=mapa.largo();y++){
				IElemento elemento = mapa.getElemento(x, y, 0);
				gameLoop.agregar(elemento);
				Imagen imagen = new VistaIElemento(elemento);
				gameLoop.agregar(imagen);
			}
		}
	}
}
