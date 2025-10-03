package ExamenPasado;

public class Conductor extends Persona {
    private String categoria;

    public Conductor(String nombre,int ci,String categoria){
        super(nombre,ci);
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return String.format("Nombre: %s, ci: %d, Categoria: %s",nombre,ci,categoria);
    }

    public void mostrar(){
        System.out.println(toString());
    }
}
