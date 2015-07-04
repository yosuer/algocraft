package fiuba.algo3.algocraft.controlador.acciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.vista.VistaMapa;

public class CrearEdificio implements ActionListener {

	private IElemento edificio;
	private int x;
	private int y;
	private VistaMapa mapa;

	public CrearEdificio(IElemento edificio) {
		this.edificio = edificio;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VistaMapa.aConstruir = edificio;
		VistaMapa.seleccionar = false;
		VistaMapa.construir = true;
		VistaMapa.atacar = false;
	}

}
