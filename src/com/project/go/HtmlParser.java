package com.project.go;

/**
 * Created by Joe K. on 11/24/2016.
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
//*the class HtmlParser and method parser builds a url out of a string input from the Main and goes to
//*yahoo and pulls up the current price, 52 week low and feeds it to the Operators.operate
//* for further processing.

public class HtmlParser {

    public static void main(String[] args) throws Exception {
        String trcker = null; //*dummy variable
        parser(trcker); //*calls the method as an object
    }

        public static void parser(String tracker) throws IOException {
        String info = "";
        String baseUrl = "http://finance.yahoo.com/quote/";
        String postfix =  "?ltr=1";
        String url = baseUrl + tracker + postfix;  //*concatinates the url
        Document doc = Jsoup.connect(url).timeout(10*1000).get(); //*this gets the yahoo finance page for Apple


        Elements div = doc.select("div [class = D(ib) Fw(200) Mend(20px)]"); //*selects a stable div who is a parent of the span w/current price.
        Elements rows = doc.select("td");//*gets the td element from the website.
        Element row = null;
        String sprice = ""; //*sprice or string price is the current price in string form that needs to be converted
        String slow = ""; //* slow or string low is the range of the 52 week low (i.e. 45.11-56.45) that needs to be truncated and converted to a number
        double price= 0;
        Elements name = doc.select("div [class = D(ib) ]");
        String company ="";
        int numtries = 5;



        while(numtries-- !=0)
       try {
           company = name.first().text();

           sprice = div.select("span").first().text();//*this code gets the current price on yahoo.com

        if(rows.hasClass("Ta(end) Fw(b)")){//*this code gets the 52 week range on yahoo.com
            row = rows.get(13);
            slow =row.text();

        }

           price = Double.parseDouble(sprice); //*this code converts the current price from string to double to be processed in operators.
           String cutoff = slow.substring(0, Math.min(slow.length(), 5)); //*this code truncates the 52 week range to just a few values stores it in var
           double low=Double.parseDouble(cutoff); //*this code converts cutoff to a number
           Operators.operate(price,low, company);


           break;
            } catch (Exception e) {

           System.out.println("error in calling: " + tracker + " recovering...");
           continue;

            }








    }


}



//*doc.getElementById("quote-market-notice").parent().child(0).text() this code marks out a stable element by id then does a few modifiers to get to the stock price.

//*if (spans.hasClass("Fw(b) D(ib) Fz(36px) Mb(-4px)"));

//* This is a for loop that was used to get all the rows from the table but it evolved into just an index
//* for the 52 week range.
//*for(int i =0; i < rows.size();  i++){
//*if(rows.hasClass("Ta(end) Fw(b)")){
//* row = rows.get(13);
//*String info =row.text();
//*System.out.println("52 week Range " + info);


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