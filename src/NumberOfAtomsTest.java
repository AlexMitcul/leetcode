import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfAtomsTest {
    private final NumberOfAtoms solver = new NumberOfAtoms();

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of(
                    "H2O",
                    "H2O"
                ),
                Arguments.of(
                    "Mg(OH)2",
                    "H2MgO2"
                ),
                Arguments.of(
                    "K4(ON(SO3)2)2",
                    "K4N2O14S4"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void robotCollisionsTest(String formula, String expected) {
        String actual = solver.countOfAtoms(formula);

        assertEquals(expected, actual);
    }
}