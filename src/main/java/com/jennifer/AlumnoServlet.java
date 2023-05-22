/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jennifer;




import com.jennifer.dao.AlumnoDAO;
import com.jennifer.dao.AlumnoDAOImpl;
import com.jennifer.model.Alumno;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/AlumnoServlet")

    
public class AlumnoServlet extends HttpServlet{
    private AlumnoDAO alumnoDao;
    
    public AlumnoServlet() {
        super();
        alumnoDao = new AlumnoDAOImpl();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.procesarSolicitud(req, resp);
    }
    
    protected void procesarSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("action")) {
            case "list":
                // this.list(request, response);
                break;
            case "create":
                this.create(request, response);
                break;
            case "read":
                // this.read(request, response);
                break;
            case "update":
                // this.update(request, response);
                break;
            case "delete":
                // this.delete(request, response);
                break;
            case "showRegister":
                this.showRegister(request, response);
                break;
            case "index":
                this.index(request, response);
                break;
            default:
                this.index(request, response);
                break;
        }
    }
    
    private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
    
    private void showRegister(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/create.jsp");
        dispatcher.forward(request, response);
    }
    
    private void create(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String nacionalidad = request.getParameter("nacionalidad");
        String matricula = request.getParameter("matricula");
        String telefono = request.getParameter("telefono");
        
        Alumno objAlumno = new Alumno();
        objAlumno.setId(Integer.parseInt(id));
        objAlumno.setNombre(nombre);
        objAlumno.setNacionalidad(nacionalidad);
        objAlumno.setMatricula(matricula);
        objAlumno.setTelefono(telefono);
        
        alumnoDao.insert(objAlumno);
        
        this.index(request, response);
    }
}

    

