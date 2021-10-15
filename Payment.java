/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Chia Yang Han
 *
 */
public class Payment {

//BA-9999
// half court
//abc
// 09/14/2021 8:10:00
// 09/14/2021 12:34:00
    Scanner scn = new Scanner(System.in);

    private String userPay;
    private double discount;
    private double total;
    private double afterDiscount;
    private String bankName;
    private String cardNum;
    private String holdername;

    double userPayValue;

    private String id;
    private String start;
    private String end;
    private String totalTime;

    public void setId(String id) {
        this.id = id;
    }

    public void setStartTime(String start) {
        this.start = start;
    }

    public void setEndTime(String end) {
        this.end = end;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public Payment() {

    }

    public void total(double total) {
        this.total = total;
    }

    public void design() {
        System.out.println("------------------------------------------");
        System.out.println("*              PAYMENT PAGE              *");
        System.out.println("------------------------------------------");
    }

    //----------------------------------------------------------------------------------------------
    //Let user input Y / N
    public void inputStartUser() {
        char user;
        System.out.println("| If Final Price more than RM 70, will get the 6% discount!! |");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Do you want to continue payment?(Y / N) : ");
        user = scn.next().charAt(0);

        startPay(user);
    }

    //Check Validate. Only can Y / N. If N,go to menu. If Y,go to payment
    public void startPay(char yn) {
        if (yn == 'Y' || yn == 'y') {
            startWork();

        } else if (yn == 'N' || yn == 'n') {
//            res.processReservation();
        } else {
            inputStartUser();
            startPay(yn);
        }
    }

    //if more than 100, get discount
    public void discountPart(double total) {
        if (total >= 70.00) {
            discount = total * (6.00 / 100.00);
            System.out.printf("Congratulation!!! You get the RM%.2f discount \n", discount);
        } else {
            System.out.println("Sorry!!! You can't get the 6% disocunt");
        }
    }

    //And start calculate the total after discount
    public void calculateAfterDiscount() {
        afterDiscount = total - discount;
        System.out.println("This is Final Total    : RM " + afterDiscount);
    }

    //Let user inout Bank Details
    public void bankDetails() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Bank platform   : ");
        bankName = input.nextLine();

        System.out.print("Enter Card Number     : ");
        cardNum = input.nextLine();
        while (!(isValidCard())) {
            System.out.print("Enter Card Number     : ");
            cardNum = input.nextLine();
        }

        System.out.print("Enter Your Name       : ");
        holdername = input.nextLine();
    }

    //Check user input is valid or not, if valid go next step
    public boolean isValidCard() {
        boolean valid;
        Matcher m = Pattern.compile("[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]").matcher(cardNum);
        valid = m.find();

        return valid;
    }

    //Let user input total
    public String inputUser() {
        System.out.print("Enter Your Payment     : RM ");
        userPay = scn.next();
        return userPay;
    }

    //Check User Input
    public boolean checkInput(String str) {
        boolean decimal = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                if (str.charAt(i) == '.') {
                    if (i == 0 || i == str.length() - 1) {  //'.' put at start or end, wrong
                        decimal = false;
                        break;
                    }
                } else {  //no digit, wrong
                    decimal = false;
                    break;
                }
            }
        }

        if (!(str.indexOf('.') == str.lastIndexOf('.'))) {      //got two '.', then wrong
            decimal = false;
        }

        return decimal;
    }

    //Check user input. If smaller, then wrong
    public boolean checkBigger(double user, double total) {
        boolean bigger = true;

        if (!(Double.compare(user, total) >= 0)) {
            bigger = false;
        }

        return bigger;
    }

    //Output invalid message
    public void falseMassege() {
        System.out.println("Can't input smaller amount!!");
    }

    //Output the remainder
    @Override
    public String toString() {
        String design = "                       -------------\n";
        return design + "This is your remainder : RM " + String.format("%.2f", (userPayValue - afterDiscount)) + "\n" + design;
    }

    public void goReceipt() {
        Scanner yesno = new Scanner(System.in);
        System.out.print("Do you want Receipt?(Y / N) : ");
        char yn = yesno.next().charAt(0);

        if (yn == 'Y' || yn == 'y') {
            Receipt rec = new Receipt(total, afterDiscount, discount, (userPayValue - afterDiscount), Double.valueOf(userPay), id, start, end, totalTime);
            rec.startWork();
        } else if (yn == 'N' || yn == 'n') {
//            processReservation();
        } else {
            goReceipt();
        }

    }

    //Start process at here
    public void startWork() {

        discountPart(total);

        System.out.print("\n");
        System.out.println("  Start Input Bank Details ");
        System.out.println("----------------------------");
        bankDetails();

        System.out.print("\n");
        System.out.println("  Please Input Total Amount");
        System.out.println("-----------------------------");

        calculateAfterDiscount();

        inputUser();

        while (!checkInput(userPay)) {
            userPay = inputUser();
        }

        userPayValue = Double.valueOf(userPay);

        if (checkBigger(userPayValue, afterDiscount) == false) {
            userPay = String.valueOf(userPayValue);
        }

        while (!(checkBigger(userPayValue, afterDiscount)) == true) {
            falseMassege();
            userPay = inputUser();
            userPayValue = Double.valueOf(userPay);
        }

        System.out.println(toString());
        System.out.println("Payment Successful !! Thanks for reservation !\n");

        goReceipt();
    }

}
