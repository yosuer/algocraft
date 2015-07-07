package fiuba.algo3.algocraft.vistaEdificios;

import java.io.IOException;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonCrearEdificio;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.IElemento;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.DepositoDeSuministros;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.modelo.edificios.Nexo;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaNexo extends VistaIElemento {

	private JButton btnCrearNexoMineral;
	private JButton btnCrearAsimilador;
	private JButton btnCrearAcceso;
	private JButton btnCrearPilon;
	private JButton btnCrearArchivoTemplario;
	private JButton btnCrearPuertoEstelar;

	public VistaNexo() {
		this.elemento = new CentroDeMando();
		this.armarImagen();
		this.btnCrearNexoMineral = new BotonCrearEdificio("CentroMineral",
				new CrearEdificio(new NexoMineral()));
		this.btnCrearAsimilador = new BotonCrearEdificio("Asimilador",
			new CrearEdificio(new Asimilador()));
		this.btnCrearAcceso = new BotonCrearEdificio("Acceso", new CrearEdificio(
				new Acceso()));
		this.btnCrearPilon = new BotonCrearEdificio("Deposito",
				new CrearEdificio(new Pilon()));
		this.btnCrearArchivoTemplario = new BotonCrearEdificio("Fabrica",new CrearEdificio(
		new ArchivoTemplario()));
		this.btnCrearPuertoEstelar = new BotonCrearEdificio("Puerto Estelar",
				new CrearEdificio(new PuertoEstelarProtoss()));
		
		
		this.acciones.add(btnCrearNexoMineral);
		this.acciones.add(btnCrearAsimilador);
		this.acciones.add(btnCrearAcceso);
		this.acciones.add(btnCrearPilon);
		this.acciones.add(btnCrearArchivoTemplario);
		this.acciones.add(btnCrearPuertoEstelar);
	}
}
