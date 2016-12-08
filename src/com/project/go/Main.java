package com.project.go;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
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
                String [] sym = Wikiparser.getSymbols();
                for (int i = 1 ; i <506 ; i++){
                    String x = sym[i];
                    HtmlParser.parser(x);
                }

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

