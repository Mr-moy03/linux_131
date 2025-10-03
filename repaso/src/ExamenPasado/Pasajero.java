package ExamenPasado;

public class Pasajero extends Persona{
    private String tipo;

    public Pasajero (String nombre,int ci,String tipo){
        super(nombre,ci);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString(){
        return String.format("  > Nombre: %s, ci: %d, Tipo: %s",nombre,ci,tipo);
    }

    public void mostrar(){
        System.out.println(toString());
    }
}
