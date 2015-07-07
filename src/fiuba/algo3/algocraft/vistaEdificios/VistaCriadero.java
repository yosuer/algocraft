package fiuba.algo3.algocraft.vistaEdificios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonCrearEdificio;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.Criadero;
import fiuba.algo3.algocraft.modelo.edificios.Espiral;
import fiuba.algo3.algocraft.modelo.edificios.Extractor;
import fiuba.algo3.algocraft.modelo.edificios.GuaridaDeHidralisco;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.edificios.ReservaDeReproduccion;
import fiuba.algo3.algocraft.modelo.edificios.ZergMineral;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaCriadero extends VistaIElemento{
	
	private JButton btnCrearZergMineral;
	private JButton btnCrearExtractor;
	private JButton btnCrearReservaDeReproduccion;
	private JButton btnCrearGuaridaDeHidralisco;
	private JButton btnCrearEspiral;

	public VistaCriadero() {
		this.elemento = new CentroDeMando();
		this.armarImagen();
		this.btnCrearZergMineral = new BotonCrearEdificio("ZergMineral",
				new CrearEdificio(new ZergMineral()));
		this.btnCrearExtractor = new BotonCrearEdificio("Extractor",
			new CrearEdificio(new Extractor()));
		this.btnCrearReservaDeReproduccion = new BotonCrearEdificio("Reserva de Reproduccion", new CrearEdificio(
				new ReservaDeReproduccion()));
		this.btnCrearGuaridaDeHidralisco = new BotonCrearEdificio("Guarida de Hidralisco",new CrearEdificio(
		new GuaridaDeHidralisco()));
		this.btnCrearEspiral = new BotonCrearEdificio("Espiral",
				new CrearEdificio(new Espiral()));
		
		
		this.acciones.add(btnCrearZergMineral);
		this.acciones.add(btnCrearExtractor);
		this.acciones.add(btnCrearReservaDeReproduccion);
		this.acciones.add(btnCrearGuaridaDeHidralisco);
		this.acciones.add(btnCrearEspiral);
	}

}
