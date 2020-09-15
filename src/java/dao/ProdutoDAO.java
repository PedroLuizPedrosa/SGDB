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
import model.Produto;

public class ProdutoDAO {

    public static List<Produto> obterProdutos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Produto> produtos = new ArrayList<Produto>();
        Produto produto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto");
            while (rs.next()) {
                produto = instanciarProduto(rs);
                produtos.add(produto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return produtos;
    }

    public static Produto obterProduto(int codProduto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Produto produto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from produto where codProduto = " + codProduto);
            rs.first();
            produto = instanciarProduto(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return produto;
    }

    public static Produto instanciarProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto(rs.getInt("codProduto"),
                rs.getString("nomeProduto"),
                rs.getInt("qntdProdutoEstoque"),
                rs.getFloat("precoProduto"),
                rs.getString("descricao"),
                null);
        produto.setCodTipoProduto(rs.getInt("TipoProduto_codTipoProduto"));
        return produto;
    }

    public static void gravar(Produto produto) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into produto (codProduto, nomeProduto, qntdProdutoEstoque,"
                    + "precoProduto, descricao, TipoProduto_codTipoProduto) values (?,?,?,?,?,?)");
            comando.setInt(1, produto.getCodProduto());
            comando.setString(2, produto.getNomeProduto());
            comando.setInt(3, produto.getQntdProdutoEstoque());
            comando.setFloat(4, produto.getPrecoProduto());
            comando.setString(5, produto.getDescricao());
            if (produto.getTipoProduto() == null) {
                comando.setNull(6, Types.INTEGER);
            } else {
                comando.setInt(6, produto.getTipoProduto().getCodTipoProduto());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Produto produto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from produto where codProduto = " + produto.getCodProduto();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Produto produto) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update produto set "
                    + "nomeProduto = '" + produto.getNomeProduto() + "',"
                    + "qntdProdutoEstoque = " + produto.getQntdProdutoEstoque() + ","
                    + "precoProduto = " + produto.getPrecoProduto() + ","
                    + "descricao = '" + produto.getDescricao() + "',"
                    + "TipoProduto_codTipoProduto = ";            
            if (produto.getTipoProduto() == null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + produto.getTipoProduto().getCodTipoProduto();
            }
            stringSQL = stringSQL + " where codProduto = " + produto.getCodProduto();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
