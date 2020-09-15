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
import model.TipoProduto;

public class TipoProdutoDAO {

    public static List<TipoProduto> obterTiposProduto() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<TipoProduto> tiposProduto = new ArrayList<TipoProduto>();
        TipoProduto tipoProduto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipoProduto");
            while (rs.next()) {
                tipoProduto = instanciarTipoProduto(rs);
                tiposProduto.add(tipoProduto);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return tiposProduto;
    }
    
    public static TipoProduto obterTipoProduto(int codTipoProduto) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        TipoProduto tipoProduto = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from tipoProduto where codTipoProduto = " + codTipoProduto);
            rs.first();
            tipoProduto = instanciarTipoProduto(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return tipoProduto;
    }

    public static TipoProduto instanciarTipoProduto(ResultSet rs) throws SQLException {
        TipoProduto tipoProduto = new TipoProduto(rs.getInt("codTipoProduto"),
                rs.getString("nomeTipoProduto"));
        return tipoProduto;
    }
    
    public static void gravar(TipoProduto tipoProduto) throws SQLException, ClassNotFoundException, ServletException {

        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into tipoproduto (codTipoProduto, nomeTipoProduto) values (?,?)");
            comando.setInt(1, tipoProduto.getCodTipoProduto());
            comando.setString(2, tipoProduto.getNomeTipoProduto());
            comando.executeUpdate();
        } finally{
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(TipoProduto tipoProduto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from tipoproduto where codTipoProduto = " + tipoProduto.getCodTipoProduto();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
    public static void alterar(TipoProduto tipoProduto) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update tipoProduto set "
                    + "nomeTipoProduto= '"  + tipoProduto.getNomeTipoProduto() + "' "
                    + "where codTipoProduto = " + tipoProduto.getCodTipoProduto();
            comando.executeUpdate(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }
    
}
