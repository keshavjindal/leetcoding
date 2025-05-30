public class ZigzagIterator {
    Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if(v1.size() != 0) queue.add(v1.iterator());
        if(v2.size() != 0) queue.add(v2.iterator());
    }

    public int next() {
        Iterator rem = queue.remove();
        int res = (int)rem.next();
        if(rem.hasNext()) queue.add(rem);
        return res;
    }

    public boolean hasNext() {
        return queue.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */