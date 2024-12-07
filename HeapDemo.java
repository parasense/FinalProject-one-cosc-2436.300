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
public class HeapDemo {

    public static void main(String[] args) {

        // Anonymous comparator of Integers.
        Comparator<Integer> MyComparator = Integer::compare;
        
        // Instantiate the Heap with the comparator.
        Heap<Integer> MyHeap = new Heap<>(MyComparator);

        // Generate the Random numbers to give the Heap.
        int[] InputNumbers = GenRandomNumbers();
        
        // Give numbers to the Heap, and print.
        //System.out.println("Adding numbers:");
        for (int k : InputNumbers){
            System.out.printf("%d ", k);
            MyHeap.add(k);
        }
        System.out.println();
        
        // Remove numbers.
        //System.out.println("\nRemoving numbers:");
        for (int k : MyHeap.DeepCopy()){
            System.out.printf("%d ",MyHeap.remove());
        }
        System.out.println();
    }
    
    // Generate 20 random RandomNumbers of 0 ~ 99.
    public static int[] GenRandomNumbers(){
        final int min=0;
        final int max=99;
        final int limit=20;
        int[] RandomNumbers = new int[limit];
        for (int i = 0 ; i < limit ; i++){
            // Casting to int because Math.random gives a double
            RandomNumbers[i] = (int) (Math.random() * max + min);
        }
        return RandomNumbers;
        
        // XXX - consistent test numbers
        //return new int[]{69,25,55,78,31,63,96,92,52,78,50,80,35,15,33,27,29,40,13,88};
    }
}
