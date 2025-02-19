package problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeProblemsTest {
    private final LeetCodeProblems tester = new LeetCodeProblems();

    @Test
    void isAnagram() {
        assertTrue(tester.isAnagram("pratik", "kiartp"));
        assertFalse(tester.isAnagram("aacc", "ccac"));
    }

    @Test
    void firstUniqChar() {
        assertEquals(0, tester.firstUniqChar("leetcode"));
        assertEquals(2, tester.firstUniqChar("loveleetcode"));
        assertEquals(6, tester.firstUniqChar("prete boy pratik"));
    }

    @Test
    void firstUniqCharUsingMaps() {
        assertEquals(0, tester.firstUniqCharUsingMaps("leetcode"));
        assertEquals(2, tester.firstUniqCharUsingMaps("loveleetcode"));
        assertEquals(6, tester.firstUniqCharUsingMaps("prete boy pratik"));
    }

    @Test
    void checkStraightLine() {
        int[][] input1 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        assertFalse(tester.checkStraightLine(input1));
        int[][] input2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        assertTrue(tester.checkStraightLine(input2));
        int[][] input3 = {{1,-8},{2,-3},{1,2}};
        assertFalse(tester.checkStraightLine(input3));
    }

    @Test
    void frequencySort() {
        assertEquals("eert", tester.frequencySort("tree"));
        assertEquals("aaaccc", tester.frequencySort("cccaaa")) ;
        assertEquals("bbAa", tester.frequencySort("Aabb"));
        assertEquals("aaarhjmn", tester.frequencySort("maharjan"));
    }

    @Test
    void singleNumber() {
        assertEquals(1, tester.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, tester.singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(5, tester.singleNumber(new int[]{2, 2, 1, 3, 3, 4, 1, 5, 4}));
    }

    @Test
    void isHappy() {
        assertTrue(tester.isHappy(19));
        assertFalse(tester.isHappy(2));
        assertTrue(tester.isHappy(7));
        assertFalse(tester.isHappy(573));
        assertFalse(tester.isHappy(88));
        assertTrue(tester.isHappy(10000));
    }

    @Test
    void countBits() {
        assertArrayEquals(new int[]{0, 1, 1}, tester.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, tester.countBits(5));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2,2}, tester.countBits(6));
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,
                2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,
                4,5,4,5,5,6,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,
                4,5,5,6,2,3,3,4,3}, tester.countBits(100));
    }

    @Test
    void checkRecord() {
        assertTrue(tester.checkRecord("PPALLP"));
        assertFalse(tester.checkRecord("PPALLL"));
        assertFalse(tester.checkRecord("PPAALL"));
        assertTrue(tester.checkRecord("PPPPP"));
        assertFalse(tester.checkRecord("PPAALLL"));
    }

    @Test
    void kidsWithCandies() {
        List<Boolean> test1 = new ArrayList<>(List.of(true, true, true, false, true));
        assertEquals(test1, tester.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));

        List<Boolean> test2 = new ArrayList<>(List.of(true, false, false, false, false));
        assertEquals(test2, tester.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));

        List<Boolean> test3 = new ArrayList<>(List.of(true,false,true));
        assertEquals(test3, tester.kidsWithCandies(new int[]{12,1,12}, 10));
    }

    @Test
    void maxSubArray() {
        assertEquals(6, tester.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(11, tester.maxSubArray(new int[]{5, -1, 3, 4}));
        assertEquals(7, tester.maxSubArray(new int[]{5, -10, 3, 4}));
        assertEquals(-3, tester.maxSubArray(new int[]{-5, -10, -3, -4}));
    }

    @Test
    void moveZeroes() {
        assertArrayEquals(new int[]{1,3,12,0,0}, tester.moveZeroes(new int[]{0,1,0,3,12}));
        assertArrayEquals(new int[]{1,3,12,15,100}, tester.moveZeroes(new int[]{1,3,12,15,100}));
        assertArrayEquals(new int[]{0,0,0,0,0}, tester.moveZeroes(new int[]{0,0,0,0,0}));
        assertArrayEquals(new int[]{1,0}, tester.moveZeroes(new int[]{0,1}));
        assertArrayEquals(new int[]{1,1,1,0,0,0}, tester.moveZeroes(new int[]{0,1,0,1,0,1}));
        assertArrayEquals(new int[]{1,23,33,5,88,0,0,0}, tester.moveZeroes(new int[]{0,1,23,33,0,5,88,0}));

    }

    @Test
    void maxProfit() {
        assertEquals(7, tester.maxProfit(new int[]{7,1,5,3,6,4}));
        assertEquals(4, tester.maxProfit(new int[]{1,2,3,4,5}));
        assertEquals(0, tester.maxProfit(new int[]{7,6,4,3,1}));
        assertEquals(1, tester.maxProfit(new int[]{6,7}));
        assertEquals(14, tester.maxProfit(new int[]{2,6,8,4,1,3,9}));
    }

    @Test
    void groupAnagrams() {
        List<List<String>> test1 = new ArrayList<>(List.of(List.of("tan","nat"),List.of("bat"),List.of("eat","tea","ate")));
        assertEquals(test1, tester.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        List<List<String>> test2 = new ArrayList<>(List.of(List.of("ccac"),List.of("aacc"),List.of("pratik","kiartp")));
        assertEquals(test2, tester.groupAnagrams(new String[]{"pratik", "aacc", "kiartp", "ccac"}));
    }

    @Test
    void twoCitySchedCost() {
        assertEquals(110, tester.twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        assertEquals(1859, tester.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
    }

    @Test
    void reverseString() {
        assertArrayEquals(new char[]{'o', 'l', 'l', 'e', 'h'}, tester.reverseString(new char[]{'h','e','l','l','o'}));
        assertArrayEquals(new char[]{'k', 'i', 't', 'a', 'r', 'p'}, tester.reverseString(new char[]{'p','r','a','t','i', 'k'}));

    }

    @Test
    void maxProduct() {
        assertEquals(12, tester.maxProduct(new int[]{3,4,5,2}));
        assertEquals(16, tester.maxProduct(new int[]{1,5,4,5}));
        assertEquals(12, tester.maxProduct(new int[]{3,7}));
    }
}