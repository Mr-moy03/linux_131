package ExamenPasado;
import java.util.Scanner;
public class ColaCircularPasajero{
    protected int MAX = 50;
    protected Pasajero[] v = new Pasajero[MAX];
    protected int fr;
    protected int fi;

    public ColaCircularPasajero() {
        this.fr = 0;
        this.fi = 0;
    }

    public int nroElem() {
        return (fi - fr + MAX) % MAX;
    }

    public boolean esVacia() {
        return (nroElem() == 0);
    }

    public boolean esLlena() {
        return (nroElem() == MAX-1);
    }

    public void push(Pasajero elem) {
        if(!esLlena()) {
            fi = (fi + 1) % MAX;
            v[fi] = elem;
        }else
            System.out.println("cola circular llena!!!");
    }
    public Pasajero pop() {
        Pasajero elem;
        if(!esVacia()) {
            fr = (fr + 1) % MAX;
            elem = v[fr];
            return elem;
        }else {
            System.out.println("Cola circular vacia!!");
            return null;
        }
    }

    public void vaciar(ColaCircularPasajero z) {
        while(!z.esVacia()) {
            push(z.pop());
        }
    }

    /*
    public void llenar(int n) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            System.out.println("Ingrese disciplina:");
            String disciplina = sc.nextLine();
            System.out.println("Ingrese deportista:");
            String deportista = sc.nextLine();
            System.out.println("Ingrese medalla:");
            String medalla = sc.nextLine();
            System.out.println("Ingrese pais:");
            String pais = sc.nextLine();
            Medallero m = new Medallero(disciplina, deportista, medalla, pais);
            adi(m);
        }
    }*/

    @Override
    public String toString() {
        ColaCircularPasajero aux = new ColaCircularPasajero();
        StringBuilder s = new StringBuilder();
        //s.append("Datos de la cola circular pasajero:\n");
        while(!esVacia()) {
            Pasajero elem = pop();
            s.append(elem+"\n");
            aux.push(elem);
        }
        vaciar(aux);
        return s.toString();
    }



    public void mostrar() {
        ColaCircularPasajero aux = new ColaCircularPasajero();
        while(!esVacia()) {
            Pasajero elem = pop();
            System.out.println("Datos de la cola circular pasajero:");
            elem.mostrar();
            aux.push(elem);
        }
        vaciar(aux);
    }
}
