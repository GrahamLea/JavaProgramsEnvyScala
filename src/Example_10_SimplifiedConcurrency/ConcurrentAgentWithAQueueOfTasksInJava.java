package Example_10_SimplifiedConcurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentAgentWithAQueueOfTasksInJava {

    private static final class Customer {
        private final String name;
        private Customer(String name) { this.name = name; }
    }

    private static final class CalculatorAgent {
        private final BlockingQueue<Customer> queue = new LinkedBlockingQueue<Customer>();
        private final Customer END_TOKEN = new Customer("");

        // NOTE: This is NOT actually equivalent as Actors.
        // Scala Actors that use loop/react only occupy a thread while processing an event
        // This is just a demonstration of how much work you need to do to get something that's
        // even remotely close.
        public void start() {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Customer customer = queue.take();
                            if (customer == END_TOKEN) {
                                System.out.println("Exiting");
                                System.exit(0);
                            }
                            System.out.print("Calculating stuff for " + customer.name + " ... ");
                            Thread.sleep(1000);
                            System.out.println("Done");

                        } catch (InterruptedException e) {
                        }
                    }
                }
            }).start();
        }

        public void accept(Customer customer) { queue.add(customer); }

        public void end() { accept(END_TOKEN); }
    }

    public static void main(String[] args) {
        CalculatorAgent calculatorAgent = new CalculatorAgent();
        calculatorAgent.start();
        calculatorAgent.accept(new Customer("Graham"));
        calculatorAgent.accept(new Customer("Pedro"));
        calculatorAgent.accept(new Customer("Alex"));
        calculatorAgent.end();
    }
}
