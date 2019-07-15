/**
 * @author Arshia Malekahmadi
 * @Source Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein(CLRS)
 *
 */
public class QuickSort {
	
	public QuickSort(){
	}
	public int partition(double array[], int p, int r) {
			double pivot = array[r];
			int i = p-1;
			for(int j = p; j < r; j++) {
				if(array[j] < pivot) {
					i++;
					double temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
			double temp = array[i+1];
			array[i+1] = array[r];
			array[r] = temp;
			
			return i+1;
		}
	
	public void sort(double[] array,int p,int r) {
		if(p < r) {
			int index = partition(array, p, r);
			sort(array, p,index-1);
			sort(array,index+1,r);
		}
	}
}

