package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import model.TipoCliente;

public class TipoClienteDAO {
   
    public static List<TipoCliente> obterTiposCliente() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoCliente> tiposCliente = new ArrayList<TipoCliente>();
        TipoCliente tipoCliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipoCliente");
            while (rs.next()) {
                tipoCliente = instanciarTipoCliente(rs);
                tiposCliente.add(tipoCliente);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return tiposCliente;
    }
    
    public static TipoCliente obterTipoCliente(int codTipoCliente) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        TipoCliente tipoCliente = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipoCliente where codTipoCliente = " + codTipoCliente);
            rs.first();
            tipoCliente = instanciarTipoCliente(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoCliente;
    }

    public static TipoCliente instanciarTipoCliente(ResultSet rs) throws SQLException {
        TipoCliente tipoCliente = new TipoCliente(rs.getInt("codTipoCliente"),
                rs.getString("descricao"),
                rs.getInt("aplicarDesconto"));
        return tipoCliente;
    }
    
    public static void gravar(TipoCliente tipoCliente) throws SQLException, ClassNotFoundException, ServletException {

        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into tipocliente (codTipoCliente, descricao, aplicarDesconto) values (?, ?,?)");
            comando.setInt(1, tipoCliente.getCodTipoCliente());
            comando.setString(2, tipoCliente.getDescricao());
            comando.setInt(3, tipoCliente.getAplicarDesconto());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(TipoCliente tipoCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tipocliente where codTipoCliente = " + tipoCliente.getCodTipoCliente();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(TipoCliente tipoCliente) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tipoCliente set "
                    + "descricao = '"  + tipoCliente.getDescricao() + "', "
                    + "aplicarDesconto =" + tipoCliente.getAplicarDesconto()
                    + "where codTipoCliente = " + tipoCliente.getCodTipoCliente();
            comando.executeUpdate(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
