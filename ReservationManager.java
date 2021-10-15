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
public interface ReservationManager {

    public abstract void addCourt(Court c);

    public abstract boolean processReservation();
    
    public abstract Court deleteCourt(String courtId, Date startTime);
}
