package services;

import data.models.Item;

public interface ItemService {
    Item createNewPackage(String description, int weightInKg);

    long numberOfPackages();
}
