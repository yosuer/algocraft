package fiuba.algo3.algocraft.modelo;

import fiuba.algo3.algocraft.excepciones.ErrorEdificioEnConstruccion;

public class ArchivoTemplario extends EdificioUnidadesAvanzadas
								implements ElementoProtoss {

	public ArchivoTemplario() {
		super();
		this.costoMineral = 150;
		this.costoVespeno = 200;
		this.tiempoDeConstruccion = 9;
		this.edificiosRequeridos.add(new PuertoEstelarProtoss());
		this.unidadesEnProduccion = new ListaMU<Unidad>();
		this.estadoFisico = new Protoss(500,500);
	}

	public void crearAltoTemplario() {
		if (this.tiempoDeConstruccion > 0) throw new ErrorEdificioEnConstruccion();
		this.unidadesEnProduccion.encolar(new AltoTemplario());
	}

	@Override
	public int escudoRestante() {
		return this.estadoFisico.getEscudo();
	}

	@Override
	public void regenerarse() {
		this.estadoFisico.regenerarse();
	}

}
