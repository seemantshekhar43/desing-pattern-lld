package observer_pattern.observers;

public class WebAppDisplay implements StockPriceObserver{
    @Override
    public void update(float stockPrice) {
        System.out.println("Stock price on Web App is: " + stockPrice);
    }
}

