//Ejercicios Array-2


//Ejercicios Array-3
public int maxSpan(int[] nums) {
        int maxSpan = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum++;
                if (nums[i] == nums[j]) {
                    if (sum > maxSpan) {
                        maxSpan = sum;
                    }
                }
            }
        }
        return maxSpan;
    }
