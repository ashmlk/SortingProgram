/**
 * @author Arshia Malekahmadi
 * @Source Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein(CLRS)
 *
 */
public class HeapSort {
	public HeapSort() {
		
	}
	public void sort(double[] array, int l) {
		for(int i = l/2 - 1; i >= 0; i--) {
			heapTree(array, l, i);
		}
		for(int i = l - 1;i >= 0; i--) {
			exchange(array, 0, i);
			heapTree(array, i, 0);
		}
	}
	public void heapTree(double array[], int n, int root) 
    { 
        int largest = root;  
        int l = 2*root + 1; 
        int r = 2*root + 2;
        if (l < n && array[l] > array[largest]) 
            largest = l;  
        if (r < n && array[r] > array[largest]) 
            largest = r; 
        if (largest != root) 
        { 
        	exchange(array, root, largest);
            heapTree(array, n, largest); 
        } 
    }
	public void exchange(double[] array,int i, int j) {
		double temp = array[i];
		array[i] = array[i];
		array[j] = temp;
	}
}
