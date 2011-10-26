package Example_08_NamedAndDefaultParameters;

public class CreatingComplexObjectInJavaWithTheBuilderPattern {
    
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
    
    public static class CustomerBuilder {
        private String name;
        private String address;
        private int age;
        private int salary;

        public CustomerBuilder() {
        }
        
        public CustomerBuilder name(String name) {
            this.name = name;
            return this;
        }
        
        public CustomerBuilder address(String address) {
            this.address = address;
            return this;
        }
        
        public CustomerBuilder age(int age) {
            this.age = age;
            return this;
        }
        
        public CustomerBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Customer build() {
            return new Customer(name, address, age, salary);
        }
    } 
    
    public static void main(String[] args) {
        // More readable, and reusable, but we had to create a lot of code to get there
        Customer customer =
            new CustomerBuilder()
                .name(args[0])
                .address(args[1])
                .age(Integer.parseInt(args[2]))
                .salary(Integer.parseInt(args[2]))
                .build();
    }
}
