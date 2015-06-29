package fiuba.algo3.titiritero.dibujables;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import fiuba.algo3.titiritero.modelo.ObjetoDibujable;
import fiuba.algo3.titiritero.modelo.ObjetoPosicionable;
import fiuba.algo3.titiritero.modelo.SuperficieDeDibujo;

public class Imagen implements ObjetoDibujable {

	private BufferedImage imagen;
	private ObjetoPosicionable posicionable;

	public Imagen(URL imagenUrl, ObjetoPosicionable posicionable) {
		try {
			this.posicionable = posicionable;
			this.imagen = ImageIO.read(imagenUrl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficieDeDibujo) {
		Graphics grafico = ((SuperficiePanel) superficieDeDibujo).getBuffer();
		int tam = 22;
		int posX = this.posicionable.getX() - 1;
		int posY = this.posicionable.getY() - 1;
		grafico.drawImage(this.imagen, tam * posX, tam * posY, tam, tam, null);
		// tam*posX+1, tam*posY-1,tam,tam,null);
		// this.imagen.getHeight(),this.imagen.getWidth(),null);
	}

	public ObjetoPosicionable getPosicionable() {
		return posicionable;
	}

}