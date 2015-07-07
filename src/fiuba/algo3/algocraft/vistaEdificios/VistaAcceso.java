package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaAcceso extends VistaIElemento implements ActionListener {

	private JButton btnCrearZealot = new JButton("Crear Zealot");
	private JButton btnCrearDragon = new JButton("Crear Dragon");
	
	public VistaAcceso() {
		this.elemento = new Acceso();
		armarImagen();
		this.btnCrearDragon.addActionListener(this);
		this.btnCrearZealot.addActionListener(this);
		
		this.acciones.add(this.btnCrearZealot);
		this.acciones.add(this.btnCrearDragon);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		
		if(evento.getSource() == this.btnCrearZealot)
		{
			((Acceso) this.elemento).crearZealot();
		}
		else
		{
			((Acceso) this.elemento).crearDragon();
		}
		
	}

}
