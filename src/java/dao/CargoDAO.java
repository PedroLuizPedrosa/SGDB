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
import model.Cargo;

public class CargoDAO {

    public static List<Cargo> obterCargos() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Cargo> cargos = new ArrayList<Cargo>();
        Cargo cargo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cargo");
            while (rs.next()) {
                cargo = instanciarCargo(rs);
                cargos.add(cargo);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return cargos;
    }

    public static Cargo obterCargo(int codCargo) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Cargo cargo = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from cargo where codCargo = " + codCargo);
            rs.first();
            cargo = instanciarCargo(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return cargo;
    }

    public static Cargo instanciarCargo(ResultSet rs) throws SQLException {
        Cargo cargo = new Cargo(rs.getInt("codCargo"),
                rs.getString("nomeCargo"),
                rs.getFloat("salario"));
        return cargo;
    }

    public static void gravar(Cargo cargo) throws SQLException, ClassNotFoundException, ServletException {

        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into cargo (codCargo, nomeCargo, salario) values (?,?,?)");
            comando.setInt(1, cargo.getCodCargo());
            comando.setString(2, cargo.getNomeCargo());
            comando.setFloat(3, cargo.getSalario());
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Cargo cargo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from cargo where codCargo = " + cargo.getCodCargo();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Cargo cargo) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update cargo set "
                    + "nomecargo = '" + cargo.getNomeCargo() + "', "
                    + "salario =" + cargo.getSalario()
                    + "where codCargo = " + cargo.getCodCargo();
            comando.executeUpdate(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
