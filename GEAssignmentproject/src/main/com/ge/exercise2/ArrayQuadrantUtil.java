package main.com.ge.exercise2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayQuadrantUtil<T> {
	private static final Logger logger = LogManager
			.getLogger(ArrayQuadrantUtil.class);

	private T[][] data;

	@SuppressWarnings("unchecked")
	public ArrayQuadrantUtil(Object[][] data) {
		this.data = (T[][]) data;
	}

	public int[] noOfDivisor(int input) {
		int mid = input / 2;
		int[] totalNoOfDivisor = new int[mid];
		int counter = 0;
		for (int i = 2; i <= mid; i++) {
			if (input % i == 0) {
				totalNoOfDivisor[counter++] = i;
			}
		}

		int[] resultData = new int[counter];
		System.arraycopy(totalNoOfDivisor, 0, resultData, 0, counter);

		return resultData;
	}

	@SuppressWarnings("unchecked")
	public T[] getQuadrantValuesForRow(int row) {
		int length = data[0].length;
		T[] resultData = (T[]) new Object[length];

		for (int i = 0; i < length; i++) {
			resultData[i] = data[row][i];
		}
		return resultData;
	}

	@SuppressWarnings("unchecked")
	public T[] getQuadrantValuesForCol(int col) {
		int length = data.length;
		T[] resultData = (T[]) new Object[length];

		for (int i = 0; i < length; i++) {
			resultData[i] = data[i][col];
		}
		return resultData;
	}

	@SuppressWarnings("unchecked")
	public T[] getQuadrantValues(int row, int column) {
		int mid =(data[0].length) / 2;
		int length = mid*mid;
		T[] resultData = (T[]) new Object[length];
		int counter = 0;

		for (int i = 0, l = row; i < mid; i++, l++) {
			for (int j = 0, k = column; j < mid; j++, k++) {
				if (counter == length)
					break;				
				resultData[counter++] = data[l][k];

			}

		}
		return resultData;
	}

	@SuppressWarnings("unchecked")
	public void getPartitionOfArray(int row, int column) {

		int[] arrayQuadrants = noOfDivisor(data[0].length);
		T[] resultData = null;

		for (int out = 0; out < arrayQuadrants.length; out++) {
			int length = arrayQuadrants[out] * arrayQuadrants[out];

			resultData = (T[]) new Object[length];
			int counter = 0;

			System.out.println("Generating the array of length: "
					+ arrayQuadrants[out]);
			for (int i = 0, l = row; i < arrayQuadrants[out]; i++, l++) {

				for (int j = 0, m = column; j < arrayQuadrants[out]; j++, m++) {
					resultData[counter++] = data[l][m];
				}
			}
			for (int i = 0; i < resultData.length; i++) {
				System.out.print(resultData[i] + " ");
			}
			System.out.println(" ");

		}

	}

	public static void main(String[] args) {
		
		//8*8 test array
		
		/*Character[][] data = {
				{ 'a', 'b', 'c', 'd', 'W', 'Y', 'Z', 'P' },
				{ 'e', 'f', 'g', 'h', 'W', 'Y', 'Z', 'P' },
				{ 'i', 'j', 'k', 'l', 'W', 'Y', 'Z', 'P' },
				{ 'm', 'n', 'o', 'p', 'W', 'Y', 'Z', 'P' },
				{ 'z', 'x', 'c', 'v', 'W', 'Y', 'Z', 'P' },
				{ 'p', 'h', 'k', 'l', 'W', 'Y', 'Z', 'P' },
				{ 'o', 'y', 'r', 't', 'W', 'Y', 'Z', 'P' },
				{ 'o', 'y', 'r', 't', 'W', 'Y', 'Z', 'P' } };*/
		
		//Test Array ofInteger type
		
		/*Integer[][] data = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 },
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 }
				};*/
		
		Character[][] data = {
	            {'a', 'b', 'c', 'd'},
	            {'e', 'f', 'g', 'h'},
	            {'i', 'j', 'k', 'l'},
	            {'m', 'n', 'o', 'p'}
	    };

		ArrayQuadrantUtil<Object> util = new ArrayQuadrantUtil<>(data);

		Object[] resultForCol = util.getQuadrantValuesForCol(0);
		Object[] resultForRow = util.getQuadrantValuesForRow(0);
		Object[] result = util.getQuadrantValues(0, 0);
		System.out.println("\n------------Result for getQuadrantValues-----------------------");

		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");

			logger.info(result[i]);
		}
		System.out.println("\n----------Result for getQuadrantValuesForCol-------------------------");
		for (int i = 0; i < resultForCol.length; i++) {
			System.out.print(resultForCol[i] + " ");

			logger.info(resultForCol[i]);
		}
		System.out.println("\n--------------Result for getQuadrantValuesForRow---------------------");
		for (int i = 0; i < resultForRow.length; i++) {
			System.out.print(resultForRow[i] + " ");

			logger.info(resultForRow[i]);
		}
		System.out.println("\n--------------Result for getPartitionOfArray---------------------");
		util.getPartitionOfArray(0, 0);
	}
}
