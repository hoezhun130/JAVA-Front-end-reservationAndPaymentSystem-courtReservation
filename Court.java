/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author HoeZhun
 */
import java.util.Date;

public abstract class Court {

    protected String courtId;
    protected String place;
    protected Date startTime;
    protected Date endTime;
    
    abstract String getCategory();

    public Court() {
        super();
    }

    public Court(String courtId, String place, Date startTime, Date endTime) {
        this.courtId = courtId;
        this.place = place;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    


    public String getCourtId() {
        return courtId;
    }


    public String getPlace() {
        return place;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }


    public void setPlace(String place) {
        this.place = place;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Court[category=" + courtId + ", place=" + place + ", startTime=" + startTime + ", endTime=" + endTime + "]";
    }
    
    
}
