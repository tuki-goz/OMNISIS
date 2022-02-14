package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;
import model.Cambiocontra;
import model.Inhabilitarusuario;
import model.Variables;

/**
 *
 * @author Alvaro Ortega SA
 */
public class Controlador extends HttpServlet {

    public String us;
    UsuarioDAO dao = new UsuarioDAO();
    Cambiocontra dao2 = new Cambiocontra();
    Inhabilitarusuario dao3 = new Inhabilitarusuario();
    Usuario p = new Usuario();
    int r;
    int contrasenha;
    int contfallo = 0;
    int contfalloblo = 0;
    //CURIOSIDADES QUE APRENDI, CUANDO HACEMOS CAGADA, METERLE UN COMENTARIO AL QUE ESTÁ BIEN Y CLONARLO. 03.09.2021

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion.equals("Ingresar")) {

            String usuar = request.getParameter("txtusuario");
            String contra = String.valueOf(request.getParameter("txtcontrasena"));
            int length = usuar.length();
            int length2 = contra.length();
            Variables.usuario1 = usuar;

            if (length == 0 || length2 == 0) {
                request.getRequestDispatcher("mensajeCamposVaciosLogin.jsp").forward(request, response);
                //   request.getRequestDispatcher("index.htm").forward(request, response);
            } else {
                p.setNombre_usuario(usuar);
                p.setClave_usuario(contra);
                r = dao.validar(p);
                if (r == 1) {
                    if (contra.equalsIgnoreCase("123")) {
                        request.getSession().setAttribute("usuar", usuar);
                        request.getRequestDispatcher("cambioContra.jsp").forward(request, response);
                    } else {
                        request.getSession().setAttribute("usuar", usuar);
                        request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    }
                } else {
                    contfalloblo = contfalloblo + 1;
                    if (contfalloblo == 3) {
                        request.getRequestDispatcher("bloqueousuario.jsp").forward(request, response);
                        contfalloblo = 0;
                    }
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    System.out.println("Hello World in Console!");
                }
            }
        } else {

            if (accion.equals("Cambiar")) {

                String usuar = request.getParameter("txtusuario");
                String contra = request.getParameter("txtcontrasena");
                String contraconf = request.getParameter("txtconfcontrasena");
                int length = contra.length();
                int length2 = contraconf.length();

                if (length == 0 || length2 == 0) {

                    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
                    //   request.getRequestDispatcher("index.htm").forward(request, response);
                    // r = 1;

                } else {

                    p.setClave_usuario(contraconf);
                    r = dao2.validar(p);
                    // contrasenha = Integer.parseInt(contra);

                    if (r == 1) {

                        request.getSession().setAttribute("usuar", usuar);
                        request.getRequestDispatcher("index.htm").forward(request, response);
                        us = usuar;

                    } else {
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                        contfallo = contfallo + 1;

                    }
                }

            } else {

                request.getRequestDispatcher("index.htm").forward(request, response);
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
