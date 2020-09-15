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
import model.Funcionario;

public class FuncionarioDAO {

    public static List<Funcionario> obterFuncionarios() throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pessoa, funcionario where pessoa.codPessoa=funcionario.codPessoa");
            while (rs.next()) {
                funcionario = instanciarFuncionario(rs);
                funcionarios.add(funcionario);
            }
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionarios;
    }

    public static Funcionario obterFuncionario(int codPessoa) throws ClassNotFoundException, SQLException {
        Connection conexao = null;
        Statement comando = null;
        Funcionario funcionario = null;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            ResultSet rs = comando.executeQuery("select * from pessoa p, funcionario f where p.codPessoa = " + codPessoa);
            rs.first();
            funcionario = instanciarFuncionario(rs);
        } finally {
            fecharConexao(conexao, comando);
        }
        return funcionario;
    }

    public static Funcionario instanciarFuncionario(ResultSet rs) throws SQLException {
        Funcionario funcionario = new Funcionario(
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
        funcionario.setCodCargo(rs.getInt("Cargo_codCargo"));
        return funcionario;
    }

    public static void gravar(Funcionario funcionario) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        PreparedStatement comando = null;

        try {
            conexao = BD.getConexao();
            comando = conexao.prepareStatement("insert into pessoa (codPessoa, nome, dataNasc, sexo, cpf, rg,"
                    + "telefone, celular, email, cep, logradouro, numero, complemento, bairro, cidade, estado) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            comando.setInt(1, funcionario.getCodPessoa());
            comando.setString(2, funcionario.getNome());
            comando.setString(3, funcionario.getDataNasc());
            comando.setString(4, funcionario.getSexo());
            comando.setString(5, funcionario.getCpf());
            comando.setString(6, funcionario.getRg());
            comando.setString(7, funcionario.getTelefone());
            comando.setString(8, funcionario.getCelular());
            comando.setString(9, funcionario.getEmail());
            comando.setString(10, funcionario.getCep());
            comando.setString(11, funcionario.getLogradouro());
            comando.setInt(12, funcionario.getNumero());
            comando.setString(13, funcionario.getComplemento());
            comando.setString(14, funcionario.getBairro());
            comando.setString(15, funcionario.getCidade());
            comando.setString(16, funcionario.getEstado());
            comando.executeUpdate();

            comando = conexao.prepareStatement("insert into funcionario (codPessoa, Cargo_codCargo) values (?, ?)");
            comando.setInt(1, funcionario.getCodPessoa());
            if (funcionario.getCargo() == null) {
                comando.setNull(2, Types.INTEGER);
            } else {
                comando.setInt(2, funcionario.getCargo().getCodCargo());
            }
            comando.executeUpdate();
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void excluir(Funcionario funcionario) throws SQLException, ClassNotFoundException {
        Connection conexao = null;
        Statement comando = null;
        String stringSQL;

        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "delete from funcionario where codPessoa = " + funcionario.getCodPessoa();
            comando.execute(stringSQL);
            stringSQL = "delete from pessoa where codPessoa = " + funcionario.getCodPessoa();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

    public static void alterar(Funcionario funcionario) throws SQLException, ClassNotFoundException {

        Connection conexao = null;
        Statement comando = null;
        String stringSQL;
        try {
            conexao = BD.getConexao();
            comando = conexao.createStatement();
            stringSQL = "update pessoa set "
                    + "nome = '" + funcionario.getNome() + "',"
                    + "datanasc = '" + funcionario.getDataNasc() + "',"
                    + "sexo = '" + funcionario.getSexo() + "',"
                    + "cpf = '" + funcionario.getCpf() + "',"
                    + "rg = '" + funcionario.getRg() + "',"
                    + "telefone = '" + funcionario.getTelefone() + "',"
                    + "celular = '" + funcionario.getCelular() + "',"
                    + "email = '" + funcionario.getEmail() + "',"
                    + "cep = '" + funcionario.getCep() + "',"
                    + "logradouro = '" + funcionario.getLogradouro() + "',"
                    + "numero = '" + funcionario.getNumero() + "',"
                    + "complemento = '" + funcionario.getComplemento() + "',"
                    + "bairro = '" + funcionario.getBairro() + "',"
                    + "cidade = '" + funcionario.getCidade() + "',"
                    + "estado = '" + funcionario.getEstado() + "'";
            stringSQL = stringSQL + "where codPessoa = " + funcionario.getCodPessoa();
            comando.execute(stringSQL);
            stringSQL = "update funcionario set Cargo_codCargo = ";
            if (funcionario.getCargo() == null) {
                stringSQL = stringSQL + "null";
            } else {
                stringSQL = stringSQL + funcionario.getCargo().getCodCargo();
            }
            stringSQL = stringSQL + " where codPessoa = " + funcionario.getCodPessoa();
            comando.execute(stringSQL);
        } finally {
            fecharConexao(conexao, comando);
        }
    }

}
