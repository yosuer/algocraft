package fiuba.algo3.titiritero.dibujables;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;

public class Imagen {

	private BufferedImage imagen;
	private ObjetoPosicionable posicionable;

	public Imagen(URL imagenUrl, ObjetoPosicionable posicionable) {
		try {
			this.posicionable = posicionable;
			this.imagen = ImageIO.read(imagenUrl);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ObjetoPosicionable getPosicionable() {
		return posicionable;
	}

	public BufferedImage getImage() {
		return imagen;
	}

}