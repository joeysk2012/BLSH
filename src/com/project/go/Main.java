package com.project.go;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import static com.project.go.Wikiparser.*;


public class Main {


    public static void main()  throws IOException {

	System.out.println("Welcome to Buy Low Sell High (BLSH)");
        DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
        Date dateobj = new Date();
        System.out.println("today's date is: " + df.format(dateobj)); //*pulls up Today's date

        System.out.println("Pulling up today's information press enter."); //*asks for report date
        Scanner sc = new Scanner(System.in); //*new scanner
        String d = sc.nextLine();


        //*The next portion asks for the sector in which you are wanting your report.
        System.out.println("What industry? All (A), Consumer Discretionary (D) Consumer Staples (S), Energy (E)");
        System.out.println("Financial (F), Healthcare (H) Industrial (I), Real Estate (R) Info. Tech. (T), Utilities (U)");
        String b = sc.nextLine();

        switch (b) {
            case "A":
                System.out.println("Pulling up All");
                //pulls up all
                String [] sym = Wikiparser.getAllSymbols();
                for (int i = 1 ; i <506 ; i++){
                    String x = sym[i];
                    HtmlParser.parser(x);
                }


                break;
            case "D":
                System.out.println("Pulling up Consumer Disc.");
                String [] sym1 = getDSymbols();
                for (int i = 1 ; i < getDSymbols().length ; i++){
                    String x = sym1[i];
                    HtmlParser.parser(x);
                }

                break;
            case "S":
                System.out.println("Pulling up Consumer Staples");
                String [] sym2 = getSSymbols();
                for (int i = 1 ; i < getSSymbols().length ; i++){
                    String x = sym2[i];
                    HtmlParser.parser(x);
                }
                break;
            case "E":
                System.out.println("Pulling up Energy");
                String [] sym3 = getESymbols();
                for (int i = 1 ; i < getESymbols().length ; i++){
                    String x = sym3[i];
                    HtmlParser.parser(x);
                }
                break;
            case "F":
                System.out.println("Pulling up Financial");
                String [] sym4 = getFSymbols();
                for (int i = 1 ; i < getFSymbols().length ; i++){
                    String x = sym4[i];
                    HtmlParser.parser(x);
                }
                break;
            case "H":
                System.out.println("Pulling up Health Care");
                String [] sym5 = getHSymbols();
                for (int i = 1 ; i < getHSymbols().length ; i++){
                    String x = sym5[i];
                    HtmlParser.parser(x);
                }
                break;
            case "I":
                System.out.println("Pulling up Industrial");
                String [] sym6 = getISymbols();
                for (int i = 1 ; i < getISymbols().length ; i++){
                    String x = sym6[i];
                    HtmlParser.parser(x);
                }
                break;
            case "R":
                System.out.println("Pulling up Real Estate");
                String [] sym7 = getRSymbols();
                for (int i = 1 ; i < getRSymbols().length ; i++){
                    String x = sym7[i];
                    HtmlParser.parser(x);
                }
                break;
            case "T":
                System.out.println("Pulling up Information Technology");
                String [] sym8 = getTSymbols();
                for (int i = 1 ; i < getTSymbols().length ; i++){
                    String x = sym8[i];
                    HtmlParser.parser(x);
                }
                System.out.println(PasstoApp.ssb);

                break;
            case "U":
                System.out.println("Pulling up Utilities");
                String [] sym9 = getUSymbols();
                for (int i = 1 ; i < getUSymbols().length ; i++){
                    String x = sym9[i];
                    HtmlParser.parser(x);
                }
                break;
            default: System.out.println("not a valid sector");
                //*this is an error message you get when you input a wrong sector.
                break;
        }


    }

    }

