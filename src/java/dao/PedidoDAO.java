package dao;

import static dao.DAO.fecharConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class PedidoDAO {

    public static List<Pedido> obterPedidos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Pedido> pedidos = new ArrayList<Pedido>();
        Pedido pedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pedido");
            while (rs.next()) {
                pedido = instanciarPedido(rs);
                pedidos.add(pedido);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return pedidos;
    }

    public static Pedido obterPedido(int codPedido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Pedido pedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pedido where codPedido = " + codPedido);
            rs.first();
            pedido = instanciarPedido(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return pedido;
    }

    public static Pedido instanciarPedido(ResultSet rs) throws SQLException {
        Pedido pedido = new Pedido(rs.getInt("codPedido"),
                rs.getString("dataPedido"),
                null);
        pedido.setCodPessoa(rs.getInt("Cliente_codPessoa"));
        return pedido;
    }

    public static void gravar(Pedido pedido) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into pedido (codPedido, dataPedido, Cliente_codPessoa) values (?,?,?)");
            comando.setInt(1, pedido.getCodPedido());
            comando.setString(2, pedido.getDataPedido());
            if (pedido.getCliente() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, pedido.getCliente().getCodPessoa());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void excluir(Pedido pedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from pedido where codPedido = " + pedido.getCodPedido();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(Pedido pedido) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update pedido set "
                    + "dataPedido = '" + pedido.getDataPedido() + "', "
                    + "Cliente_codPessoa = ";            
            if (pedido.getCliente() == null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + pedido.getCliente().getCodPessoa();
            }
            stringSQL = stringSQL + " where codPedido = " + pedido.getCodPedido();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
