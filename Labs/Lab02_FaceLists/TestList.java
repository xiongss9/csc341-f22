import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class TestList {

	static Face f0 = new Face("last0,first0,100,100,1,2,3,4,5,6");
	static Face f1 = new Face("last1,first1,100,200,1,2,3,4,5,6");
	static Face f2 = new Face("last2,first2,100,200,1,2,3,4,5,6");
	static Face f3 = new Face("last3,first3,200,400,2,4,6,8,10,12");
	static Face f4 = new Face("last4,first4,100,100,1,2,3,4,5,6");

	public static void main(String[] args) {

		// Initial add() and peek() test
		/* It is a bit of a chicken-and-egg problem.
		* To test add(), peek() needs to be correct to confirm face was added.
		* To test peek(), add() needs to be correct to confirm location of face.
		*/

		System.out.println("\n\nSanity check test of add, length, peek.");
		System.out.println("If these initial tests do not pass, the rest of the tests are irrelevant!\n");
		List faceDB = new List(5);
		faceDB.add(f1);
		Assert.assertEquals(1,faceDB.length(),"First Add (length)");
		Assert.assertEquals(f1,faceDB.peek(0),"First Add (f1)");
		System.out.println("\nSanity Check complete!");
		/* Once the above are confirmed to be working, the rest of the testing can proceed.
		*/

		try {
			testConstructorGetters();
		} catch(Exception e) {
			System.out.println("\n\n*** STOP HERE -- something wrong with constructor!!\n\n");
		}
		try {
			testSearches();
		} catch(Exception e) {
			System.out.println("\n\nSEARCHES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testAdds();
		} catch(Exception e) {
			System.out.println("\n\nADDS THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testRemoves();
		} catch(Exception e) {
			System.out.println("\n\nREMOVES THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
		try {
			testConvert();
		} catch(Exception e) {
			System.out.println("\n\nCONVERT THROWING EXCEPTION.");
			e.printStackTrace();
			System.out.println("\n\n");
		}
	} // end main

	/* __________________________________________________________________ */
	public static void testConstructorGetters() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing List constructor ...");

		List faces;

		// Test default constructor and getters
		faces = new List();
		Assert.assertEquals(500, faces.capacity(), "List() capacity");
		Assert.assertEquals(0, faces.length(), "List() length");
		Assert.assertEquals(true, faces.isEmpty(), "List() isEmpty");

		// Test constructor with size parameter
		faces = new List(5);
		Assert.assertEquals(0, faces.length(), "List(5) length");
		Assert.assertEquals(5, faces.capacity(), "List(5) capacity");
		Assert.assertEquals(true, faces.isEmpty(), "List(5) isEmpty");

		// Test length getter (tested at 0 above)
		faces.add(f1);
		Assert.assertEquals(1,faces.length(),"length()");
		faces.add(f2);
		Assert.assertEquals(2,faces.length(),"length()");

		// Test isEmpty and isFull.
		faces = new List(3);
		Assert.assertEquals(false, faces.isFull(), "isFull - empty");
		Assert.assertEquals(true, faces.isEmpty(), "isEmpty");

		faces.add(f1);
		Assert.assertEquals(false, faces.isFull(), "isFull - 1 of 3");
		Assert.assertEquals(false, faces.isEmpty(), "isEmpty - 1 of 3");

		faces.add(f1);
		faces.add(f1);
		Assert.assertEquals(true, faces.isFull(), "isFull - 3 of 3");
		Assert.assertEquals(false, faces.isEmpty(), "isEmpty - 3 of 3");

		// test length getter when full
		Assert.assertEquals(3,faces.length(),"length()");

	} // end testConstructorGetters

	/* __________________________________________________________________ */
	public static void testSearches() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing List search methods ...");

		List faces;

		Face f = new Face("last0,first0,100,100,1,2,3,4,5,6");

		faces = new List(5);
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);

		System.out.println("------------testing peek()");
		Assert.assertEquals(f0,faces.peek(0),"Peek at index 0");
		Assert.assertEquals(f1,faces.peek(1),"Peek at index 1");
		Assert.assertEquals(f2,faces.peek(2),"Peek at index 2");
		Assert.assertEquals(null,faces.peek(3), "Peek invalid >count");
		Assert.assertEquals(null,faces.peek(5), "Peek invalid >length");
		Assert.assertEquals(null,faces.peek(-1), "Peek invalid -1");

		System.out.println("------------Testing recordNo()");
		Assert.assertEquals(0, faces.recordNo(f0), "recordNo first");
		Assert.assertEquals(1, faces.recordNo(f1), "recordNo middle");
		Assert.assertEquals(2, faces.recordNo(f2), "recordNo last");
		Assert.assertEquals(-1, faces.recordNo(f), "recordNo but not in list");

	} // end testSearches

	/* __________________________________________________________________ */
	public static void testAdds() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing List add methods ...");

		List faces;

		System.out.println("--------------add(Face)");
		faces = new List(3);

		Assert.assertEquals(0,faces.length(),"pre-add (length)");
		faces.add(f0);
		Assert.assertEquals(1,faces.length(),"add first (length)");
		Assert.assertEquals(f0,faces.peek(0),"add first (value)");
		faces.add(f1);
		Assert.assertEquals(2,faces.length(),"add 2nd (length)");
		Assert.assertEquals(f1,faces.peek(1),"add 2nd (value)");
		faces.add(f2);
		Assert.assertEquals(3,faces.length(),"add to capacity (length)");
		Assert.assertEquals(f2,faces.peek(2),"add to capacity (value)");
		faces.add(f3);
		Assert.assertEquals(3,faces.length(),"add attempt over capacity (length)");
		Assert.assertEquals(f3,faces.peek(2),"add attempt over capacity (value)");


		System.out.println("--------------add(face, index)");
		faces = new List(6);
		faces.add(f0,0);
		Assert.assertEquals(1,faces.length(),"add to empty (length)");
		Assert.assertEquals(f0,faces.peek(0),"add to empty (value)");

		faces.add(f1,0);	// order is now f1,f0
		Assert.assertEquals(2,faces.length(),"add at 0 (length)");
		Assert.assertEquals(f1,faces.peek(0),"add at 0 (value)");
		Assert.assertEquals(f0,faces.peek(1),"add at 0 (2nd song)");

		faces.add(f2,2);	// order is now f1, f0, f2
		Assert.assertEquals(3,faces.length(),"add at end (length)");
		Assert.assertEquals(f2,faces.peek(2),"add at end (value)");
		Assert.assertEquals(f1,faces.peek(0),"add at end (1st)");
		Assert.assertEquals(f0,faces.peek(1),"add at end (2nd)");

		/** TODO: Write a collection of tests here to test adding in the middle of the List */


		// test invalid indices
		faces.add(f4,-1);
		Assert.assertEquals(4,faces.length(),"add at -1 (length)");
		faces.add(f4,5);
		Assert.assertEquals(4,faces.length(),"add beyond last (length)");

		/** TODO: Write a couple of tests that test trying to peek beyond the last element and beyond the capacity.
		 */


		System.out.println("--------------set(Face, index)");
		faces = new List(6);
		// †his assumes that add is working correctly!
		faces.add(f0);
		faces.add(f1);
		faces.add(f2);

		faces.set(f3,0); // order is f3, f1, f2
		Assert.assertEquals(3,faces.length(),"set(0) length");
		Assert.assertEquals(f3,faces.peek(0),"set(0) value");
		Assert.assertEquals(f1,faces.peek(1),"set(0) (2nd)");
		Assert.assertEquals(f2,faces.peek(2),"set(0) (3rd)");

		faces.set(f4,1);	// order is f3, f4, f2
		Assert.assertEquals(3,faces.length(),"set(1) length");
		Assert.assertEquals(f4,faces.peek(1),"set(1) value");
		Assert.assertEquals(f3,faces.peek(0),"set(1) (1st )");
		Assert.assertEquals(f2,faces.peek(2),"set(1) (3rd )");

		faces.set(f1,2);	// order is f3, f4, f1
		Assert.assertEquals(3,faces.length(),"set(2) length");
		Assert.assertEquals(f1,faces.peek(2),"set(2) value");
		Assert.assertEquals(f3,faces.peek(0),"set(2) (1st )");
		Assert.assertEquals(f4,faces.peek(1),"set(2) (2nd )");

		faces.set(f2,3);	// set 1 past the last element
		//  invalid indices. should not change {f3,f4,f1}
		Assert.assertEquals(3,faces.length(),"set at length, bad index (length)");
		Assert.assertEquals(null,faces.peek(3),"set at length, bad index (value)");
		faces.set(f2,5);
		Assert.assertEquals(3,faces.length(),"set at capacity, bad index (length)");
		Assert.assertEquals(null,faces.peek(5),"set at capacity, bad index (value)");
		faces.set(f2,-1);
		Assert.assertEquals(3,faces.length(),"set at -1 (length)");
		Assert.assertEquals(f3,faces.peek(0),"set at -1 (value)");
	}

	/* __________________________________________________________________ */
	public static void testRemoves() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing List remove methods ...");

		// This is assuming add, length, contains is working!

		List faces;

	}

	/* __________________________________________________________________ */
	public static void testConvert() {
		System.out.println("\n\n_________________________________________");
		System.out.println("Testing List convert methods ...");

		List faces;
		Face[] array;

		System.out.println("--------------Testing toArray()");
		faces = new List(4);
		if (null!=faces.toArray()) {
			System.out.println(
			"ERROR: toArray empty list. Expect null. Results not null.");
		}

		faces.add(f0);
		array = faces.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 1 element. Returns null.");
		} else {
			Assert.assertEquals(1,array.length,"toArray 1 element (length)");
			Assert.assertEquals(array[0], f0, "toArray 1 element (value)");
		}

		faces.add(f1);
		array = faces.toArray();
		if (null==array) {
			System.out.println("ERROR: toArray 2 elements. Returns null.");
		} else {
			Assert.assertEquals(2,array.length,"toArray 2 elements (length)");
			Assert.assertEquals(array[0], f0, "toArray 2 elements (face 0)");
			Assert.assertEquals(array[1], f1, "toArray 2 elements (face 1)");
		}
	} // end testConvert
} // end class Main
