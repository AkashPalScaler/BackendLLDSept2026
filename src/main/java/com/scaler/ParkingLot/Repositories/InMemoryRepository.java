package com.scaler.ParkingLot.Repositories;

import com.scaler.ParkingLot.Models.BaseClass;

import java.util.*;

// save(), getById(), findAll()
public class InMemoryRepository<T extends BaseClass> {
    Map<Long, T> store = new HashMap<>();
    private static Long lastId = 0l;
    public T save(T item){
        if(item.getId() == null){
            item.setId(++lastId);
        }
        if(item.getCreated_at() == null){
            item.setCreated_at(new Date()); // only first time
        }
        item.setUpdated_at(new Date()); // Every time there's an update
        store.put(item.getId(), item);
        return item;
    }

    public T getById(Long id){
        return store.get(id);
    }

    public List<T> findAll(){
        return new ArrayList<>(store.values());
    }
}
