package data.repositries;

import data.models.TrackingInfo;

import java.util.List;

public interface TrackingInfosRepository {
    long count();
    TrackingInfo save(TrackingInfo trackingInfo);
    TrackingInfo findById(int id);
    void deleteById(int id);
    void deleteAllById(int ...ids);
    void deleteAll();
    boolean existById(int id);
    List<TrackingInfo> findAll();
    List<TrackingInfo> saveAll(TrackingInfo... TrackingInfos);
    List<TrackingInfo> findAllById(int ...ids);
    void deleteAllEntities(TrackingInfo ... trackingInfos);
}
