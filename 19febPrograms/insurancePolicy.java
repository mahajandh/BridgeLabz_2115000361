import java.util.*;

class InsurancePolicy implements Comparable<InsurancePolicy> {
    private String policyNumber;
    private String policyholderName;
    private Date expiryDate;
    private String coverageType;
    private double premiumAmount;

    public InsurancePolicy(String policyNumber, String policyholderName, Date expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() { return policyNumber; }
    public Date getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    @Override
    public int compareTo(InsurancePolicy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InsurancePolicy that = (InsurancePolicy) obj;
        return policyNumber.equals(that.policyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public String toString() {
        return "Policy{" + "Number='" + policyNumber + "', Holder='" + policyholderName + "', Expiry=" + expiryDate + ", Coverage='" + coverageType + "', Premium=" + premiumAmount + "}";
    }
}

public class InsurancePolicyManagement {
    private Set<InsurancePolicy> hashSet = new HashSet<>();
    private Set<InsurancePolicy> linkedHashSet = new LinkedHashSet<>();
    private Set<InsurancePolicy> treeSet = new TreeSet<>();

    public void addPolicy(InsurancePolicy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    public Set<InsurancePolicy> getAllPolicies() {
        return new HashSet<>(hashSet);
    }

    public Set<InsurancePolicy> getPoliciesExpiringSoon(int days) {
        Set<InsurancePolicy> expiringSoon = new TreeSet<>();
        Date now = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        cal.add(Calendar.DAY_OF_YEAR, days);
        Date threshold = cal.getTime();
        
        for (InsurancePolicy policy : treeSet) {
            if (policy.getExpiryDate().before(threshold)) {
                expiringSoon.add(policy);
            }
        }
        return expiringSoon;
    }

    public Set<InsurancePolicy> getPoliciesByCoverageType(String coverageType) {
        Set<InsurancePolicy> policies = new HashSet<>();
        for (InsurancePolicy policy : hashSet) {
            if (policy.getCoverageType().equalsIgnoreCase(coverageType)) {
                policies.add(policy);
            }
        }
        return policies;
    }

    public Set<InsurancePolicy> findDuplicatePolicies() {
        Set<String> seenNumbers = new HashSet<>();
        Set<InsurancePolicy> duplicates = new HashSet<>();
        for (InsurancePolicy policy : hashSet) {
            if (!seenNumbers.add(policy.getPolicyNumber())) {
                duplicates.add(policy);
            }
        }
        return duplicates;
    }

    public static void main(String[] args) {
        InsurancePolicyManagement manager = new InsurancePolicyManagement();
        manager.addPolicy(new InsurancePolicy("P123", "John Doe", new Date(System.currentTimeMillis() + 20 * 86400000L), "Health", 500.0));
        manager.addPolicy(new InsurancePolicy("P124", "Jane Smith", new Date(System.currentTimeMillis() + 40 * 86400000L), "Auto", 700.0));
        manager.addPolicy(new InsurancePolicy("P123", "John Doe", new Date(System.currentTimeMillis() + 20 * 86400000L), "Health", 500.0));
        
        System.out.println("All Policies: " + manager.getAllPolicies());
        System.out.println("Expiring Soon: " + manager.getPoliciesExpiringSoon(30));
        System.out.println("Health Policies: " + manager.getPoliciesByCoverageType("Health"));
        System.out.println("Duplicate Policies: " + manager.findDuplicatePolicies());
    }
}
