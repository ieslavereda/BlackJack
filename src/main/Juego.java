/**
 * 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Creado el 22 mar. 2019
 * 
 * @author <a href="mailto:joaalsai@ieslavereda.es">Joaquin Vicente Alonso
 *         Saiz</a>
 *
 */
public class Juego {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Deque<Carta> baraja = new LinkedList<Carta>();

		char[] valores = { '1', '2', '3', '4', '5', '6', '7', '8', '9', 'J', 'Q', 'K' };
		char[] palos = { "\u2663".charAt(0), "\u2660".charAt(0), "\u2665".charAt(0), "\u2666".charAt(0) };
		double puntosJugador = 0, puntosMaquina = 0;

		for (char p : palos) {
			for (char v : valores) {

				baraja.add(new Carta(p, v));

			}
		}

		// Barajamos la baraja
		Collections.shuffle((List<?>) baraja);

		puntosJugador = jugador(baraja);

	}

	private static double jugador(Deque<Carta> baraja) {

		List<Carta> mano = new ArrayList<Carta>();
		Scanner entrada = new Scanner(System.in);
		double puntos = 0;
		char opcion;
		System.out.println("Quieres una carta? [*|n/N]: ");
		opcion = entrada.nextLine().charAt(0);

		while (opcion != 'n' && opcion != 'N' && puntos < 21) {
			mano.add(baraja.pop());
			puntos = mano.stream().collect(Collectors.summingDouble(Carta::getValor));

			for (Carta c : mano)
				System.out.print(c + " ");
			System.out.println("Puntos: " + puntos);

			System.out.println("Quieres otra carta? [*|n/N]: ");
			opcion = entrada.nextLine().charAt(0);
		}

		return puntos;
	}

}
