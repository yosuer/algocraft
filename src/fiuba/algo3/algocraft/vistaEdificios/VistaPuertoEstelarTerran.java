package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.vista.Log;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPuertoEstelarTerran extends VistaIElemento implements
		ActionListener {

	private JButton btnCrearNaveCiencia = new JButton("NaveCiencia");
	private JButton btnCrearNaveTransporte = new JButton("NaveTransporte");
	private JButton btnCrearEspectro = new JButton("Espectro");

	public VistaPuertoEstelarTerran() {
		elemento = new PuertoEstelarTerran();
		armarImagen();
		btnCrearNaveCiencia.addActionListener(this);
		btnCrearNaveTransporte.addActionListener(this);
		btnCrearEspectro.addActionListener(this);

		acciones.add(btnCrearEspectro);
		acciones.add(btnCrearNaveCiencia);
		acciones.add(btnCrearNaveTransporte);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		try {
			if (event.getActionCommand() == "NaveCiencia")
				((PuertoEstelarTerran) ControladorMapa.select)
						.crearNaveCiencia();

			if (event.getActionCommand() == "NaveTransporte")
				((PuertoEstelarTerran) ControladorMapa.select)
						.crearNaveDeTransporteTerran();

			if (event.getActionCommand() == "Espectro")
				((PuertoEstelarTerran) ControladorMapa.select).crearEspectro();

		} catch (ErrorEdificioEnConstruccion e) {
			Log.loguear("Edificio construyendose");
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			Log.loguear("Casas insuficientes");
		} catch (ErrorRecursosInsuficientes e) {
			Log.loguear("Recursos insuficientes");
		}
	}

}
