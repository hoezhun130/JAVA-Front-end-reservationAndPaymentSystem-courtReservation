/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Date;

/**
 *
 * @author HoeZhun
 */
public class Tennis extends Court {

    private String courtType;

    public String getCourtType() {
        return courtType;
    }

    public void setCourtType(String courtType) {
        this.courtType = courtType;
    }

    public Tennis() {
        super();
    }

    public Tennis(String courtType, String courtId, String place, Date startTime, Date endTime) {
        super(courtId, place, startTime, endTime);
        this.courtType = courtType;
    }

    public Tennis(String courtType) {
        this.courtType = courtType;
    }

    @Override
    public String toString() {
        DateTimeConfig dtc = new DateTimeConfig();
        String endtime = null;

        if (endTime != null) {
            endtime = dtc.getFormattedDateTime(endTime, "MM/dd/yyyy HH:mm:ss");
        }
        return "Tennis" + "," + " Court Type= " + courtType + "," + " Court ID= " + courtId + "," + " Place= " + place
                + "," + " Start Time= " + dtc.getFormattedDateTime(startTime, "MM/dd/yyyy HH:mm:ss") + ","
                + " End Time= " + endTime;
    }

    @Override
    String getCategory() {
        return "Tennis";
    }

}
