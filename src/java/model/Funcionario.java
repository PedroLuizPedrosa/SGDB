package model;

import dao.CargoDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Funcionario extends Pessoa {

    private Cargo cargo;
    private int codCargo;

    public Funcionario() {
    }

    public Funcionario(int codPessoa, String nome, String dataNasc, String sexo, String cpf, String rg, String telefone, String celular, String email, String cep, String logradouro, int numero, String complemento,
            String bairro, String cidade, String estado, Cargo cargo) {
        super(codPessoa, nome, dataNasc, sexo, cpf, rg, telefone, celular, email, cep, logradouro, numero, complemento, bairro, cidade, estado);
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        if ((cargo == null) && (codCargo != 0)) {
            try {
                cargo = CargoDAO.obterCargo(codCargo);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public int getCodCargo() {
        return codCargo;
    }

    public void setCodCargo(int codCargo) {
        this.codCargo = codCargo;
    }

}
