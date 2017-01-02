package com.project.go;

import java.math.RoundingMode;



/**
 * Created by Joe K. on 11/29/2016.
 */

//*this Class Operators method operate processes the current stock price and 52 week low and calculates the
    //*percent of low.
public class Operators {

    public static void operate(double price, double low, String company){

        double percent = (price/low-1)*100;
        double rpercent = Math.round(percent * 100.0) / 100.0; ///* is this an accurate way to round?
        StringBuilder sb = new StringBuilder(32);

        if(rpercent <= 10) {
           // System.out.println(company + " is trading at:");
            sb.append(company + "\n");
           // System.out.println("the current price is:  " + price);
            sb.append("the current price is:  " + price + "\n");
           // System.out.println("the 52 week low is:  " + low);
            sb.append("the 52 week low is:  " + low +"\n");
           // System.out.println("percent of 52 week low is:  " + rpercent);
            sb.append("percent of 52 week low is:  " + rpercent + "\n");
             PasstoApp.superString(sb.toString());



        }



    }




}
