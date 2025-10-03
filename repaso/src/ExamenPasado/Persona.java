package ExamenPasado;

public class Persona {
    protected String nombre;
    protected int ci;
    public Persona(String nombre,int ci){
        this.nombre = nombre;
        this.ci = ci;
    }

    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getCi(){
        return this.ci;
    }
    public void setCi(int ci){
        this.ci = ci;
    }

    @Override
    public String toString(){
        return String.format("Nombre: %s, Ci: %d",nombre,ci);
    }


    public void mostrar(){
        System.out.println(toString());
    }

}
