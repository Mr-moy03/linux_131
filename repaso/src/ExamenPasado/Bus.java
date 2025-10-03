package ExamenPasado;

public class Bus {
    private String placa;
    private int capacidad;
    private Conductor conductor;
    private Ruta ruta;
    private ColaCircularPasajero ccPasajero;

    public Bus(String placa,int capacidad,Conductor conductor,Ruta ruta,ColaCircularPasajero ccPasajero){
        this.placa = placa;
        this.capacidad = capacidad;
        this.conductor = conductor;
        this.ruta = ruta;
        this.ccPasajero = ccPasajero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public ColaCircularPasajero getCcPasajero() {
        return ccPasajero;
    }

    public void setCcPasajero(ColaCircularPasajero ccPasajero) {
        this.ccPasajero = ccPasajero;
    }


    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(String.format("-> Placa: %s, Capacidad: %d\n",placa,capacidad));
        s.append("-> Conductor:\n");
        s.append("---"+conductor+"\n");

        s.append("-> Ruta:\n");
        s.append("---"+ruta+"\n");

        s.append("-> Pasajeros:\n");
        s.append(ccPasajero+"\n");

        return s.toString();
    }

    public void mostrar(){
        System.out.println(toString());
    }
}
