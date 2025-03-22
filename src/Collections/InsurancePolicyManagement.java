package Collections;

import java.util.*;
import java.time.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return "Policy{" +
                "policyNumber='" + policyNumber + '\'' +
                ", policyholderName='" + policyholderName + '\'' +
                ", expiryDate=" + expiryDate +
                ", coverageType='" + coverageType + '\'' +
                ", premiumAmount=" + premiumAmount +
                '}';
    }
}

public class InsurancePolicyManagement {
    Map<String, Policy> policyMap = new HashMap<>();
    Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    TreeMap<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();

    void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    Policy getPolicy(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    List<Policy> getExpiringPolicies(int days) {
        LocalDate today = LocalDate.now();
        LocalDate targetDate = today.plusDays(days);
        return new ArrayList<>(sortedPolicyMap.headMap(targetDate, true).values());
    }

    List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equals(policyholderName)) {
                result.add(policy);
            }
        }
        return result;
    }

    void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        sortedPolicyMap.headMap(today, false).clear();
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new Policy("P123", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        system.addPolicy(new Policy("P124", "Bob", LocalDate.now().plusDays(10), "Auto", 700.0));
        system.addPolicy(new Policy("P125", "Alice", LocalDate.now().plusDays(40), "Home", 800.0));

        System.out.println(system.getPolicy("P123"));
        System.out.println(system.getExpiringPolicies(30));
        System.out.println(system.getPoliciesByHolder("Alice"));
        system.removeExpiredPolicies();
    }
}

