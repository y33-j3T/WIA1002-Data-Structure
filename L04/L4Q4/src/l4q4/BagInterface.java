package l4q4;

public interface BagInterface<T> {

    /** Gets the current number of entries in this bag.
        @return the integer number of entries currently in the bag */
    public int getCurrentSize();

    /** Sees whether this bag is full.
        @return true if the bag is full, or false if not */
    public boolean isFull();

    /** Sees whether this bag is empty.
        @return true if the bag is empty, or false if not */
    public boolean isEmpty();

    /** Adds a new entry to this bag.
        @param newEntry the object to be added as a new entry
        @return true if the addition is successful, or false if not */
    public boolean add(T newEntry);

    /** Removes one unspecified entry from this bag, if possible.
        @return either the removed entry, if the removal was successful, or null */
    public T remove();

    /** Removes one occurrence of a given entry from this bag.
        @param anEntry the entry to be removed
        @return true if the removal was successful, or false if not */
    public boolean remove(T anEntry);

    /** Removes all entries from this bag.*/
    public void clear();

    /** Counts the number of times a given entry appears in this bag.
        @param anEntry the entry to be counted
        @return the number of times anEntry appears in the bag */
    public int getFrequencyOf(T anEntry);

    /** Tests whether this bag contains a given entry.
        @param anEntry the entry to locate
        @return true if this bag contains anEntry, or false otherwise */
    public boolean contains(T anEntry);

    /** Retrieves all entries that are in this bag.
        @return a newly allocated array of all the entries in the bag */
    public T[] toArray();
    
    /** Retrieve a new bag containing items in both the bag receiving the call 
        to the method and the bag that is the method’s argument
        @param anotherBag the items from another bag to be added
        @return a new bag containing item from both original and another bag */
    public BagInterface<T> union(BagInterface<T> anotherBag);
    
    /** Retrieve a new bag containing overlapping items in the bag receiving the call 
        to the method and the bag that is the method’s argument
        @param anotherBag the items from another bag 
        @return a new bag containing overlapping item from original and another bag */
    public BagInterface<T> intersection(BagInterface<T> anotherBag);
    
    /** Retrieve a new bag containing the items that would be left in the bag receiving
        the call to the method after removing those that also occur in the bag that is 
        the method's argument.
        @param anotherBag the items from another bag 
        @return a new bag containing difference of two bags */
    public BagInterface<T> difference(BagInterface<T> anotherBag);
} // end BagInterface


