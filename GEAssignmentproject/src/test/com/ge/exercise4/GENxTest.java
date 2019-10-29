package test.com.ge.exercise4;

import static org.junit.Assert.assertEquals;
import main.com.ge.exercise4.GENx;

import org.junit.Before;
import org.junit.Test;

public class GENxTest {

    GENx testEngine;

    @Before
    public void setUp() {
        testEngine = new GENx("0001");
    }

    @Test
    public void toStringTest() {
        assertEquals("GENx SN: 0001", testEngine.toString());
    }

    @Test
    public void thrustToWeightRatioTest() {
        assertEquals(testEngine.takeoffThrust / testEngine.wetWeight, testEngine.thrustToWeightRatio(), 0.01);
    }
}