package org.carrental.dao;

import org.carrental.domain.Customer;

import java.sql.ClientInfoStatus;
import java.util.List;

public interface CRUD<T> {

    void insert(T obj);
    List<T> getAll();

    //T getById(T id);

 //   Customer getById(Long id);

    Customer getById(Long id);

    void update(T obj, Long id);

    void deleteById(Long id);

}
