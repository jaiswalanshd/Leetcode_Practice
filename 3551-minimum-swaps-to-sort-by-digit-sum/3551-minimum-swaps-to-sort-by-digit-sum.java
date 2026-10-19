class Solution {
    public int digitsum(int num){
        int sum = 0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=0;i<n;i++){
            ans[i]=nums[i];
        }

        Arrays.sort(ans, (a,b) -> {
            int sum1 = digitsum(a);
            int sum2 = digitsum(b);

            if(sum1 == sum2){
                return Integer.compare(a,b);
            }

            return Integer.compare(sum1,sum2);
        });

        int swap = 0;
        for(int i=0;i<n;i++){
            mpp.put(nums[i],i);
        }
        for(int i = 0;i < n;i++){
            if(nums[i] != ans[i]){
                int j = mpp.get(ans[i]);
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;

                mpp.put(nums[i],i);
                mpp.put(nums[j],j);

                swap++;
            }
        }
        return swap;
    }
}