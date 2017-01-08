package com.project.go;

/**
 * Created by Joe K. on 12/2/2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


//*This is a dummy class I used to test functionalities of the Wikipeida parser.
//*
//*

public class WikiparserTestor {

    public static void main(String[] args) throws Exception {
        String dummy = null;
        getDSymbols(); //*calls the method as an object
    }



    public static String[] getDSymbols() throws IOException {

        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_S%26P_500_companies").timeout(10*1000).get(); //*this gets the wiki page for SP500
        Elements rows = doc.select("tr");//*gets the span elements from the website.
        Element row = null;
        String [] symbols = new String[506];


        for(int i=1; i<506; i++ ){
            row = rows.get(i).child(3);
            String x = row.text();
            if (x.equals("Consumer Discretionary")){
                row = rows.get(i).child(0);
                String y =row.text();
                symbols[i] = y ;

            }

        }

        symbols = Arrays.stream(symbols)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        return (symbols);

    }


}














//1. The direct select method:
//*doc.getElementById("quote-market-notice").parent().child(0).text() this code marks out a stable element by id then does a few modifiers to get to the stock price.


//*2. The for loop with if statement
//* This is a for loop that was used to get all the rows from the table but it evolved into just an index
//* for the 52 week range.
//*for(int i =0; i < rows.size();  i++){
//*if(rows.hasClass("Ta(end) Fw(b)")){
//* row = rows.get(13);
//*String info =row.text();
//*System.out.println("52 week Range " + info);

//*3. the enhanced for loop.
//* this code is an enhanced for loop that gets all the values from the table.

//*for(Element rowElement : rows){
//*    if(rowElement.hasClass("Ta(end) Fw(b)")){
//*      row = rowElement;
//*     String info =row.text();
//*     System.out.println("ROWS: " + info);






//*copied stack overflow an iterator not sure what it does.

//*Iterator<Element> ite = table.select("<tr>").iterator();

//*System.out.println("Value 1: " + ite.next().text());
//*System.out.println("Value 2: " + ite.next().text());
//*System.out.println("Value 3: " + ite.next().text());
//*System.out.println("Value 4: " + ite.next().text());

//*copied from stack over flow and it is the opriginal code i was working with turned out it doesn't work since jsoup hates
//* classes with the % sign.
//*Elements table = doc.select("table.W(100%)");
//*Element row = table.select("tr").get(5);

//*final String number = row.select("td").text();
//*System.out.println(number);