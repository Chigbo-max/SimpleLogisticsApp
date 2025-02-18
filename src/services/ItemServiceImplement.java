package services;

import data.models.Item;
import data.repositries.Items;
import data.repositries.ItemsRepository;
import data.repositries.TrackingInfos;
import data.repositries.TrackingInfosRepository;

public class ItemServiceImplement implements ItemService{
    private ItemsRepository items;
    private TrackingInfoService trackingInfoService;

    public ItemServiceImplement(ItemsRepository items, TrackingInfoService trackingInfoService) {
        this.items = items;
        this.trackingInfoService = trackingInfoService;
    }


    @Override
    public Item createNewPackage(String description, int weightInKg) {
        Item newItem = new Item();
        newItem.setDescription(description);
        newItem.setWeightInGrams(weightInKg);
        Item savedItem =  items.save(newItem);
        trackingInfoService.createNewTrackingInfo(savedItem);
        return savedItem;
    }


    @Override
    public long getNumberOfPackages() {
        return items.count();
    }

    @Override
    public void deleteById(int id) {
       if(!items.existById(id)){throw new IllegalArgumentException("Item id does not exist");}
       trackingInfoService.deleteById(id);
       items.deleteById(id);
    }

    @Override
    public void deleteAll() {
        items.deleteAll();
    }

    @Override
    public boolean existById(int id) {
        if(items.existById(id)){return true;}
        return false;
    }


}
