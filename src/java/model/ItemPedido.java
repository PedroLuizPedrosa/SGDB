package model;

import dao.PedidoDAO;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemPedido {

    private int codItemPedido;
    private int qntdProdutoPedido;
    public Pedido pedido;
    private Produto produto;
    private int codProduto;
    private int codPedido;

    public ItemPedido() {
    }

    public ItemPedido(int codItemPedido, int qntdProdutoPedido, Pedido pedido, Produto produto) {
        this.codItemPedido = codItemPedido;
        this.qntdProdutoPedido = qntdProdutoPedido;
        this.pedido = pedido;
        this.produto = produto;
    }

    public int getCodItemPedido() {
        return codItemPedido;
    }

    public void setCodItemPedido(int codItemPedido) {
        this.codItemPedido = codItemPedido;
    }

    public int getQntdProdutoPedido() {
        return qntdProdutoPedido;
    }

    public void setQntdProdutoPedido(int qntdProdutoPedido) {
        this.qntdProdutoPedido = qntdProdutoPedido;
    }

    public Pedido getPedido() {
        if ((pedido == null) && (codPedido != 0)) {
            try {
                pedido = PedidoDAO.obterPedido(codPedido);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        if ((produto == null) && (codProduto != 0)) {
            try {
                produto = ProdutoDAO.obterProduto(codProduto);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Funcionario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }

    public float calculaTotal() {
        float total;
        total = this.getQntdProdutoPedido() * produto.getPrecoProduto();
        return total;
    }

    public float calculaDesconto() {
        float calcDesc;
        int categoriaCliDesc = pedido.getCliente().getTipoCliente().getAplicarDesconto();
        calcDesc = calculaTotal() - ((calculaTotal() * categoriaCliDesc) / 100);
        return calcDesc;
    }

    public float desconto() {

        float calcDesc;
        String categoriaCliente = pedido.getCliente().getTipoCliente().getDescricao();
        int categoriaCliDesc = pedido.getCliente().getTipoCliente().getAplicarDesconto();
        float valor = 200;
        float totalCompra = calculaTotal();

        if ("VIP".equals(categoriaCliente)) {
            calcDesc = totalCompra - ((totalCompra * categoriaCliDesc) / 100);
            if (totalCompra >= 5 * valor) {
                calcDesc = (calcDesc - (totalCompra * 10) / 100);
            } else if (totalCompra >= 3 * valor) {
                calcDesc = ( calcDesc - (totalCompra * 6) / 100);
            } else if (totalCompra > 0){
                calcDesc = (calcDesc - (totalCompra * 2) / 100);
            }
            return calcDesc;
        } else if ("FREQUENTE".equals(categoriaCliente)) {
            calcDesc = totalCompra - ((totalCompra * categoriaCliDesc) / 100);
            if (totalCompra >= 5 * valor) {
                calcDesc = (calcDesc - (totalCompra * 8) / 100);
            } else if (totalCompra >= 4 * valor) {
                calcDesc = (calcDesc - (totalCompra * 4) / 100);
            }
            return calcDesc;
        } else if ("MODERADO".equals(categoriaCliente)) {
            calcDesc = totalCompra - ((totalCompra * categoriaCliDesc) / 100);
            if (calculaTotal() >= 6 * valor) {
                calcDesc = (calcDesc - (totalCompra * 6) / 100);
            } else if (calculaTotal() >= 4 * valor) {
                calcDesc = (calcDesc - (totalCompra * 3) / 100);
            }
            return calcDesc;
        } else if ("INICIANTE".equals(categoriaCliente)) {
            calcDesc = totalCompra - ((totalCompra * categoriaCliDesc) / 100);
            if (calculaTotal() >= 7 * valor) {
                calcDesc = (calcDesc - (totalCompra * 5) / 100);
            } else if (calculaTotal() >= 5 * valor) {
                calcDesc = (calcDesc - (totalCompra * 2) / 100);
            }
            return calcDesc;
        } else if (calculaTotal() >= valor * 10) {
            calcDesc = totalCompra - ((totalCompra * 10) / 100);
            return calcDesc;
        } else {
            return calcDesc = totalCompra;
        }
    }

    /*public void desconto() {

        String categoriaCliente = pedido.getCliente().getTipoCliente().getDescricao();
        int categoriaCliDesc = pedido.getCliente().getTipoCliente().getAplicarDesconto();
        float totalComDesc = 0;
        float valor = 200;

        if ("Vip".equals(categoriaCliente)) {
            if (calculaTotal() >= valor) {
                calculaDesconto();
            }
        } else if ("Frequente".equals(categoriaCliente)) {
            if (calculaTotal() >= (valor * 2)) {
                calculaDesconto();
            }
        } else if ("Moderado".equals(categoriaCliente)) {
            if (calculaTotal() >= (valor * 3)) {
                calculaDesconto();
            }
        } else if ("Inciante".equals(valor * 4)) {
            if (calculaTotal() >= (valor * 3.5)) {
                calculaDesconto();
            }
        } else if (calculaTotal() >= (valor * 5)) {
            totalComDesc = calculaTotal() - ((calculaTotal() * 5) / 100);
        } else if (calculaTotal() >= (valor * 6)) {
            totalComDesc = calculaTotal() - ((calculaTotal() * 6) / 100);
        } else if (calculaTotal() >= (valor * 7)) {
            totalComDesc = calculaTotal() - ((calculaTotal() * 7) / 100);
        }

    }*/
}
