/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.jennifer.dao;
import com.jennifer.model.Alumno;
import java.util.List;


public interface AlumnoDAO {
    
    public List<Alumno> findAll();
    public Alumno insert(Alumno objAlumno);
    public Alumno findById(Integer id);
    public Alumno updateById(Integer id, Alumno objAlumno);
    public Boolean deleteById(Integer id);
}


