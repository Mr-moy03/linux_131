import java.util.Scanner;

public class main {
    public static void main(String[] args){
        LS_Normal ls = new LS_Normal();

        ls.adiFinal(1);
        ls.adiFinal(2);
        ls.adiFinal(3);
        ls.adiFinal(4);
        ls.mostrar();

        //insertarNodo(ls);
        insertarNodoV2(ls);
        ls.mostrar();

    }
    public static void insertarNodo(LS_Normal ls){
        Nodo R = ls.getP();
        Nodo S;
        int nro;
        Scanner sc = new Scanner(System.in);

        while (R != null){
            Nodo nuevo = new Nodo();
            System.out.println("Introdu0ce un numero:");
            nro = sc.nextInt();
            nuevo.setDato(nro);
            S = R.getSig();
            R.setSig(nuevo);
            nuevo.setSig(S);
            R = S;
        }


    }

    public static void insertarNodoV2(LS_Normal ls){
        LS_Normal aux = new LS_Normal();

        int nro;
        Scanner sc = new Scanner(System.in);

        while (!ls.esVacia()){
            Nodo x = ls.eliPrincipio();
            aux.adiFinal(x.getDato());
            System.out.println("Introdu0ce un numero:");
            nro = sc.nextInt();
            aux.adiFinal(nro);
        }
        ls.setP(aux.getP());  //ls = aux; aux = null;
        aux.setP(null);


    }
}
