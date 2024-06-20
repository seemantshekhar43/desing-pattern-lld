package observer_pattern.observers;

public class MobileDisplay implements StockPriceObserver{
    private String deviceId;

    public MobileDisplay(String deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    public void update(float stockPrice) {
        System.out.println("Stock price on mobile with deviceID: "+ deviceId + " is: " + stockPrice);
    }
}
