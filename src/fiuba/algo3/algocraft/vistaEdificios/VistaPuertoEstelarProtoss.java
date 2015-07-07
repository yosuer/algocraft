package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPuertoEstelarProtoss extends VistaIElemento implements ActionListener {

	JButton btnCrearNaveDeTransporte = new JButton("Crear Nave De Transporte");
	JButton btnCrearScout = new JButton("Crear Scout");
	
	public VistaPuertoEstelarProtoss(){
		this.elemento = new PuertoEstelarProtoss();
		this.armarImagen();
		
		this.btnCrearNaveDeTransporte.addActionListener(this);
		this.btnCrearScout.addActionListener(this);
		
		this.acciones.add(btnCrearNaveDeTransporte);
		this.acciones.add(btnCrearScout);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == this.btnCrearNaveDeTransporte)
		{
			((PuertoEstelarProtoss) this.elemento).crearNaveDeTransporteProtoss();
		}
		else
		{
			((PuertoEstelarProtoss) this.elemento).crearScout();
		}
	}

}
