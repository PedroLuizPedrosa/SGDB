package model;

public class Cargo {

    private int codCargo;
    private String nomeCargo;
    private float salario;

    public Cargo() {
    }

    public Cargo(int codCargo, String nomeCargo, float salario) {
        this.codCargo = codCargo;
        this.nomeCargo = nomeCargo;
        this.salario = salario;
    }

    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

    public String getNomeCargo() {
        return nomeCargo;
    }

    public void setNomeCargo(String nomeCargo) {
        this.nomeCargo = nomeCargo;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

}
