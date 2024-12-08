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
