public class ZigzagIterator {
    int one;
    int two;
    List<Integer> list1;
    List<Integer> list2;
    boolean fromOne;
    

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1 = v1;
        one = 0;
        list2 = v2;
        two = 0;
        fromOne = true;
    }

    public int next() {
        int eleToReturn;

        if(fromOne){
            fromOne = false;
            // return from first list
            if(one < list1.size()){
                eleToReturn = list1.get(one);
                one++;
            }
            else{
                eleToReturn = list2.get(two);
                two++;
            }
        }else{
            fromOne = true;
            // return from second list
            if(two < list2.size()){
                eleToReturn = list2.get(two);
                two++;
            }
            else{
                eleToReturn = list1.get(one);
                one++;
            }
        }

        return eleToReturn;
    }

    public boolean hasNext() {
        if(one + two == list1.size() + list2.size()) return false;
        else return true;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */