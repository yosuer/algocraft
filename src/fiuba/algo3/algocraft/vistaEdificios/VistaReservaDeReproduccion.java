package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.unidades.Zerling;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaReservaDeReproduccion extends VistaIElemento implements ActionListener {

	JButton btnCrearZergling = new JButton(" Crear Zergling");
	
	public VistaReservaDeReproduccion(){
		this.elemento = new ReservaDeReproduccion();
		this.armarImagen();
		
		this.btnCrearZergling.addActionListener(this);
		
		this.acciones.add(btnCrearZergling);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((ReservaDeReproduccion) this.elemento).crearUnidad(new Zerling());
	}

}
