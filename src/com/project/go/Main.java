package com.project.go;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class Main {


    public static void main(String[] args)  throws IOException {

	System.out.println("Welcome to Buy Low Sell High (BLSH)");
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println("today's date is: " + df.format(dateobj)); //*pulls up Today's date

        System.out.println("do you want today's report (t)? or enter a date (MM/dd/yy)"); //*asks for report date
        Scanner sc = new Scanner(System.in); //*new scanner
        String d = sc.nextLine();

        if(d.equalsIgnoreCase("t") ) {    //*stores date as a string 'a' for later use
            String a = df.format(dateobj);
        }else {
           String a = d;
        }
        //*The next portion asks for the sector in which you are wanting your report.
        System.out.println("What industry? All (A), Consumer (C), Energy (E) Financial (F), Healthcare (HC) Industrial (I), Tech. (T)");
        String b = sc.nextLine();

        switch (b) {
            case "A":
                System.out.println("Pulling up All");
                HtmlParser.parser("MMM");
                HtmlParser.parser("AXP");
                HtmlParser.parser("AAPL");
                HtmlParser.parser("BA");
                HtmlParser.parser("CAT");
                HtmlParser.parser("CVX");
                HtmlParser.parser("CSCO");
                HtmlParser.parser("KO");
                HtmlParser.parser("DIS");
                HtmlParser.parser("DD");
                HtmlParser.parser("XOM");
                HtmlParser.parser("GE");
                HtmlParser.parser("GS");
                HtmlParser.parser("HD");
                HtmlParser.parser("IBM");
                HtmlParser.parser("INTC");
                HtmlParser.parser("JNJ");
                HtmlParser.parser("JPM");
                HtmlParser.parser("MCD");
                HtmlParser.parser("MRK");
                HtmlParser.parser("MSFT");
                HtmlParser.parser("NKE");
                HtmlParser.parser("PFE");
                HtmlParser.parser("PG");
                HtmlParser.parser("TRV");
                HtmlParser.parser("UTX");
                HtmlParser.parser("UNH");
                HtmlParser.parser("VZ");
                HtmlParser.parser("V");
                HtmlParser.parser("WMT");

                break;
            case "C":
                System.out.println("Pulling up Consumer");
                //*pull up report for date 'a' for sector C
                break;
            case "E":
                System.out.println("Pulling up Energy");
                //*pull up report for date 'a' for sector E
                break;
            case "F":
                System.out.println("Pulling up Financial");
                //*pull up report for date 'a' for sector F
                break;
            case "H":
                System.out.println("Pulling up Health Care");
                //*pull up report for date 'a' for sector HC
                break;
            case "I":
                System.out.println("Pulling up Industrial");
                //*pull up report for date 'a' for sector I
                break;
            case "T":
                System.out.println("Pulling up Tech");
                //*pull up report for date 'a' for sector T
                break;
            default: System.out.println("Invalid input");
                //*this is an error message you get when you input a wrong sector.
                break;
        }


    }

    }

