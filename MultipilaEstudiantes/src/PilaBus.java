public class PilaBus{
	protected int max = 50;
	protected Bus v[] = new Bus[max];
	private int tope;

	public PilaBus() {
		this.tope = -1;
	}
	public boolean esVacia(){
		return (this.tope == -1);
	}

	public boolean esLlena(){
		return (this.tope == max-1);
	}
	
	public void push(Bus elem){
		if(!esLlena()){
			this.tope++;
			this.v[this.tope] = elem;
		}
		else
			System.out.println("Pila Llena!!!");
	}

	public Bus pop(){
		Bus elem;
		if(!esVacia()){
			elem = this.v[this.tope];
			this.tope--;
			return elem;
		}
		else
			System.out.println("Pila es vacia!!!!");
			return null;
	}
	@Override
	public String toString(){
		PilaBus aux = new PilaBus();
		StringBuilder s = new StringBuilder();
		System.out.println("Datos de la pila: ");
		while(!esVacia()){
			Bus elem = pop();
			//System.out.println(elem);
			s.append(elem);
			aux.push(elem);
		} 
		vaciar(aux);
		return s.toString();
	}
	
	public void mostrar(){
		PilaBus aux = new PilaBus();
		System.out.println("Datos de la pila: ");
		while(!esVacia()){
			Bus elem = pop();
			//System.out.println(elem);
			elem.mostrar();
			aux.push(elem);
		} 
		vaciar(aux);
	}
	public void vaciar(PilaBus p){
		while(!p.esVacia()){
			this.push(p.pop());
		}
	}

	public int nroElem(){
		return tope + 1;
	}
}



/*
	public void llenar(int n){
		Scanner lee = new Scanner(System.in);
		System.out.println("Intr datos nombre, materia");
		for (int i = 1; i <= n; i++) {
			String nombre = lee.next();
			int edad = lee.nextInt();
			String tipo = lee.next();

			Pasajero elem = new Pasajero(nombre, edad, tipo);
			//char elem = lee.next().charAt(0);
			this.push(elem);
		}
	}*/