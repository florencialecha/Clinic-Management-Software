package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OdontologDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(BD.class);
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGO VALUES (?,?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGO";


    @Override
    public void registrar(Odontologo odontologo) {


        Connection connection = null;

        try {
            connection = BD.getConnection();
            LOGGER.info("Se registra un pedido de conexión a la base de datos");

            PreparedStatement ps = connection.prepareStatement(SQL_INSERT);
            ps.setInt(1,odontologo.getId());
            ps.setInt(2,odontologo.getMatricula());
            ps.setString(3,odontologo.getNombre());
            ps.setString(4,odontologo.getApellido());
            ps.execute();
            LOGGER.info("Su solicitud fue ejecutada con éxito, ha ingresado a: " + odontologo.getNombre());

        } catch (Exception e) {
            LOGGER.error("No se logró ejecutar su pedido a la bbdd." + e);
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("No se logró cerrar la conexión" + e);
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Odontologo> buscarTodos() {

        List<Odontologo> odontologoList = new ArrayList<>();
        Odontologo odontologo = null;
        Connection connection = null;

        try {
            connection = BD.getConnection();
            LOGGER.info("Se registra un pedido de conexión a la base de datos");

            PreparedStatement ps = connection.prepareStatement(SQL_SELECT_ALL);
            LOGGER.info("Sus pedido está siendo procesado");
            ResultSet rs = ps.executeQuery();
            LOGGER.info("Sus resultados están siendo procesados");
            while (rs.next()) {
                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                odontologoList.add(odontologo);
                LOGGER.info("Matrícula: " + rs.getInt(2) + " -Nombre: " + rs.getString(3) + " -Apellido: " + rs.getString(4));
            }

        } catch (Exception e) {
            LOGGER.error("No se logró ejecutar su pedido a la bbdd." + e);
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("No se logró cerrar la conexión" + e);
                e.printStackTrace();
            }
        }
        return odontologoList;
    }
}
