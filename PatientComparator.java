import java.util.Comparator;

/*
  1. Patients with a greater severity get priority.
  2. Older patients with the same severity get priority.
  3. Patients with the same age and severity who arrive earlier get priority. 
*/
public class PatientComparator implements Comparator<Patient>{
    
    public int compare(Patient a, Patient b){
        
        // Check severity.
        // Note: Higher severity number has more weight.
        int severity = (
            b.getSeverity().compareTo(a.getSeverity())
        );
        if (severity != 0){
            return severity;
        }

        // Check age.
        // Note: Older age has more weight.
        int dob = a.getDob().compareTo(b.getDob());
        if (dob != 0){
            return dob;
        }

        // All things being equal, check arrivalTime.
        // Note: the code given for 5 patients ensures unique arrival time.
        return a.getArrivalTime().compareTo(b.getArrivalTime());
        
    }
}
