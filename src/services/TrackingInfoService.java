package services;

import data.models.Item;
import data.models.TrackingInfo;


public interface TrackingInfoService {
    TrackingInfo createNewTrackingInfo(Item iem);

    long getNumberOfTrackingInfo();

    boolean existById(int id);

    void deleteById(int id);

    void deleteAll();
}
