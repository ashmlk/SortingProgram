/**
 * @author Arshia Malekahmadi
 * @Source Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein(CLRS)
 *
 */
public class InsertionSort {
	public InsertionSort() {
	}
	public void sort(double[] array) {
		for(int i = 1;i < array.length; ++i) {
			double key = array[i];
			int j = i -1;
			while(j > 0 && array[j] > key) {
				array[j + 1] = array[j];
				j = j - 1;
			}
			array[j+1] = key;
		}
	}
}