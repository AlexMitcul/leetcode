import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class StepByStepDirectionsFromBinaryTreeNodeToAnotherTest {
    private final StepByStepDirectionsFromBinaryTreeNodeToAnother solver = new StepByStepDirectionsFromBinaryTreeNodeToAnother();

    // root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
    public static Stream<Arguments> provideArguments() {
        return Stream.of(
            Arguments.of(TreeNode.deserialize("5,1,2,3,null,6,4,null,null,null,null"), 3, 6, "UURL"),
            Arguments.of(TreeNode.deserialize("2,1,null"), 2, 1, "L")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void stepByStepDirectionsFromBinaryTreeNodeToAnotherTest(TreeNode root, int startValue, int endValue, String expected) {
        String actual = solver.getDirections(root, startValue, endValue);

        assertEquals(expected, actual);
    }
}