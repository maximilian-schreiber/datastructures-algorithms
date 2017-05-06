package at.fhj.sorting;

public class Sort {

	/**
	 * sort an array with quicksort algorithm
	 * 
	 * @param a
	 *            ... whole array of values to sort
	 * @param l
	 *            ... left boundary; where to start sorting
	 * @param r
	 *            ... right boundary; where to end sorting
	 */
	public static <T extends ICompare<T>> void quicksort(T[] a, int l, int r) {

        //Check for valid input parameters
        if (l >= r || a.length == 0){
            return;
        }

		//Get the pivot element (middle element of the array)
        int pivotPosition = l+(r-l)/2;
        T pivot = a[pivotPosition];

		int i = l;
		int j = r;

		while (i <=j ){
            // Make sure that left elements are smaller and right elements are greater than the pivot element
            while(a[i].greaterEqual(pivot) == false){
				i++;
			}
			while(a[j].lesserEqual(pivot) == false){
				j--;
			}

			// Move the wrong placed elements
			if(i <= j){
				T temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}

		//Repeat
		if (l < j){
			quicksort(a, l, j);
		}

		if (r > i){
			quicksort(a, i, r);
		}
	}

	/**
	 * sort an array with bubblesort algorithm
	 * 
	 * @param a
	 *            ... whole array of values to sort
	 */
	public static <T extends ICompare<T>> void bubblesort(T[] a) {
		for(int i = 1; i < a.length; i++){
			for(int j = 0; j < a.length - i; j++) {
                if(a[j].greaterEqual(a[j+1])){
                    T tempSwap =  a[j];
                    a[j] = a[j+1];
                    a[j+1] = tempSwap;
                }
            }
		}
	}
}
