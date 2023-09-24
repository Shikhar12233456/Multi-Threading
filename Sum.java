class Sum implements Runnable{
    Integer[] arr;
    int lo;
    int high;
    int sum;

    public void run(){
        System.out.println("Thread Created");
        getSum();
    }

    Sum(){}
    Sum(Integer[] arr, int lo, int high){
        this.arr = arr;
        this.lo = lo;
        this.high = high;
    }

    void getSum(){
        if(lo > high){
            this.sum = 0;
            return;
        }
        if(lo == high){
            this.sum = arr[lo];
            return ;
        }
        int mid = lo + (high - lo)/2;
        Sum x = new Sum(arr, lo, mid-1);
        Thread t1 = new Thread(x);
        t1.start();
        Sum y = new Sum(arr, mid, high);
        Thread t2 = new Thread(y);
        t2.start();
        
        try{
            t1.join();
            t2.join();
        }catch(Exception e) {}
        
        this.sum = x.sum + y.sum;
    }
}
