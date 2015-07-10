package fiuba.algo3.algocraft.vistaEdificios;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Boton;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.edificios.Criadero;
import fiuba.algo3.algocraft.modelo.edificios.Espiral;
import fiuba.algo3.algocraft.modelo.edificios.Extractor;
import fiuba.algo3.algocraft.modelo.edificios.GuaridaDeHidralisco;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.edificios.ZergMineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaCriadero extends VistaIElemento {

	private JButton btnCrearZergMineral;
	private JButton btnCrearExtractor;
	private JButton btnCrearReservaDeReproduccion;
	private JButton btnCrearGuaridaDeHidralisco;
	private JButton btnCrearEspiral;

	public VistaCriadero() {
		this.elemento = new Criadero();
		this.armarImagen();
		this.btnCrearZergMineral = new Boton("ZergMineral", new CrearEdificio(
				new ZergMineral()));
		this.btnCrearExtractor = new Boton("Extractor", new CrearEdificio(
				new Extractor()));
		this.btnCrearReservaDeReproduccion = new Boton("ReservaReproduccion",
				new CrearEdificio(new ReservaDeReproduccion()));
		this.btnCrearGuaridaDeHidralisco = new Boton("GuaridaHidralisco",
				new CrearEdificio(new GuaridaDeHidralisco()));
		this.btnCrearEspiral = new Boton("Espiral", new CrearEdificio(
				new Espiral()));

		this.acciones.add(btnCrearZergMineral);
		this.acciones.add(btnCrearExtractor);
		this.acciones.add(btnCrearReservaDeReproduccion);
		this.acciones.add(btnCrearGuaridaDeHidralisco);
		this.acciones.add(btnCrearEspiral);
	}

}
