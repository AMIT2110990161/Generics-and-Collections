package Generics;

import java.util.ArrayList;
import java.util.List;

// Abstract Job Role
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return "Job Role: " + roleName;
    }
}

// Specific Job Roles
class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

// Generic Resume Class
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    @Override
    public String toString() {
        return "Resume: " + candidateName + ", " + jobRole;
    }
}

// Resume Screening System
class ResumeScreening {
    public static void processResumes(List<? extends Resume<? extends JobRole>> resumes) {
        System.out.println("Processing Resumes:");
        for (Resume<?> resume : resumes) {
            System.out.println(resume);
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        List<Resume<?>> resumes = new ArrayList<>();

        resumes.add(new Resume<>("Alice Johnson", new SoftwareEngineer()));
        resumes.add(new Resume<>("Bob Smith", new DataScientist()));
        resumes.add(new Resume<>("Charlie Brown", new ProductManager()));

        ResumeScreening.processResumes(resumes);
    }
}
