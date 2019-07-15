/**
 * @author Arshia Malekahmadi
 * @Source Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein(CLRS)
 *
 */
public class SelectionSort {
	public SelectionSort() {
		
	}
	public void sort(double[] array, int l) {
		for(int i = 0; i< l; i++) {
			int min = i;
			for(int j =0;j < l;j++) {
				if(array[j] < array[min]) {
					min = j;
				}
			}
			double temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}
}
