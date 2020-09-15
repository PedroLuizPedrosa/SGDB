package controller;

import dao.ClienteDAO;
import dao.TipoClienteDAO;
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
import model.TipoCliente;

public class ManterClienteController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }else if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("tiposCliente", TipoClienteDAO.obterTiposCliente());
            if (!operacao.equals("Incluir")) {
                int codPessoa = Integer.parseInt(request.getParameter("codPessoa"));
                Cliente cliente = ClienteDAO.obterCliente(codPessoa);
                request.setAttribute("cliente", cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/cadastroCliente.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        try {
            String operacao = request.getParameter("operacao");
            int codPessoa = Integer.parseInt(request.getParameter("txtCodPessoa"));
            String nome = request.getParameter("txtNome");
            String dataNasc = request.getParameter("txtDataNasc");
            String sexo = request.getParameter("txtSexo");
            String cpf = request.getParameter("txtCpf");
            String rg = request.getParameter("txtRg");
            String telefone = request.getParameter("txtTelefone");
            String celular = request.getParameter("txtCelular");
            String email = request.getParameter("txtEmail");
            String cep = request.getParameter("txtCep");
            String logradouro = request.getParameter("txtLogradouro");
            int numero = Integer.parseInt(request.getParameter("txtNumero"));
            String complemento = request.getParameter("txtComplemento");
            String bairro = request.getParameter("txtBairro");
            String cidade = request.getParameter("txtCidade");
            String estado = request.getParameter("txtEstado");
            TipoCliente tipoCliente = null;
            if (!operacao.equals("Excluir")) {
                int codTipoCliente = Integer.parseInt(request.getParameter("txtCodTipoCliente"));
                if (codTipoCliente != 0) {
                    tipoCliente = TipoClienteDAO.obterTipoCliente(codTipoCliente);
                }
            }
            Cliente cliente = new Cliente(codPessoa, nome, dataNasc, sexo, cpf, rg, telefone, celular, email,
                    cep, logradouro, numero, complemento, bairro, cidade, estado, tipoCliente);
          
            if (operacao.equals("Incluir")) {
                ClienteDAO.gravar(cliente);
            }else if (operacao.equals("Excluir")){
                ClienteDAO.excluir(cliente);
            }else if (operacao.equals("Editar")){
                ClienteDAO.alterar(cliente);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaClienteController");
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
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterClienteController.class.getName()).log(Level.SEVERE, null, ex);
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
