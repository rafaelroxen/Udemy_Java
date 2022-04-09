package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    private Integer room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Integer room, Date checkIn, Date checkOut) {
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Date getCheckIn() {
        return checkIn;
    }


    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        //O comando getTime() ira puxar em milisegundos
        long diff = checkOut.getTime() - checkIn.getTime();
        //O TimeUnit vai converter em dias
        return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut){
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + room
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                +sdf.format(checkOut)
                +", "
                +duration()
                + " nights.";
    }
}
