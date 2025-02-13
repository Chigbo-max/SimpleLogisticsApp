package data.repositries;

import data.models.TrackingInfo;

import java.util.ArrayList;
import java.util.Arrays;

public class TrackingInfos {

    ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();
    private static int counter;

    public int count() {
        return trackingInfos.size();
    }

    public void save(TrackingInfo trackingInfo) {
        trackingInfo.setId(generateId());
        trackingInfo.setItemId(trackingInfo.getItemId());
        trackingInfos.add(trackingInfo);
    }

    public int generateId(){
       return ++counter;
    }

    public TrackingInfo findById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return trackingInfo;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        TrackingInfo trackingInfo = findById(id);
        trackingInfos.remove(trackingInfo);
    }

    public void deleteAllById(int... ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

    public boolean existById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void deleteAll() {
        trackingInfos.clear();
    }

    public ArrayList<TrackingInfo> findAllById(int ... ids) {
        ArrayList<TrackingInfo> foundTrackingInfo = new ArrayList<>();
        for(int id : ids) {
            TrackingInfo trackingInfo = findById(id);
            if (trackingInfo != null) {
                foundTrackingInfo.add(trackingInfo);
            }
        }
       return foundTrackingInfo;
    }

    public ArrayList<TrackingInfo> findAll() {
        return trackingInfos;
    }

    public ArrayList<TrackingInfo> saveAll(TrackingInfo ... trackingInfos) {
        return new ArrayList<>(Arrays.asList(trackingInfos));
    }

    public void deleteAllEntities(TrackingInfo ... trackingInfos) {

        for(TrackingInfo trackingInfo : trackingInfos) {
            deleteById(trackingInfo.getId());
        }
    }

    public void update(TrackingInfo trackingInfo) {
        trackingInfo.setInfo(trackingInfo.getInfo());
        trackingInfo.setTime(trackingInfo.getTime());
    }

    @Override
    public String toString() {
        return "TrackingInfos{" +
                "trackingInfos=" + trackingInfos +
                '}';
    }


}
