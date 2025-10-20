//Nodo.java
public class Nodo {
    private int numero;
    private Nodo sig;

    public Nodo(){
        sig = null;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Nodo getSig() {
        return sig;
    }

    public void setSig(Nodo sig) {
        this.sig = sig;
    }
}
