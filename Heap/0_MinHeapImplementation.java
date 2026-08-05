/**
 * Problem Link : https://practice.geeksforgeeks.org/problems/min-heap-implementation/1
 * Platform     : GFG
 * Difficulty   : Easy
 */

class minHeap {
    
    private ArrayList<Integer> arr;
    private int heapSize;

    public minHeap() {
        arr = new ArrayList<>();
        heapSize=arr.size();
    }

    public void push(int x) {
        // Insert x into the heap
        arr.add(x);
        heapSize=arr.size();
        int curr=heapSize-1;
        while(curr>0 && arr.get(curr)<arr.get((curr-1)/2)){
            int parent =(curr-1)/2;
            int smallest = arr.get(curr);
            arr.set(curr,arr.get(parent));
            arr.set(parent,smallest);
            curr=parent;
        }
    }
    

    public void pop() {
        if (heapSize == 0) {
            return;
        }
        // Remove the top (minimum) element
        arr.set(0,arr.get(heapSize-1));
        arr.remove(heapSize-1);
        heapSize=arr.size();
        min_heapify(0);
    }

    public int peek() {
        // Return the top element or -1 if empty
        if(heapSize>0){
            return arr.get(0);
        }
        return -1;
    }

    public int size() {
        // Return the number of elements in the heap
        return heapSize;
    }
    private void min_heapify(int index){
        int min = index;
        int left = 2*index + 1;
        int right = 2*index+2;
        if (left<heapSize && arr.get(left)<arr.get(min)){
            min = left;
        }
        if(right<heapSize && arr.get(right)<arr.get(min)){
            min = right;
        }
        if(min==index){
            return;
        }
        //swap
        int minValue = arr.get(index);
        arr.set(index,arr.get(min));
        arr.set(min,minValue);
        //call min heapify
        min_heapify(min);
    
    }
}
