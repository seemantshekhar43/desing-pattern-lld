package observer_pattern;

import observer_pattern.observables.StockPriceData;
import observer_pattern.observers.MobileDisplay;
import observer_pattern.observers.StockPriceObserver;
import observer_pattern.observers.WebAppDisplay;

public class Main {

    /*
    Problem statement:Real-time Stock Price Updates
    Imagine you are developing a financial application that displays real-time stock prices.
    The application needs to update multiple user interfaces (UI) components whenever there is a change in stock prices.
     */

    public static void main(String[] args) {
        StockPriceData stockPriceData = new StockPriceData();

        StockPriceObserver mobileDisplay1 = new MobileDisplay("dflaksdj234343");
        StockPriceObserver mobileDisplay2 = new MobileDisplay("iuerowrew12334");
        StockPriceObserver webAppDisplay = new WebAppDisplay();

        stockPriceData.addObserver(mobileDisplay1);
        stockPriceData.addObserver(mobileDisplay2);
        stockPriceData.addObserver(webAppDisplay);

        System.out.println("-------------- Updating stock price ---------------");
        stockPriceData.setStockPrice(223.4f);
        System.out.println("-------------- Updating stock price ---------------");
        stockPriceData.setStockPrice(124.7f);

        stockPriceData.remove(mobileDisplay1);
        System.out.println("-------------- Updating stock price ---------------");
        stockPriceData.setStockPrice(98.3f);
    }

    /*

    Advantages:
    1. Decoupling: The subject does not need to know the concrete classes of its observers. It only interacts with them through the observer interface.
    2. Flexibility: Observers can be added or removed at runtime, allowing for dynamic changes in behavior.
    3. Scalability: Multiple observers can listen to the same subject, making it easy to extend the system with new observers without modifying the subject.
    4. Reusability: Observers and subjects can be reused independently of each other.

     */
}
