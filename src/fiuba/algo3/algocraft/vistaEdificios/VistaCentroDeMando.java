package fiuba.algo3.algocraft.vistaEdificios;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.Boton;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.DepositoDeSuministros;
import fiuba.algo3.algocraft.modelo.edificios.Fabrica;
import fiuba.algo3.algocraft.modelo.edificios.PuertoEstelarTerran;
import fiuba.algo3.algocraft.modelo.edificios.Refineria;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaCentroDeMando extends VistaIElemento {

	private JButton btnCrearCentroMineral;
	private JButton btnCrearRefineria;
	private JButton btnCrearBarraca;
	private JButton btnCrearDeposito;
	private JButton btnCrearFabrica;
	private JButton btnCrearPuertoEstelar;

	public VistaCentroDeMando() {
		this.elemento = new CentroDeMando();
		this.armarImagen();
		this.btnCrearCentroMineral = new Boton("CentroMineral",
				new CrearEdificio(new CentroDeMineral()));
		this.btnCrearRefineria = new Boton("Refineria", new CrearEdificio(
				new Refineria()));
		this.btnCrearBarraca = new Boton("Barraca", new CrearEdificio(
				new Barraca()));
		this.btnCrearDeposito = new Boton("Deposito", new CrearEdificio(
				new DepositoDeSuministros()));
		this.btnCrearFabrica = new Boton("Fabrica", new CrearEdificio(
				new Fabrica()));
		this.btnCrearPuertoEstelar = new Boton("Puerto Estelar",
				new CrearEdificio(new PuertoEstelarTerran()));

		this.acciones.add(btnCrearCentroMineral);
		this.acciones.add(btnCrearRefineria);
		this.acciones.add(btnCrearBarraca);
		this.acciones.add(btnCrearDeposito);
		this.acciones.add(btnCrearFabrica);
		this.acciones.add(btnCrearPuertoEstelar);
	}

}
