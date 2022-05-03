// Given an array of numbers, program to
// arrange the numbers to form the
// largest number
import java.util.*;

class GenerateLargestNo {

	// The main function that prints the
	// arrangement with the largest value.
	// The function accepts a vector of strings
	static void printLargest(Vector<String> arr)
	{

		Collections.sort(arr, new Comparator<String>()
		{
			// A comparison function which is used by
			// sort() in printLargest()
			@Override public int compare(String X, String Y)
			{

				// first append Y at the end of X
				String XY = X + Y;

				// then append X at the end of Y
				String YX = Y + X;
				System.out.println("XY = "+XY);
                System.out.println("YX = "+YX);
                System.out.println("======");
				// Now see which of the two
				// formed numbers
				// is greater
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		Iterator it = arr.iterator();

		while (it.hasNext())
			System.out.print(it.next());
	}

	// Driver code
	public static void main(String[] args)
	{

		Vector<String> arr;
		arr = new Vector<>();

		// output should be 6054854654
		arr.add("37");
		arr.add("1");
		arr.add("9");
		arr.add("55");
        arr.add("19");
        arr.add("6");
		printLargest(arr);
	}
}
// This code is contributed by Shubham Juneja
