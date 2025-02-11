package data.models;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;

public class TrackingInfoTest{



    @Test
    public void testTrackingInfoIdIsCreated(){
       TrackingInfo trackingInfo = new TrackingInfo("DELIVERY STARTS BY MORNING");
       TrackingInfo trackingInfo2 = new TrackingInfo("Delivery starts by noon");
        assertEquals(trackingInfo2.getId(), 2);

    }




}