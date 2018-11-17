package modelo.dataccess;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDT {
    String strUrlbd,strUsrbd,strPasbd;
    Connection conConecta = null;
    
    public conexionDT() throws Exception{
//        CONEXION CON BASE DE DATOS ORACLE
//        strUsrbd="uap";
//        strPasbd="2018";
//        strUrlbd="jdbc:oracle:thin:@localhost:1521:db11g";
//        try
//        {   //Carga el driver JDBC
//            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//            //Obtiene la conexion;
//            conConecta=DriverManager.getConnection(strUrlbd,strUsrbd,strPasbd);
//            if (conConecta != null){
//                System.out.println("Conectado...");
//            }
//        }
//        catch (Exception e){
//            throw e;
//        }
        strUsrbd="root";
        strPasbd="krypton";
        strUrlbd="jdbc:mysql://localhost:3306/bdcloud";;
        try
        {   //Carga el driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Obtiene la conexion;
            conConecta=DriverManager.getConnection(strUrlbd,strUsrbd,strPasbd);
            if (conConecta != null){
                System.out.println("Conectado...");
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public Connection obtenerConexion()
    { return conConecta; }

    public Connection cerrarConexion() throws Exception
    {
      try {
        System.out.println("Cerrado...");
        conConecta.close();
        conConecta = null;
        return conConecta;
      } catch (Exception e){
          throw e;
      }
    }    
}