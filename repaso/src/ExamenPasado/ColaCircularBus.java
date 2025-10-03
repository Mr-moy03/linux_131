package ExamenPasado;

public class ColaCircularBus {
    protected int MAX = 50;
    protected Bus[] v = new Bus[MAX];
    protected int fr;
    protected int fi;

    public ColaCircularBus() {
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

    public void push(Bus elem) {
        if(!esLlena()) {
            fi = (fi + 1) % MAX;
            v[fi] = elem;
        }else
            System.out.println("cola circular llena!!!");
    }
    public Bus pop() {
        Bus elem;
        if(!esVacia()) {
            fr = (fr + 1) % MAX;
            elem = v[fr];
            return elem;
        }else {
            System.out.println("Cola circular vacia!!");
            return null;
        }
    }

    public void vaciar(ColaCircularBus z) {
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


    public void mostrar() {
        ColaCircularBus aux = new ColaCircularBus();
        while(!esVacia()) {
            Bus elem = pop();
            System.out.println("Datos de la cola circular BUS:");
            elem.mostrar();
            aux.push(elem);
        }
        vaciar(aux);
    }
}
