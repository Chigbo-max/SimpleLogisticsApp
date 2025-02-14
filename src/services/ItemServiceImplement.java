package services;

import data.models.Item;
import data.repositries.Items;
import data.repositries.ItemsRepository;

public class ItemServiceImplement implements ItemService{
    private ItemsRepository repository = new Items();

    @Override
    public Item createNewPackage(String description, int weightInKg) {
        Item newItem = new Item();
        newItem.setDescription(description);
        newItem.setWeightInGrams(weightInKg);
        return repository.save(newItem);
    }


    @Override
    public long numberOfPackages() {
        return repository.count();
    }
}
