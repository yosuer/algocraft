package fiuba.algo3.algocraft.vista.vistasModelo;

import javax.swing.JButton;

import fiuba.algo3.algocraft.controlador.BotonCrearEdificio;
import fiuba.algo3.algocraft.controlador.acciones.CrearEdificio;
import fiuba.algo3.algocraft.modelo.edificios.Barraca;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMando;
import fiuba.algo3.algocraft.modelo.edificios.CentroDeMineral;
import fiuba.algo3.algocraft.modelo.edificios.DepositoDeSuministros;
import fiuba.algo3.algocraft.vista.VistaIElemento;

public class VistaCentroDeMando extends VistaIElemento {

	private JButton btnCrearCentroMineral;
	private JButton btnCrearBarraca;
	private JButton btnCrearDeposito;

	public VistaCentroDeMando() {
		elemento = new CentroDeMando();
		armarImagen();
		btnCrearCentroMineral = new BotonCrearEdificio("CentroMineral",
				new CrearEdificio(new CentroDeMineral()));
		btnCrearBarraca = new BotonCrearEdificio("Barraca", new CrearEdificio(
				new Barraca()));
		btnCrearDeposito = new BotonCrearEdificio("Deposito",
				new CrearEdificio(new DepositoDeSuministros()));

		acciones.add(btnCrearCentroMineral);
		acciones.add(btnCrearBarraca);
		acciones.add(btnCrearDeposito);
	}

}
