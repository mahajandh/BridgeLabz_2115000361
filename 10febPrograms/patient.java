import java.util.*;

// Abstract class Patient
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPatientDetails() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age;
    }

    public abstract double calculateBill();
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// InPatient class
class InPatient extends Patient implements MedicalRecord {
    private double dailyCharge;
    private int daysAdmitted;
    private List<String> records;

    public InPatient(String patientId, String name, int age, double dailyCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyCharge = dailyCharge;
        this.daysAdmitted = daysAdmitted;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return dailyCharge * daysAdmitted;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// OutPatient class
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return records;
    }
}

// Main class
public class HospitalManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();
        
        InPatient patient1 = new InPatient("P101", "Alice", 30, 2000, 5);
        OutPatient patient2 = new OutPatient("P102", "Bob", 40, 500);
        
        patients.add(patient1);
        patients.add(patient2);
        
        patient1.addRecord("Admitted for surgery");
        patient2.addRecord("Routine check-up");
        
        for (Patient patient : patients) {
            System.out.println(patient.getPatientDetails() + " | Total Bill: " + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                System.out.println("Medical Records: " + ((MedicalRecord) patient).viewRecords());
            }
        }
    }
}
