import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayOpsTest {

    @ParameterizedTest
    @MethodSource("returnLastFourArrayArgumentsProvider")
    void shouldReturnLastFoursArray(int[] out, int[] in){
        Assertions.assertArrayEquals(out,ArrayOps.doLastFourArrayReturn(in));
    }

    private static Stream<Arguments> returnLastFourArrayArgumentsProvider(){
        return Stream.of(
             Arguments.of(new int[]{1,7},new int[]{1,2, 4, 4, 2, 3, 4, 1, 7}),
             Arguments.of(new int[]{3,3,2,7,8},new int[]{1,2, 4, 4, 3, 3, 2, 7, 8}),
             Arguments.of(new int[]{7},new int[]{1,2, 4, 4, 2, 4, 4, 4, 7})
        );
    }
    @ParameterizedTest
    @MethodSource("shouldFindOneOrFourInArrayArgumentsProvider")
    void shouldFindOneOrFourInArrayPassed(boolean result, int[] in){
        Assertions.assertEquals(result ,ArrayOps.isFoursOrOneInIntArray(in));
    }

    private static Stream<Arguments> shouldFindOneOrFourInArrayArgumentsProvider(){
        return Stream.of(
                Arguments.of(true,new int[]{1,2, 4, 4, 2, 3, 4, 1, 7}),
                Arguments.of(false,new int[]{3,2, 2, 6, 5, 7, 8, 9, 3}),
                Arguments.of(true,new int[]{5,6, 7, 5, 2, 4, 4, 4, 8})
        );
    }

}