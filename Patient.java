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
import java.time.LocalTime;

public class Patient{

    private final String name;
    private final LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    Patient(String name, LocalDate dob){
        this.name = name;
        this.dob = dob;
    }

    public void setArrivalTime(LocalTime arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    
    public void setSeverity(Severity severity){
        this.severity = severity;
    }
        
    public String getName(){
        return name;
    }

    public LocalDate getDob(){
        return dob;
    }

    public Severity getSeverity(){
        return severity;
    }
    
    public LocalTime getArrivalTime(){
        return arrivalTime;
    }

    public String toString(){
        return String.format(
            "%s\n DOB=%s\n severity=%s\n arrivalTime=%s",
            name, 
            dob, 
            severity, 
            arrivalTime
        );
    }
}