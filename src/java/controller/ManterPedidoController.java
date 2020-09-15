package controller;

import dao.ClienteDAO;
import dao.PedidoDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Pedido;

public class ManterPedidoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        } else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("clientes", ClienteDAO.obterClientes());
            if (!operacao.equals("Incluir")) {
                int codPedido = Integer.parseInt(request.getParameter("codPedido"));
                Pedido pedido = PedidoDAO.obterPedido(codPedido);
                request.setAttribute("pedido", pedido);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroPedido.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            int codPedido = Integer.parseInt(request.getParameter("txtCodPedido"));
            String dataPedido = request.getParameter("txtDataPedido");
            Cliente cliente = null;
            if (!operacao.equals("Excluir")) {
                int codPessoa = Integer.parseInt(request.getParameter("txtCodPessoa"));
                if (codPessoa != 0) {
                    cliente = ClienteDAO.obterCliente(codPessoa);
                }
            }
            Pedido pedido = new Pedido(codPedido, dataPedido, cliente);

            if (operacao.equals("Incluir")) {
                PedidoDAO.gravar(pedido);
            } else if (operacao.equals("Excluir")) {
                PedidoDAO.excluir(pedido);
            } else if (operacao.equals("Editar")) {
                PedidoDAO.alterar(pedido);
            }
            
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPedidoController");
            view.forward(request, response);
        } catch (IOException e) {
            throw new ServletException(e);
        } catch (SQLException e) {
            throw new ServletException(e);
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        } catch (ServletException e) {
            throw e;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
