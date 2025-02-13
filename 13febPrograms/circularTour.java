class CircularTour {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int totalSurplus = 0, currentSurplus = 0, startIndex = 0;

        for (int i = 0; i < petrol.length; i++) {
            int netGain = petrol[i] - distance[i];
            totalSurplus += netGain;
            currentSurplus += netGain;

            if (currentSurplus < 0) {
                startIndex = i + 1; // Reset start index
                currentSurplus = 0; // Reset surplus
            }
        }

        return totalSurplus >= 0 ? startIndex : -1; // If totalSurplus < 0, no valid tour
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int start = findStartingPoint(petrol, distance);
        System.out.println(start); // Output: 1 (0-based index)
    }
}
