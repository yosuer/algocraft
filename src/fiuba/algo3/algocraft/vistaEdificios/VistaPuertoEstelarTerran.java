package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPuertoEstelarTerran extends VistaIElemento implements ActionListener {

	private JButton btnCrearNaveCiencia = new JButton("Crear Nave Ciencia");
	private JButton btnCrearNaveTransporte = new JButton("Crear Nave de transporte");
	
	public VistaPuertoEstelarTerran(){
		this.elemento =  new PuertoEstelarTerran();
		this.armarImagen();
		this.btnCrearNaveCiencia.addActionListener(this);
		this.btnCrearNaveTransporte.addActionListener(this);
		
		this.acciones.add(btnCrearNaveCiencia);
		this.acciones.add(btnCrearNaveTransporte);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btnCrearNaveCiencia)
		{
			((PuertoEstelarTerran) this.elemento).crearNaveCiencia();
		}
		else
		{
			((PuertoEstelarTerran)this.elemento).crearNaveDeTransporteTerran();
		}
	}

}
