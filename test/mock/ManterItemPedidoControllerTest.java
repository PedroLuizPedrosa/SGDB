package mock;

import controller.ManterItemPedidoController;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import junit.framework.TestCase;
import static org.easymock.EasyMock.*;

public class ManterItemPedidoControllerTest extends TestCase {

    public void testManterItemPedidoControllerIncluir() throws ServletException, IOException, SQLException, ClassNotFoundException {

        HttpServletRequest requestMock = createMock(HttpServletRequest.class);
        HttpServletResponse responseMock = createMock(HttpServletResponse.class);

        expect(requestMock.getParameter("operacao")).andReturn("Incluir");
        expect(requestMock.getParameter("txtCodItemPedido")).andReturn("2");
        expect(requestMock.getParameter("txtCodProduto")).andReturn("1");
        expect(requestMock.getParameter("txtQntdProdutoPedido")).andReturn("2");
        expect(requestMock.getParameter("txtCodPedido")).andReturn("1");
        replay(requestMock);

        ManterItemPedidoController controller = new ManterItemPedidoController();

        boolean resInc = controller.confirmarOperacao(requestMock, responseMock);

        assertEquals(true, resInc);
    }

    public void testManterReservaControllerExcluir() throws ServletException, IOException, SQLException, ClassNotFoundException {

        HttpServletRequest requestMock = createMock(HttpServletRequest.class);
        HttpServletResponse responseMock = createMock(HttpServletResponse.class);
        
        expect(requestMock.getParameter("operacao")).andReturn("Excluir");
        expect(requestMock.getParameter("txtCodItemPedido")).andReturn("2");
        expect(requestMock.getParameter("txtQntdProdutoPedido")).andReturn("2");
        replay(requestMock);

        ManterItemPedidoController controller = new ManterItemPedidoController();

        boolean resExc = controller.confirmarOperacao(requestMock, responseMock);

        assertEquals(true, resExc);
    }

}
