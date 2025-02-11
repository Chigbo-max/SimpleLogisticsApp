package data.models;
import data.repositries.Items;

import java.util.ArrayList;

import static data.repositries.Items.*;

public class Item {
    private static int count = 0;
    private int id;
    private String name;
    private String description;
    private int weightInGrams;
    private Receiver receiver;
    private Sender sender;


    public Item(String name, String description, int weightInGrams) {
        this.id = generateId();
        this.name = name;
        this.description = description;
        this.weightInGrams = weightInGrams;
    }



    public int getItemsSize  () {
        return getItems().size();

    }

    public void saveItem(Item item){
        addItem(item);
        ++count;

    }


    public int generateId(){
        return ++count;
    }

    public int getId() {
        return id;
    }

    public int findItemById(int id){
        for(Item item : getItems()){
            if(item.getId() == id){
                return id;
            }
        }
        throw new IllegalArgumentException("Id not found");
    }

    public boolean existById(int id) {
        for(Item item : getItems()){
            if(item.getId() == id){
                return true;
            }
        }
        return false;
    }



    public void deleteItemById(int id) {
        for(Item item : getItems()){
            if(item.getId() == id){
                System.out.println(item.getId());
                removeItem(item);
                count--;
            }
        }
    }

    public int getCount(){
        return count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeightInGrams() {
        return weightInGrams;
    }

    public void setWeightInGrams(int weightInGrams) {
        this.weightInGrams = weightInGrams;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }

    public Sender getSender() {
        return sender;
    }

    public void setSender(Sender sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", weightInGrams=" + weightInGrams +
                ", receiver=" + receiver +
                ", sender=" + sender +
                '}';
    }


}
