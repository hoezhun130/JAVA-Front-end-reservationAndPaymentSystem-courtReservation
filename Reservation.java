/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author HoeZhun
 */
public class Reservation implements ReservationManager {

    private ArrayList<Court> courtList;

    private int reservationLots;

    //-------------------------
    Payment pay = new Payment();
    Receipt rec = new Receipt();

    public Reservation() {

    }
    //-----------------------------

    public Reservation(int ListLength) {
        this.reservationLots = ListLength;
        courtList = new ArrayList<Court>();
    }

    public void addCourt(Court c) {
        courtList.add(c);
    }

    public boolean processReservation() {
        boolean exit = false;
        Scanner scn = new Scanner(System.in);
        System.out.println("\n\n\n");
        System.out.println("******** Welcome To the TARUC Sport Court Reservation System ********");
        System.out.println("1-Reserve court\n" + "2-Reservation List\n" + "3-Delete Reservation\n" + "4-Payment\n" + "5-Exit\n");
        System.out.println("Please Enter a number:");
        int choice = scn.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1-Basketball");
                System.out.println("2-Football");
                System.out.println("3-Tennis");
                System.out.println("Select a category:");
                int choice1 = scn.nextInt();

                int personAmount = 0;
                System.out.println("Please enter person amount");
                personAmount = scn.nextInt();
                while (personAmount > 20) { //validating number of person
                    System.out.println("Too many person.Please Reduce and Try again:");
                    personAmount = scn.nextInt();
                }

                switch (choice1) {
                    case 1:
                        System.out.println("Court ID");
                        System.out.println("--------");
                        System.out.println("Basketball = BA-9999");
                        System.out.println("*9999 = any numbers");
                        System.out.println("Enter Court ID:");
                        scn.nextLine();
                        String courtId = scn.nextLine();

                        while (!idValidation(courtId)) { //id validation
                            courtId = scn.next();
                        }

                        String courtType;
                        System.out.println("Enter court type(half court/full court):");
                        courtType = scn.nextLine();

                        System.out.println("Enter place:");
                        String place = scn.nextLine();

                        System.out.println("Enter start Date and Time (MM/dd/yyyy HH:mm:ss): ");
                        String startTime = scn.nextLine();

                        pay.setStartTime(startTime);  //Get start into payment

                        DateTimeConfig dtc = new DateTimeConfig();
                        startTime = dtc.DateValidate(startTime, scn);//validating the date
                        startTime = dtc.TimeValidate(startTime, scn);//validating time
                        Date startTime1 = dtc.stringtoDate(startTime, "MM/dd/yyyy HH:mm:ss");

                        Court c = new Basketball(courtType, courtId, place, startTime1, null);
                        this.addCourt(c);
                        System.out.println("\nReservation Confirmation:");
                        System.out.println(c.toString());
                        System.out.printf("\n\n");
                        break;

                    case 2:
                        System.out.println("Court ID");
                        System.out.println("--------");
                        System.out.println("Football = FO-9999");
                        System.out.println("*9999 = any numbers");
                        System.out.println("Enter Court ID:");
                        scn.nextLine();
                        courtId = scn.nextLine();

                        while (!idValidation(courtId)) { //id validation
                            courtId = scn.next();
                        }

                        System.out.println("Enter court type(half court/full court):");
                        courtType = scn.nextLine();

                        System.out.println("Enter place:");
                        place = scn.nextLine();

                        System.out.println("Enter start Date and Time (MM/dd/yyyy HH:mm:ss): ");
                        startTime = scn.nextLine();

                        pay.setStartTime(startTime);  //Get start into payment

                        dtc = new DateTimeConfig();
                        startTime = dtc.DateValidate(startTime, scn);//validating the date
                        startTime = dtc.TimeValidate(startTime, scn);//validating time
                        startTime1 = dtc.stringtoDate(startTime, "MM/dd/yyyy HH:mm:ss");

                        c = new Football(courtType, courtId, place, startTime1, null);
                        this.addCourt(c);
                        System.out.println("\nReservation Confirmation:");
                        System.out.println(c.toString());
                        System.out.printf("\n\n");
                        break;

                    case 3:
                        System.out.println("Court ID");
                        System.out.println("--------");
                        System.out.println("Tennis = TE-9999");
                        System.out.println("*9999 = any numbers");
                        System.out.println("Enter Court ID:");
                        scn.nextLine();
                        courtId = scn.nextLine();

                        while (!idValidation(courtId)) { //id validation
                            courtId = scn.next();
                        }

                        System.out.println("Enter court type(half court/full court):");
                        courtType = scn.nextLine();

                        System.out.println("Enter place:");
                        place = scn.nextLine();

                        System.out.println("Enter start Date and Time (MM/dd/yyyy HH:mm:ss): ");
                        startTime = scn.nextLine();

                        pay.setStartTime(startTime);  //Get start into payment

                        dtc = new DateTimeConfig();
                        startTime = dtc.DateValidate(startTime, scn);//validating the date
                        startTime = dtc.TimeValidate(startTime, scn);//validating time
                        startTime1 = dtc.stringtoDate(startTime, "MM/dd/yyyy HH:mm:ss");

                        c = new Tennis(courtType, courtId, place, startTime1, null);    
                        this.addCourt(c);
                        System.out.println("\nReservation Confirmation:");
                        System.out.println(c.toString());
                        System.out.printf("\n\n");
                        break;
                }
                break;

            case 2:
                System.out.println("Reserved Court:");
                if (courtList.size() > 0) {
                    for (int i = 0; i < courtList.size(); i++) {
                        System.out.println(courtList.get(i).toString());
                        System.out.printf("\n\n");
                    }
                } else {
                    System.out.println("no court added,try again!!");
                    System.out.printf("\n\n");
                }
                break;

            case 3:
                if (courtList.size() > 0) {
                    scn.nextLine();
                    System.out.println("Enter court ID:");
                    String courtId = scn.nextLine();
                    System.out.println("Enter the start date & time(MM/dd/yyyy HH:mm:ss):");
                    String startT = scn.nextLine();

                    DateTimeConfig dtc2 = new DateTimeConfig();
                    Date startTm = dtc2.stringtoDate(startT, "MM/dd/yyyy HH:mm:ss");
                    Court c = deleteCourt(courtId.trim(), startTm);

                    System.out.println("Deleted Court is: " + c.toString());
                    System.out.printf("\n\n");
                } else {
                    System.out.println("No court added, try again!!");
                    System.out.printf("\n\n");
                }
                break;

            case 4:
                if (courtList.size() > 0) {
                    pay.design();
                    scn.nextLine();
                    System.out.println("Enter court ID:");
                    String courtId1 = scn.nextLine();
                    System.out.println("Enter the end date & time(MM/dd/yyyy HH:mm:ss):");
                    String endT1 = scn.nextLine();
                    DateTimeConfig dtc3 = new DateTimeConfig();
                    Date endTm1 = dtc3.stringtoDate(endT1, "MM/dd/yyyy HH:mm:ss");

                    displayCharges(courtId1, endTm1);

                    pay.setEndTime(endT1);

                    pay.setId(courtId1);

                    pay.inputStartUser();
                    
                    choose();

                } else {
                    System.out.println("No court added, try again!!");
                    System.out.printf("\n\n");
                }
                break;
            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Input! Try Again");
                System.out.printf("\n\n");
                break;
        }
        return exit;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String username;
        String password;
        String comfirmpass;

        System.out.println("      =============================");
        System.out.println("           SELECT YOUR OPTION           ");
        System.out.println("      =============================");
        System.out.println("         1 LogIn       2 Register");
        System.out.print("Your Selection is :");
        int selection = scn.nextInt();
        //////////////////////////////////////////users
        if (selection == 1) {
            System.out.print("\n");
            System.out.println("Welcome  Back ");
            System.out.println("-----------------------");
            System.out.print("      Please Enter your User ID (99ABC99999):");
            username = scn.next();
            System.out.print("      Please Enter your User password (ABC1234):");
            password = scn.next();
            System.out.print("\n\n");
            User users = new User(username, password);

            //////////////////////////////////////////////////////////////////////////////User ID///////////////////////////////////////////////////
            boolean validID = users.validateID(username);
            if (validID) {
                System.out.printf("%27s\n", "Valid User ID Format");
            } else {
                System.out.printf("%27s\n", "Invalid USer  ID Format !!");
                System.out.print("      Please Enter Again your User ID :");
                username = scn.next();
            }
            ////////////////////////////////////////////////////////////////////////////////User Password/////////////////////////////////////////////  
            boolean validPS = users.validatepass(password);
            if (validPS) {
                System.out.printf("%28s\n", "Valid Password Format");
            } else {
                System.out.println("Invalid Password Format !!");
                System.out.println("Password should lenght than 7 !!");
                System.out.println("Password must include Characters and Digits !! ");
                System.out.print("      Please Enter Again your User password :");
            password=scn.next();
            }
        } ///////////////////////////////////////////Member//////////
        else if (selection == 2) {
            int i;
            System.out.print("\n");
            System.out.println("Sign Up A new Member");
            System.out.println("-----------------------------");

            scn.nextLine();
            System.out.println("Please Fill-in your personal Information");
            System.out.print("      Enter your Full Name :");
            String MemberName = scn.nextLine();
            System.out.print("      Enter your Nric (000000-00-0000) :");
            String Nric = scn.next();
            scn.nextLine();
            System.out.print("      Enter your Gender (F/M)  :");
            String Gender = scn.next();
            System.out.print("      Enter your Email :");
            String Email = scn.next();
            System.out.print("      Enter your Home Address :");
            String Address = scn.next();

            System.out.println("\n");
            System.out.println("CREATE A NEW USER ID AND PASSWORD");
            scn.nextLine();
            System.out.print("      Enter your User Id (99ABC99999):");
            username = scn.next();
            System.out.print("      Enter your New User password (ABC1234):");
            password = scn.next();
            System.out.print("      Enter your comfirm  password (ABC1234):");
            comfirmpass = scn.next();

            Member members = new Member(MemberName, Nric, Gender, Email, Address, username, password);
            System.out.print("\n");
            System.out.println("Validation Check");
            System.out.println("-----------------------------");
            /////////////////////////////////////////////////////////////Password/////////////////////////////////////////////
            members.stringCompare(password, comfirmpass);
            System.out.println("Correct Password");
            ///////////////////////////////////////////////////////////NRIC/////////////////////////////////////////////////////////
            boolean validenric = members.validatemembernric(Nric);
            if (validenric == true) {
                System.out.println("Nric Format Correct");
            } else {
                System.out.println("Invalid Nric Format");
            }
            ////////////////////////////////////////////////////////////Gender////////////////////////////////////////////////////////

            ////////////////////////////////////////////////////////////Email check/////////////////////////////////////////////////
            boolean validemail = members.validatememberemail(Email);
            if (validemail == true) {
                System.out.println("Email Format Correct");
            } else {
                System.out.println("Invalid Email Format");
            }

            //////////////////////////////////////////////////////OUTPUT////////////////////////////////////////////////////
            System.out.println("\n");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println("Mr/Mrs: " + members.getMemberName() + " ! Your Account has been registered successful");
            System.out.println("Period Time: " + dtf.format(now));

        } else {
            System.out.println("No valid input!!");
        }

        ReservationManager manager = new Reservation(20);
        boolean exit = false;

        while (!exit) {
            exit = manager.processReservation();
        }
    }

    public static boolean idValidation(String id) {

        boolean isValid = false;

        Matcher m = Pattern.compile("[A-Z][A-Z]-[0-9][0-9][0-9][0-9]").matcher(id);
        if (m.find()) {
            isValid = true;
        } else {
            System.out.print(id + " is not a valid court ID.Try again: ");

        }

        return isValid;
    }

    public Court deleteCourt(String courtId, Date startTime) {// delete a vehicle
        Court c = null;

        for (int i = 0; i < courtList.size(); i++) {
            if (courtList.get(i).getCourtId().trim().equalsIgnoreCase(courtId)) {
                c = courtList.get(i);
                c.setStartTime(startTime);
                courtList.remove(i);
                break;
            }
        }

        System.out.println("Deleted Court Type: " + c.getCategory());
        return c;
    }

    public void displayCharges(String courtId, Date exitTime) {
        Scanner scn = new Scanner(System.in);
        Date inT = null;

        for (int i = 0; i < courtList.size(); i++) {
            if (courtList.get(i).getCourtId().trim().equalsIgnoreCase(courtId)) {
                inT = courtList.get(i).getStartTime();
                break;
            }
        }

        System.out.println("\n");
        System.out.println("This is your total times : ");
        DateTimeConfig dtc = new DateTimeConfig();
        String timediff = dtc.getTimeDifference(inT, exitTime);
        pay.setTotalTime(timediff);

        String timediffdays = timediff.split(",")[0].split("-")[1].trim();
        String timediffhrs = timediff.split(",")[1].split("-")[1].trim();
        String timediffmins = timediff.split(",")[2].split("-")[1].trim();
        int numdays = Integer.parseInt(timediffdays);
        int numhrs = Integer.parseInt(timediffhrs);
        int nummins = Integer.parseInt(timediffmins);

        double valueph = 10.0, valuehph = 6.0, max24h = 300.0, totVal = 0.0;
        double left = 0.0;

        if (numhrs == 0 && nummins > 0) {
            totVal = valueph;
        }
        if (numhrs > 0 && numhrs <= 3) {
            totVal += (valueph * numhrs);
        }
        if (nummins > 0) {
            totVal += 3;
        }
        if (numhrs > 3 && numhrs < 24) {
            totVal += (3 * 3);
            totVal = totVal + (valuehph * numhrs);
        }
        if (numdays > 0) {
            totVal += (max24h * numdays);
        }
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("  Court ID Is: " + courtId + "   |        |    Final Price Is: RM" + totVal);
        System.out.println("---------------------------------------------------------------");

        pay.total(totVal);
    }
    
    public void choose() {
        Scanner scn = new Scanner(System.in);
        System.out.println(" 1. Back To Menu\n 2. Exit");
        System.out.print(" Enter Your Chosen : ");
        int choose = scn.nextInt();
        if (choose == 1) {
            processReservation();
        } else if (choose == 2) {
            System.exit(0);
        } else {
            choose();
        }
    }
}
