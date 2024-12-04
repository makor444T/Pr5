import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FiniteAutomatonTest {
    @ParameterizedTest
    @CsvSource({
            "abcTESTabc, 4",
            "abcTES, 3",
            "TEST, 4",
            "TTEST, 4",
            "abTESTTEST, 4",
            "TESTTESTtest, 4"
    })
    public void testFiniteAutomaton(String input, int expectedState) {
        FiniteAutomaton automaton = new FiniteAutomaton();
        int finalState = automaton.process(input);
        assertEquals(expectedState, finalState);
        if (expectedState == 4) {
            assertTrue(automaton.isAccepted());
        } else {
            assertFalse(automaton.isAccepted());
        }
    }

    @Test
    public void testNoMatch() {
        FiniteAutomaton automaton = new FiniteAutomaton();
        assertEquals(0, automaton.process("abcxyz"));
        assertFalse(automaton.isAccepted());
    }
}