package edu.ncsu.csc316.transportation_manager.list;

/**
 * An Array Based Data Structure that automatically
 * resizes when needed.
 * 
 * @author Nicholas Board (ndboard)
 * @param <E> Generic data type.
 */
@SuppressWarnings("unchecked")
public class ArrayBasedList<E> {

	/** The number of objects in the array. */
	private int size;
	/** The array of objects. */
	private E[] items;

	/**
	 * Constructor of the ArrayBasedList.
	 */
	public ArrayBasedList() {
		
		size = 0;
		items = (E[]) new Object[1];
	}
	
	/**
	 * Gets an object from the ArrayBasedList.
	 * @param idx The index to retrieve the desired object from.
	 * @return The object at specified index.
	 */
	public E lookUp(int idx) {
		
		return items[idx];
	}
	
	/**
	 * Removes an object from the ArrayBasedList.
	 * @param idx The index of the object you want to remove.
	 * @return The removed object.
	 */
	public E remove(int idx) {
		
		E removed = items[idx];
		
		for( int i = idx; i < size - 1; i++ ) {
			
			items[i] = items[i + 1];
		}
		size--;
		
		return removed;
	}
	
	/**
	 * Adds a new object to the end of the ArrayBasedList
	 * , resizing the ArrayBasedList if necessary.
	 * @param o The item o to add to the ArrayBasedList.
	 */
	public void insert( Object o ) {

		if ( items.length == size )
			items = resize(items);
		
		items[ size ] = (E) o;
		size++;
	}
	
	/**
	 * Adds a new object at the specified index in the
	 * ArrayBasedList, resizing if necessary.
	 * @param o The object o to add to the ArrayBasedList.
	 * @param idx The idx to insert the new object at.
	 */
	public void insertAt( Object o, int idx ) {
		
		if ( items.length == size )
			items = resize(items);
		
		while( items.length <= idx ) {
			items = resize(items);
		}
		
		for( int i = idx; i < size; i++ ) {
			
			items[i + 1] = items[i];
		}
		
		items[idx] = (E) o;
		size++;
	}

	/**
	 * Sets an item into a slot in the ArrayBasedList.
	 * @param slot The slot to set the new item at.
	 * @param newItem The new item to set in the slot.
	 */
	public void replace(int slot, E newItem) {
		items[slot] = newItem;
	}
	
	/**
	 * Gets the ArrayBasedList's size.
	 * @return the size of the ArrayBasedList.
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Indicates if or if not the  array is empty.
	 * @return true if size is zero, otherwise false.
	 */
	public boolean isEmpty() {
		
		return (this.size <= 0);
	}
	
	/**
	 * Swaps two objects in an ArrayBasedList.
	 * @param i The location of the first object to swap.
	 * @param j The location of the second object to swap.
	 */
	public void swap(int i, int j) {
		E temp = this.lookUp(i);
		this.replace(i, this.lookUp(j));
		this.replace(j, temp);
	}
	
	/**
	 * Resizes the given ArrayBasedList to
	 * one that is double the current size.
	 * @param The list to double the size of.
	 * @return The new list that is doubled. 
	 */
	private E[] resize( E[] list ) {
		
		E[] newList = (E[]) new Object[ size * 2 ];
		
		for( int i = 0; i < size; i++ ) {
			
			newList[i] = list[i];
		}
		
		return newList;
	}
}
