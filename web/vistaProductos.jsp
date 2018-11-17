<%@page import="java.util.*"%>
<%@page import="modelo.entities.productosNT"%>
<%@page import="modelo.dataccess.productosDT"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Productos</title>
        <script lang="JavaScript">
            function cargar(codi, desc, stoc, prec){
                document.frmProductos.txtCodi.value=codi;
                document.frmProductos.txtDesc.value=desc;
                document.frmProductos.txtStoc.value=stoc;
                document.frmProductos.txtPrec.value=prec;
            }
        </script>
    </head>
    <%
        productosDT prdctsDT = new productosDT();
        List<productosNT> prdcts = new ArrayList();
    %>    
    <body>
        <form name="frmProductos" method="POST" action="productosCT">
            <div>
                <label for="codigo">Codigo</label>
                <div>
                    <input type="text" name="txtCodi">
                </div>
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <div>
                    <input type="text" name="txtDesc">
                </div>
            </div>
            <div>
                <label for="stock">Stock</label>
                <div>
                    <input type="text" name="txtStoc">
                </div>
            </div>
            <div>
                <label for="precio">Precio</label>
                <div>
                    <input type="text" name="txtPrec">
                </div>
            </div>
            <br>
            <input type="submit" name="btnInsertar" value="Insertar">
            <input type="submit" name="btnActualizar" value="Actualizar">
            <input type="submit" name="btnEliminar" value="Eliminar">
        </form>
        <br>
        <hr><center>
        <br>
        <%
             if(request.getParameter("std")!=null){
                 if(request.getParameter("std").equals("1")){
                    out.println("<a href='vistaProductos.jsp'>"+request.getParameter("mens")+"</a><br>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<a href='vistaProductos.jsp'>"+request.getParameter("mens")+"</a><br>");
            }
                }
        %>
        <br>
        <table border="1px">
            <tr> 
                <td>Codigo </td><td>Descripción </td><td>Stock </td><td>Precio </td><td>Accion </td>
            </tr>
            <%
                prdcts = prdctsDT.listarTodos();
                for(productosNT p:prdcts){
            %>
            <tr>
                <td align="right"><%=p.getCodigo()%> </td>
                <td><%=p.getDescripcion()%> </td>
                <td align="right"><%=p.getStock()%> </td>
                <td align="right"><%=p.getPrecio()%> </td>
                <td><a href="javascript:void(0);" onclick="cargar(<%=p.getCodigo()%>,
                            '<%=p.getDescripcion()%>',<%=p.getStock()%>,
                            <%=p.getPrecio()%>)">Cargar</a></td>
            </tr>
            <% } %>
        </table>
        </center>
    </body>
</html>
