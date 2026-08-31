class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> count =new HashMap<>();
        int res=0,max_count=0;
        for(int num:nums){
            count.put(num,count.getOrDefault(num,0)+1 );
            if(count.get(num)>max_count){
                res=num;
                max_count=count.get(num);
            }
        }
        return res;
    }
}