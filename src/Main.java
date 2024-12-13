import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DBFunciones db = new DBFunciones();
        Connection conn = db.conexion("Ejercicio_vistas", "postgres", "ATLAS2010");
        db.read_data(conn);
    }
}