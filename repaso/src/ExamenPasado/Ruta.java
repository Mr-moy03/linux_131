package ExamenPasado;

public class Ruta {
    private String origen;
    private String destino;
    private String horaSalida;

    public Ruta(String origen,String destino,String horaSalida){
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
    }


    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString(){
        return String.format("Origen: %s, Destino: %s, Hora de salida: %s",origen,destino,horaSalida);
    }

    public void mostrar(){
        System.out.println(toString());
    }
}
