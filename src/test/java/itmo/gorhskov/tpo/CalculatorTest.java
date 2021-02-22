package itmo.gorhskov.tpo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static itmo.gorhskov.tpo.Calculator.sin;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("Check PI dots")
    void checkPiDots() {
        assertAll(
                () -> assertEquals(0, sin(-Math.PI)),
                () -> assertEquals(-1, sin(-Math.PI / 2)),
                () -> assertEquals(0, sin(0)),
                () -> assertEquals(1, sin(Math.PI / 2)),
                () -> assertEquals(0, sin(Math.PI)),
                () -> assertEquals(0, sin(3 * Math.PI))
        );
    }

    @Test
    @DisplayName("Check dots from (-PI, PI)")
    void checkDots() {
        assertAll(
                () -> assertEquals(-0.842, sin(-2.14)),
                () -> assertEquals(-0.921, sin(-1.17)),
                () -> assertEquals(0.932, sin(1.2)),
                () -> assertEquals(0.259, sin(2.88)),
                () -> assertEquals(-0.49, sin(-2.63)),
                () -> assertEquals(-0.605, sin(-0.65)),
                () -> assertEquals(0.548, sin(0.58)),
                () -> assertEquals(0.638, sin(2.45)),
                () -> assertEquals(0.638, sin(2.45 + 2 * Math.PI))
        );
    }
}