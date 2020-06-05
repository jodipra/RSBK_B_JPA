/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HZ
 */

@PersistenceContext(name = "persistence/LogicalName", unitName = "JPA_TUGASPU")
@WebServlet(name = "QuerySurvey", urlPatterns = {"/QuerySurvey"})
public class QuerySurvey extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Resource
    private javax.transaction.UserTransaction utx;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
 String nama = "";
 if (request.getParameter("nama") != null) {
 nama = request.getParameter("nama");
 }
 
  String jurusan = "";
 if (request.getParameter("jurusan") != null) {
 nama = request.getParameter("jurusan");
 }
  String alamat = "";
 if (request.getParameter("alamat") != null) {
 alamat = request.getParameter("alamat");
 }
  String telp = "";
 if (request.getParameter("telp") != null) {
 telp = request.getParameter("telp");
 }
  String minat = "";
 if (request.getParameter("minat") != null) {
 minat = request.getParameter("minat");
 }
 Context ctx = (Context) new InitialContext().lookup("java:comp/env");
 utx.begin();
 EntityManager em = (EntityManager) ctx.lookup("persistence/LogicalName");
 Query q = em.createNativeQuery("INSERT s INTO Survey s VALUES(?1,?2,?3,?3,?4,?5,?6");
//Query q = em.createNativeQuery("SELECT ROUND(AVG(Emp.SALARY),0) FROM Dept, Emp WHERE Emp.DEPT_DID = Dept.DID and Dept.Dname =?1");
 q.setParameter(1, nama);
 q.setParameter(2, jurusan);
 q.setParameter(3, alamat);
 q.setParameter(4, telp);
 q.setParameter(5, minat);
 q.executeUpdate();
// List r = q.getResultList();
 utx.commit();
 out.println("Berhasil Input");
 } catch (Exception e) {
 e.printStackTrace();
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
