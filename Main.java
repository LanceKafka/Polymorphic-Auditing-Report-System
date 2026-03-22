import java.util.Scanner;

public class Main {
    private static Repository repo = new Repository();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean adding = true;

        while (adding) {
            System.out.println("\n--- Add New Hardware Batch ---");
            System.out.print("Enter Type (1 for Laptop, 2 for Phone, 0 to Finish): ");
            int type = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (type == 0) {
                adding = false;
                break;
            }

            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Enter Brand: ");
            String brand = scanner.nextLine();
            System.out.print("Enter Spec Value: ");
            int spec = scanner.nextInt();

            if (type == 1) {
                repo.addHardware(new Laptop(id, brand, spec));
            } else if (type == 2) {
                repo.addHardware(new Phone(id, brand, spec));
            }
        }

        printMasterList();
        performPolymorphicAudit();
    }

    public static void printMasterList() {
        System.out.println("\n=== HARDWARE MASTERLIST ===");
        System.out.printf("%-5s %-20s %-20s%n", "ID", "Brand", "Interpretation");
        for (Hardware item : repo.getHardwareData()) {
            System.out.printf("%-5d %-20s %-20s%n", 
                item.id, item.brand, item.getInterpretation());
        }
    }

    public static void performPolymorphicAudit() {
        int laptop16 = 0, laptop32 = 0, phone50 = 0;

        for (Hardware item : repo.getHardwareData()) {
            if (item instanceof Laptop) {
                if (item.spec == 16) laptop16++;
                else if (item.spec == 32) laptop32++;
            } else if (item instanceof Phone) {
                if (item.spec == 50) phone50++;
            }
        }

        System.out.println("\n=== POLYMORPHIC AUDIT REPORT ===");
        System.out.println("Total 16GB Laptops: " + laptop16);
        System.out.println("Total 32GB Laptops: " + laptop32);
        System.out.println("Total 50MP Phones:  " + phone50);
    }
}