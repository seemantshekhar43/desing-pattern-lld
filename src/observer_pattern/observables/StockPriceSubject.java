package observer_pattern.observables;

import observer_pattern.observers.StockPriceObserver;

public interface StockPriceSubject {
    void addObserver(StockPriceObserver stockPriceObserver);
    void remove(StockPriceObserver stockPriceObserver);
    void notifyObservers();


}
