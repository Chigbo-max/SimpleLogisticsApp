package data.models;


import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest{
    @Test
    public void testItemsAreCreated(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        Item secondItem = new Item("bag", "to be delivered quick", 2);
        Item thirdItem = new Item("bag", "to be delivered quick", 2);

        assertEquals(thirdItem.getId(), 3);
    }

    @Test
    public void testThatItemNameIsUpdated(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        newItem.setName("second hand bag");
        assertEquals("second hand bag", newItem.getName());
    }

    @Test
    public void testThatItemsAreAddedToTheList(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        newItem.saveItem(newItem);
        assertEquals(newItem.getItemsSize(), 1);
    }

    @Test
    public void testThatItemsCanBeFoundByTheirId(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        newItem.saveItem(newItem);
        assertEquals(newItem.findItemById(newItem.getId()), newItem.getId());
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, ()-> newItem.findItemById(5));
        assertEquals(illegalArgumentException.getMessage(), "Id not found");
    }

    @Test
    public void testThatItemExistById(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        newItem.saveItem(newItem);
        assertTrue(newItem.existById(newItem.getId()));
    }

    @Test
    public void testThatItemsCanBeDeletedByTheirId(){
        Item newItem = new Item("bag", "to be delivered quick", 2);
        newItem.saveItem(newItem);
        assertEquals(newItem.getItemsSize(), 1);
        System.out.println(newItem.getItemsSize());

        newItem.deleteItemById(newItem.getId());
//        assertEquals(newItem.getCount(), 0 );
    }


}