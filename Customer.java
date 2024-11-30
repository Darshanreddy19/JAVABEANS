import java.util.*;
public class Customer {
    private int id;
    private double balance;
    private String firstName;
    private String lastName;
    public Customer(int id, double balance, String firstName, String lastName) {
        this.id = id;
        this.balance = balance;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "ID=" + id +
                ", Balance=" + balance +
                ", FirstName='" + firstName + '\'' +
                ", LastName='" + lastName + '\'' +
                '}';
    }
}

 class CustomerSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.println("Enter the number of customers:");
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Customer " + (i + 1) + ":");
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            customers.add(new Customer(id, balance, firstName, lastName));
        }
        customers.sort(Comparator.comparing(Customer::getFirstName)
                .thenComparing(Customer::getLastName)
                .thenComparingInt(Customer::getId)
                .thenComparingDouble(Customer::getBalance));

        // Display sorted customers
        System.out.println("\nSorted Customers:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }

        scanner.close(); // Close the scanner
    }
}
