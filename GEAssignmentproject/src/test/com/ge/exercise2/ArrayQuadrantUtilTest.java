package test.com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;
import main.com.ge.exercise2.ArrayQuadrantUtil;
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {
	Character[][] data = {
            {'a', 'b', 'c', 'd'},
            {'e', 'f', 'g', 'h'},
            {'i', 'j', 'k', 'l'},
            {'m', 'n', 'o', 'p'}
    };
	
	/*Integer[][] data = { 
	{ 1, 2, 3, 4 }, 
	{ 5, 6, 7, 8 },
	{ 9, 10, 11, 12 },
	{ 13, 14, 15, 16 }
	};*/
	
	@SuppressWarnings("rawtypes")
	@Test
	public void getnoOfDivisorTest(){
		ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
		
		int[] expectedResult = {2};
		assertArrayEquals(expectedResult, util.noOfDivisor(data[0].length));
		
		
	}

    @SuppressWarnings("rawtypes")
	@Test
    public void getQuadrantValuesTest() {
       
        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValues(0,0));

        Object[] expectedResult = {'a', 'b', 'e', 'f'};
//        Object[] expectedResult = {1,2,5,6};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0));
    }
    
      
    @SuppressWarnings("rawtypes")
	@Test
    public void getRowQuadrantValuesOfRowTest() {
      
        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValuesForRow(0));
        
        Object[] expectedResult = {'a', 'b', 'c', 'd'};
//        Object[] expectedResult = {1,2,3,4};
        assertArrayEquals(expectedResult, util.getQuadrantValuesForRow(0));
        
        
    }
    
    @SuppressWarnings("rawtypes")
	@Test
    public void getColQuadrantValuesOfColTest() {
       
        ArrayQuadrantUtil util = new ArrayQuadrantUtil(data);
        Assume.assumeNotNull(util.getQuadrantValuesForCol(0));
        
        Object[] expectedResult = {'a', 'e', 'i', 'm'};
//        Object[] expectedResult = {1,5,9,13};
        assertArrayEquals(expectedResult, util.getQuadrantValuesForCol(0));
        
        
    }
    
   
}