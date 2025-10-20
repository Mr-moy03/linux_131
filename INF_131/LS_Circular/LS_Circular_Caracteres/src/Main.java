import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LS_Circular lc = new LS_Circular();

        lc.adiFinal('a');
        lc.adiFinal('b');
        lc.adiFinal('c');
        lc.adiFinal('d');

        lc.mostrar();
        insertarInesimaNodo(lc,3,2);
        lc.mostrar();

    }

    public static void insertarInesimaNodo(LS_Circular lc,int n , int i){
        LS_Circular aux = new LS_Circular();
        int cont = 0;
        Scanner lee = new Scanner(System.in);
        while(!lc.esVacia()){
            Nodo x = lc.eliPrincipio();
            aux.adiFinal(x.getCaracter());
            if(cont == i-1){
                System.out.println("--- Ingrese los " + n + " caracteres a insertar ---");
                for(int j = 1;j <= n;j++){
                    String linea = lee.nextLine();
                    char caracter = linea.charAt(0);
                    aux.adiFinal(caracter);
                }
            }
            cont ++;
        }
        lc.setP(aux.getP());
    }
    public static void insertarInesimaNodoV2(LS_Circular lc, int n, int i) {

        // 1. Encontrar el i-ésimo nodo
        Nodo R = lc.getP();
        for (int k = 1; k < i; k++) {
            R = R.getSig();
        }
        // 2. Guardar la referencia al resto de la lista
        Nodo S = R.getSig();

        Scanner lee = new Scanner(System.in);
        System.out.println("\n--- Ingrese los " + n + " caracteres a insertar después de '" + R.getCaracter() + "' ---");

        // 3. Bucle para leer e insertar cada nuevo nodo
        for (int j = 1; j <= n; j++) {
            System.out.print("Carácter #" + j + ": ");
            String linea = lee.nextLine();
            char caracter = linea.charAt(0);
            Nodo nuevo = new Nodo();
            nuevo.setCaracter(caracter);

            // Re-enlazamos los punteros
            R.setSig(nuevo);  // El nodo anterior (R) ahora apunta al nuevo
            nuevo.setSig(S);  // El nuevo nodo apunta al resto de la lista (S)

            // Avanzamos R para que la siguiente inserción sea después de este nuevo nodo
            R = nuevo;
        }
    }

}