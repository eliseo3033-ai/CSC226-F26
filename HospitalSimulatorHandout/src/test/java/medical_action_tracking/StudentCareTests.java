package medical_action_tracking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import patient_intake.Patient;

class StudentCareTests {
    @Test
    void waitingRoomServesAllFourLevelsInPriorityOrder() {
        EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom(); 
        Patient patient2 = patient("P002", 2);
        Patient patient3 = patient("P003", 3);
        Patient patient1 = patient("P001", 1);
        Patient patient4 = patient("P004", 4);

        waitingRoom.addPatient(patient2);
        waitingRoom.addPatient(patient3);
        waitingRoom.addPatient(patient1);
        waitingRoom.addPatient(patient4);

        assertSame(patient1, waitingRoom.nextPatient());
        assertSame(patient2, waitingRoom.nextPatient());
        assertSame(patient3, waitingRoom.nextPatient());
        assertSame(patient4, waitingRoom.nextPatient());
    }
    @Test
    void rejectingAnInvalidPatientWithoutAffectingTheQueue(){
        EmergencyWaitingRoom waitingRoom = new EmergencyWaitingRoom();
        Patient patient1 = patient("P001", 2);
        Patient patient2 = patient("P002", 6);

        assertTrue(waitingRoom.addPatient(patient1));
        assertFalse(waitingRoom.addPatient(patient2));
        assertEquals(1, waitingRoom.size());
        assertSame(patient1, waitingRoom.nextPatient());
    }
    @Test
    void stackWorksAfterBecomingEmpty() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("first");
        assertEquals("first", stack.pop());

        stack.push("second");
        
        assertEquals("second", stack.peek());
        assertEquals(1, stack.size());
    }
    @Test
    void queueWorksAfterBecomingEmpty() {
    LinkedQueue<String> queue = new LinkedQueue<>();

    queue.enqueue("first");
    assertEquals("first", queue.dequeue());

    queue.enqueue("second");

    assertEquals("second", queue.peekFront());
    assertEquals(1, queue.size());
    assertEquals("second", queue.dequeue());
    assertTrue(queue.isEmpty());
}
@Test
void stackHandlesMultiplePushesAfterRecovery() {
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("first");
    assertEquals("first", stack.pop());

    stack.push("second");
    stack.push("third");

    assertEquals("third", stack.pop());
    assertEquals("second", stack.pop());
    assertTrue(stack.isEmpty());
}
@Test
void undoRecentTreatmentVerifyIfOldOneIsStillThere() {
    TreatmentHistory history = new TreatmentHistory();
    history.addTreatment("P001", "Assessment", "9:00");
    history.addTreatment("P002", "X-Ray", "9:05");

    assertEquals("X-Ray", history.undoLastAction().getTreatmentName());

    history.addTreatment("P003", "Medication", "9:10");

    assertEquals("Medication", history.undoLastAction().getTreatmentName());
    assertEquals("Assessment", history.undoLastAction().getTreatmentName());
    assertTrue(history.undoLastAction() == null);

}


    private Patient patient(String patientID, int triageLevel) {
        return new Patient(patientID, "Test", "Patient", 30, "Checkup",
        triageLevel, "Waiting", "ER-001", 9, "INS-001");
    }
    
}