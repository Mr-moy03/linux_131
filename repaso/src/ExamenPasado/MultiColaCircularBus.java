package ExamenPasado;

public class MultiColaCircularBus {
    private int n;
    private ColaCircularBus[] c;

    public MultiColaCircularBus(int n){
        this.n = n;
        this.c = new ColaCircularBus[n];
        for(int i = 0;i < n; i++){
            c[i] = new ColaCircularBus();
        }
    }

    public boolean esVacia(int i){
        return c[i].esVacia();
    }

    public boolean esLlena(int i){
        return c[i].esLlena();
    }

    public int nroElem(int i){
        return c[i].nroElem();
    }
    public void push(int i, Bus m){
        c[i].push(m);
    }
    public Bus pop(int i){
        return c[i].pop();
    }

    public void mostrar(){
        for(int i = 0;i <= this.n-1;i++){
            System.out.println("<Datos dela MultiColaCircular>");
            c[i].mostrar();
        }
    }
    /*
    // ✅ llenar UNA cola específica
    public void llenar(int i, int n) {
        c[i].llenar(n);
    }

    // ✅ llenar TODAS las colas con n elementos cada una
    public void llenarTodas(int n) {
        for (int i = 0; i < this.n; i++) {
            c[i].llenar(n);
        }
    }*/

    public void vaciar(int i,int j){
        c[i].vaciar(c[j]);
    }

    public void vaciar(int i,ColaCircularBus aux){
        c[i].vaciar(aux);
    }
}

