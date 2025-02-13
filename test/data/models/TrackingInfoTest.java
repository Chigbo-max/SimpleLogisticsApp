package data.models;


import data.repositries.TrackingInfos;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TrackingInfoTest{

    TrackingInfo trackingInfo;
    TrackingInfos trackingInfos;

    @Before
    public void setUp() {
        trackingInfo = new TrackingInfo();
        trackingInfo.setInfo("customer requests goods be sent to Lagos");
        trackingInfo.setTime(LocalDateTime.now());
        trackingInfos = new TrackingInfos();
    }



    @Test
    public void testThatTrackingInfoListIsEmpty_getZero(){
        assertEquals(0,trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfoListIsNotEmpty_getOne(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
    }

    @Test
    public void testThatTwoItemsAreSaved_DeleteOneById_GetOne(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteById(newTrackingInfo.getId());
        assertEquals(1,trackingInfos.count());
    }

    @Test
    public void deleteAllById_getZero(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteAllById(trackingInfo.getId(), newTrackingInfo.getId());
        assertEquals(0,trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfoExistById(){
        trackingInfos.save(trackingInfo);
        assertTrue(trackingInfos.existById(trackingInfo.getId()));
    }

    @Test
    public void deleteAll_getZero(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteAll();
        assertEquals(0,trackingInfos.count());
    }

    @Test
    public void saveTwoTackingInfos_findAllById_getTwo(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        assertEquals(2, trackingInfos.findAllById(trackingInfo.getId(), newTrackingInfo.getId()).size());
    }

    @Test
    public void saveTwoTrackingInfos_findAll_getTwo(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        assertEquals(2, trackingInfos.findAll().size());
    }

    @Test
    public void saveAllTrackingInfos_getTwo(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        assertEquals(2, trackingInfos.saveAll(trackingInfo, newTrackingInfo).size());
    }

    @Test
    public void saveTwoTrackingInfos_deleteAllEntities_getZero(){
        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        TrackingInfo newTrackingInfo = new TrackingInfo();
        trackingInfos.save(newTrackingInfo);
        assertEquals(2,trackingInfos.count());
        trackingInfos.deleteAllEntities(trackingInfo, newTrackingInfo);
        assertEquals(0,trackingInfos.count());
    }

    @Test
    public void testThatTrackingInfoIsUpdated(){

        trackingInfos.save(trackingInfo);
        assertEquals(1,trackingInfos.count());
        trackingInfo.setInfo("customer requests goods be re-routed to Abuja");
        trackingInfo.setTime(LocalDateTime.now());
        trackingInfos.update(trackingInfo);
        assertEquals(1,trackingInfos.count());
        System.out.println(trackingInfos);
    }




}