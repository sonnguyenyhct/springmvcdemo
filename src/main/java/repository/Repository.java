package repository;

import java.util.List;

public interface Repository<T> {
    Iterable<T> fillAll();
    T findById(Long id);
    void save(T t);
    void remove(Long id);
}
