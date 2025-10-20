//Listasimple.java
public class ListaSimple {
	protected Nodo P;  //raiz de la lista
	
	public ListaSimple() {
		P = null;		// la raiz apunta a nullo es decir
						// se define una lista simple vacia
	}

	public Nodo getP() {
		return P;
	}

	public void setP(Nodo p) {
		P = p;
	}
	
}
