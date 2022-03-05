class HeapSort
{
  public static void main(String[] args) {
    int [] arr = new int[]{1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
    System.out.println("\nThe input array is : ");
    for(int i : arr)
      System.out.print(i+" ");

    buildHeapFromArray(arr,arr.length);

    //printing after building the heap
    System.out.println("\nThe array after heapifying : ");
    for(int i : arr)
      System.out.print(i+" ");


    heapSort(arr,arr.length);
    System.out.println("\nThe array after heapsort is as follows : ");
    for(int i : arr)
      System.out.print(i+" ");

  }

  public static void heapSort(int [] arr, int size)
  {
      for(int i = size-1 ; i>0 ;i--)
      {
        swap(arr,i,0);
        heapifyArray(arr,i,0);
        // since the first element is deleted and moved to end
        // hence the size of array to be sorted is reduced by 1
        // and the array is heapified by making the 1st element maxm
      }
  }

  public static void swap(int [] arr, int a , int b)
  {
    int temp = arr[a];
    arr[a]= arr[b];
    arr[b]=temp;
  }


  public static void buildHeapFromArray(int [] arr, int size)
  {
    int start = size/2;
    for(int i=start;i>=0;i--)
    {
      heapifyArray(arr,size,i);
    }
  }

  public static void heapifyArray(int [] arr, int size , int i)
  {
    int largest = i;
    int left = 2*i;
    int right = 2*i+1;

    if(left < size && arr[left] > arr[largest])
      largest = left;

    if(right < size && arr[right] > arr[largest])
      largest = right;

    if(largest!=i)
    {
      int temp = arr[i];
      arr[i]=arr[largest];
      arr[largest]=temp;
      heapifyArray(arr,size,largest);
    }
  }
}
