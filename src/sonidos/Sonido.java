/**
 * 
 */
package sonidos;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Creado el 25 mar. 2019
 * 
 * @author <a href="mailto:joaalsai@ieslavereda.es">Joaquin Vicente Alonso
 *         Saiz</a>
 *
 */
public class Sonido {

	public static void emitir(String f) {

		Clip sonido;

		try {

			sonido = AudioSystem.getClip(null);

			AudioInputStream ais = AudioSystem.getAudioInputStream(Sonido.class.getResource("/sonidos/" + f));

			sonido.open(ais);
			sonido.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
