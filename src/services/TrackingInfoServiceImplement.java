package services;

import data.models.Item;
import data.models.TrackingInfo;
import data.repositries.TrackingInfos;
import data.repositries.TrackingInfosRepository;

import java.time.LocalDateTime;

public class TrackingInfoServiceImplement implements TrackingInfoService {
    TrackingInfosRepository trackingInfos;

    public TrackingInfoServiceImplement(TrackingInfosRepository trackingInfos) {
        this.trackingInfos = trackingInfos;
    }

    @Override
    public TrackingInfo createNewTrackingInfo(Item item) {
        TrackingInfo trackingInfo = new TrackingInfo();
        trackingInfo.setItemId(item.getId());
        trackingInfo.setInfo(item.getDescription());
        trackingInfos.save(trackingInfo);
        return trackingInfo;
    }

    @Override
    public long getNumberOfTrackingInfo(){
        return trackingInfos.count();
    }

    @Override
    public boolean existById(int id) {
        if(!trackingInfos.existById(id)){
            throw new IllegalArgumentException("Tracking info id does not exist");
        }
        return true;
    }

    @Override
    public void deleteById(int id) {
        if(!trackingInfos.existById(id)){
            throw new IllegalArgumentException("Tracking info id does not exist");
        }
        trackingInfos.deleteById(id);
    }

    @Override
    public void deleteAll() {
        trackingInfos.deleteAll();
    }
}
