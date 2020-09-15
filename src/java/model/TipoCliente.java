package model;

public class TipoCliente {

    private int codTipoCliente;
    private String descricao;
    private int aplicarDesconto;

    public TipoCliente() {
    }

    public TipoCliente(int codTipoCliente, String descricao, int aplicarDesconto) {
        this.codTipoCliente = codTipoCliente;
        this.descricao = descricao;
        this.aplicarDesconto = aplicarDesconto;
    }
    
    public int getCodTipoCliente() {
        return codTipoCliente;
    }

    public void setCodTipoCliente(int codTipoCliente) {
        this.codTipoCliente = codTipoCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAplicarDesconto() {
        return aplicarDesconto;
    }

    public void setAplicarDesconto(int aplicarDesconto) {
        this.aplicarDesconto = aplicarDesconto;
    }
    
    
    
}
