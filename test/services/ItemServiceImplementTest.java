package services;

import data.models.Item;
import data.repositries.Items;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemServiceImplementTest {

    ItemService itemService;

    @Before
    public void setUp()  {
        itemService = new ItemServiceImplement();
    }

    @Test
    public void createAPackage_getTheCountOfOne(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(1, itemService.numberOfPackages());
    }

}