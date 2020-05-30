// Pratik Maharjan
// LeetCode Problems


package problems;

import java.util.*;

public class LeetCodeProblems {

    /**
     * @param s the first string
     * @param t the second string
     * @return returns true of the strings are anagrams, else returns false. eg: pratik -> kraipt
     */
    // takes in two strings and returns true if they are anagrams, else returns false.
    public boolean isAnagram(String s, String t) {
        char[] str = s.toCharArray();
        char[] tr = t.toCharArray();

        if(s.length() != t.length()){
            return false;
        }

        Arrays.sort(str);
        Arrays.sort(tr);

        for(int i = 0; i < str.length; i++){
            if(str[i] != tr[i]){
                return false;
            }
        }

        return true;
    }

    /**
     * @param s takes in a string
     * @return returns the index of the first unique character in the string.
     */
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && i != j) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) return i;
        }
        return -1;
    }

    /**
     * @param s takes in a string
     * @return returns the index of the first unique character in the string.
     *
     * Solve this time using maps
     */
    public int firstUniqCharUsingMaps(String s) {
        char[] ch = s.toCharArray();
        char c = ' ';
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i]) == false) {
                map.put(ch[i], 1);
            } else {
                int oldVal = map.get(ch[i]);
                int newVal = oldVal + 1;
                map.put(ch[i], newVal);
            }
        }

        Set<Map.Entry<Character, Integer>> hmap = map.entrySet();

        for (Map.Entry<Character, Integer> data : hmap) {
            if (data.getValue() == 1) {
                c = data.getKey();
                // System.out.println(c);
                break;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param coordinates takes in two dimensional array that consists of coordinates. [[1,1],[2,2],[3,3]]
     * @return return true of the coordinates form a straight line.
     */
    public boolean checkStraightLine(int[][] coordinates){
        int x1=coordinates[0][0];
        int x2= coordinates[1][0];
        int y1=coordinates[0][1];
        int y2 = coordinates[1][1];
        for(int i=2;i<coordinates.length;i++){
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];

            // (y2-y1)/(x2-x1)  == (y3-y2)/(x3-x2)

            if((x2-x1)*(y3-y2) !=  (x3-x2)*(y2-y1))
            {
                //System.out.println(i);
                return false;
            }
        }
        return true;
    }

    /**
     * @param s Takes in a string s
     * @return returns a new altered string that has higher frequency characters in the front
     * ex: tree will become eetr or eert
     */
    public String frequencySort(String s) {
        HashMap<Character, Integer> table = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++){
            if(!table.containsKey(s.charAt(i))){
                table.put(s.charAt(i), 1);
            }
            else{
                int value = table.get(s.charAt(i));
                table.put(s.charAt(i), value+1);
            }
        }

        int max = 0;
        char keyCh = 0;
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < table.size(); i++){
            max = 0;
            for(char ch:table.keySet()){
                if(table.get(ch) > max){
                    keyCh = ch;
                    max = table.get(ch);
                }
            }
            if(max != 0){
                for(int j=0;j<max;j++){
                    answer.append(keyCh);
                }
                table.put(keyCh, 0);
            }
        }
        return answer.toString();
    }

    /**
     * @param nums Given a non-empty array of integers, every element appears twice except for one.
     * @return  Find that single one and return it.
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 1){
            return nums[0];
        }

        int value = 0;
        for(int i = 0; i < nums.length-1; i=i+2){
            if(nums[i] != nums[i+1]){
                value = nums[i];
                break;
            }
            if(i == nums.length-3){
                value = nums[nums.length-1];
                break;
            }
        }
        return value;
    }

    /**
     * @param n takes in an integer n
     * @return  returns true if the n is a happy number.
     *
     * A happy number is a number defined by the following process: Starting with any positive integer, replace the
     * number by the sum of the squares of its digits, and repeat the process until the number equals 1
     * (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this
     * process ends in 1 are happy numbers.
     */
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int newnum = n;

        while(newnum != 1){
            if(set.contains(newnum)){
                return false;
            }
            else{
                set.add(newnum);
            }
            newnum = singleNumberSplit(newnum);
        }
        return true;
    }

    /**
     * @param number takes in an integer
     * @return returns an integer that is the sum of the squares of its digits of the number.
     *
     * Part of the isHappy problem.
     */
    public int singleNumberSplit(int number){
        int num = 0;
        int value = 0;
        while(number >= 10){
            num = number%10;
            value = value + (num*num);
            number = number/10;
        }
        if(number > 0){
            num = number;
            value = value + (num*num);
        }
        return value;
    }

    /**
     * @param num takes in a positive integer
     * @return returns a int array
     *
     * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their
     * binary representation and return them as an array.
     *
     * Example:
     *  Input: 2
     *  Output: [0,1,1]
     */
    public int[] countBits(int num) {
        int[] array = new int[num+1];

        for(int i = 0; i < num+1; i ++){
            String binary = Integer.toBinaryString(i);
            int temp = 0;
            for(int j = 0; j < binary.length(); j++){
                if(binary.charAt(j) == '1'){
                    temp++;
                }
            }
            array[i] = temp;
        }
        return array;
    }

    /**
     * @param s takes in a string that consists of either "A": Absent or "P": Present or "L": Late
     * @return returns true if the attendance record deserved a reward.
     *
     * The attendance record deserves a reward if it doesn't contain
     * more than one 'A' (absent) or more than two continuous 'L' (late).
     */
    public boolean checkRecord(String s) {
        char[] array = s.toCharArray();
        int absent = 0;
        int late = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] == 'A'){
                absent++;
            }
        }
        for(int i = 0; i < array.length-2; i++){
            if(array[i] == 'L' && array[i+1] == 'L' && array[i+2] == 'L'){
                late++;
            }
        }
        if(absent > 1 || late > 0){
            return false;
        }
        return true;
    }

    /**
     * @param times
     * @param N
     * @param K
     * @return
     *
     * There are N network nodes, labelled 1 to N.
     * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node,
     * v is the target node, and w is the time it takes for a signal to travel from source to target.
     * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal?
     * If it is impossible, return -1.
     *
     * Example 1:
     *  Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
     *  Output: 2
     */
    public int networkDelayTime(int[][] times, int N, int K) {
        int value = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Set<Integer> set = new HashSet<>();

        for(int i = 1; i <= N; i++){
            set.add(i);
        }

        for(int i = 0; i < times.length; i++){
            if(times[i][0] == K){
                set.remove(times[i][1]);
                if(value < times[i][2]){
                    value++;
                }
            }
            else{
                value++;
            }

        }

        //if(set.isEmpty()){
        return value;
        //}
        //else{
        //    return -1;
        //}
    }

    /**
     * @param candies Array of candies per ith kid
     * @param extraCandies  int number of extra candies
     * @return list of boolean values
     *
     * Given the array candies and the integer extraCandies, where candies[i] represents
     * the number of candies that the ith kid has.
     * For each kid check if there is a way to distribute extraCandies among the kids such that
     * he or she can have the greatest number of candies among them.
     * Notice that multiple kids can have the greatest number of candies.
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> greatest = new ArrayList<Boolean>();
        int highest = 0;
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] > highest){
                highest = candies[i];
            }
        }
        for(int i = 0; i < candies.length; i++) {
            if((candies[i]+extraCandies) >= highest){
                greatest.add(true);
            }
            else{
                greatest.add(false);
            }
        }
        return greatest;
    }

    /**
     * @param nums takes in a int array with positive and negative numbers
     * @return  returns the sum of the contiguous subarray (containing at least one number) which has the largest sum
     */
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            currSum = currSum + nums[i];
            if(currSum > maxSum){
                maxSum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }

    /**
     * @param nums takes in a int array
     * @return returns the same int array but with all the zeros at the end of the array while all the
     * non-zero numbers remain in the same sequence.
     *
     * Example:
     *  Input: [0,1,0,3,12]
     *  Output: [1,3,12,0,0]
     */
    public int[] moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for(int z = j; z < nums.length; z++){
            nums[z] = 0;
        }
        return nums;
    }

}
