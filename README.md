# BLSH

12/2/2016


A fundamental rule of making gains in the stock market is to buy stock when it's low in value and sell at a later date when
it is higher in value. This java program pulls stock market data from finance.yahoo.com and parses it and makes calculatins on it.
Most notably, it takes the 52 week low of a certain stock tracker and compares that against the current price. 


 There are currently three classes.The main class handles the menu items in the console and scans for user input. It pulls up stocks that make up the dow jones and S&P 500 that are within 10% of thier 52 week low seperated by sectors (All, Health Care, Inustrial, Tech, Consumer, Financial). In the future I would like to add historical data to it but for now it just pulls up todays date and current time.The HtmlParser class has the method parser that reads html from each stock's yahoo page and get's current price and 52 week low. It feeds the tracker symbol, price and low to the class Operator which has the method operate that calculates the % of 52 week low and determines if that is 10% of lower. The ouput is printed out in console. The parse and operate methodes are repeated for all stock tracker symbols.


-Joe Kurokawa
kurokaw1@gmail.com
