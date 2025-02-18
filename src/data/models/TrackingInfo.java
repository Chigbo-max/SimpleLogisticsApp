package data.models;

import java.time.LocalDateTime;

public class TrackingInfo {

    private int id;
    private int itemId;
    private String info;
    LocalDateTime time = LocalDateTime.now();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "TrackingInfo{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", info='" + info + '\'' +
                ", time=" + time +
                '}';
    }
}
