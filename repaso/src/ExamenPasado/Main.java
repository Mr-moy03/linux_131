package ExamenPasado;

public class Main {
    public static void main(String[] args){
        // 1. Crear conductores
        Conductor conductor1 = new Conductor("Juan Pérez", 1234567, "A");
        Conductor conductor2 = new Conductor("María García", 7654321, "B");
        Conductor conductor3 = new Conductor("Carlos López", 9876543, "C");
        Conductor conductor4 = new Conductor("Juan Perez", 9346456, "A");

        // 2. Crear rutas
        Ruta ruta1 = new Ruta("La Paz", "Cochabamba", "08:00");
        Ruta ruta2 = new Ruta("Santa Cruz", "Sucre", "14:30");
        Ruta ruta3 = new Ruta("Oruro", "Potosi", "06:15");
        Ruta ruta4 = new Ruta("Oruro", "La Paz", "07:15");

        // 3. Crear colas de pasajeros para cada bus
        ColaCircularPasajero pasajerosBus1 = new ColaCircularPasajero();
        ColaCircularPasajero pasajerosBus2 = new ColaCircularPasajero();
        ColaCircularPasajero pasajerosBus3 = new ColaCircularPasajero();
        ColaCircularPasajero pasajerosBus4 = new ColaCircularPasajero();

        // 4. Agregar pasajeros a las colas
        Pasajero pasajero1 = new Pasajero("Ana Torres", 1110000, "Adulto");
        Pasajero pasajero2 = new Pasajero("Luis Mendoza", 2222222, "Estudiante");
        Pasajero pasajero3 = new Pasajero("Sofia Castro", 3333333, "Adulto Mayor");

        pasajerosBus1.push(pasajero1);
        pasajerosBus1.push(pasajero2);
        pasajerosBus1.push(pasajero3);

        Pasajero pasajero4 = new Pasajero("Pedro Rojas", 4444444, "Docente");
        Pasajero pasajero5 = new Pasajero("Elena Vargas", 5555555, "Administrativo");

        pasajerosBus2.push(pasajero4);
        pasajerosBus2.push(pasajero5);

        Pasajero pasajero6 = new Pasajero("Roberto Silva", 6666666, "Docente");
        Pasajero pasajero7 = new Pasajero("Carmen Flores", 7777777, "Estudiante");
        Pasajero pasajero8 = new Pasajero("David Herrera", 8888888, "Docente");
        Pasajero pasajero9 = new Pasajero("Laura Paredes", 9999999, "Administrativo");

        pasajerosBus3.push(pasajero6);
        pasajerosBus3.push(pasajero7);
        pasajerosBus3.push(pasajero8);
        pasajerosBus3.push(pasajero9);


        Pasajero pasajero10 = new Pasajero("Carlos Silva", 5555555, "Estudiante");
        Pasajero pasajero11 = new Pasajero("Luis Flores", 1111111, "Estudiante");


        pasajerosBus4.push(pasajero10);
        pasajerosBus4.push(pasajero11);

        // 5. Crear buses
        Bus bus1 = new Bus("abc", 30, conductor1, ruta1, pasajerosBus1);
        Bus bus2 = new Bus("xxx", 40, conductor2, ruta2, pasajerosBus2);
        Bus bus3 = new Bus("yyy", 30, conductor3, ruta3, pasajerosBus3);
        Bus bus4 = new Bus("zzz", 30, conductor4, ruta4, pasajerosBus4);





        // 6. Crear la multicolas circular de buses
        MultiColaCircularBus multiColaBuses = new MultiColaCircularBus(5);

        // 7. Agregar buses a diferentes colas de la multicolas
        multiColaBuses.push(0, bus1);  // Lunes
        multiColaBuses.push(0, bus2);  // Lunes
        multiColaBuses.push(0, bus3);  // Lunes
        multiColaBuses.push(0, bus4);  // Lunes

        multiColaBuses.push(1, bus2);  // Martes
        multiColaBuses.push(1, bus1);  // Martes

        multiColaBuses.push(2, bus4);  // Miercoles
        multiColaBuses.push(2, bus1);  // Miercoles
        multiColaBuses.push(2, bus3);  // Miercoles

        multiColaBuses.push(3, bus4);  // Jueves
        multiColaBuses.push(3, bus3);  // Jueves
        multiColaBuses.push(3, bus1);  // Jueves

        multiColaBuses.push(4, bus3);  // Viernes
        multiColaBuses.push(4, bus4);  // Viernes

        // Mostrar todo
        System.out.println("=== MULTICOLAS CIRCULAR DE BUSES ===");
        multiColaBuses.mostrar();

        // b) Mostrar placas de buses con mayor número de pasajeros en día X (Miércoles = 2)
        System.out.println("=== b) BUSES CON MÁS PASAJEROS - MIÉRCOLES ===");
        mostrarBusesMayorPasajeros(multiColaBuses, 2);

        // c) Mostrar días que un pasajero usó el servicio (CI 1111111 = Ana Torres)
        System.out.println("\n=== c) DÍAS QUE USÓ EL SERVICIO PASAJERO CI 1111111 ===");
        mostrarDiasPorPasajero(multiColaBuses, 1111111);

        // d) Agrupar por tipo de pasajero en Jueves
        System.out.println("\n=== d) AGRUPACIÓN POR TIPO - JUEVES ===");
        agruparPorTipoJueves(multiColaBuses, 3);
    }
    public static void mostrarBusesMayorPasajeros(MultiColaCircularBus semana, int dia) {

        ColaCircularBus aux = new ColaCircularBus();
        int maxPasajeros = -1;

        // Primera pasada: encontrar el máximo
        while(!semana.esVacia(dia)) {
            Bus bus = semana.pop(dia);
            int numPasajeros = bus.getCcPasajero().nroElem();
            if(numPasajeros > maxPasajeros) {
                maxPasajeros = numPasajeros;
            }
            aux.push(bus);
        }

        // Segunda pasada: mostrar buses con máximo
        while(!aux.esVacia()) {
            Bus bus = aux.pop();
            if(bus.getCcPasajero().nroElem() == maxPasajeros) {
                System.out.println("Placa: " + bus.getPlaca() + " - Pasajeros: " + maxPasajeros);
            }
            semana.push(dia, bus);
        }
    }

    // c) Método para mostrar días que un pasajero usó el servicio
    public static void mostrarDiasPorPasajero(MultiColaCircularBus semana, int ciPasajero) {
        String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        boolean[] usadoEnDia = new boolean[5];

        for(int dia = 0; dia < 5; dia++) {
            ColaCircularBus auxDia = new ColaCircularBus();

            while(!semana.esVacia(dia)) {
                Bus bus = semana.pop(dia);
                ColaCircularPasajero auxPasajeros = new ColaCircularPasajero();
                boolean encontrado = false;

                // Buscar pasajero en este bus
                while(!bus.getCcPasajero().esVacia()) {
                    Pasajero p = bus.getCcPasajero().pop();
                    if(p.getCi() == ciPasajero) {
                        encontrado = true;
                    }
                    auxPasajeros.push(p);
                }

                if(encontrado) {
                    usadoEnDia[dia] = true;
                }

                // Restaurar cola de pasajeros
                bus.getCcPasajero().vaciar(auxPasajeros);
                auxDia.push(bus);
            }

            // Restaurar cola del día
            semana.vaciar(dia, auxDia);
        }

        // Mostrar resultados
        for(int i = 0; i < 5; i++) {
            if(usadoEnDia[i]) {
                System.out.println("- " + dias[i]);
            }
        }
    }

    // d) Método para agrupar por tipo de pasajero en jueves
    public static void agruparPorTipoJueves(MultiColaCircularBus semana, int jueves) {
        ColaCircularBus auxJueves = new ColaCircularBus();
        int busNum = 1;

        while(!semana.esVacia(jueves)) {
            Bus bus = semana.pop(jueves);
            System.out.println("\nBus " + busNum + " - Placa: " + bus.getPlaca());

            // Contadores por tipo
            int estudiantes = 0, docentes = 0, administrativos = 0;
            ColaCircularPasajero auxPasajeros = new ColaCircularPasajero();

            while(!bus.getCcPasajero().esVacia()) {
                Pasajero p = bus.getCcPasajero().pop();

                // Contar por tipo (directo como en el PDF)
                if("Estudiante".equals(p.getTipo())) {
                    estudiantes++;
                } else if("Docente".equals(p.getTipo())) {
                    docentes++;
                } else if("Administrativo".equals(p.getTipo())) {
                    administrativos++;
                }

                auxPasajeros.push(p);
            }

            // Mostrar resultados
            System.out.println("  Estudiantes: " + estudiantes);
            System.out.println("  Docentes: " + docentes);
            System.out.println("  Administrativos: " + administrativos);
            System.out.println("  Total: " + (estudiantes + docentes + administrativos));

            // Restaurar cola de pasajeros
            bus.getCcPasajero().vaciar(auxPasajeros);
            auxJueves.push(bus);
            busNum++;
        }

        // Restaurar cola de jueves
        semana.vaciar(jueves, auxJueves);
    }

    // Método auxiliar para nombres de días
    public static String getNombreDia(int dia) {
        String[] nombres = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
        return (dia >= 0 && dia < 5) ? nombres[dia] : "Día inválido";
    }
}























