<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Inserta los datos de la entidad bancaria </h2>
        <form action="insert.jsp">
            Nombre: <input type="text" name="nombre" value=""><br/>        
            Codigo: <input type="text" name="codigo" value=""><br/>
            CIF: <input type="text" name="cif" value=""><br/>   
            Tipo de entidad: 
           <select name="tipo">
                <option value="cooperativaCredito"> cooperativaCredito </option>
                <option value="banco"> banco </option>
                <option value="cajaAhorro"> cajaAhorro </option>
                <option value="establecimientoFinancierodecredito"> establecimientoFinancierodecredito </option>
            </select><br/> 
            <input type="submit" value="Insertar" name="subir"/>
        </form>
    </body>
</html>