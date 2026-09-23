package patient_intake;
// Switch from using ArrayList to a flat array implementation for patient storage.

public class PatientRegistry {
    // Flat array to store patients and a size field to track the number of stored patients.
    private Patient[] patientRegistry;
    private int size; // track actual number of patients

    // Initial capacity for the flat array. Can be adjusted as needed.
    private static final int INITIAL_CAPACITY = 10;

    public PatientRegistry() {
        patientRegistry = new Patient[INITIAL_CAPACITY];
        size = 0;
    }

    public void addPatient(Patient patient) {
        if (size < INITIAL_CAPACITY) {
            patientRegistry[size] = patient;
            size ++;
        }
        // TODO OPTIONAL (+5%): Expand the array when it becomes full.
    }

    /**
     * Returns the patients currently stored in the registry.
     * The optional encapsulation extension requires returning a defensive copy.
     */
    public Patient[] getPatientRegistry() {
        Patient [] patients = new Patient[size];

        for (int i=0; i < size; i++) {
            patients[i] = patientRegistry[i];
        }
        return patients;

    }

    public Patient getPatientByID(String patientID) {
        for (int i=0; i < size; i++) {
            if (patientRegistry[i].getPatientID().equals(patientID)) return patientRegistry[i]; // if the ID matches the .get method, 
                                                                                                // then the patient will be displayed 
        }
        return null;
    }

    /**
     * Removes a patient from the registry by patientID.
     * @param patientID The ID of the patient to remove
     * @return true if patient was found and removed, false otherwise
     */
    public boolean removePatient(String patientID) {
        return false; // TODO OPTIONAL (+5%): Remove the patient with this ID.
    }

    /**
     * Removes a patient from the registry by index.
     * @param index The index of the patient to remove
     * @return the removed Patient, or null if index is invalid
     */
    public Patient removePatient(int index) {
        return null; // TODO OPTIONAL (+5%): Remove by index and shift later elements left.
    }

    /**
     * Updates a patient in the registry by matching patientID.
     * @param updatedPatient The patient with updated information
     * @return true if patient was found and updated, false otherwise
     */
    public boolean updatePatient(Patient updatedPatient) {
        return false; // TODO OPTIONAL (+5%): Replace the patient with the same ID.
    }
    
    @Override
    public String toString() {
        String displayInfo = "PatientRegistry || size = " + size +":\n"; // initiate first so the names don't get replaced during each loop
        for (int i=0; i < size ; i++) {
            displayInfo += patientRegistry[i] + "\n"; // the patients will be added each loop
        }
        return displayInfo;
    }

}


