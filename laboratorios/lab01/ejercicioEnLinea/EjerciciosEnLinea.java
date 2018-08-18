package ejerciciosenlinea;

public class EjerciciosEnLinea {
//Recursión 1

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }

        return 2 + bunnyEars(bunnies - 1);
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int bunnyEars2(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        }

        return 2 + bunnyEars2(bunnies - 1);
    }

    public int sumDigits(int n) {
        if (n <= 9) {
            return n;
        }

        return sumDigits(n / 10) + sumDigits(n % 10);
    }

    //Recursión 2:
    public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        } else {
            if (nums[start] == 6) {
                return groupSum6(start + 1, nums, target - 6);
            } else {
                return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);
            }

        }
    }

    public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        } else {
            return groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target);
        }

    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        } else {
            if (nums[start] % 5 == 0) {
                if (start <= nums.length - 2 && nums[start + 1] == 1) {
                    return groupSum5(start + 2, nums, target - nums[start]);
                } else {
                    return groupSum5(start + 1, nums, target - nums[start]);
                }
            }
        }
        return groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target);
    }

    public boolean splitArray(int[] nums) {
        return aux(nums, 0, 0, 0);
    }

    public boolean aux(int[] nums, int i, int m1, int m2) {
        if (i >= nums.length) {
            return m1 == m2;
        }
        if (aux(nums, i + 1, m1 + nums[i], m2)) {
            return true;
        }
        if (aux(nums, i + 1, m1, m2 + nums[i])) {
            return true;
        }
        return false;
    }

    public boolean groupSumClump(int start, int[] nums, int target) {
        if (start >= nums.length) {
            return target == 0;
        }
        int aux = start + 1;;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[start] == nums[i]) {
                aux++;
            } else {
                break;
            }
        }
        return groupSumClump(aux, nums, target - ((aux - start) * nums[start])) || groupSumClump(aux, nums, target);
    }

}
