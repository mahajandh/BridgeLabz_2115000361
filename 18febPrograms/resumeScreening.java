import java.util.ArrayList;
import java.util.List;

// Abstract JobRole class
abstract class JobRole {
    private String candidateName;
    private int experienceYears;

    public JobRole(String candidateName, int experienceYears) {
        this.candidateName = candidateName;
        this.experienceYears = experienceYears;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " - Candidate: " + candidateName + ", Experience: " + experienceYears + " years";
    }
}

// Concrete JobRole subclasses
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class DataScientist extends JobRole {
    public DataScientist(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

class ProductManager extends JobRole {
    public ProductManager(String candidateName, int experienceYears) {
        super(candidateName, experienceYears);
    }
}

// Generic Resume class
class Resume<T extends JobRole> {
    private List<T> resumes = new ArrayList<>();

    public void addResume(T resume) {
        resumes.add(resume);
    }

    public List<T> getResumes() {
        return resumes;
    }
}

// Utility class with wildcard method
class ResumeProcessor {
    public static void processResumes(List<? extends JobRole> resumes) {
        System.out.println("Processing Resumes:");
        for (JobRole resume : resumes) {
            System.out.println(resume);
        }
    }
}

// Main class
public class ResumeScreeningSystem {
    public static void main(String[] args) {
        // Create resume lists for different roles
        Resume<SoftwareEngineer> softwareEngineerResumes = new Resume<>();
        Resume<DataScientist> dataScientistResumes = new Resume<>();
        Resume<ProductManager> productManagerResumes = new Resume<>();

        // Add resumes
        softwareEngineerResumes.addResume(new SoftwareEngineer("Alice Johnson", 5));
        softwareEngineerResumes.addResume(new SoftwareEngineer("Bob Smith", 3));

        dataScientistResumes.addResume(new DataScientist("Charlie Brown", 4));
        dataScientistResumes.addResume(new DataScientist("David Lee", 6));

        productManagerResumes.addResume(new ProductManager("Emily Davis", 7));
        productManagerResumes.addResume(new ProductManager("Frank White", 5));

        // Process resumes using wildcard method
        System.out.println("Software Engineer Resumes:");
        ResumeProcessor.processResumes(softwareEngineerResumes.getResumes());

        System.out.println("\nData Scientist Resumes:");
        ResumeProcessor.processResumes(dataScientistResumes.getResumes());

        System.out.println("\nProduct Manager Resumes:");
        ResumeProcessor.processResumes(productManagerResumes.getResumes());
    }
}
