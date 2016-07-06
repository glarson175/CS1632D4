import java.util.Random;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.lang.System;
	
public class CS1632D4 {

	public static void main (String args[]){
	
		int[] test = GenerateRandomArray();
		
		System.out.println(Arrays.toString(test)+ " " + Arrays.toString(laboonify(test)));
	}
	
	public static int[] GenerateRandomArray() {
		Random rand = new Random();
		int randomSize;
		int randomInt;
		
		randomSize = rand.nextInt(100)+1;//values from 1 to 100
		
		int[] RandArray = new int[randomSize];// sizes between 1 and 100


		for(int i = 0; i < randomSize; i++) {
			randomInt = rand.nextInt(100)+1;
			RandArray[i] = randomInt;
		}
		
		return RandArray;

	}
	
	public static int[] laboonify(int[] array){

		int[] ReturnArray = new int[array.length+1];
		int total = 0;
		for(int i = 0; i < array.length; i++){
			
			ReturnArray[i] = array[i]*array[i];
			total += ReturnArray[i];
		}
		ReturnArray[array.length] = total; //adds total to the last element in the array
		return ReturnArray;
		
	}

	//Test that the size of the Laboon Array is one larger than the original Array
	@Test 
	public void LaboonifySizeEqualsOriginalPlusOne(){
		
		int NumberOfArrays = 0;
		boolean pass = false;
		while (NumberOfArrays <100)
		{
			int[] randArray = GenerateRandomArray();
			
			int[] laboonArray = laboonify(randArray);
			
			if (laboonArray.length == (randArray.length)+1)
			{
				pass = true;
			}
			else{
				pass = false;
				break;
			}
			
			NumberOfArrays++;
		}
		assertTrue(pass);
	}
	
	//Test that each element of the Laboonify Array is actually Squared correctly
	@Test
	public void TestElementsSqaured(){
		
		int NumberOfArrays = 0;
		boolean pass = false;
		while (NumberOfArrays <100)
		{
			int[] randArray = GenerateRandomArray();
			
			int[] laboonArray = laboonify(randArray);
			
			for(int i = 0; i < randArray.length; i++)
			{
				if(laboonArray[i]==Math.pow(randArray[i], 2))
				{
					pass = true;
				}
				else{
					pass = false;
					break;
				}
			}
			if (!pass){
				break;
			}
			NumberOfArrays++;
		}
		assertTrue(pass);
	}
	
	//Test that the last element in the Laboon Array is equal to the total value of all the previous elements 
	@Test
	public void LaboonLastElementEqualsTotalValueOfAllElements(){
		
		int NumberOfArrays = 0;
		boolean pass = false;
		while (NumberOfArrays <100)
		{
			int[] randArray = GenerateRandomArray();
			
			int[] laboonArray = laboonify(randArray);
			
			int total = 0;
			int i;
			for (i=0; i < randArray.length; i++)
			{
				total += laboonArray[i];
			}
			if (total == laboonArray[i])
			{
				pass = true;
			}
			else {
				pass = false;
				break;
			}
			NumberOfArrays++;
		}
		assertTrue(pass);
	}
	
}

	
