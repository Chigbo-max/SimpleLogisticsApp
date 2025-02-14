package data.repositries;

import data.models.Item;

import java.util.ArrayList;
import java.util.List;

public interface ItemsRepository {
    long count();
    Item save(Item item);
    Item findById(int id);
    void deleteById(int id);
    void deleteAllById(int ...ids);
    void deleteAll();
    boolean existById(int id);
    List<Item> findAll();
    List<Item> saveAll(Item... items);
    List<Item> findAllById(int ...ids);
    void deleteAllEntities(Item... items);

}
