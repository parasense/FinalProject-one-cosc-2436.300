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
        T tailNode = arrayHeap.remove(getLastIndex());

        if (!arrayHeap.isEmpty()) {
            setValue(0, tailNode);
            downSift();
        }

        return headNode;
    }

    private void upSift() {
        int index = getLastIndex();
        int parentIndex = getParentIndex(index);

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
                
                //  Otherwise swap the parent node.
                swapValues(index, parentIndex);
                index = parentIndex;
                parentIndex = getParentIndex(index);
                
            }
        }
    }
    
    private void downSift() {
        int index = 0;
        T workNode = getValue(index);
        int size = arrayHeap.size();
        
        while (getLeftChildIndex(index) < size) {
            
            int leftChildIndex = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            int minChildIndex = leftChildIndex;
            
            if (rightChildIndex < size){
                
                // Find the smaller child node
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

            // Stop if workNode is less-than-or-equal minChildIndex.
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
            
            // Reset the Index for next iteration
            index = minChildIndex;
        }

    }

    // Clone the Heap.
    public ArrayList<T> deepCopy() {
        return new ArrayList<>(arrayHeap);
    }
    
    // Returns parent node's Index possition.
    private Integer getParentIndex(Integer idx){
        return (idx -1) / 2;
    }
    
    // Returns left child node Index possition.
    private Integer getLeftChildIndex(Integer idx){
        return (2 * idx) + 1;
    }
    
    // Returns right child node Index possition.
    private Integer getRightChildIndex(Integer idx){
        return (2 * idx) + 2;
    }
    
    // Returns last array node Index possition.
    private int getLastIndex(){
        return (arrayHeap.size() - 1);
    }
    
    // Return the value of a given node.
    private T getValue(Integer idx){
        return arrayHeap.get(idx);
    }
    
    // Set the node value of a given Index possition.
    private void setValue(Integer idx, T node){
        arrayHeap.set(idx, node);
    }
    
    // Exchange nodes.
    private void swapValues(Integer idxA, Integer idxB){
        T NodeA = this.arrayHeap.get(idxA);
        arrayHeap.set(idxA, arrayHeap.get(idxB));
        arrayHeap.set(idxB, NodeA);
    }
}
