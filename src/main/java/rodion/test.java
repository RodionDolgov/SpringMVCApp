package rodion;

import java.util.HashMap;

public class test {
        public int[] retint(){
            int[] nums = new int[5];
            nums[0] = 1;
            nums[1] = 1;
            nums[2] = 2;
            nums[3] = 2;
            nums[4] = 3;
            return nums;
        }
        public int singleNumber(int[] nums) {
            HashMap <Integer, Integer> map = new HashMap<>();
            int result = 0;
            for(Integer item: nums){
                if(map.get(item) == null){
                    map.put(item,1);
                }else{
                    map.put(item,2);
                }
            }
            for(Integer item: nums){
                if(map.get(item) == 1){
                    result = map.get(item);
                }
            }
            return result;
        }
}
