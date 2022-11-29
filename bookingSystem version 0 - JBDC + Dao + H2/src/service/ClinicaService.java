package service;

import dao.IDao;
import dao.OdontologDaoH2;
import model.Odontologo;

import java.util.List;

public class ClinicaService {

    private IDao<Odontologo> odontologoIDao;

    public ClinicaService() {
        odontologoIDao = new OdontologDaoH2();
    }

    public void registrar(Odontologo odontologo) {
        odontologoIDao.registrar(odontologo);
    }

    public List<Odontologo> buscarTodos() {
       return odontologoIDao.buscarTodos();
    }

}
