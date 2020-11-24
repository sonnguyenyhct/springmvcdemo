package service;

import model.Customer;

public interface IService<T> {
    Iterable<T> selectAll();
    T findById(Long id);
    void save(T t);
    void update(T t);
    void remote(Long id);
}
