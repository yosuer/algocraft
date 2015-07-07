package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaFabrica extends VistaIElemento implements ActionListener {

	private JButton btnCrearGolliat = new JButton("Crear Golliat");
	
	public VistaFabrica(){
		this.elemento = new Fabrica();
		this.armarImagen();
		this.btnCrearGolliat.addActionListener(this);
		this.acciones.add(btnCrearGolliat);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((Fabrica)this.elemento).crearGolliat();
	}

}
