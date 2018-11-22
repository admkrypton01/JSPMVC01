package modelo.dataccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.entities.productosNT;

public class productosDT {
    public boolean insertar(productosNT prdtsNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();        
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("insert into articulos"
                    + "(codigo,descripcion,stock,precio) values(?,?,?,?)");
            ps.setInt(1,ultimoCodigo(cnnConexion)+1);
            ps.setString(2,prdtsNT.getDescripcion());
            ps.setDouble(3,prdtsNT.getStock());
            ps.setDouble(4,prdtsNT.getPrecio());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }

    public boolean actualizar(productosNT prdtsNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("update articulos set "
                    + "descripcion=?,stock=?,precio=? where codigo=?");
            ps.setString(1,prdtsNT.getDescripcion());
            ps.setDouble(2,prdtsNT.getStock());
            ps.setDouble(3,prdtsNT.getPrecio());
            ps.setInt(4,prdtsNT.getCodigo());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }
    
    public boolean eliminar(productosNT prdtsNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("delete from articulos "
                    + "where codigo=?");
            ps.setInt(1,prdtsNT.getCodigo());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }

    public List<productosNT> listarTodos() throws Exception{
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        List<productosNT> lstTodos = new ArrayList<>();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("select * from articulos "
                    + "order by codigo");
            ResultSet rslListado = ps.executeQuery();
            while(rslListado.next()){
                lstTodos.add(new productosNT(rslListado.getInt("codigo"),
                rslListado.getString("descripcion"),
                rslListado.getDouble("stock"),
                rslListado.getDouble("precio")));
            }
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return lstTodos;
    }

    public int ultimoCodigo(Connection _cnnConexion) throws Exception{
        int _codigo = 0;
        try{
            PreparedStatement ps=_cnnConexion.prepareStatement("select * from articulos "
                    + "order by codigo desc");
            ResultSet rslListado = ps.executeQuery();
            if(rslListado.next()){
                _codigo = rslListado.getInt("codigo");
            }
        }catch(Exception e){
            throw e;
        }
        return _codigo;
    }
}
