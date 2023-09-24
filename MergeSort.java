class SortingWithThread implements Runnable{
    private int[] arr;
    private int left;
    private int right;
    private int[] ans;

    public void SortedArray(){
        for(int i: ans) System.out.print(i+" ");
    }
    public SortingWithThread(int[] arr, int i, int j){
        this.arr = arr;
        this.left = i;
        this.right = j;
    }

    @Override
    public void run(){
        System.out.println("Starting new Thread: "+this.left+" right: "+this.right);
        sort();
    }

    private void sort(){
        if(left == right && left >= 0){
            this.ans = new int[]{arr[left]};
            return;
        }
        if(left > right) return;

        int mid = left + (right-left)/2;
        SortingWithThread lefSortingWithThread = new SortingWithThread(arr, left, mid);
        Thread t1 = new Thread(lefSortingWithThread);
        t1.start();
        SortingWithThread rSortingWithThread = new SortingWithThread(arr, mid+1, right);
        Thread t2 = new Thread(rSortingWithThread);
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        merge(lefSortingWithThread.ans, rSortingWithThread.ans);
    }

    private int[] merge(int[] left, int[] right){
        ans = new int[left.length + right.length];
        int r = 0, i = 0, j = 0;

        while(i<left.length && j< right.length){
            if(left[i] < right[j]){
                ans[r++] = left[i++];
            }else ans[r++] = right[j++];
        }
        while(i< left.length) ans[r++] = left[i++];

        while(j< right.length) ans[r++] = right[j++];

        return ans;
    }
}

class MergeSort{
    public static void main(String[] args) {
        int arr[] = {3,6,4,2,1,10};
        SortingWithThread sortingWithThread = new SortingWithThread(arr, 0, arr.length-1);
        Thread t = new Thread(sortingWithThread);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {e.printStackTrace();}

        sortingWithThread.SortedArray();
    }
}
