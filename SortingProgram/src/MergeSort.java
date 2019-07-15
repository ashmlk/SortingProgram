
public class MergeSort {

	public MergeSort(){
	}
	public void merge(double array[], int start,int mid, int end) {
		int l1 = mid - start + 1;
		int l2 = end - mid;
		
		double[] a1 = new double[l1];
		double[] a2 = new double[l2];
		
		for(int i = 0;i < l1;++i) {
			a1[i]=array[start+i];
		}
		for(int i = 0;i < l2;++i) {
			a1[i]=array[mid+i+1];
		}
		
		int i = 0, j = 0, k = start;
		while(i < l1 && j < l2) {
			if(a1[i] <= a2[j]) {
				array[k] = a1[i];
				i++;
			}
			else {
				array[k] = a2[j];
				j++;
			}
			k++;
		}
		
		while(i < l1) {
			array[k] = a1[i];
			i++;
			k++;
		}
		while(j < l2) {
			array[k] = a2[j];
			j++;
			k++;
		}
	}
	public void sort(double array[], int mid, int end) {
		if(mid < end) {
			int new_mid = mid+(end - mid)/2;
			sort(array, mid, new_mid);
			sort(array, new_mid+1,end);
			merge(array, mid, new_mid, end);
		}
	}
}