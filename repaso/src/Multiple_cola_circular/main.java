package Multiple_cola_circular;

public class main {
    public static void main(String[] args) {
        MultiColaCirMed multi = new MultiColaCirMed(); // 2 colas circulares

        Medallero m1 = new Medallero("Atletismo", "Juan Perez", "Oro", "Bolivia");
        Medallero m2 = new Medallero("Natación", "Maria Lopez", "Plata", "Argentina");
        Medallero m3 = new Medallero("Ciclismo", "Carlos Gomez", "Bronce", "Chile");
        Medallero m4 = new Medallero("Fútbol", "Luis Fernandez", "Oro", "Brasil");
        Medallero m5 = new Medallero("Tenis", "Sofia Ruiz", "Plata", "España");
        Medallero m6 = new Medallero("Judo", "Akira Tanaka", "Oro", "Japón");
        Medallero m7 = new Medallero("Boxeo", "Miguel Torres", "Bronce", "México");
        Medallero m8 = new Medallero("Básquet", "James Carter", "Oro", "EEUU");
        Medallero m9 = new Medallero("Gimnasia", "Ana Silva", "Plata", "Portugal");
        Medallero m10 = new Medallero("Levantamiento de pesas", "Ivan Petrov", "Oro", "Rusia");

        // Insertar en las colas
        multi.push(0,m1);
        multi.push(0,m2);
        multi.push(0,m3);


        multi.push(1,m4);
        multi.push(1,m5);
        multi.push(1,m6);

        multi.push(2,m7);
        multi.push(2,m8);
        multi.push(2,m9);


        // Mostrar todas las colas
        //multi.mostrar();

    }
}
