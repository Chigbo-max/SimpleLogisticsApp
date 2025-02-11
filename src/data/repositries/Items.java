package data.repositries;

import data.models.Item;

import java.util.ArrayList;

public class Items {

   private static ArrayList<Item> items = new ArrayList<Item>();

   public static void addItem(Item item) {
       items.add(item);
   }

   public static ArrayList<Item> getItems() {
       return items;
   }

    public static void removeItem(Item item) {
       items.remove(item);
    }

}
