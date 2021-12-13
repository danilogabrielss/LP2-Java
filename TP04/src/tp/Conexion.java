package tp;

import java.sql.*;

public class Conexion {
    public Conexion(){
    getConexion();}

public static Connection getConexion(){
    Connection con = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS:1433;databaseName=aulajava"
                    + ";integratedSecurity=true";
            con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            /*for (int i = 0; i < 1000; i++) {
                String x = "INSERT INTO ALUNOS (nome, idade,sexo) VALUES('ALUNO " + i + "',18,'" + (i % 2 == 0 ? 'F' : 'M') + "')";
                st.executeUpdate(x);
            }*/
            //con.close();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return con;
    }
}
