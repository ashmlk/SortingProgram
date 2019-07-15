/**
 * @author Arshia Malekahmadi
 * @Source Introduction to Algorithms by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, and Clifford Stein(CLRS)
 *
 */
public class BubbleSort {
	public BubbleSort() {
		
	}
	public void sort(double[] array, int l) {
		for(int i = 0;i < l; i++) {
			for(int j =0;j < l - i - 1;j++) {
				if(array[j] > array[j+1]) {
					exchange(array, j, j+1);
				}
			}
		}
	}
	public void exchange(double[] array,int i, int j) {
		double temp = array[i];
		array[i] = array[i];
		array[j] = temp;
	}
}
