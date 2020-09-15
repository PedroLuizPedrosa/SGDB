package model;

import dao.TipoProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produto {

    private int codProduto;
    private String nomeProduto;
    private int qntdProdutoEstoque;
    private float precoProduto;
    private String descricao;
    private TipoProduto tipoProduto;
    private int codTipoProduto;

    public Produto() {
    }

    public Produto(int codProduto, String nomeProduto, int qntdProdutoEstoque, float precoProduto, String descricao, TipoProduto tipoProduto) {
        this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.qntdProdutoEstoque = qntdProdutoEstoque;
        this.precoProduto = precoProduto;
        this.descricao = descricao;
        this.tipoProduto = tipoProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQntdProdutoEstoque() {
        return qntdProdutoEstoque;
    }

    public void setQntdProdutoEstoque(int qntdProdutoEstoque) {
        this.qntdProdutoEstoque = qntdProdutoEstoque;
    }

    public float getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(float precoProduto) {
        this.precoProduto = precoProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoProduto getTipoProduto() {
        if ((tipoProduto == null) && (codTipoProduto != 0)) {
            try {
                tipoProduto = TipoProdutoDAO.obterTipoProduto(codTipoProduto);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    
    public int getCodTipoProduto() {
        return codTipoProduto;
    }

    public void setCodTipoProduto(int codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }

}
