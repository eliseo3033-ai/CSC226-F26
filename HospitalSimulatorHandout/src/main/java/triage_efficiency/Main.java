package triage_efficiency;

import patient_intake.Patient;

public class Main {
    public static void main(String[] args) {
        // TODO REQUIRED: Generate the patient data.
        // TODO REQUIRED: Sort the data by patientID when needed.
        // TODO REQUIRED: Run each search method and print a found and not-found example.
        // TODO OPTIONAL: Call timeDemo() to compare algorithm runtimes.
    }

    /**
     * REQUIRED (80%): Generate sample patient data for testing.
     *
     * Build an array of Patient objects with realistic IDs, names, complaints,
     * and triage information so you can test each search method.
     */
    public static Patient[] generatePatients(int count) {
        // TODO REQUIRED: Create the patient array and fill it with sample data.
        Patient [] patients = new Patient[count];
        
        patients[0] = new Patient("P002","Mary","Johnson",32,"Headache",3,
                                "Admission","ER-102",9,"INS-23456");
        patients[1] = new Patient("P005","Michael", "Davis", 8, "Fractured Arm", 2, 
                                "Pediatrics", "PED-201" ,12 , "INS-56789");
        patients[2] = new Patient("P009", "David", "Taylor", 19, "Back Pain", 4,
                                 "Waiting", "WR-001", 16, "INS-90123");
        patients[3] =  new Patient("P008", "Elizabeth", "Moore", 72, "Dizziness", 2,
                                "Triage","ER-106", 15, "INS-89012");
        patients[4] = new Patient("P001", "John", "Smith", 45, "Chest Pain", 1,
                                 "Admission", "ER-101", 8, "INS-12345");
        patients[5] = new Patient("P010", "Barbara", "Anderson", 35, "Cut on Hand", 3,
                                 "Treatment", "ER-107", 17, "INS-01234");
        patients[6] =  new Patient("P003", "Robert", "Williams", 67, "Abdominal Pain", 2,
                                 "Triage", "ER-103", 10, "INS-34567");
    return patients;  
    }
    

    /**
     * REQUIRED (80%): Sort patients by patientID before binary search.
     *
     * The binary-search version only works on an array sorted by patientID.
     */
    public static Patient[] sortByPatientId(Patient[] patients) {
        // TODO REQUIRED: Sort the array by patientID before testing binary search.
        int lowestID = 0;
        for (int i = 1; i < patients.length; i++) {
            if (patients[i].getPatientID().compareTo(patients[lowestID].getPatientID()) < 0) {
                lowestID = i;
                Patient temp = patients[0];
                patients[0] = patients[lowestID];
                patients[lowestID] = temp;
            }
        }
        return patients;
    }
}
