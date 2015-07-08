package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.vista.PanelEstado;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaPuertoEstelarTerran extends VistaIElemento implements
		ActionListener {

	private JButton btnCrearNaveCiencia = new JButton("NaveCiencia");
	private JButton btnCrearNaveTransporte = new JButton("NaveTransporte");

	public VistaPuertoEstelarTerran() {
		elemento = new PuertoEstelarTerran();
		armarImagen();
		btnCrearNaveCiencia.addActionListener(this);
		btnCrearNaveTransporte.addActionListener(this);

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

		} catch (ErrorEdificioEnConstruccion e) {
			PanelEstado.log.append("Edificio construyendose"
					+ PanelEstado.newline);
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			PanelEstado.log.append("Casas insuficientes" + PanelEstado.newline);
		} catch (ErrorRecursosInsuficientes e) {
			PanelEstado.log.append("Recursos insuficientes"
					+ PanelEstado.newline);
		}
	}

}
