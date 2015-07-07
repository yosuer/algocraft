package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.ControladorMapa;
import fiuba.algo3.algocraft.excepciones.ErrorCapacidadDePoblacionInsuficiente;
import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;
import fiuba.algo3.algocraft.excepciones.ErrorRecursosInsuficientes;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.vista.PanelEstado;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaFabrica extends VistaIElemento implements ActionListener {

	private JButton btnCrearGolliat = new JButton("Crear Golliat");

	public VistaFabrica() {
		this.elemento = new Fabrica();
		this.armarImagen();
		this.btnCrearGolliat.addActionListener(this);
		this.acciones.add(btnCrearGolliat);
	}

	@Override
	public void actionPerformed(ActionEvent ev) {
		try {
			((Fabrica) ControladorMapa.select).crearGolliat();
		} catch (ErrorEdificioEnConstruccion e) {
			PanelEstado.log.append("Edificio construyendose"
					+ PanelEstado.newline);
		} catch (ErrorCapacidadDePoblacionInsuficiente e) {
			PanelEstado.log.append("Casas insuficientes" + PanelEstado.newline);
		} catch (ErrorRecursosInsuficientes e) {
			PanelEstado.log.append("Recursos Insuficientes"
					+ PanelEstado.newline);
		}
	}

}
