/**
 * 
 */
package main;

/**
 * Creado el 22 mar. 2019
 * 
 * @author <a href="mailto:joaalsai@ieslavereda.es">Joaquin Vicente Alonso
 *         Saiz</a>
 *
 */
public class Carta {

	public static final String ROJO = "\u001b[1;91m";
	public static final String NEGRO = "\u001b[1;30m";
	public static final String DEFAULT = "\u001b[0m";

	private char palo;
	private char valor;
	private String color;

	public Carta(char palo, char valor) {
		super();
		this.palo = palo;
		this.valor = valor;
		if (palo == '♥' || palo == '♦')
			color = ROJO;
		else
			color = NEGRO;
	}

	/**
	 * @return the palo
	 */
	public char getPalo() {
		return palo;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		switch (valor) {
		case ('J'):
		case ('Q'):
		case ('K'):
			return 0.5;
		default:
			return Double.parseDouble(String.valueOf(valor));
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return color + valor + " " + palo + DEFAULT;
	}

}
