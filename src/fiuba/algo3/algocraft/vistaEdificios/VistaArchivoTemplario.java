package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaArchivoTemplario extends VistaIElemento implements ActionListener {

	private JButton btnCrearAltoTemplario = new JButton("Crear Alto Templario");
	
	public VistaArchivoTemplario(){
		
		this.elemento = new ArchivoTemplario();
		armarImagen();
		this.btnCrearAltoTemplario.addActionListener(this);
		this.acciones.add(this.btnCrearAltoTemplario);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((ArchivoTemplario) this.elemento).crearAltoTemplario();
	}

}
