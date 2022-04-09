package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.print("Room nunber: ");
        int room = sc.nextInt();
        System.out.print("Check-in date (dd/mm/yyyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-out date (dd/mm/yyyy): ");
        Date checkOut = sdf.parse(sc.next());

        //Método dizendo se a data do checkOut for maior do checkIn
        if (!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservation reservation = new Reservation(room,checkIn,checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println("Enter the date for update the reserve:");
            System.out.println();
            System.out.println("Enter the data of reservation: ");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            Date now = new Date();

            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation: Reservate dates for update must be futures dates.");
            } else if (checkOut.before(checkIn)) {
                System.out.println("Check-out date must be after check-in date.");
            } else {
                reservation.updateDates(checkIn,checkOut);
                System.out.println("Reservation: " + reservation);
            }

        }


        sc.close();
    }
}
