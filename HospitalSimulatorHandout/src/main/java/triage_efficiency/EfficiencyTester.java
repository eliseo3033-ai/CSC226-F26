package triage_efficiency;

import patient_intake.Patient;

public class EfficiencyTester {

    /**
     * REQUIRED (80%): Implement linear search.
     *
     * Search through the patient array one element at a time until the matching
     * patientID is found. Return the Patient if it exists; otherwise return null.
     *
     * This method must run in O(n) time.
     */
    public Patient linearSearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement linear search.
        // Search the entire array in order and return the matching Patient.

       for (int i=0; i < patients.length; i++) { // checks every person in the array
            if (patients[i].getPatientID().equals(pid)) { //compares both ID's
                return patients[i]; //Found it! and returns the matching patient
            }
       }
       return null; // was not found
    }

    /**
     * REQUIRED (80%): Implement binary search.
     *
     * This method works only on an array that is sorted by patientID.
     * Repeatedly divide the search range in half until the target is found.
     *
     * This method must run in O(log n) time.
     */
    public Patient binarySearch(Patient[] patients, String pid) {
        // TODO REQUIRED: Implement iterative binary search.
        // The array must be sorted by patientID before calling this method.
       int low = 0;
       int high = patients.length - 1;

       while (low <= high) {
        int mid = (high + low) / 2;

        if (patients[mid].getPatientID().equals(pid)) { // found the matching ID!
            return patients[mid];
        }
        else if (patients[mid].getPatientID().compareTo(pid) > 0) { // middle ID too big?
            high = mid - 1; // move to the right
        } 
        else {
            low = mid + 1; // miidle ID too small? Move to the left
        }
        }
       return null; // ID was not found in the array
    }

    /**
     * OPTIONAL (+5%): Implement a different O(log n) search algorithm.
     *
     * Pick one of the following approaches and implement it:
     * - Exponential search
     * - Jump search
     * - Ternary search
     *
     * Add a short comment above the method explaining:
     * - which algorithm you chose
     * - where you learned about it
     * - why it works
     */
    public Patient logNSearch(Patient[] patients, String pid) {
        // TODO OPTIONAL: Research and implement a second O(log n) algorithm.
        // Cite your source and explain the approach in a comment before the logic.
        return null;
    }

    public void timeDemo() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 + 5;
        }
        long endTime = System.nanoTime();

        System.out.println("The example addition took: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            int x = 5 * 5;
        }
        endTime = System.nanoTime();
        System.out.println("The example multiplication took: " + (endTime - startTime) + " ns");
    }
}
