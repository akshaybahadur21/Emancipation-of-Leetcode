/*

170. Two Sum III - Data structure design
Easy

Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false

*/

class TwoSum {

    /** Initialize your data structure here. */
    Map<Integer, Integer> map;
    public TwoSum() {
        this.map = new HashMap<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(int key : map.keySet()){
            int comp = value - key;
            if(map.containsKey(comp))
                if(key == comp && map.get(comp) >= 2 || key != comp && map.containsKey(comp)) return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

class TwoSum {

    /** Initialize your data structure here. */
    List<Integer> list;
    public TwoSum() {
        this.list = new ArrayList<>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(list);
        int lo = 0, hi = list.size() - 1;
        while(lo < hi){
            if(list.get(lo) + list.get(hi) == value) return true;
            if(list.get(lo) + list.get(hi) > value) hi--;
            else lo++;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
