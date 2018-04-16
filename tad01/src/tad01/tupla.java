package tad01;

public class tupla<T1,T2> {

	private T1 x;
	private T2 y;
	
	
	
	
	public tupla (T1 x, T2 y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	
	public T1 getX() {
		return this.x;
	}


	public void setX(T1 x) {
		this.x = x;
	}



	public T2 getY() {
		return this.y;
	}


	public void setY(T2 y) {
		this.y = y;
	}

@Override
	public String toString() {
		return "( " + x.toString() + " , " + y.toString() + " )";
	}





	public static void main(String[] args) {
		
		
		tupla<String,Integer> prueba = new tupla<String,Integer> ("hola",4);
		System.out.print(prueba.toString());
		
		
		

	}

}
