package dao;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {

    private static final Logger LOGGER = Logger.getLogger(BD.class);

    public static void crearTabla(){

        Connection connection = null;

        try {

            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute("DROP TABLE IF EXISTS ODONTOLOGO;" +
               "CREATE TABLE ODONTOLOGO (ID INT PRIMARY KEY, MATRICULA INT, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)");

        } catch (Exception e) {

            LOGGER.error("No se logró establecer la conexión" + e);
            e.printStackTrace();

        } finally {

            try{
                connection.close();
                LOGGER.info("La conexión se cerró de forma exitosa.");
            }catch (Exception e){
                LOGGER.error("No se logró cerrar la conexión" + e);
                e.printStackTrace();
            }

        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/LechaFlorencia", "sa", "sa");
    }
}
