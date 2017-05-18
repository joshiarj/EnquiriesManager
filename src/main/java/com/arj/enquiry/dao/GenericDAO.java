package com.arj.enquiry.dao;

import java.util.List;

public interface GenericDAO<T> {
    int insert(T t);
    void update(T t);
    boolean delete(int id);
    T getById(int id);
    List<T> getAll();
}
