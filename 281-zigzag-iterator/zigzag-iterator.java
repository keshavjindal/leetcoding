public class ZigzagIterator {
    private int current;
  
    // Total number of vectors
    private int listCount;
  
    // List to keep track of the indexes of current read position for each vector.
    private List<Integer> indices = new ArrayList<>();
  
    // List holding the two input vectors.
    private List<List<Integer>> vectors = new ArrayList<>();

    // Constructor which initializes the ZigzagIterator with two lists (v1 and v2).
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        current = 0;
        listCount = 2; // Since we always have two lists (v1 and v2) for this iterator.
        indices.add(0);  // Adding initial indices for both vectors.
        indices.add(0);
        vectors.add(v1); // Adding the provided lists to the vectors list.
        vectors.add(v2);
    }

    // Returns the next element in the zigzag iteration.
    public int next() {
        // Get the current vector and the index for the element to return.
        List<Integer> vector = vectors.get(current);
        int index = indices.get(current);
        int result = vector.get(index); // Get the next element.
        indices.set(current, index + 1); // Update the index for the current vector.
        current = (current + 1) % listCount; // Move to the next vector.
        return result;
    }

    // Returns true if there is a next element in the iteration, false otherwise.
    public boolean hasNext() {
        int start = current; // Remember the starting point.
        // Cycle through the vectors to find if any vector still has elements left.
        while (indices.get(current) == vectors.get(current).size()) {
            current = (current + 1) % listCount; // Move to next vector.
            if (start == current) {
                // If we have cycled through all vectors without finding an element,
                // then there are no elements left, return false.
                return false;
            }
        }
        // If we have found a vector that still has elements, return true.
        return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */