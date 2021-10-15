/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author Chia Yang Han
 */
public class Receipt {

    private double subTotal;
    private double total;
    private double discount;
    private double remainder;
    private double payment;

    private String id;
    private String start;
    private String end;
    private String totalTime;

    public Receipt() {
    }

    public Receipt(double subTotal, double total, double discount, double remainder, double payment, String id, String start, String end, String totalTime) {
        this.subTotal = subTotal;
        this.total = total;
        this.discount = discount;
        this.remainder = remainder;
        this.payment = payment;
        this.id = id;
        this.start = start;
        this.end = end;
        this.totalTime = totalTime;
    }

    public void design() {
        System.out.println("-----------------------------------------");
        System.out.println("*                Receipt                *");
        System.out.println("-----------------------------------------");
    }

    public void paymentPart() {

        System.out.println("        Court ID      : " + id);
        System.out.println("        Start Time    : " + start);
        System.out.println("        End Time      : " + end);
        System.out.println("        Total Time    : " + totalTime + "\n");

        System.out.println("         Subtotal     :   RM " + subTotal);
        System.out.println("         Discount     : - RM " + discount);
        System.out.println("                     --------------");
        System.out.println("         Total        :   RM " + total + "\n");
        System.out.println("         Payment      :   RM " + payment);
        System.out.println("         Your Change  :   RM " + String.format("%.2f", remainder));
        System.out.println("\n       Thanks you, Come Again!\n       -----------------------\n");

    }

    public void startWork() {
        design();
        paymentPart();
    }

}
