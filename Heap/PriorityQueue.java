/*************************************************************************
 *  Compilation:  javac PriorityQueue.java
 *  Execution:    java PriorityQueue 
 *
 *  Generic min priority queue implementation with a binary heap
 *
 *************************************************************************/
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The <tt>PriorityQueue</tt> class represents a priority queue of Elements.
 *  It supports the usual <em>insert</em> and <em>removeMin</em>
 *  funstions, as well as methods for peeking at the minimum key,
 *  checking if the priority queue is empty, and iterating through
 *  the Elments.
 *
 *	<i>Project 2</i> team member: George Wain, Zhengyi Yin, Zihang He, Yudi An
 *  @author Yudi An
 */

public class PriorityQueue<E> implements Iterable<E>{
	private static final int DEFULT_CAPACITY = 2;//default capacity of array

	private E[] PriorityQueue;	                             //store Element from 1 to N
	private int N = 0;                           // number of Element in array
	private Comparator<E> comparator;			//optional comparator

	/**
     * Initializes an priority queue with specific size.
     */
	public PriorityQueue(int initialCapacity){
		PriorityQueue = (E[]) new Object[initialCapacity+1];

	}

	/**
     * Initializes an priority queue with defult size.
     */
	public PriorityQueue(){
		this(DEFULT_CAPACITY);
	}

	/**
     * Initializes an priority queue with defult size.
     * using the given comparator.
     */
	public PriorityQueue(Comparator<E> comparator){
		this(DEFULT_CAPACITY,comparator);
	}

	/**
     * Initializes an priority queue with specific size.
     * using the given comparator.
     */
	public PriorityQueue(int initialCapacity, Comparator<E> comparator){
		this.comparator = comparator;
		PriorityQueue = (E[]) new Object[initialCapacity+1];
	}	

	/**
     * Initializes an priority queue with Element array.
     */
	public PriorityQueue(E[] e){
		this(e.length);
		for(int i=0;i<e.length;i++){
			E temp = e[i];
			insert(temp);
		}

	}
	
	/**
     * Returns the number of items in this PriorityQueue.
     * @return the number of items in this PriorityQueue
     */ 
	public int size(){
		return N;
	}

	/**
     * Is this PriorityQueue empty?
     * @return true if this PriorityQueue is empty; false otherwise
     */
	public boolean isEmpty(){
		return N == 0;
	}

	/**
     * get the minimun item from priority queue
     * @return the minimun item
     */
	public E getMin(){

		return PriorityQueue[1];
	}

	// resize the underlying array
	private void resize(int newcapacity){
		E[] temp = (E[]) new Object[newcapacity];
		for(int i=1; i<=N;i++){
			temp[i] = PriorityQueue[i];
		}
		PriorityQueue = temp;

	}

	/**
     * Adds the item to this priority queue.
     * @param item the item to add
     */
	public void insert(E e){
		if(N == PriorityQueue.length-1) 
			resize(2*PriorityQueue.length);
		N++;
		PriorityQueue[N] = e;
        heapUp(N);
	}

    /**
     * Removes and returns the item on this PriorityQueue that was least recently added.
     * @return the item on this queue that was least recently added 
     * @throws java.util.NoSuchElementException if this queue is empty
     */
	public E removeMin(){
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		swap(1,N);
		E min = PriorityQueue[N];
		N--;
		heapDown(1);
		PriorityQueue[N+1] = null; 
		if (N > 0 && N == (PriorityQueue.length-1)/4) resize(PriorityQueue.length/2);
		return min;
	}

	//helper function for insert operation
	private void heapUp(int n){
		while(n>1 && isBigger(n/2,n)){
			swap(n,n/2);
			n = n/2;
		}
	}

	//helper function for remoce operation
	private void heapDown(int n){
		while(2*n <= N){
			int w = 2*n;
			if(w < N && isBigger(w,w+1)){
				w++;
			}
			if(!isBigger(n,w)) break;
			swap(n,w);
			n=w;
		}
	}

	//switch the two item with their keys
	private void swap(int n, int m){
		E temp = PriorityQueue[n];
		PriorityQueue[n] = PriorityQueue[m];
		PriorityQueue[m] = temp;
	}
	//compare with two item
	private boolean isBigger(int i, int j){
		if (comparator == null) {
            return ((Comparable<E>) PriorityQueue[i]).compareTo(PriorityQueue[j]) > 0;
        }
        else {
            return comparator.compare(PriorityQueue[i], PriorityQueue[j]) > 0;
        }
	}

	/**
     * Returns an iterator that iterates over the items in this PriorityQueue in natural order.
     * @return an iterator that iterates over the items in  b  this PriorityQueue in natural order
     */
	public Iterator<E> iterator(){

        return new heapIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class heapIterator implements Iterator<E>{
        // create a new PriorityQueue
        private PriorityQueue<E> copy;

        public heapIterator(){
        	if (comparator == null) copy = new PriorityQueue<E>(size());
            else                    copy = new PriorityQueue<E>(size(), comparator);
            for (int i = 1; i <= N; i++)
                copy.insert(PriorityQueue[i]);
        }

        
        public boolean hasNext()  { return !copy.isEmpty();   }
        public void remove()      { throw new UnsupportedOperationException();  }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E item = copy.removeMin();           
            return item;
        }      
    }

    //unit test for PriorityQueue
    public static void main(String[] args){
    	Integer[] str = {2,1,3,4,5,6,7,8,10};
    	
    	PriorityQueue<Integer> PriorityQueue = new PriorityQueue<Integer>(str);
    	System.out.print(PriorityQueue.size() + " ");
        Iterator<Integer> itr = PriorityQueue.iterator();
      	while(itr.hasNext()) {
         Integer element = itr.next();
         System.out.print(element + " ");
      	}
      	System.out.println();
      	PriorityQueue.insert(100);
      	PriorityQueue.insert(120);
      	PriorityQueue.insert(0);
      	PriorityQueue.insert(104);
      	
      	Iterator<Integer> itr1 = PriorityQueue.iterator();
      	while(itr1.hasNext()) {
         Integer element = itr1.next();
         System.out.print(element + " ");
      	}

      	System.out.println(PriorityQueue.removeMin());
      	System.out.println(PriorityQueue.removeMin());
      	System.out.println(PriorityQueue.removeMin());
      	System.out.println(PriorityQueue.removeMin());
      	System.out.println(PriorityQueue.removeMin());
        
    }

}

