package data.repositries;

import data.models.Item;

import java.util.ArrayList;
import java.util.Arrays;

public class Items {

   private ArrayList <Item> items = new ArrayList<Item>();
   private static int counter;

   public Items() {
       items = new ArrayList<>();
   }

    public int count  () {
        return items.size();
    }

    public void save(Item item) {
       item.setId(generateId());
       items.add(item);
    }

    public int generateId(){
       return ++counter;
    }

    public Item findById(int id) {
       for(Item item : items) {
           if(item.getId() == id) {
               return item;
           }
       }
       return null;
    }

    public void deleteById(int id) {
       Item item = findById(id);
       items.remove(item);
    }

    public void deleteAllById(int ...ids) {
       for(int id : ids) {
           deleteById(id);
       }
    }

    public void deleteAll(){
       items.clear();
    }

    public boolean existById(int id) {
        for(Item item : items) {
            if(item.getId() == id) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<Item> findAll(){
       return items;
    }

    public ArrayList<Item> saveAll(Item... items) {
        return new ArrayList<>(Arrays.asList(items));
    }

    public ArrayList<Item> findAllById(int ...ids) {
       ArrayList<Item> foundItems = new ArrayList<>();
        for(int id : ids){
            Item item = findById(id);
            if(item != null) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void update(Item item) {
       item.setName(item.getName());
       item.setDescription(item.getDescription());
       item.setWeightInGrams(item.getWeightInGrams());
    }

    @Override
    public String toString() {
        return "Items{" +
                "items=" + items +
                '}';
    }
}
