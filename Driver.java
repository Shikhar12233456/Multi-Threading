
public class Driver{
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6}; 
        Sum sum = new Sum(arr, 0, 5);
        Thread t = new Thread(sum);
        System.out.println(sum.sum);
    }
}