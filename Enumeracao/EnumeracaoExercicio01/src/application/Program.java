package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        //O SimpleDateFormat serve para criar um objeto que aceita tipo data.
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Entre com o nome do departamento: ");
        String departamentName = sc.nextLine();
        System.out.print("Enter the worker name: ");
        String workerName = sc.nextLine();
        System.out.print("Enter the level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),baseSalary,new Departament(departamentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 1; i <=n; i++){

            System.out.println("Enter contract #" + i + " number:");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate,valuePerHour,hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        //Fazer o recorte do String e convertendo para int.
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartament().getName());

        System.out.println("Income for " + monthAndYear + ": " + String.format("%2.f", worker.income(month,year)));


        sc.close();
    }
}
