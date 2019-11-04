//Alexander Howes
import java.util.*;
public class queue2 {
private ArrayList<Integer> arr;
public queue2 (){
    arr = new ArrayList<Integer>();
}
        public boolean isEmpty() {
            if(arr.isEmpty()) {
                return true;
            }
            return false;
        }
        public void loadValue(int val) {
            arr.add(val);
        }
        public int nextValue() {
            if(arr.size()<1) {
                return -1;
            }
            return arr.remove(0);
        }
        public void normalize() {
        int normalizer = arr.get(0);
        for(int crawler=0;crawler<arr.size();crawler++) {
            int newelement = arr.get(crawler);
            newelement=newelement-normalizer;
            arr.set(crawler, newelement);
        }
        }
        public int[] peek(int num) {
            int [] peek = new int[num];
            int crawler;
            for(crawler=0; crawler<num; crawler++) {
                peek[crawler]=arr.get(crawler);
            }
            return peek;
        }
        int size() {
            return arr.size();
        }
}