/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jennifer.dao;
import com.jennifer.config.Conexion;
import com.jennifer.model.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class AlumnoDAOImpl implements AlumnoDAO{
    
    private Conexion objConexion;
private Connection objConnection;

public AlumnoDAOImpl() {
    objConexion = new Conexion();
}

@Override
public List<Alumno> findAll() {
    String consulta = "SELECT * FROM alumnos";
    List<Alumno> listado = new LinkedList<>();

    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();

        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        // Ejecuta la consulta
        ResultSet rs = prest.executeQuery(consulta);

        Alumno objAlumno;

        while (rs.next()) {
            objAlumno = new Alumno();
            objAlumno.setId(rs.getInt("id"));
            objAlumno.setNombre(rs.getString("nombre"));
            objAlumno.setNacionalidad(rs.getString("nacionalidad"));
            objAlumno.setMatricula(rs.getString("matricula"));
            objAlumno.setTelefono(rs.getString("telefono"));

            listado.add(objAlumno);
        }
    } catch (Exception e) {
        System.out.println("Error en la consulta");
    }
    return listado;
}

@Override
public Alumno insert(Alumno objAlumno) {
    String consulta = "INSERT INTO alumnos ( nombre, nacionalidad, matricula, telefono) VALUES (?,?,?,?)";
    try {
        this.objConexion.conectar();
        this.objConnection = this.objConexion.getJdbcConnection();
        // Inicialización de la consulta
        PreparedStatement prest = this.objConnection.prepareStatement(consulta);
        // Agregar los datos dentro de la consulta

        prest.setString(1, objAlumno.getNombre());
        prest.setString(2, objAlumno.getNacionalidad());
        prest.setString(3, objAlumno.getMatricula());
        prest.setString(4, objAlumno.getTelefono());

        int count = prest.executeUpdate();

        ResultSet rs = null;
        rs = prest.executeQuery("SELECT LAST_INSERT_ID()");

        int autoKey = -1;
        if (rs.next()) {
            autoKey = rs.getInt("id");
            objAlumno.setId(autoKey);
            System.out.println("Ultimo ID introducido: " + autoKey);
        } else {
            System.out.println("No existe dato de ID");
        }

    } catch (Exception e) {
        System.out.println("Error al insertar");
    }
    return objAlumno;
}

@Override
public Alumno findById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}

@Override
public Alumno updateById(Integer id, Alumno objAlumno) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}

@Override
public Boolean deleteById(Integer id) {
    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
}
}


