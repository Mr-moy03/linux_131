package Multiple_cola_circular;

import java.util.Scanner;

public class ColaCircularMed{
    protected int MAX = 50;
    protected Medallero[] v = new Medallero[MAX];
    protected int fr;
    protected int fi;

    public ColaCircularMed() {
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

    public void adi(Medallero elem) {
        if(!esLlena()) {
            fi = (fi + 1) % MAX;
            v[fi] = elem;
        }else
            System.out.println("cola circular llena!!!");
    }
    public Medallero eli() {
        Medallero elem;
        if(!esVacia()) {
            fr = (fr + 1) % MAX;
            elem = v[fr];
            return elem;
        }else {
            System.out.println("Cola circular vacia!!");
            return null;
        }
    }

    public void vaciar(ColaCircularMed z) {
        while(!z.esVacia()) {
            adi(z.eli());
        }
    }
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
    }

    public void mostrar() {
        ColaCircularMed aux = new ColaCircularMed();
        while(!esVacia()) {
            Medallero elem = eli();
            //System.out.print("");
            elem.mostrar();
            aux.adi(elem);
        }
        vaciar(aux);
    }
}
