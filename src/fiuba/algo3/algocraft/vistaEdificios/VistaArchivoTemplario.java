package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.vista.Log;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaArchivoTemplario extends VistaIElemento implements
		ActionListener {

	private JButton btnCrearAltoTemplario = new JButton("AltoTemplario");

	public VistaArchivoTemplario() {
		this.elemento = new ArchivoTemplario();
		armarImagen();
		this.btnCrearAltoTemplario.addActionListener(this);
		this.acciones.add(btnCrearAltoTemplario);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			((ArchivoTemplario) ControladorMapa.select).crearAltoTemplario();

		} catch (ErrorEdificioEnConstruccion e) {
			Log.loguear("Edificio construyendose");
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			Log.loguear("Casas insuficientes");
		} catch (ErrorRecursosInsuficientes e) {
			Log.loguear("Recursos insuficientes");
		}
	}

}
