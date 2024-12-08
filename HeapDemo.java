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
        Comparator<Integer> myComparator = Integer::compare;
        
        // Instantiate the Heap with the comparator.
        Heap<Integer> myHeap = new Heap<>(myComparator);

        // Generate the Random numbers to give the Heap.
        int[] inputNumbers = genRandomNumbers();
        
        // Give numbers to the Heap, and print.
        for (int k : inputNumbers){
            System.out.printf("%d ", k);
            myHeap.add(k);
        }
        System.out.println();
        
        // Remove numbers.
        for (int k : myHeap.deepCopy()){
            System.out.printf("%d ",myHeap.remove());
        }
        System.out.println();
    }
    
    // Generate 20 random RandomNumbers of 0 ~ 99.
    public static int[] genRandomNumbers(){
        final int min=0;
        final int max=99;
        final int limit=20;
        int[] randomNumbers = new int[limit];
        for (int i = 0 ; i < limit ; i++){
            // Casting to int because Math.random gives a double
            randomNumbers[i] = (int) (Math.random() * max + min);
        }
        
        return randomNumbers;
    }
}
