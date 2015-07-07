package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.GuaridaDeHidralisco;
import fiuba.algo3.algocraft.modelo.unidades.Hidralisco;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaGuaridaDeHidralisco extends VistaIElemento implements ActionListener{
	
	JButton btnCrearHidralisco = new JButton("Crear Hidralisco");

	public VistaGuaridaDeHidralisco(){
		this.elemento = new GuaridaDeHidralisco();
		this.armarImagen();
		
		this.btnCrearHidralisco.addActionListener(this);
		
		this.acciones.add(btnCrearHidralisco);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.btnCrearHidralisco)
		{
			( ( GuaridaDeHidralisco )this.elemento).crearUnidad(new Hidralisco());
		}
	}

}
