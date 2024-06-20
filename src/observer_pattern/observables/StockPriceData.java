package observer_pattern.observables;

import observer_pattern.observers.StockPriceObserver;

import java.util.ArrayList;
import java.util.List;

public class StockPriceData implements StockPriceSubject{

    private final List<StockPriceObserver> observerList;
    private float stockPrice;

    public StockPriceData() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(StockPriceObserver stockPriceObserver) {
        this.observerList.add(stockPriceObserver);
    }

    @Override
    public void remove(StockPriceObserver stockPriceObserver) {
        this.observerList.remove(stockPriceObserver);
    }

    @Override
    public void notifyObservers() {
        for(StockPriceObserver observer : this.observerList){
            observer.update(this.stockPrice);
        }

    }

    public float getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(float stockPrice) {
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}
