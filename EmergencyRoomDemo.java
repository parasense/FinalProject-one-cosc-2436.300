import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class EmergencyRoomDemo {
    
    // Note: TimeUnit sleep() seems to throw InterruptedException.
    public static void main(String[] args) throws InterruptedException {
        
        EmergencyRoom emergencyRoom = (
            new EmergencyRoom(new PatientComparator())
        );

        emergencyRoom.checkIn(
            new Patient(
                "Mirabella Jones", 
                LocalDate.of(1973, 7, 11)), 
            Severity.SEVEN
        );
        TimeUnit.MILLISECONDS.sleep(10);
        
        emergencyRoom.checkIn(
            new Patient(
                "Ruth Mendez", 
                LocalDate.of(1965, 1, 22)), 
            Severity.SEVEN
        );
        TimeUnit.MILLISECONDS.sleep(10);
        
        emergencyRoom.checkIn(
            new Patient(
                "Melvin Ingram", 
                LocalDate.of(1965, 1, 22)), 
            Severity.SEVEN
        );
        TimeUnit.MILLISECONDS.sleep(10);
        
        emergencyRoom.checkIn(
            new Patient(
                "Tara Silva", 
                LocalDate.of(1975, 5, 8)), 
            Severity.EIGHT
        );
        TimeUnit.MILLISECONDS.sleep(10);
        
        emergencyRoom.checkIn(
            new Patient(
                "Jeff Barnes", 
                LocalDate.of(1968, 12, 19)), 
            Severity.EIGHT
        );

        // Display the Heap sorting.
        Patient patient;
        while ((patient = emergencyRoom.admit()) != null) {
            System.out.printf("%s admitted\n\n", patient);
        }
    }
}
