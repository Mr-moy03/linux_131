public class Pasajero {
	private String nombre;
	private int edad;
	private String tipo;
	
	public Pasajero(String nombre,int edad,String tipo){
		this.setNombre(nombre);
		this.setEdad(edad);
		this.setTipo(tipo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return String.format("--Nombre: %s, Edad: %d, Tipo: %s", nombre,edad,tipo);
	}

    public void mostrar() {
        System.out.println(toString());
    }
}
