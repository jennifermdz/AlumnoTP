<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Pagina de Registro de Alumno</h1>
        <form action="<%= request.getContextPath()%>/AlumnoServlet" method="GET">
            <label for="id">ID:</label>
            <input type="text" name="id" id="id">
            <br>
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" id="nombre">
            <br>
            <label for="nacionalidad">Nacionalidad:</label>
            <input type="text" name="nacionalidad" id="nacionalidad">
            <br>
            <label for="matricula">Matricula:</label>
            <input type="text" name="matricula" id="matricula">
            <br>
            <label for="telefono">Telefono:</label>
            <input type="text" name="telefono" id="telefono">
            <br>
            <input type="submit" value="Registrar">
        </form>
            
    </body>
</html>

