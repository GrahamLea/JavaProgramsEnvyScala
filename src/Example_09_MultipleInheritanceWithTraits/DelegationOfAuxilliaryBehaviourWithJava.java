package Example_09_MultipleInheritanceWithTraits;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DelegationOfAuxilliaryBehaviourWithJava {

    interface Watcher<T> {
        void received(T t);
    }

    interface Watchable<T> {
        void addWatcher(Watcher<T> watcher);
    }

    static class WatchableHelp<T> implements Watchable<T> {

        public final List<Watcher<T>> watchers = new ArrayList<Watcher<T>>();

        public void addWatcher(Watcher<T> watcher) { watchers.add(watcher); }

        public void notify(T value) {
            for (Watcher<T> watcher : watchers)
                watcher.received(value);
        }
    }

    static abstract class Repository<T> {
        public void save(T value) { /* ... */ }
    }

    static class StockPrice extends BigDecimal {
        public StockPrice(String val) { super(val); }
    }

    static class StockMarket extends Repository<StockPrice> implements Watchable<StockPrice> {

        private final WatchableHelp<StockPrice> watchableHelp = new WatchableHelp<StockPrice>();

        @Override
        public void save(StockPrice value) {
            super.save(value);
            watchableHelp.notify(value);
        }

        public void addWatcher(Watcher<StockPrice> stockPriceWatcher) {
            watchableHelp.addWatcher(stockPriceWatcher);
        }
    }

    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        stockMarket.addWatcher(new Watcher<StockPrice>() {
            public void received(StockPrice stockPrice) {
                System.out.println("stockPrice = " + stockPrice);
            }
        });
        stockMarket.save(new StockPrice("1.50"));
    }
}
