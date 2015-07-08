package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.vista.Log;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPuertoEstelarProtoss extends VistaIElemento implements
		ActionListener {

	private JButton btnCrearNaveDeTransporte = new JButton("NaveDeTransporte");
	private JButton btnCrearScout = new JButton("Scout");

	public VistaPuertoEstelarProtoss() {
		elemento = new PuertoEstelarProtoss();
		armarImagen();

		btnCrearNaveDeTransporte.addActionListener(this);
		btnCrearScout.addActionListener(this);

		acciones.add(btnCrearNaveDeTransporte);
		acciones.add(btnCrearScout);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		try {
			if (event.getActionCommand() == "NaveDeTransporte")
				((PuertoEstelarProtoss) ControladorMapa.select)
						.crearNaveDeTransporteProtoss();
			if (event.getActionCommand() == "Scout")
				((PuertoEstelarProtoss) ControladorMapa.select).crearScout();

		} catch (ErrorEdificioEnConstruccion e) {
			Log.loguear("Edificio construyendose");
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			Log.loguear("Casas insuficientes");
		} catch (ErrorRecursosInsuficientes e) {
			Log.loguear("Recursos insuficientes");
		}
	}

}
