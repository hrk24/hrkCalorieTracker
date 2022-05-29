package com.springboot.hrk.calorietracker.util;

import java.util.*;

import static java.lang.Math.abs;

public class LeetCodeUtil {

    public static void main(String[] args) {
        LeetCodeUtil.twoSum(new int[]{3, 2, 4}, 6);
        LeetCodeUtil.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }

    static int hammingweight(int n) {
        String bitString = Integer.toBinaryString(n);
        ;
        int count = 0;
        for (int i = 0; i < bitString.length(); i++) {
            if (Character.valueOf(bitString.charAt(i)) == Character.valueOf('1')) {
                count++;
            }
        }
        return count;
    }

    //optimized using binary subtraction
    static int hammingweightOptimized(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n & n - 1);
        }
        return count;
    }

    //custom code to convert decimal to binary
    static String convertDecimalToBinary(int n) {
        //binary array
        List binaryArrList = new ArrayList();

        // array to store binary number
        int[] binaryNum = new int[1000];
        // counter for binary array
        int i = 0;
        while (n > 0) {
            // storing remainder in binary array
            binaryNum[i] = n % 2;
            n = n / 2;
            i++;
        }

        // printing binary array in reverse order
        for (int j = i - 1; j >= 0; j--)
            binaryArrList.add(binaryNum[j]);

        return binaryArrList.toString();
    }

    static int sumAndProductOfIntegerDigits(int n) {
        int rem;
        int product = 1, sum = 0;
        List<Integer> digList = new ArrayList();

        while (n > 0) {
            rem = n % 10;
            n = n / 10;
            digList.add(rem);
            sum += rem;
            product *= rem;
        }

       /* if(!digList.contains(Integer.valueOf(0))) {
            for (Integer obj : digList) {
                if (obj.intValue() > 0) {
                    product = product * obj.intValue();
                }
                sum = sum+obj.intValue();
            }
        } else {
            product = 0;
            for (Integer obj : digList) {
               sum = sum+obj.intValue();
            }
        }*/

        return product - sum;
    }

    static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i + 1] > A[i + 2])
                return A[i] + A[i + 1] + A[i + 2];
        return 0;

    }

    static int nearestValidPoint(int x, int y, int[][] points) {
        //Find valid points
        int[][] validpoints = new int[points.length][points.length];
        int k = 0;
        int index = 0;
        boolean isZero = false;
        int temp = 0;
        int mandistance = -1;
        List<List<Integer>> validList = new ArrayList<>();
        List<Integer> distList = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                validpoints[k] = points[i];
                k++;
                validList.add(Arrays.asList(new Integer[]{points[i][0], points[i][1]}));
            }
        }

        for (int i = validList.toArray().length; i >= 0; i--) {
            //temp = abs(validpoints[i][0]-validpoints[i+1][0]) + abs(validpoints[i][1]-validpoints[i+1][1]);
            temp = abs(validpoints[i][0] - x) + abs(validpoints[i][1] - y);
            if (mandistance == -1 || mandistance > temp) {
                mandistance = temp;
                index = i;
            }
            distList.add(temp);
        }

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == validpoints[index][0] && points[i][1] == validpoints[index][1]) {
                index = i;
                isZero = true;
                break;
            }
        }

        if (!isZero) index = -1;

        return index;
    }

    static int nearestValidPointTest(int x, int y, int[][] points) {
        //Find valid points
        int index = 0;
        boolean isZero = false;
        int mandistance = -1;

        for (int i = 0; i < points.length; i++) {
            if (points[i][0] == x || points[i][1] == y) {
                //This is a valid point -- calc distance from position
                isZero = true;
                int distance = distance(x, y, points[i][0], points[i][1]);
                if (mandistance == -1 || mandistance > distance) {
                    mandistance = distance;
                    index = i;
                }
            }
        }
        if (!isZero) return -1;
        return index;
    }

    static int distance(int x, int y, int x1, int y1) {
        return Math.abs(x - x1) + Math.abs(y - y1);
    }

    //two sum
    static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> ipMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            ipMap.put(nums[i],i);
        }

        for(int i=0;i<nums.length;i++){
            int check = target - nums[i];
            if(ipMap.containsKey(check) && ipMap.get(check)!=i){
                return new int[]{i,ipMap.get(check)};
            }
        }

        return new int[]{1};
    }

    //Remove Duplicates From Array
    static int removeDuplicates(int[] nums){
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i]!=nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
