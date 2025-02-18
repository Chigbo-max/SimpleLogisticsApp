package services;

import data.models.Item;

public interface ItemService {
    Item createNewPackage(String description, int weightInKg);

    long getNumberOfPackages();

    void deleteById(int id);

    void deleteAll();

    boolean existById(int id);
}
