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

import java.util.ArrayList;
import java.util.Comparator;

public class Heap<T> {
    private final ArrayList<T> arrayHeap;
    private final Comparator<? super T> arrayHeapComparator;

    Heap(Comparator<? super T> comparator) {
        this.arrayHeap = new ArrayList<>();
        this.arrayHeapComparator = comparator;
    }

    
    public void add(T node) {
        arrayHeap.add(node);
        upSift();
    }

    public T remove() {
        
        if (arrayHeap.isEmpty()) {
            return null;
        }

        T headNode = getValue(0);
        T tailNode = arrayHeap.remove(lastIndex()); // not recursion

        if (!arrayHeap.isEmpty()) {
            setValue(0, tailNode);
            downSift();
        }

        return headNode;
    }

    private void upSift() {
        int index = lastIndex();
        int parentIndex = parentIndex(index);

        while (index != 0)
        {
            
            // Find the smaller node.
            if
            (
                arrayHeapComparator.compare(
                    getValue(index),
                    getValue(parentIndex)
                ) >= 0
            ){
                
                break;
                
            } else { 
                
                //  Otherwise swap the parentIndex node.
                swapValues(index, parentIndex);
                index = parentIndex;
                parentIndex = parentIndex(index);
                
            }
        }
    }
    
    private void downSift() {
        int index = 0;
        T workNode = getValue(index);
        int size = arrayHeap.size();
        
        while (leftChildIndex(index) < size) {
            
            int leftChildIndex = leftChildIndex(index);
            int rightChildIndex = rightChildIndex(index);
            int minChildIndex = leftChildIndex;
            
            if (rightChildIndex < size){
                
                // Find the smaller child
                if
                (
                    arrayHeapComparator.compare(
                        getValue(rightChildIndex),
                        getValue(leftChildIndex)
                    ) < 0
                ){
                    
                    minChildIndex = rightChildIndex;
                    
                } else {
                    
                    minChildIndex = leftChildIndex;
                }
            }

            // Stop if workNode is less-than-or-equal MinChildIndex.
            if
            (
                arrayHeapComparator.compare(
                    workNode,
                    getValue(minChildIndex)
                ) <= 0
            )
            {
                
                break;
                
            } else {
            
                //  Otherwise swap the smaller node.
                swapValues(index, minChildIndex);
                
            }
            
            // Reset the index for next iteration
            index = minChildIndex;
        }

    }

    // Clone the Heap.
    public ArrayList<T> deepCopy() {
        return new ArrayList<>(arrayHeap);
    }
    
    // Returns parentIndex node's index possition.
    private Integer parentIndex(Integer idx){
        return (idx -1) / 2;
    }
    
    // Returns left child node index possition.
    private Integer leftChildIndex(Integer idx){
        return (2 * idx) + 1;
    }
    
    // Returns right child node index possition.
    private Integer rightChildIndex(Integer idx){
        return (2 * idx) + 2;
    }
    
    // Returns last array node index possition.
    private int lastIndex(){
        return (arrayHeap.size() - 1);
    }
    
    // Return the value of a given node.
    private T getValue(Integer idx){
        return arrayHeap.get(idx);
    }
    
    // Set the node value of a given index possition.
    private void setValue(Integer idx, T node){
        arrayHeap.set(idx, node);
    }
    
    // Exchange node values.
    private void swapValues(Integer idxA, Integer idxB){
        T NodeA = this.arrayHeap.get(idxA);
        arrayHeap.set(idxA, arrayHeap.get(idxA));
        arrayHeap.set(idxB, NodeA);
    }
}