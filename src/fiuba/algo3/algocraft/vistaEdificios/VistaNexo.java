package fiuba.algo3.algocraft.vistaEdificios;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Boton;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.edificios.Acceso;
import fiuba.algo3.algocraft.modelo.edificios.ArchivoTemplario;
import fiuba.algo3.algocraft.modelo.edificios.Asimilador;
import fiuba.algo3.algocraft.modelo.edificios.Nexo;
import fiuba.algo3.algocraft.modelo.edificios.NexoMineral;
import fiuba.algo3.algocraft.modelo.edificios.Pilon;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarProtoss;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaNexo extends VistaIElemento {

	private JButton btnCrearNexoMineral;
	private JButton btnCrearAsimilador;
	private JButton btnCrearAcceso;
	private JButton btnCrearPilon;
	private JButton btnCrearArchivoTemplario;
	private JButton btnCrearPuertoEstelar;

	public VistaNexo() {
		this.elemento = new Nexo();
		this.armarImagen();
		this.btnCrearNexoMineral = new Boton("NexoMineral", new CrearEdificio(
				new NexoMineral()));
		this.btnCrearAsimilador = new Boton("Asimilador", new CrearEdificio(
				new Asimilador()));
		this.btnCrearAcceso = new Boton("Acceso", new CrearEdificio(
				new Acceso()));
		this.btnCrearPilon = new Boton("Pilon", new CrearEdificio(new Pilon()));
		this.btnCrearArchivoTemplario = new Boton("ArchivoTemplario",
				new CrearEdificio(new ArchivoTemplario()));
		this.btnCrearPuertoEstelar = new Boton("Puerto Estelar",
				new CrearEdificio(new PuertoEstelarProtoss()));

		this.acciones.add(btnCrearNexoMineral);
		this.acciones.add(btnCrearAsimilador);
		this.acciones.add(btnCrearAcceso);
		this.acciones.add(btnCrearPilon);
		this.acciones.add(btnCrearArchivoTemplario);
		this.acciones.add(btnCrearPuertoEstelar);
	}
}
