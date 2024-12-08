/*
 * Final Project
 *
 * Jon Disnard <jdisnard1@collin.edu>
 * COSC-2436.003
 * Professor Dimitrios Sellountos
 * December 8th 2024
 *
 * Product Version: Apache NetBeans IDE 23
 * Java: 21.0.4; OpenJDK 64-Bit Server VM 21.0.4+2
 * Runtime: OpenJDK Runtime Environment 21.0.4+2
 * System: Linux version 6.8.9-100.fc38.x86_64 running on amd64; UTF-8; en_US (nb)
 */

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class EmergencyRoomDemo{

    // Note: TimeUnit sleep() seems to throw InterruptedException.
    public static void main(String[] args) throws InterruptedException{

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
        while ((patient = emergencyRoom.admit()) != null){
            System.out.printf("%s admitted\n\n", patient);
        }
    }
}