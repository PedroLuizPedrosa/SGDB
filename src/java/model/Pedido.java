package model;

import dao.ClienteDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pedido {

    private int codPedido;
    private String dataPedido;
    private Cliente cliente;
    private int codPessoa;

    public Pedido() {
    }

    public Pedido(int codPedido, String dataPedido, Cliente cliente) {
        this.codPedido = codPedido;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        if ((cliente == null) && (codPessoa != 0)) {
            try {
                cliente = ClienteDAO.obterCliente(codPessoa);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }
    
}
