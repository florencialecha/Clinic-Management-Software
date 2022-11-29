package dao;

import java.util.List;

public interface IDao<T> {

    void registrar(T t);
    List<T> buscarTodos();

}
