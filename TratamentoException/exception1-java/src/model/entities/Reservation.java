package model.entities;

import model.exception.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {


    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Integer room;
    private Date checkIn;
    private Date checkOut;

    public Reservation(Integer room, Date checkIn, Date checkOut) throws DomainException {
        if (checkOut.before(checkIn)) {
            throw new DomainException("Check-out date must be after check-in date.");
        }
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

    public void updateDates(Date checkIn, Date checkOut) throws DomainException{

        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainException( "Error in reservation: Reservate dates for update must be futures dates.");
        }
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
