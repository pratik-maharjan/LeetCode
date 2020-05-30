package problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCodeProblemsTest {
    private LeetCodeProblems tester = new LeetCodeProblems();

    @Test
    void isAnagram() throws Exception{
        assertTrue(tester.isAnagram("pratik", "kiartp"));
        assertFalse(tester.isAnagram("aacc", "ccac"));
    }

    @Test
    void firstUniqChar() throws Exception{
        assertEquals(0, tester.firstUniqChar("leetcode"));
        assertEquals(2, tester.firstUniqChar("loveleetcode"));
        assertEquals(6, tester.firstUniqChar("prete boy pratik"));
    }

    @Test
    void firstUniqCharUsingMaps() throws Exception{
        assertEquals(0, tester.firstUniqCharUsingMaps("leetcode"));
        assertEquals(2, tester.firstUniqCharUsingMaps("loveleetcode"));
        assertEquals(6, tester.firstUniqCharUsingMaps("prete boy pratik"));
    }

    @Test
    void checkStraightLine() throws Exception{
        int[][] input1 = {{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        assertFalse(tester.checkStraightLine(input1));
        int[][] input2 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        assertTrue(tester.checkStraightLine(input2));
        int[][] input3 = {{1,-8},{2,-3},{1,2}};
        assertFalse(tester.checkStraightLine(input3));
    }

    @Test
    void frequencySort() throws Exception{
        assertEquals("eert", tester.frequencySort("tree"));
        assertEquals("aaaccc", tester.frequencySort("cccaaa")) ;
        assertEquals("bbAa", tester.frequencySort("Aabb"));
        assertEquals("aaarhjmn", tester.frequencySort("maharjan"));
    }

    @Test
    void singleNumber() throws Exception {
        assertEquals(1, tester.singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, tester.singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(5, tester.singleNumber(new int[]{2, 2, 1, 3, 3, 4, 1, 5, 4}));
    }

    @Test
    void isHappy() throws Exception {
        assertTrue(tester.isHappy(19));
        assertFalse(tester.isHappy(2));
        assertTrue(tester.isHappy(7));
        assertFalse(tester.isHappy(573));
        assertFalse(tester.isHappy(88));
        assertTrue(tester.isHappy(10000));
    }

    @Test
    void countBits() throws Exception{
        assertArrayEquals(new int[]{0, 1, 1}, tester.countBits(2));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, tester.countBits(5));
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2,2}, tester.countBits(6));
        assertArrayEquals(new int[]{0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1,2,2,3,2,3,3,4,
                2,3,3,4,3,4,4,5,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,
                4,5,4,5,5,6,1,2,2,3,2,3,3,4,2,3,3,4,3,4,4,5,2,3,3,4,3,4,4,5,3,4,4,5,
                4,5,5,6,2,3,3,4,3}, tester.countBits(100));
    }

    @Test
    void checkRecord() throws Exception{
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
}