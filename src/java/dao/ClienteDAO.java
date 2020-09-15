package dao;

import static dao.DAO.fecharConexao;
import javax.servlet.ServletException;
import model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public static List<Cliente> obterClientes() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pessoa, cliente where pessoa.codPessoa=cliente.codPessoa");
            while (rs.next()) {
                cliente = instanciarCliente(rs);
                clientes.add(cliente);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return clientes;
    }

    public static Cliente obterCliente(int codPessoa) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cliente cliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pessoa p , cliente c where p.codPessoa = " + codPessoa );
            rs.first();
            cliente = instanciarCliente(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return cliente;
    }

    public static Cliente instanciarCliente(ResultSet rs) throws SQLException {
        Cliente cliente = new Cliente(
                rs.getInt("codPessoa"),
                rs.getString("nome"),
                rs.getString("dataNasc"),
                rs.getString("sexo"),
                rs.getString("cpf"),
                rs.getString("rg"),
                rs.getString("telefone"),
                rs.getString("celular"),
                rs.getString("email"),
                rs.getString("cep"),
                rs.getString("logradouro"),
                rs.getInt("numero"),
                rs.getString("complemento"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                null);
            cliente.setCodTipoCliente(rs.getInt("TipoCliente_codTipoCliente"));
        return cliente;
    }

    public static void gravar(Cliente cliente) throws SQLException, ClassNotFoundException, ServletException {

        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into pessoa (codPessoa, nome, dataNasc, sexo, cpf, rg, telefone, celular, email, cep, logradouro, numero, complemento, bairro, cidade, estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, cliente.getCodPessoa());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getDataNasc());
            comando.setString(4, cliente.getSexo());
            comando.setString(5, cliente.getCpf());
            comando.setString(6, cliente.getRg());
            comando.setString(7, cliente.getTelefone());
            comando.setString(8, cliente.getCelular());
            comando.setString(9, cliente.getEmail());
            comando.setString(10, cliente.getCep());
            comando.setString(11, cliente.getLogradouro());
            comando.setInt(12, cliente.getNumero());
            comando.setString(13, cliente.getComplemento());
            comando.setString(14, cliente.getBairro());
            comando.setString(15, cliente.getCidade());
            comando.setString(16, cliente.getEstado());
            comando.executeUpdate();
            
            comando = conexao.prepareStatement("insert into cliente (codPessoa, TipoCliente_codTipoCliente) values (?, ?)");
            comando.setInt(1, cliente.getCodPessoa());
            if (cliente.getTipoCliente() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, cliente.getTipoCliente().getCodTipoCliente());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Cliente cliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from cliente where cliente.codPessoa = " + cliente.getCodPessoa();
            comando.execute(stringSQL);
            stringSQL = "delete from pessoa where codPessoa = " + cliente.getCodPessoa();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Cliente cliente) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update pessoa set "
                    + "nome = '" + cliente.getNome() + "',"
                    + "datanasc = '" + cliente.getDataNasc() + "',"
                    + "sexo = '" + cliente.getSexo() + "',"
                    + "cpf = '" + cliente.getCpf() + "',"
                    + "rg = '" + cliente.getRg() + "',"
                    + "telefone = '" + cliente.getTelefone() + "',"
                    + "celular = '" + cliente.getCelular() + "',"
                    + "email = '" + cliente.getEmail() + "',"
                    + "cep = '" + cliente.getCep() + "',"
                    + "logradouro = '" + cliente.getLogradouro() + "',"
                    + "numero = '" + cliente.getNumero() + "',"
                    + "complemento = '" + cliente.getComplemento() + "',"
                    + "bairro = '" + cliente.getBairro() + "',"
                    + "cidade = '" + cliente.getCidade() + "',"
                    + "estado = '" + cliente.getEstado() + "'";
            stringSQL = stringSQL + "where codPessoa = " + cliente.getCodPessoa();
            comando.execute(stringSQL);
            stringSQL = "update cliente set Cliente_codTipoCliente = ";
            if (cliente.getTipoCliente() == null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + cliente.getTipoCliente().getCodTipoCliente();
            }
            stringSQL = stringSQL + " where codPessoa = " + cliente.getCodPessoa();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
}
