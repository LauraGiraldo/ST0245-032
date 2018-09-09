//Array-2

public int countEvens(int[] nums) {
  int count=0;
  for(int i=0; i<nums.length;i++){
    if(nums[i]%2==0)
     count+=1;
   }
  return count;
}

public int bigDiff(int[] nums) {
  int max=nums[0];
  int min=nums[0];
  if(nums.length==2){
    if(nums[0]<nums[1])
    return nums[1]-nums[0];
    else
    return nums[0]-nums[1];
  }
  for(int i=1; i<nums.length-1; i++){
    if(max < Math.max(nums[i],nums[i+1]))
        max= Math.max(nums[i],nums[i+1]);
    if(min>Math.min(nums[i],nums[i+1]) )
        min= Math.min(nums[i],nums[i+1]);
    
  }
  return max-min;
}

public int centeredAverage(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int suma = 0;
        for (int i = 0; i < nums.length; i++) {
          suma += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return (suma - min - max) / (nums.length - 2);
    }

public int sum13(int[] nums) {
  int sum=0;
  for(int i=0; i<nums.length; i++){
    if(nums[i]==13)
    i++;
    else
    sum+= nums[i];
  }
  return sum;
}


public int sum67(int[] nums) {
  int sum=0; 
  if(nums.length <1)
  return 0;
  
  for(int i=0; i< nums.length;i++){
    if(nums[i]==6){
      while(nums[i]!=7)
      i++;
    }
    else
    sum+=nums[i];
  }
  
  return sum;
}
//Array-3
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

public int[] fix34(int[] nums) {
        int[] aux = nums;
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == 3) {
                if (aux[i + 1] != 4) {
                    for (int j = 0; j < aux.length; j++) {
                        if (nums[j] == 4 && nums[j - 1] != 3) {
                            nums[j] = aux[i + 1];
                            aux[i + 1] = 4;
                        }
                    }
                }
            }
        }
        return aux;
    }

public int[] fix45(int[] nums) {
        int[] aux = nums;
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == 4) {
                if (aux[i + 1] != 5) {
                    for (int j = 0; j < aux.length; j++) {
                        if (j-1 >= 0 && nums[j] == 5 && nums[j - 1] != 4) {
                            nums[j] = aux[i + 1];
                            aux[i + 1] = 5;
                        }else if(j == 0 && nums[j] == 5){
                          nums[j] = aux[i + 1];
                            aux[i + 1] = 5;
                        }
                    }
                }
            }
        }
        return aux;
    }


public boolean canBalance(int[] nums) {
 int sum1=0;

 for(int i=0; i<nums.length; i++){
   sum1+=nums[i];
  
   int sum2=0;
 for(int j=nums.length-1; j > i;j--){
   sum2+=nums[j];
 }
 if(sum1==sum2)
 return true;
 
 }

 return false;
}


