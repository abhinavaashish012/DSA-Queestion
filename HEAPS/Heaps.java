// different cobinations for heaps are possible
// https://stackoverflow.com/questions/30552777/when-building-heap-is-heap-unique
import java.io.*;
import java.util.*;

//using MAX HEAP throughout
class Heaps
{
  public static void main(String[] args) {
    int [] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

    List<Integer> array = new ArrayList<Integer>();


    System.out.println("The array before heapifying : ");
    for(int i : arr)
      {
        System.out.print(i+" ");
        array.add(i);
      }

      //building heap from the input
      buildHeap(array);

      //printing after building the heap
      System.out.println("\nThe array after heapifying : ");
      for(int i : array)
        System.out.print(i+" ");

      // adding an element and heapifying the array
      array.add(11);
      buildHeap(array);

      // printing after heapifying the array after addition
      System.out.println("\nThe array after adding : ");
      for(int i : array)
        System.out.print(i+" ");
  }

  public static void buildHeap(List<Integer> array)
  {
    int start = array.size()/2;
    // the last non-leaf nodes will start from size/2 index
    // so we need to heapify from that index only
    for(int i=start;i>=0;i--)
    {
      heapify(array,array.size(),i);
    }
  }

  public static void heapify(List<Integer> array, int sz , int i)
  {
      int largest=i;
      int left = 2*i;
      int right = 2*i+1;

      if(left < sz && array.get(left) > array.get(largest))
        largest=left;

      if(right < sz && array.get(right) > array.get(largest))
        largest=right;

        // swapping in case the child node is large
        // and heapifying it from that index
        if(largest!=i)
        {
          swap(array,i,largest);
          heapify(array,sz,largest);
        }
  }

  public static void swap(List<Integer> array, int a , int b)
  {
    int temp = array.get(a);
    array.set(a,array.get(b));
    array.set(b,temp);
    // fro replacing the elements in the arraylist
    //use .set() function
  }

}
