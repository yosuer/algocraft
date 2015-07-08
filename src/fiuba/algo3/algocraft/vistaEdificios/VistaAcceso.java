package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.vista.PanelEstado;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaAcceso extends VistaIElemento implements ActionListener {

	private JButton btnCrearZealot = new JButton("Zealot");
	private JButton btnCrearDragon = new JButton("Dragon");

	public VistaAcceso() {
		this.elemento = new Acceso();
		armarImagen();

		this.btnCrearDragon.addActionListener(this);
		this.btnCrearZealot.addActionListener(this);

		this.acciones.add(this.btnCrearZealot);
		this.acciones.add(this.btnCrearDragon);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		try {
			if (event.getActionCommand() == "Zealot")
				((Acceso) ControladorMapa.select).crearZealot();

			if (event.getActionCommand() == "Dragon")
				((Acceso) ControladorMapa.select).crearDragon();

		} catch (ErrorEdificioEnConstruccion e) {
			PanelEstado.log.append("Edificio construyendose"
					+ PanelEstado.newline);
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			PanelEstado.log.append("Casas insuficientes" + PanelEstado.newline);
		}

	}

}
