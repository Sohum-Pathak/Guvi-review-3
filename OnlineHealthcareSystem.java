import java.util.*;

class OnlineHealthcareSystem {

    private static Scanner scanner = new Scanner(System.in);

    // Models for the system
    static class Patient {
        String name;
        int age;
        String condition;

        Patient(String name, int age, String condition) {
            this.name = name;
            this.age = age;
            this.condition = condition;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age + ", Condition: " + condition;
        }
    }

    static class Doctor {
        String name;
        String specialty;

        Doctor(String name, String specialty) {
            this.name = name;
            this.specialty = specialty;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Specialty: " + specialty;
        }
    }

    static class Appointment {
        String patientName;
        String doctorName;
        String date;

        Appointment(String patientName, String doctorName, String date) {
            this.patientName = patientName;
            this.doctorName = doctorName;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Patient: " + patientName + ", Doctor: " + doctorName + ", Date: " + date;
        }
    }

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    // Core features
    private void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter patient condition: ");
        String condition = scanner.nextLine();

        patients.add(new Patient(name, age, condition));
        System.out.println("Patient added successfully.");
    }

    private void addDoctor() {
        System.out.print("Enter doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter doctor specialty: ");
        String specialty = scanner.nextLine();

        doctors.add(new Doctor(name, specialty));
        System.out.println("Doctor added successfully.");
    }

    private void scheduleAppointment() {
        System.out.print("Enter patient name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter doctor name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        appointments.add(new Appointment(patientName, doctorName, date));
        System.out.println("Appointment scheduled successfully.");
    }

    private void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("List of patients:");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            System.out.println("List of doctors:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
        } else {
            System.out.println("List of appointments:");
            for (Appointment appointment : appointments) {
                System.out.println(appointment);
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n--- Online Healthcare Management System ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Add Doctor");
        System.out.println("3. Schedule Appointment");
        System.out.println("4. View Patients");
        System.out.println("5. View Doctors");
        System.out.println("6. View Appointments");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        while (true) {
            displayMenu();
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    addDoctor();
                    break;
                case 3:
                    scheduleAppointment();
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 7:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        OnlineHealthcareSystem system = new OnlineHealthcareSystem();
        system.run();
    }
}
