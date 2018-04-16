package conjuntoT;
import java.util.ArrayList;
import java.util.Random;




public class Conjunto<T> {

	ArrayList<T> elementos;
	
	Conjunto(T[] elementosIniciales) {
		
		this.elementos = new ArrayList<T>();
		for (int i = 0; i < elementosIniciales.length; i++) {
			this.elementos.add(elementosIniciales[i]);
		}
	}
	
		
	
	Conjunto() {
		this.elementos = new ArrayList<T>();
	}
		
	
	public Integer tamaño() {
		
		return this.elementos.size();
	}

	public void Agregar(T i) {
		this.elementos.add(i);
	}
	
	public T DameUno() {

		Random ran = new Random();
		int nroAzar = ran.nextInt(this.tamaño());
		return this.iesimo(nroAzar);
	}
	
	public T iesimo(Integer indice ) {
		return this.elementos.get(indice);
	}

	
	public void union(Conjunto<T> c) {
		
		for(int i = 0; i < c.tamaño(); i++) {
			if (!this.existeElemento(c.iesimo(i))) {
				
				this.Agregar(c.iesimo(i));

			}
		}
		
	}
		
	public Conjunto<T> union2(Conjunto<T> c) {
		
		Conjunto<T> union = new Conjunto<T>();
		
		union.union(this);
		union.union(c);
		return union;
		
		
		
	}
		
	public void interseccion (Conjunto<T> c ) {
		
		Conjunto<T> aux = new Conjunto<T>();
		
		aux.union(this);
		this.vaciarConjunto();
		
		
		for(int i = 0; i < aux.tamaño(); i++ ) {
			
			if (c.existeElemento(aux.iesimo(i))) {
				this.Agregar(aux.iesimo(i));
			}
		}
		
		
		
		
	}
	
	
	
	public Conjunto<T> interseccion2 (Conjunto<T> c) {
		
		Conjunto<T> aux = new Conjunto<T>();
		
		aux.union(this);
		aux.interseccion(c);
		
		return aux; 
	}
		
		
	
	
	
	private void vaciarConjunto() {
		
		this.elementos.removeAll(this.elementos);
	}
	
	
	
	
	

private boolean existeElemento(T elem) {
	
	for(int i = 0; i < this.tamaño(); i++ ) {
		
		if (this.iesimo(i).equals(elem)) {
			return true;
		}
		
		
	}
	return false;
	
}

public String toString() {
	
	String cadena = "{ ";
for(int i = 0; i < this.tamaño(); i++ ) {
		
		if (i + 1 == this.tamaño()) {
			cadena = cadena + this.iesimo(i).toString() + " }";
		}else {
			cadena = cadena + this.iesimo(i).toString() + " , ";
		}
}

return cadena;

}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Integer[] arreglo = new Integer[] {1,2,3,4,5};
		Integer[] arreglo2 = new Integer[] {1,3,5,7,8,9};
		
		
		Conjunto<Integer> ejemplo1 = new Conjunto<Integer>(arreglo);
		Conjunto<Integer> ejemplo2 = new Conjunto<Integer>(arreglo2);
		Conjunto<Integer> union = new Conjunto<Integer>();
		Conjunto<Integer> interseccion = new Conjunto<Integer>();
		
		System.out.print("tenemos 2 conjuntos y ellos son \n");
		System.out.println(ejemplo1.toString());
		System.out.println(ejemplo2.toString());
		
		
		System.out.print("\n La unión entre ellos es \n");
		System.out.println(ejemplo1.union2(ejemplo2).toString());
		//System.out.println(ejemplo1.toString());
		
		System.out.print("\n La intersección entre ellos es \n");
		System.out.println(ejemplo1.interseccion2(ejemplo2).toString());
		System.out.println(ejemplo1.toString());
		
		
		
		

		
		
	}

}
