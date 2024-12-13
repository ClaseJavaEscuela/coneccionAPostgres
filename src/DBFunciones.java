import java.sql.Connection;
import java.sql.DriverManager;

public class DBFunciones {

    public Connection conexion(String dbName,String user,String password){
        Connection conn = null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/"+dbName,user,password);

            if(conn!=null){
                System.out.println("Conexion exitosa");
            }else{
                System.out.println("Conexion fallida");
            }

        }catch (Exception e){
            System.out.println("Error en la conexion");
        }
        return conn;
    }
    public void read_data(Connection conn){
        try{
            String query = "SELECT * FROM clientes";
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                System.out.print(rs.getString("nombre")+"<->"+rs.getString("ciudad")+"\n");
            }
        }catch (Exception e){
            System.out.println("Error en la lectura");
        }
    }
}
