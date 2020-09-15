package model;

import dao.TipoClienteDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cliente extends Pessoa {
    
    private TipoCliente tipoCliente;
    private int codTipoCliente;

    public Cliente() {
    }

    public Cliente(int codPessoa, String nome, String dataNasc, String sexo, String cpf, String rg, String telefone, String celular, String email, String cep, String logradouro, int numero, String complemento, String bairro, String cidade, String estado, TipoCliente tipoCliente) {
        super(codPessoa, nome, dataNasc, sexo, cpf, rg, telefone, celular, email, cep, logradouro, numero, complemento, bairro, cidade, estado);
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        if ((tipoCliente == null) && (codTipoCliente != 0)) {
            try {
                tipoCliente = TipoClienteDAO.obterTipoCliente(codTipoCliente);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(int codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    

}
