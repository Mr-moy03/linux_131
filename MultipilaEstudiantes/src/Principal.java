public class Principal {
    public static void main(String[] args) {
        PilaPasajero pila1 = new PilaPasajero();
        PilaPasajero pila2 = new PilaPasajero();
        PilaPasajero pila3 = new PilaPasajero();
        PilaPasajero pila4 = new PilaPasajero();
        PilaPasajero pila5 = new PilaPasajero();

        Pasajero p1 = new Pasajero("Lucía Martínez", 25, "Adulto");
        Pasajero p2 = new Pasajero("Carlos Gómez", 12, "Niño");
        Pasajero p3 = new Pasajero("Ana Torres", 65, "Adulto Mayor");
        Pasajero p4 = new Pasajero("Pedro Rivera", 35, "Adulto");
        Pasajero p5 = new Pasajero("Sofía Ramírez", 19, "Estudiante");
        Pasajero p6 = new Pasajero("Miguel López", 45, "Adulto");
        Pasajero p7 = new Pasajero("Isabel Hernández", 8, "Niño");
        Pasajero p8 = new Pasajero("Jorge Salas", 70, "Adulto Mayor");
        Pasajero p9 = new Pasajero("Camila Núñez", 16, "Estudiante");
        Pasajero p10 = new Pasajero("Tomás Castillo", 50, "Adulto");
        Pasajero p11 = new Pasajero("Alan", 22, "Estudiante");
        Pasajero p12 = new Pasajero("María Lopez", 20, "Estudiante");

        pila1.push(p1);
        pila1.push(p2);
        pila1.push(p3);


        pila2.push(p5);
        pila2.push(p6);
        pila2.push(p7);
        pila2.push(p12);

        pila3.push(p8);
        pila3.push(p9);
        pila3.push(p1);

        pila4.push(p10);
        pila4.push(p2);
        pila4.push(p11);
        pila4.push(p7);

        pila5.push(p2);
        pila5.push(p3);
        pila5.push(p9);

        Bus bus1 = new Bus("ABC123", "Rojo", pila1, "Carlos Pérez", "Ruta 1");
        Bus bus2 = new Bus("DEF456", "Azul", pila2, "María López", "Ruta 2");
        Bus bus3 = new Bus("GHI789", "Verde", pila3, "Juan García", "Ruta 3");
        Bus bus4 = new Bus("JKL012", "Amarillo", pila4, "Ana Torres", "San Pedro");
        Bus bus5 = new Bus("MNO345", "Blanco", pila5, "Luis Rodríguez", "Ruta 5");

        Mp_PilaBus mpb = new Mp_PilaBus(5);

        mpb.adicionar(0, bus1);
        mpb.adicionar(1, bus2);
        mpb.adicionar(2, bus3);
        mpb.adicionar(3, bus4);
        mpb.adicionar(4, bus5);

        //mpb.mostrar();

        // a. Mostrar todos los buses que transportaron pasajeros tipo "estudiante"
        System.out.println("__A)__");
        mostrarBusesPasajeroTipo(mpb, "Estudiante");

        // b. De los buses de color X ordenar ascendentemente por edad su pila de pasajeros
        System.out.println("__B)__");
        ordenarPasajerosPorEdad(mpb, "Azul");

        // c. Eliminar los buses con ruta X que hayan transportado al pasajero Y
        System.out.println("__C)__");
        eliminarBusesRutaConPasajero(mpb, "San Pedro", "Alan");

        //mpb.mostrar();
    }

    // INCISO A
    public static void mostrarBusesPasajeroTipo(Mp_PilaBus mpb, String pasajeroTipo) {
        for (int i = 0; i < mpb.getN(); i++) {
            PilaBus aux = new PilaBus();
            while(!mpb.esVacia(i)) {
                Bus x = mpb.eliminar(i);
                if(buscarPasajeroTipo(x, pasajeroTipo)) {
                    System.out.println("Bus con pasajero " + pasajeroTipo);
                    x.mostrar();
                }
                aux.push(x);
            }
            mpb.vaciar(i, aux);
        }
    }

    public static boolean buscarPasajeroTipo(Bus bus, String pasajeroTipo) {
        boolean sw = false;
        PilaPasajero pilaPas = bus.getPilaPas();
        PilaPasajero aux = new PilaPasajero();
        while(!pilaPas.esVacia()) {
            Pasajero x = pilaPas.pop();
            if(x.getTipo().equals(pasajeroTipo))
                sw = true;
            aux.push(x);
        }
        pilaPas.vaciar(aux);
        bus.setPilaPas(pilaPas);
        return sw;
    }

    // INCISO B
    public static void ordenarPasajerosPorEdad(Mp_PilaBus mpb, String color) {
        for (int i = 0; i < mpb.getN(); i++) {
            PilaBus aux = new PilaBus();
            while(!mpb.esVacia(i)) {
                Bus x = mpb.eliminar(i);
                if(x.getColor().equalsIgnoreCase(color)) {
                    //System.out.println("=== ANTES DE ORDENAR ===");
                    //x.mostrar();
                    ordenarPilaPasajerosPorEdad(x.getPilaPas());
                    //System.out.println("=== DESPUÉS DE ORDENAR ===");
                    x.mostrar();
                }
                aux.push(x);
            }
            mpb.vaciar(i, aux);
        }
    }

    public static void ordenarPilaPasajerosPorEdad(PilaPasajero pila) {
        if(pila.esVacia()) return;

        PilaPasajero pilaOrdenada = new PilaPasajero();

        while(!pila.esVacia()) {
            Pasajero actual = pila.pop();
            int contador = 0;
            while(!pilaOrdenada.esVacia()) {
                Pasajero temp = pilaOrdenada.pop();
                if(temp.getEdad() > actual.getEdad()) {
                    pila.push(temp);
                    contador++;
                } else {
                    pilaOrdenada.push(temp);
                    break;
                }
            }
            pilaOrdenada.push(actual);
            for(int i = 0; i < contador; i++) {
                pilaOrdenada.push(pila.pop());
            }
        }
        pila.vaciar(pilaOrdenada);
    }

    // INCISO C
    public static void eliminarBusesRutaConPasajero(Mp_PilaBus mpb, String ruta, String nombrePasajero) {
        for (int i = 0; i < mpb.getN(); i++) {
            PilaBus aux = new PilaBus();
            while(!mpb.esVacia(i)) {
                Bus x = mpb.eliminar(i);

                boolean debeEliminar = x.getRuta().equals(ruta) && buscarPasajeroPorNombre(x, nombrePasajero);

                if(!debeEliminar) {
                    aux.push(x);
                } else {
                    System.out.println("Eliminando bus de ruta " + ruta + " con pasajero " + nombrePasajero);
                    x.mostrar();
                }
            }
            mpb.vaciar(i, aux);
        }
    }

    public static boolean buscarPasajeroPorNombre(Bus bus, String nombrePasajero) {
        boolean sw = false;
        PilaPasajero pilaPas = bus.getPilaPas();
        PilaPasajero aux = new PilaPasajero();
        while(!pilaPas.esVacia()) {
            Pasajero x = pilaPas.pop();
            if(x.getNombre().equals(nombrePasajero))
                sw = true;
            aux.push(x);
        }
        pilaPas.vaciar(aux);
        bus.setPilaPas(pilaPas);
        return sw;
    }
}