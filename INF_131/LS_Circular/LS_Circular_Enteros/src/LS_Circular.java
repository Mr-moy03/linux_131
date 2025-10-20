//LS_Circular.java
import java.util.Scanner;

public class LS_Circular extends ListaSimple {
    public LS_Circular(){
        super();
    }

    public boolean esVacia(){
        return  (P == null);
    }
    public int nroNodos(){
        int c = 0;
        if (P != null){
            Nodo R = P;
            while (R.getSig() != P){
                c++;
                R = R.getSig();
            }
            c++;
        }
        return c;
    }

    public void adiFinal(int z){
        Nodo nuevo = new Nodo();
        nuevo.setNumero(z);

        if (P == null) {
            P = nuevo;
            P.setSig(P);
        }
        else {
            Nodo R = P;
            while(R.getSig() != P){
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
        }
    }

    public void mostrar(){
        Nodo R = P;
        while (R.getSig() != P){
            System.out.print(R.getNumero() + " -> ");
            R = R.getSig();
        }
        System.out.println(R.getNumero() + " -> (Inicio)");
    }

    public void adiPrincipio(int z){
        Nodo nuevo = new Nodo();
        nuevo.setNumero(z);
        if (P == null){
            P = nuevo;
            P.setSig(P);
        }
        else {
            Nodo R = P;
            while (R.getSig() != P){
                R = R.getSig();
            }
            R.setSig(nuevo);
            nuevo.setSig(P);
            P = nuevo;
        }
    }

    public Nodo eliPrincipio() {
        if (esVacia()) {
            return null;
        }
        Nodo x = P;
        if (P.getSig() == P) { // Caso de un solo nodo
            P = null;
        } else {
            Nodo R = P;
            while (R.getSig() != P) { // Encontrar el último nodo
                R = R.getSig();
            }
            P = P.getSig(); // Mover P al segundo nodo
            R.setSig(P);    // El último ahora apunta al nuevo primero
        }
        x.setSig(null); // Desvincular el nodo eliminado
        return x;
    }

    public Nodo eliFinal() {
        Nodo x;
        if (P.getSig() == P) {
            x = P;
            P = null;
            x.setSig(null);
            return x;
        } else {

            Nodo R = P;
            Nodo S = P;
            while (R.getSig() != P) {
                S = R;
                R = R.getSig();
            }
            x = R;
            S.setSig(P);
            x.setSig(null);
            return x;
        }
    }

    public Nodo eliFinal1() {
        Nodo x = new Nodo();
        if(P != null) {
            if(P.getSig() == P) {
                x = P;
                x.setSig(null);
                P = null;
            }else {
                Nodo S = new Nodo();
                Nodo R = P;
                while(R.getSig() != P) {
                    S = R;
                    R = R.getSig();
                }
                x = R;
                x.setSig(null);
                S.setSig(P);
            }
        }
        return x;
    }


    public void llenarFinal(int n) {
        Scanner lee = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Ingresando Numero #" + i + " (al Final) ---");
            int numero = lee.nextInt();
            adiFinal(numero);
        }
    }


    public void llenarPrincipio(int n) {
        Scanner lee = new Scanner(System.in);

        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Ingresando Numero #" + i + " (al Principio) ---");
            int numero = lee.nextInt();
            adiPrincipio(numero);

        }
    }
}
