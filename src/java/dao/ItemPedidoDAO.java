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
import model.ItemPedido;

public class ItemPedidoDAO {

    public static List<ItemPedido> obterItensPedidos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<ItemPedido> itensPedidos = new ArrayList<ItemPedido>();
        ItemPedido itemPedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itemPedido");
            while (rs.next()) {
                itemPedido = instanciarItemPedido(rs);
                itensPedidos.add(itemPedido);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return itensPedidos;
    }

    public static ItemPedido obterItemPedido(int codItemPedido) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        ItemPedido itemPedido = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from itemPedido where codItemPedido = " + codItemPedido);
            rs.first();
            itemPedido = instanciarItemPedido(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return itemPedido;
    }

    public static ItemPedido instanciarItemPedido(ResultSet rs) throws SQLException {
        ItemPedido itemPedido = new ItemPedido(rs.getInt("codItemPedido"),
                rs.getInt("qntdProdutoPedido"),
                null,
                null);
        itemPedido.setCodProduto(rs.getInt("Produto_codProduto"));
        itemPedido.setCodPedido(rs.getInt("Pedido_codPedido"));
        return itemPedido;
    }

    public static void gravar(ItemPedido itemPedido) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into itempedido (codItemPedido, qntdProdutoPedido, Pedido_codPedido, Produto_codProduto) values (?,?,?,?)");
            comando.setInt(1, itemPedido.getCodItemPedido());
            comando.setInt(2, itemPedido.getQntdProdutoPedido());
            if (itemPedido.getPedido() == null) {
                comando.setNull(3, Types.INTEGER);
            } else {
                comando.setInt(3, itemPedido.getPedido().getCodPedido());
            }
            if (itemPedido.getProduto() == null) {
                comando.setNull(4, Types.INTEGER);
            } else {
                comando.setInt(4, itemPedido.getProduto().getCodProduto());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(ItemPedido itemPedido) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from itempedido where codItemPedido = " + itemPedido.getCodItemPedido();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(ItemPedido itemPedido) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update itemPedido set "
                    + "qntdProdutoPedido = " + itemPedido.getQntdProdutoPedido() + ", "
                    + "Pedido_codPedido = ";
            if (itemPedido.getPedido() == null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + itemPedido.getPedido().getCodPedido();
            }
            stringSQL = stringSQL + ", Produto_codProduto = ";
            if (itemPedido.getProduto()== null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + itemPedido.getProduto().getCodProduto();
            }
            stringSQL = stringSQL + " where codItemPedido = " + itemPedido.getCodItemPedido();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
