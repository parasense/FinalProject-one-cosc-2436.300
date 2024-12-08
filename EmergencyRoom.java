
import java.util.Comparator;

public class EmergencyRoom {

    private final Heap<Patient> patients;

    // A constructor that takes a comparator for Patient objects.
    EmergencyRoom(Comparator<Patient> comparator) {
        patients = new Heap<>(comparator);

    }

    /*
    A checkIn() method that takes a Patient and their reported Severity.
    It then sets the patient’s severity and arrival time fields and adds 
    the patient to the priority queue. The arrival time value should be 
    the current time.
     */
    public void checkIn(Patient patient, Severity severity) {

        // Set the two non-immutable fields.
        patient.setSeverity(severity);
        patient.setArrivalTime(java.time.LocalTime.now());

        // Insert the patient object into the Heap.
        patients.add(patient);

    }

    /*
    An admit() method that removes a Patient object from the head of the
    priority queue and returns it. If the priority queue is empty admit() should
    return null.
     */
    public Patient admit() {
        return patients.remove();
    }
}
