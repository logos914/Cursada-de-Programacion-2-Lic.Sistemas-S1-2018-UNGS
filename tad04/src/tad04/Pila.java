package tad04;

import java.util.ArrayList;
import java.util.Random;

public class Pila<T> {

	// INICIALIZACIONES
	private ArrayList<T> elementos;

	// CONSTRUCTOR
	Pila() {

		this.elementos = new ArrayList<T>();

	}

	// OPERACIONES BASICAS

	public boolean vacia() {

		if (this.elementos.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public void agregar(T i) {

		this.elementos.add(i);

	}

	public T quitar() {
		T retorna = this.cima();
		this.elementos.remove(this.tamaño() - 1);
		return retorna;

	}

	private int tamaño() {
		return this.elementos.size();
	}

	public T cima() {
		return this.elementos.get(this.tamaño() - 1);
	}

	// Este metodo hace trampa para hacer mas rapido

	public String toString() {
		String cadena = "";

		for (int i = this.elementos.size() - 1; i >= 0; i = i - 1) {
			cadena = cadena + this.elementos.get(i).toString() + "\n";
		}
		return cadena;

	}

	// OPERACIONES HEAVY QUE SOLO PUEDEN USAR OPERACIONES BASICAS

	public T minimo() {

		if (this.vacia()) {
			throw new RuntimeException("La pila esta vacia para obtener el mínimo");
		} else {

			T minimo = this.cima();
			T obtenido;
			Pila<T> auxiliar = new Pila<T>();

			while (!this.vacia()) {

				obtenido = this.quitar();
				auxiliar.agregar(obtenido);

				if ((int) minimo > (int) obtenido) {
					minimo = obtenido;

				}

			}

			while (!auxiliar.vacia()) {

				obtenido = auxiliar.quitar();
				if (!obtenido.equals(minimo)) {
					this.agregar(obtenido);
				}

			}

			return minimo;

		}

	}

	public void ordenar() {

		Pila<T> auxiliar = new Pila<T>();

		while (!this.vacia()) {

			auxiliar.agregar(this.minimo());

		}

		while (!auxiliar.vacia()) {
			this.agregar(auxiliar.quitar());
		}

	}

	public void mezclarOrdenar(Pila<T> pila2) {

		while (!pila2.vacia()) {
			this.agregar(pila2.quitar());
		}

		this.ordenar();

	}

	public Pila<T> mezclarOrdenar2(Pila<T> pila2) {

		Pila<T> auxiliar = new Pila<T>();
		Pila<T> auxiliarsegunda = new Pila<T>();

		this.mezclarOrdenar(pila2);

		while (!this.vacia()) {
			auxiliarsegunda.agregar(this.quitar());
		}

		while (!auxiliarsegunda.vacia()) {
			this.agregar(auxiliarsegunda.cima());
			auxiliar.agregar(auxiliarsegunda.cima());
			auxiliarsegunda.quitar();
		}
		return auxiliar;

	}

	public Pila<T> ordenarMezclar(Pila<T> pila2) {

		Pila<T> auxiliar = new Pila<T>();

		this.ordenar();
		pila2.ordenar();

		while (!this.vacia() && !this.vacia()) {

			if ((int) this.cima() < (int) pila2.cima()) {
				auxiliar.agregar(this.cima());
				this.quitar();
			} else {
				auxiliar.agregar(pila2.cima());
				pila2.quitar();
			}

		}

		if (!this.vacia()) {
			while (!this.vacia()) {
				auxiliar.agregar(this.cima());
				this.quitar();
			}
		}

		if (!pila2.vacia()) {
			while (!pila2.vacia()) {
				auxiliar.agregar(pila2.cima());
				pila2.quitar();
			}
		}

		return auxiliar;

	}

	public static void main(String[] args) {

		Pila<Integer> prueba1 = new Pila<Integer>();
		Pila<Integer> prueba2 = new Pila<Integer>();
		Pila<Integer> result3;
		Random ran = new Random();

		for (int i = 0; i < 10; i++) {
			prueba1.agregar(ran.nextInt(40) - 20);
			prueba2.agregar(ran.nextInt(80) - 40);
		}

		System.out.println("PILA 1");
		System.out.println(prueba1.toString());

		System.out.println("PILA 2");
		System.out.println(prueba2.toString());

		System.out.println("Probamos minimo");

		prueba1.minimo();

		System.out.println(prueba1.toString());

		System.out.println("Probamos ordenar");

		prueba1.ordenar();

		System.out.println(prueba1.toString());

		System.out.println("Probamos ordenar Y mezclar");

		result3 = prueba1.ordenarMezclar(prueba2);

		System.out.println(result3.toString());

		System.out.println(result3.vacia());

	}
}
