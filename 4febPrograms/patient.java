
class Patient {
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    public static int getTotalPatients() {
        return totalPatients;
    }

    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital: " + hospitalName);
            System.out.println("Patient ID: " + this.patientID);
            System.out.println("Name: " + this.name);
            System.out.println("Age: " + this.age);
            System.out.println("Ailment: " + this.ailment);
        } else {
            System.out.println("Invalid patient instance.");
        }
    }

    public static void main(String[] args) {
        Patient patient1 = new Patient(101, "Alice Brown", 30, "Flu");
        Patient patient2 = new Patient(102, "Bob White", 45, "Fracture");

        System.out.println("Total Patients: " + getTotalPatients());
        patient1.displayPatientDetails();
        patient2.displayPatientDetails();
    }
}

