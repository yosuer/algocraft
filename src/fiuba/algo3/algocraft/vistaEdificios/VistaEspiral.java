package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Espiral;
import fiuba.algo3.algocraft.modelo.unidades.AmoSupremo;
import fiuba.algo3.algocraft.modelo.unidades.Reina;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaEspiral extends VistaIElemento implements ActionListener{

	JButton btnCrearReina = new JButton("Crear Reina");
	JButton btnCrearAmoSupremo = new JButton("Crear Amo Supremo");
	
	public VistaEspiral(){
		this.elemento = new Espiral();
		this.armarImagen();
		
		this.btnCrearAmoSupremo.addActionListener(this);
		this.btnCrearReina.addActionListener(this);
		
		this.acciones.add(this.btnCrearAmoSupremo);
		this.acciones.add(this.btnCrearReina);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.btnCrearAmoSupremo)
		{
			((Espiral) this.elemento).crearUnidad(new Reina());
		}
		else
		{
			((Espiral) this.elemento).crearUnidad(new AmoSupremo());
		}
	}
	
	

}
