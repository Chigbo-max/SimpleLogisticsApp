package services;

import data.models.Item;
import data.repositries.Items;
import data.repositries.ItemsRepository;
import data.repositries.TrackingInfos;
import data.repositries.TrackingInfosRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemServiceImplementTest {

    ItemService itemService;
    TrackingInfosRepository trackingInfos;
    ItemsRepository itemsRepository;
    TrackingInfoService trackingInfoService;
    @Before
    public void setUp()  {
        trackingInfos = new TrackingInfos();
        itemsRepository = new Items();
        trackingInfoService = new TrackingInfoServiceImplement(trackingInfos);
        itemService = new ItemServiceImplement(itemsRepository,trackingInfoService);

    }

    @Test
    public void createAPackage_getTheCountOfOne(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(1, itemService.getNumberOfPackages());
    }

    @Test
    public void createAPackage_getTheItemId(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertTrue(itemService.existById(savedItem.getId()));
    }

    @Test
    public void createAPackage_getTheTrackingInfo(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(200, savedItem.getWeightInGrams());
        assertEquals(1, trackingInfos.count());
    }

    @Test
    public void createAPackage_deleteById_getZero_test(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(200, savedItem.getWeightInGrams());
        assertEquals(1, itemService.getNumberOfPackages());
        assertEquals(1, trackingInfos.count());
        itemService.deleteById(savedItem.getId());
        assertEquals(0, itemService.getNumberOfPackages());
        assertEquals(0, trackingInfos.count());
    }

    @Test
    public void test_that_exception_is_throw_if_id_does_not_exist(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(200, savedItem.getWeightInGrams());
        assertEquals(1, itemService.getNumberOfPackages());
        assertEquals(1, trackingInfos.count());
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,()->itemService.deleteById(2));
        assertEquals(illegalArgumentException.getMessage(),"Item id does not exist");
    }

    @Test
    public void createTwoPackages_deleteAll_getZero_test(){
        Item savedItem = itemService.createNewPackage("Bag of rice", 200);
        assertEquals(200, savedItem.getWeightInGrams());
        assertEquals(1, itemService.getNumberOfPackages());
        assertEquals(1, trackingInfos.count());

        Item savedItem2 = itemService.createNewPackage("Bowl of eba", 500);
        assertEquals(500, savedItem2.getWeightInGrams());
        assertEquals(2, itemService.getNumberOfPackages());
        assertEquals(2, trackingInfos.count());

        itemService.deleteAll();
        assertEquals(0, itemService.getNumberOfPackages());
    }


}