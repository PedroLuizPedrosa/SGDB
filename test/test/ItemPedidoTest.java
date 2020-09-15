package test;

import junit.framework.TestCase;
import model.Cliente;
import model.ItemPedido;
import model.Pedido;
import model.TipoCliente;
import model.Produto;

public class ItemPedidoTest extends TestCase {

    ItemPedido itemPedido;
    Cliente cliente;
    TipoCliente tipoCliente;
    Produto produto;
    Pedido pedido;

    @Override
    public void setUp() {
        itemPedido = new ItemPedido();
        cliente = new Cliente();
        tipoCliente = new TipoCliente();
        produto = new Produto();
        pedido = new Pedido();

        itemPedido.setPedido(pedido);
        itemPedido.setProduto(produto);
        pedido.setCliente(cliente);
        cliente.setTipoCliente(tipoCliente);
    }

    /**
     * ************************* VIP *********************************
     */
    public void testItemPedido_Desconto_VIP1000() {
        tipoCliente.setDescricao("VIP");
        tipoCliente.setAplicarDesconto(10);
        itemPedido.setQntdProdutoPedido(20);
        produto.setPrecoProduto(50);

        assertEquals((float) 800, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_VIP600() {
        tipoCliente.setDescricao("VIP");
        tipoCliente.setAplicarDesconto(10);
        itemPedido.setQntdProdutoPedido(20);
        produto.setPrecoProduto(30);

        assertEquals((float) 504, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_VIP1() {
        tipoCliente.setDescricao("VIP");
        tipoCliente.setAplicarDesconto(10);
        itemPedido.setQntdProdutoPedido(1);
        produto.setPrecoProduto(1);

        assertEquals((float) 0.88, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_VIP0() {
        tipoCliente.setDescricao("VIP");
        tipoCliente.setAplicarDesconto(10);

        assertEquals((float) 0, itemPedido.desconto());
    }
    /**
     * ********************** FREQUENTE ******************************
     */
    public void testItemPedido_Desconto_FREQUENTE1000() {
        tipoCliente.setDescricao("FREQUENTE");
        tipoCliente.setAplicarDesconto(8);
        itemPedido.setQntdProdutoPedido(20);
        produto.setPrecoProduto(50);

        assertEquals((float) 840, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_FREQUENTE800() {
        tipoCliente.setDescricao("FREQUENTE");
        tipoCliente.setAplicarDesconto(8);
        itemPedido.setQntdProdutoPedido(20);
        produto.setPrecoProduto(40);

        assertEquals((float) 704, itemPedido.desconto());
    }
    
    public void testItemPedido_Desconto_FREQUENTE799() {
        tipoCliente.setDescricao("FREQUENTE");
        tipoCliente.setAplicarDesconto(8);
        itemPedido.setQntdProdutoPedido(799);
        produto.setPrecoProduto(1);

        assertEquals((float) 735.08, itemPedido.desconto());
    }

    /**
     * *********************** MODERADO *******************************
     */
    public void testItemPedido_Desconto_MODERADO1200() {
        tipoCliente.setDescricao("MODERADO");
        tipoCliente.setAplicarDesconto(6);
        itemPedido.setQntdProdutoPedido(30);
        produto.setPrecoProduto(40);

        assertEquals((float) 1056, itemPedido.desconto());
    }
    
    public void testItemPedido_Desconto_MODERADO800() {
        tipoCliente.setDescricao("MODERADO");
        tipoCliente.setAplicarDesconto(6);
        itemPedido.setQntdProdutoPedido(20);
        produto.setPrecoProduto(40);

        assertEquals((float) 728, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_MODERADO799() {
        tipoCliente.setDescricao("MODERADO");
        tipoCliente.setAplicarDesconto(6);
        itemPedido.setQntdProdutoPedido(1);
        produto.setPrecoProduto(799);

        assertEquals((float) 751.06, itemPedido.desconto());
    }

    /**
     * *********************** INICIANTE *******************************
     */
    public void testItemPedido_Desconto_INICIANTE1400() {
        tipoCliente.setDescricao("INICIANTE");
        tipoCliente.setAplicarDesconto(5);
        itemPedido.setQntdProdutoPedido(70);
        produto.setPrecoProduto(20);

        assertEquals((float) 1260, itemPedido.desconto());
    }

    public void testItemPedido_Desconto_INICIANTE1000() {
        tipoCliente.setDescricao("INICIANTE");
        tipoCliente.setAplicarDesconto(5);
        itemPedido.setQntdProdutoPedido(25);
        produto.setPrecoProduto(40);

        assertEquals((float) 930, itemPedido.desconto());
    }
    
    public void testItemPedido_Desconto_INICIANTE999() {
        tipoCliente.setDescricao("INICIANTE");
        tipoCliente.setAplicarDesconto(5);
        itemPedido.setQntdProdutoPedido(1);
        produto.setPrecoProduto(999);

        assertEquals((float) 949.05, itemPedido.desconto());
    }

    /**
     * ************ SEM CATEGORIA, DESCONTO COM VALOR *****************
     */
    public void testItemPedido_Desconto_2000() {
        itemPedido.setQntdProdutoPedido(50);
        produto.setPrecoProduto(40);

        assertEquals((float) 1800, itemPedido.desconto());
    }

    /**
     * *********************** SEM DESCONTO ***************************
     */
    public void testItemPedido_Desconto_1999() {
        itemPedido.setQntdProdutoPedido(1);
        produto.setPrecoProduto(1999);

        assertEquals((float) 1999, itemPedido.desconto());
    }
}
