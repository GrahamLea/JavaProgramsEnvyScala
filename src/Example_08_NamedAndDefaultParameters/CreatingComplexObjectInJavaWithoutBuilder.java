package Example_08_NamedAndDefaultParameters;

public class CreatingComplexObjectInJavaWithoutBuilder {

    public static class Customer {
        private final String name;
        private final String address;
        private final int age;
        private final int salary;

        public Customer(String name, String address, int age, int salary) {
            this.name = name;
            this.address = address;
            this.age = age;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        // Unreadable code: what are these arguments?
        Customer customer1 = new Customer(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));

        // More readable, but four locals that I don't really need, and not re-usable:
        String name = args[0];
        String address = args[1];
        int age = Integer.parseInt(args[2]);
        int salary = Integer.parseInt(args[3]);
        Customer customer2 = new Customer(name, address, age, salary);
    }
}
