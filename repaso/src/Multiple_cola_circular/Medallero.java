package Multiple_cola_circular;

public class Medallero {
    private String disciplina;
    private String deportista;
    private String medalla;
    private String pais;

    public Medallero(String disciplina, String deportista, String medalla,String pais){
        this.disciplina =  disciplina;
        this.deportista = deportista;
        this.medalla = medalla;
        this.pais = pais;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDeportista() {
        return deportista;
    }

    public void setDeportista(String deportista) {
        this.deportista = deportista;
    }

    public String getMedalla() {
        return medalla;
    }

    public void setMedalla(String medalla) {
        this.medalla = medalla;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString(){
        return String.format("Disciplina: %s, Deportista: %s, Medalla: %s, Pais: %s",disciplina,deportista,medalla,pais);
    }

    public void mostrar(){
        System.out.println(toString());
    }
}
