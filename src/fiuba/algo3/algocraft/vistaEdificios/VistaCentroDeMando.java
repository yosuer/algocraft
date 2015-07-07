package fiuba.algo3.algocraft.vistaEdificios;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonCrearEdificio;
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
		this.btnCrearCentroMineral = new BotonCrearEdificio("CentroMineral",
				new CrearEdificio(new CentroDeMineral()));
		this.btnCrearRefineria = new BotonCrearEdificio("Refineria",
				new CrearEdificio(new Refineria()));
		this.btnCrearBarraca = new BotonCrearEdificio("Barraca", new CrearEdificio(
				new Barraca()));
		this.btnCrearDeposito = new BotonCrearEdificio("Deposito",
				new CrearEdificio(new DepositoDeSuministros()));
		this.btnCrearFabrica = new BotonCrearEdificio("Fabrica",new CrearEdificio(
				new Fabrica()));
		this.btnCrearPuertoEstelar = new BotonCrearEdificio("Puerto Estelar",
				new CrearEdificio(new PuertoEstelarTerran()));
		
		
		this.acciones.add(btnCrearCentroMineral);
		this.acciones.add(btnCrearRefineria);
		this.acciones.add(btnCrearBarraca);
		this.acciones.add(btnCrearDeposito);
		this.acciones.add(btnCrearFabrica);
		this.acciones.add(btnCrearPuertoEstelar);
	}

}
