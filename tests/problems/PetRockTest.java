package problems;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.Timeout;

import static org.junit.jupiter.api.Assertions.*;

class PetRockTest {
    private PetRock rocky;

    @Rule
    public Timeout globalTimeout = Timeout.millis(100);

    @BeforeEach
    void setUp() {
        rocky = new PetRock("Rocky");
    }

    @Test
    void testGetName() throws Exception{
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    void testUnhappyToStart() throws Exception{
        assertFalse(rocky.isHappy());
    }

    @Test
    void testHappyAfterPlay() throws Exception {
        rocky.play();
        assertTrue(rocky.isHappy());
    }

    @Test
    void testFailedException() throws Exception{
        assertThrows(IllegalStateException.class, () -> rocky.getHappyMessage());
    }

    @Test
    void testGetHappyMessage() throws Exception {
        rocky.play();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm Happy!", msg);
    }
}