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
    private final ArrayList<T> ArrayHeap;
    private final Comparator<? super T> ArrayHeapComparator;

    Heap(Comparator<? super T> comparator) {
        this.ArrayHeap = new ArrayList<>();
        this.ArrayHeapComparator = comparator;
    }

    
    public void add(T node) {
        ArrayHeap.add(node);
        UpSift();
    }

    public T remove() {
        
        // XXX
        if (ArrayHeap.isEmpty()) {
            return null;
        }

        T HeadNode = GetValue(0);
        T TailNode = ArrayHeap.remove(Last());

        if (!ArrayHeap.isEmpty()) {
            SetValue(0, TailNode);
            DownSift();
        }

        return HeadNode;
    }

    private void UpSift() {
        int index = Last();
        int ParentIndex = Parent(index);

        while (index != 0)
        {
            
            // Find the smaller node.
            if
            (
                ArrayHeapComparator.compare(
                    //WorkNode, 
                    GetValue(index),
                    GetValue(ParentIndex)
                ) >= 0
            ){
                
                break;
                
            } else { 
                
                //  Otherwise swap the parent node.
                SwapNodes(index, ParentIndex);
                index = ParentIndex;
                ParentIndex = Parent(index);
                
            }
        }
    }
    
    private void DownSift() {
        int Index = 0;
        T WorkNode = GetValue(Index);
        int Size = ArrayHeap.size();
        
        while (LeftChild(Index) < Size) {
            
            int LeftChildIndex = LeftChild(Index);
            int RightChildIndex = RightChild(Index);
            int MinChildIndex = LeftChildIndex;
            
            if (RightChildIndex < Size){
                
                // Find the smaller child
                if
                (
                    ArrayHeapComparator.compare(
                        GetValue(RightChildIndex), 
                        GetValue(LeftChildIndex)
                    ) < 0
                ){
                    
                    MinChildIndex = RightChildIndex;
                    
                } else {
                    
                    MinChildIndex = LeftChildIndex;
                }
            }

            // Stop if WorkNode is less-than-or-equal MinChildIndex.
            if
            (
                ArrayHeapComparator.compare(
                    WorkNode, 
                    GetValue(MinChildIndex)
                ) <= 0
            )
            {
                
                break;
                
            } else {
            
                //  Otherwise swap the smaller node.
                SwapNodes(Index, MinChildIndex);
                
            }
            
            // Reset the Index for next iteration
            Index = MinChildIndex;
        }

    }

    // Clone the Heap.
    public ArrayList<T> DeepCopy() {
        return new ArrayList<>(ArrayHeap);
    }
    
    // Returns parent node's Index possition.
    private Integer Parent(Integer idx){
        return (idx -1) / 2;
    }
    
    // Returns left child node Index possition.
    private Integer LeftChild(Integer idx){
        return (2 * idx) + 1;
    }
    
    // Returns right child node Index possition.
    private Integer RightChild(Integer idx){
        return (2 * idx) + 2;
    }
    
    // Returns last array node Index possition.
    private int Last(){
        return (this.ArrayHeap.size() - 1);
    }
    
    // Return the value of a given node.
    private T GetValue(Integer idx){
        return this.ArrayHeap.get(idx);
    }
    
    // Set the node value of a given Index possition.
    private void SetValue(Integer idx, T node){
        this.ArrayHeap.set(idx, node);
    }
    
    // Inefficient, but makes code look clean.
    private void SwapNodes(Integer idxA, Integer idxB){
        T NodeA = this.ArrayHeap.get(idxA);
        T NodeB = this.ArrayHeap.get(idxB);
        this.ArrayHeap.set(idxA, NodeB);
        this.ArrayHeap.set(idxB, NodeA);
    }
}