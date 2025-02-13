package data.models;


import data.repositries.Items;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class ItemTest{

    Item item;
    Items items;

    @Before
    public void setUp(){
        item = new Item();
        item.setName("Fridge");
        item.setDescription("Please deliver in perfect condition");
        item.setWeightInGrams(200);
        items = new Items();
    }

    @Test
    public void testThatItemListIsEmpty(){
         assertEquals(0,items.count());
    }

    @Test
    public void addTwoItems_getTwo(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
    }

    @Test
    public void addTwoItems_deleteOneById_getOne(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        items.deleteById(newItem.getId());
        assertEquals(1,items.count());
    }

    @Test
    public void addTwoItems_deleteAllById_getZero(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        items.deleteAllById(item.getId(), newItem.getId());
        assertEquals(0,items.count());
    }

    @Test
    public void deleteAllItems_Zero(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        items.deleteAll();
        assertEquals(0,items.count());
    }

    @Test
    public void testThatItemExistById(){
        items.save(item);
        assertTrue(items.existById(item.getId()));
    }


    @Test
    public void addTwoItems_findAllById_getTwo(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        assertEquals(2,items.findAllById(item.getId(), newItem.getId()).size());
    }

    @Test
    public void addTwoItems_findAll_getTwo(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        assertEquals(2,items.findAll().size());
    }


    @Test
    public void saveTwoItems_getTwo(){
        items.save(item);
        assertEquals(1,items.count());
        Item newItem = new Item();
        items.save(newItem);
        assertEquals(2,items.count());
        assertEquals(2,items.saveAll(item, newItem).size());
    }

    @Test
    public void testThatItemName_description_and_weight_is_updated(){
        items.save(item);
        assertEquals(1,items.count());
        item.setName("Phone");
        item.setDescription("Phone is updated");
        item.setWeightInGrams(100);
        items.update(item);
        assertEquals(1,items.count());
    }



}