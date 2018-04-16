package clase1;

public class ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int mtx[][] = {{1,2},{4,5}};
		
		System.out.print(mayorDiversidad(mtx));

	}

	
	public static boolean mayorDiversidad2(int[][] arr) {
		
		boolean res = true;
		
		
		return res;
	}
	
public static boolean mayorDiversidad(int[][] mtx) {
		
		boolean res = true;
		for (int fila = 0; fila + 1< mtx.length; fila++) {
			
				res = midenIgual(mtx[fila],mtx[fila+1]) && res;
			
			
		}
		if (mtx.length == 0 || mtx.length == 1 ) {
			res = false && res;
		}
		
		
		
		if (res) {
			
			
			// Esto calcula que sean estrictamente ascedentes dentro de cada fila
			for (int fila = 0; fila < mtx.length; fila++) {
				res = estrictamenteAscendente(mtx[fila]) && res;
				
			}
			
			
			
			
			
			// Esto calcula que en cada columna los "contiguos" no sean pares o impares entre si.
			for (int col = 0; col < mtx[0].length ; col++) {
			
				for (int fila = 0; fila + 1 < mtx.length; fila++) {
					
						
						res = dispares(mtx[fila][col],mtx[fila+1][col]) && res;
						
	 				
				}
				
			}
			
			
		}
		
		else {
			System.out.print("se rompio todo   ");
		}
		
		
		
		return res;
		
		
		
		
		
		
		
		
		
		
		
	}

	public static boolean estrictamenteAscendente(int[] fila) {
		boolean ultimo = true;
		for (int elemento = 0; elemento + 1 < fila.length; elemento++) {
			
			ultimo = fila[elemento] < fila[elemento+1] && ultimo;
						
		}
		return ultimo;
		
	}
	
	
	
	public static boolean dispares(int a, int b) {
		if (a % 2 == 0 && b % 2 != 0) {
			return true;
		} else if (a % 2 != 0 && b % 2 == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public static boolean midenIgual (int[] a, int[] b) {
		
		if (a.length == b.length) {
			return true;
		} else {
			  return false;
		}
		
	}
	
	

}
