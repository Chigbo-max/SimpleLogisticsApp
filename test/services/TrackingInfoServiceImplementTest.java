package services;

import data.models.Item;
import data.models.TrackingInfo;
import data.repositries.TrackingInfos;
import data.repositries.TrackingInfosRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class TrackingInfoServiceImplementTest {

    TrackingInfoService trackingInfoService;
    TrackingInfosRepository trackingInfos;
    Item item;

    @Before
    public void setUp(){
        trackingInfos = new TrackingInfos();
        trackingInfoService = new TrackingInfoServiceImplement(trackingInfos);
        item = new Item();
    }

    @Test
    public void createATrackingInfo_getTheCountOfOne(){
        TrackingInfo newTrackingInfo = trackingInfoService.createNewTrackingInfo(item);
        assertEquals(1, trackingInfoService.getNumberOfTrackingInfo());
    }

    @Test
    public void createATrackingInfo_getTheTrackingInfoId(){
        TrackingInfo newTrackingInfo= trackingInfoService.createNewTrackingInfo(item);
        assertTrue(trackingInfoService.existById(newTrackingInfo.getId()));
    }

    @Test
    public void createATrackingInfo_deleteById_getZero_test(){
        TrackingInfo newTrackingInfo= trackingInfoService.createNewTrackingInfo(item);
        assertEquals(1, trackingInfoService.getNumberOfTrackingInfo());
        assertTrue(trackingInfoService.existById(newTrackingInfo.getId()));
        assertEquals(1, trackingInfos.count());
        trackingInfoService.deleteById(newTrackingInfo.getId());
        assertEquals(0, trackingInfoService.getNumberOfTrackingInfo());
    }

    @Test
    public void test_that_exception_is_throw_if_id_does_not_exist(){
        TrackingInfo newTrackingInfo= trackingInfoService.createNewTrackingInfo(item);
        assertEquals(1, trackingInfoService.getNumberOfTrackingInfo());
        assertTrue(trackingInfoService.existById(newTrackingInfo.getId()));
        assertEquals(1, trackingInfos.count());
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,()->trackingInfoService.deleteById(2));
        assertEquals(illegalArgumentException.getMessage(),"Tracking info id does not exist");
    }

    @Test
    public void createTwoTrackingInfo_deleteAll_getZero_test(){
        TrackingInfo newTrackingInfo= trackingInfoService.createNewTrackingInfo(item);
        assertEquals(1, trackingInfoService.getNumberOfTrackingInfo());
        assertTrue(trackingInfoService.existById(newTrackingInfo.getId()));
        assertEquals(1, trackingInfos.count());

        TrackingInfo newTrackingInfo2= trackingInfoService.createNewTrackingInfo(item);
        assertEquals(2, trackingInfoService.getNumberOfTrackingInfo());
        assertTrue(trackingInfoService.existById(newTrackingInfo2.getId()));
        assertEquals(2, trackingInfos.count());

        trackingInfoService.deleteAll();
        assertEquals(0, trackingInfoService.getNumberOfTrackingInfo());
    }





}