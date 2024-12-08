import java.time.LocalDate;
import java.time.LocalTime;

public class Patient {
    private final String name;
    private final LocalDate dob;
    private Severity severity;
    private LocalTime arrivalTime;

    public Patient(String name, LocalDate dob){
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

    public String toString() {
        return String.format(
            "%s\n DOB: %s\n severity: %s\n arrivalTime: %s", 
            name, 
            dob, 
            severity, 
            arrivalTime
        );
    }
    
}