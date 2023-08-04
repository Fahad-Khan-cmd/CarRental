package org.carrental.dao;

import org.carrental.domain.*;

import java.util.List;

public interface CRUD<T> {

   void insert(T obj);


    void insert(Vehicle obj);

    void insert(Booking obj);

    List<T> getAll();

    //T getById(T id);

 //   Customer getById(Long id);

    Customer getById(Long id);

    void update(T obj, Long  id);

   // void update(T obj, Long  id);

    void update(Customer obj);

    void update(Customer obj, Integer id);

    void update(Vehicle obj, Integer id);

    void deleteById(Long id);

    List<Customer> getByName(String Name);

    void update(User customer);

    void update(VehicleOwner obj);

    void update(VehicleOwner obj, Integer id);

    void update(Booking obj, Integer id);

    //  void update(Customer customer);


    // void update(T customer);


    // void update(T customer);
}
