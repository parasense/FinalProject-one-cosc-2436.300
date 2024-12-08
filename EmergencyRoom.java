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

import java.util.Comparator;

public class EmergencyRoom{

    private final Heap<Patient> patients;

    // A constructor that takes a comparator for Patient objects.
    EmergencyRoom(Comparator<Patient> comparator){
        patients = new Heap<>(comparator);

    }

    /*
    A checkIn() method that takes a Patient and their reported Severity.
    It then sets the patient’s severity and arrival time fields and adds 
    the patient to the priority queue. The arrival time value should be 
    the current time.
     */
    public void checkIn(Patient patient, Severity severity){

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
    public Patient admit(){

        // It's a wrapper for the heap remove method.
        return patients.remove();
    }
}
