package Multiple_cola_circular;

public class MultiColaCirMed {
    private int n = 100;
    private ColaCircularMed[] c = new ColaCircularMed[n];

    public MultiColaCirMed(){
        for(int i = 0;i <= 99; i++){
            c[i] = new ColaCircularMed();
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
    public void push(int i,Medallero m){
        c[i].adi(m);
    }
    public Medallero pop(int i){
        return c[i].eli();
    }

    public void mostrar(){
        for(int i = 0;i <= this.n-1;i++){
            System.out.println("<>");
            c[i].mostrar();
        }
    }
    // ✅ llenar UNA cola específica
    public void llenar(int i, int n) {
        c[i].llenar(n);
    }

    // ✅ llenar TODAS las colas con n elementos cada una
    public void llenarTodas(int n) {
        for (int i = 0; i < this.n; i++) {
            c[i].llenar(n);
        }
    }

    public void vaciar(int i,int j){
        c[i].vaciar(c[j]);
    }

    public void vaciar(int i,ColaCircularMed aux){
        c[i].vaciar(aux);
    }
}
