package model;

public class TipoProduto {

    private int codTipoProduto;
    private String nomeTipoProduto;

    public TipoProduto() {
    }

    public TipoProduto(int codTipoProduto, String nomeTipoProduto) {
        this.codTipoProduto = codTipoProduto;
        this.nomeTipoProduto = nomeTipoProduto;
    }

    public int getCodTipoProduto() {
        return codTipoProduto;
    }

    public void setCodTipoProduto(int codTipoProduto) {
        this.codTipoProduto = codTipoProduto;
    }

    public String getNomeTipoProduto() {
        return nomeTipoProduto;
    }

    public void setNomeTipoProduto(String nomeTipoProduto) {
        this.nomeTipoProduto = nomeTipoProduto;
    }

}
