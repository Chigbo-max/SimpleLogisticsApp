package data.repositries;

import data.models.TrackingInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class TrackingInfos implements TrackingInfosRepository{

    ArrayList<TrackingInfo> trackingInfos = new ArrayList<>();
    private static int counter;

    @Override
    public long count() {
        return trackingInfos.size();
    }

    @Override
    public TrackingInfo save(TrackingInfo trackingInfo) {
        if(isSave(trackingInfo))saveNew(trackingInfo);
        else replace(trackingInfo);
        return trackingInfo;
    }

    private int generateId(){
       return ++counter;
    }

    @Override
    public TrackingInfo findById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return trackingInfo;
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        TrackingInfo trackingInfo = findById(id);
        trackingInfos.remove(trackingInfo);
    }

    @Override
    public void deleteAllById(int... ids) {
        for (int id : ids) {
            deleteById(id);
        }
    }

    @Override
    public void deleteAll() {
        trackingInfos.clear();
    }
    @Override
    public boolean existById(int id) {
        for (TrackingInfo trackingInfo : trackingInfos) {
            if (trackingInfo.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ArrayList<TrackingInfo> findAll() {
        return trackingInfos;
    }

    @Override
    public ArrayList<TrackingInfo> saveAll(TrackingInfo ... trackingInfos) {
        return new ArrayList<>(Arrays.asList(trackingInfos));
    }

    @Override
    public ArrayList<TrackingInfo> findAllById(int ... ids) {
        return getTrackingInfos(ids);
    }

    @Override
    public void deleteAllEntities(TrackingInfo ... trackingInfos) {

        for(TrackingInfo trackingInfo : trackingInfos) {
            deleteById(trackingInfo.getId());
        }
    }



    private void replace(TrackingInfo trackingInfo) {
        findById(trackingInfo.getId());
        deleteById(trackingInfo.getId());
        trackingInfos.add(trackingInfo);
    }

    private boolean isSave(TrackingInfo trackingInfo) {
        return trackingInfo.getId() == 0;
    }

    private void saveNew(TrackingInfo trackingInfo) {
        trackingInfo.setId(generateId());
        trackingInfo.setItemId(trackingInfo.getItemId());
        trackingInfos.add(trackingInfo);
    }

    private ArrayList<TrackingInfo> getTrackingInfos(int[] ids) {
        ArrayList<TrackingInfo> foundTrackingInfo = new ArrayList<>();
        for(int id : ids) {
            TrackingInfo trackingInfo = findById(id);
            if (trackingInfo != null) {
                foundTrackingInfo.add(trackingInfo);
            }
        }
        return foundTrackingInfo;
    }

    @Override
    public String toString() {
        return "TrackingInfos{" +
                "trackingInfos=" + trackingInfos +
                '}';
    }


}
