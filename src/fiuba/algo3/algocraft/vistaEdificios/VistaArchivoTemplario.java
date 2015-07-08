package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.vista.PanelEstado;
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
			PanelEstado.log.append("Edificio construyendose"
					+ PanelEstado.newline);
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			PanelEstado.log.append("Casas insuficientes" + PanelEstado.newline);
		}
	}

}
