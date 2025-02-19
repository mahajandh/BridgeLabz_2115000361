import java.util.*;
import java.time.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    @Override
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
    private Map<String, Policy> policyMap = new HashMap<>();
    private Map<String, Policy> orderedPolicyMap = new LinkedHashMap<>();
    private Map<LocalDate, Policy> sortedPolicyMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        orderedPolicyMap.put(policy.policyNumber, policy);
        sortedPolicyMap.put(policy.expiryDate, policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);
        List<Policy> expiringPolicies = new ArrayList<>();
        for (Policy policy : sortedPolicyMap.values()) {
            if (!policy.expiryDate.isAfter(threshold)) {
                expiringPolicies.add(policy);
            }
        }
        return expiringPolicies;
    }

    public List<Policy> getPoliciesByHolder(String policyholderName) {
        List<Policy> policies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.policyholderName.equals(policyholderName)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        policyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        orderedPolicyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
        sortedPolicyMap.values().removeIf(policy -> policy.expiryDate.isBefore(today));
    }

    public static void main(String[] args) {
        InsurancePolicyManagement system = new InsurancePolicyManagement();
        system.addPolicy(new Policy("P123", "Alice", LocalDate.now().plusDays(20), "Health", 500.0));
        system.addPolicy(new Policy("P124", "Bob", LocalDate.now().plusDays(40), "Auto", 700.0));
        system.addPolicy(new Policy("P125", "Alice", LocalDate.now().plusDays(10), "Home", 600.0));
        
        System.out.println("Policy P123: " + system.getPolicyByNumber("P123"));
        System.out.println("Policies expiring soon: " + system.getPoliciesExpiringSoon());
        System.out.println("Policies for Alice: " + system.getPoliciesByHolder("Alice"));
        
        system.removeExpiredPolicies();
        System.out.println("Remaining policies after removing expired ones: " + system.policyMap);
    }
}
