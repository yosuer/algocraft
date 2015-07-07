package fiuba.algo3.algocraft.modelo.magias;

import fiuba.algo3.algocraft.modelo.Activo;
import fiuba.algo3.algocraft.modelo.Controlable;
import fiuba.algo3.algocraft.modelo.ElementoProtoss;
import fiuba.algo3.algocraft.modelo.IElementoCreador;
import fiuba.algo3.algocraft.modelo.MagiaUnidad;
import fiuba.algo3.algocraft.modelo.Unidad;
import fiuba.algo3.algocraft.modelo.unidades.AlucinacionUnidad;
import fiuba.algo3.algocraft.modelo.unidades.Marine;

public class Alucinacion extends MagiaUnidad implements IElementoCreador {
	
	private Unidad unidad;
	
	public Alucinacion(Unidad unidad) {
		this.unidad = unidad;
	}

	@Override
	public void aplicarA(Unidad unaUnidad) {
		this.crearUnidad(unaUnidad);
		this.crearUnidad(unaUnidad);
	}

	@Override
	public void enviarUnidadAlMapa(Unidad unidad) {
		this.unidad.getMapa().agregarElemento(unidad.getPosicion().x(),unidad.getPosicion().y() , unidad);
	}

	@Override
	public void crearUnidad(Unidad unidad) {
		
		Unidad alucinacion = new AlucinacionUnidad(unidad);
		alucinacion.actualizarEstado(new Activo(unidad));
		alucinacion.setPosicion(unidad.getPosicion());
		this.enviarUnidadAlMapa(alucinacion);
	}

}
