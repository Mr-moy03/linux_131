//NodeP.java
public class Nodo {
	private int dato;  //define el dato objeto persona
	private Nodo sig; //definiendo el campo enlace sig
	
	public Nodo() {  //constructor
		sig = null;
	}

	public int getDato() {
		return dato;
	}

	public void setDato(int dato) {
		this.dato = dato;
	}

	public Nodo getSig() {
		return sig;
	}

	public void setSig(Nodo sig) {
		this.sig = sig;
	}
	
}
