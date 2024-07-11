import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.junit.jupiter.api.Assertions.*;

class ReverseSubstringsBetweenEachPairofParenthesesTest {
    private final ReverseSubstringsBetweenEachPairofParentheses solver =
            new ReverseSubstringsBetweenEachPairofParentheses();

    @ParameterizedTest
    @CsvSource({
        "'(abcd)', 'dcba'",
        "'(u(love)i)', 'iloveu'",
        "'(ed(et(oc))el)', 'leetcode'",
    })
    public void testReverseParentheses(String input, String expected) {
        String actual = solver.reverseParentheses(input);

        assertEquals(expected, actual);
    }
}