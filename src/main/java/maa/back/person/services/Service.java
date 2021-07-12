package maa.back.person.services;

import java.util.Collection;

public interface Service<T>{
    T saveOrUpdate(T entity);
    T findById(Long id);
    Collection<T> findAll();
    void delete(Long id);
}
