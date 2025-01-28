import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Main Class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Hospital Management System!");
        // Show menu and handle user input
        Menu.showMenu();
    }
}

class PatientRegistration {
    static ArrayList<Patient> patients = new ArrayList<>();

    public static void registerPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter Patient Contact: ");
        String contact = scanner.nextLine();

        Patient newPatient = new Patient(name, age, gender, contact);
        patients.add(newPatient);
        System.out.println("Patient Registered Successfully.");
    }

    public static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }
        System.out.println("Registered Patients:");
        for (Patient patient : patients) {
            System.out.println("Name: " + patient.name + ", Age: " + patient.age + ", Gender: " + patient.gender + ", Contact: " + patient.contact);
        }
    }
}

class Patient {
    String name;
    int age;
    String gender;
    String contact;

    public Patient(String name, int age, String gender, String contact) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }
}

class AppointmentScheduling {
    static ArrayList<Appointment> appointments = new ArrayList<>();

    public static void scheduleAppointment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Appointment Time (HH:MM): ");
        String time = scanner.nextLine();

        Appointment newAppointment = new Appointment(patientName, doctorName, date, time);
        appointments.add(newAppointment);
        System.out.println("Appointment Scheduled Successfully.");
    }

    public static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
            return;
        }
        System.out.println("Scheduled Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println("Patient: " + appointment.patientName + ", Doctor: " + appointment.doctorName + ", Date: " + appointment.date + ", Time: " + appointment.time);
        }
    }
}

class Appointment {
    String patientName;
    String doctorName;
    String date;
    String time;

    public Appointment(String patientName, String doctorName, String date, String time) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }
}

class ElectronicHealthRecords {
    static HashMap<String, String> healthRecords = new HashMap<>();

    public static void manageEHR() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Health Record Details: ");
        String record = scanner.nextLine();

        healthRecords.put(patientName, record);
        System.out.println("Electronic Health Record Updated.");
    }

    public static void viewEHR() {
        if (healthRecords.isEmpty()) {
            System.out.println("No electronic health records available.");
            return;
        }
        System.out.println("Electronic Health Records:");
        healthRecords.forEach((patient, record) -> System.out.println("Patient: " + patient + ", Record: " + record));
    }
}

class BillingInvoicing {
    static ArrayList<Bill> bills = new ArrayList<>();

    public static void manageBilling() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Treatment Details: ");
        String treatmentDetails = scanner.nextLine();
        System.out.print("Enter Amount: ");
        double amount = scanner.nextDouble();

        Bill newBill = new Bill(patientName, treatmentDetails, amount);
        bills.add(newBill);
        System.out.println("Invoice Generated Successfully.");
    }

    public static void viewBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills generated.");
            return;
        }
        System.out.println("Generated Bills:");
        for (Bill bill : bills) {
            System.out.println("Patient: " + bill.patientName + ", Treatment: " + bill.treatmentDetails + ", Amount: " + bill.amount);
        }
    }
}

class Bill {
    String patientName;
    String treatmentDetails;
    double amount;

    public Bill(String patientName, String treatmentDetails, double amount) {
        this.patientName = patientName;
        this.treatmentDetails = treatmentDetails;
        this.amount = amount;
    }
}

class InventoryManagement {
    static HashMap<String, Integer> inventory = new HashMap<>();

    public static void manageInventory() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Item Name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        inventory.put(itemName, inventory.getOrDefault(itemName, 0) + quantity);
        System.out.println("Inventory Updated Successfully.");
    }

    public static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No inventory items available.");
            return;
        }
        System.out.println("Inventory Details:");
        inventory.forEach((item, quantity) -> System.out.println("Item: " + item + ", Quantity: " + quantity));
    }
}

class StaffManagement {
    static ArrayList<Staff> staffList = new ArrayList<>();

    public static void manageStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Position: ");
        String position = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();

        Staff newStaff = new Staff(name, position, contact);
        staffList.add(newStaff);
        System.out.println("Staff Information Updated.");
    }

    public static void viewStaff() {
        if (staffList.isEmpty()) {
            System.out.println("No staff registered.");
            return;
        }
        System.out.println("Staff Details:");
        for (Staff staff : staffList) {
            System.out.println("Name: " + staff.name + ", Position: " + staff.position + ", Contact: " + staff.contact);
        }
    }
}

class Staff {
    String name;
    String position;
    String contact;

    public Staff(String name, String position, String contact) {
        this.name = name;
        this.position = position;
        this.contact = contact;
    }
}

class Menu {
    public static void showMenu() {
        System.out.println("1. Register Patient");
        System.out.println("2. Schedule Appointment");
        System.out.println("3. Manage Electronic Health Records");
        System.out.println("4. Billing and Invoicing");
        System.out.println("5. Manage Inventory");
        System.out.println("6. Manage Staff");
        System.out.println("7. View All Patients");
        System.out.println("8. View All Appointments");
        System.out.println("9. View All Bills");
        System.out.println("10. View Inventory");
        System.out.println("11. View All Staff");
        System.out.println("0. Exit");
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1: PatientRegistration.registerPatient(); break;
                case 2: AppointmentScheduling.scheduleAppointment(); break;
                case 3: ElectronicHealthRecords.manageEHR(); break;
                case 4: BillingInvoicing.manageBilling(); break;
                case 5: InventoryManagement.manageInventory(); break;
                case 6: StaffManagement.manageStaff(); break;
                case 7: PatientRegistration.viewPatients(); break;
                case 8: AppointmentScheduling.viewAppointments(); break;
                case 9: BillingInvoicing.viewBills(); break;
                case 10: InventoryManagement.viewInventory(); break;
                case 11: StaffManagement.viewStaff(); break;
                case 0: System.out.println("Exiting System. Goodbye!"); break;
                default: System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }
}