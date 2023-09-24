
public class sort {
    public static void main(String[] args) {
        int[] arr = {6, 243,65, 32, 9, 43,  4343, 4343, 345, 44234,234,
                        3534,43, 54,54,5324,35545,454,54,54,54,5,45,4523,2,33,54,5,6,
                        55,34,32,54,654,435,43,5,4,5,456,764534,76543,54542,5543465,
                        443642,435434,144677767,534543,45442323,4434,3434,543,543543,56657,
                        664,43243,43,4235654,654543,5435,43543,543,543,534,543,5435,345435,
                        3534,64,35,6,5,6,6,65,44,23,2,4346,5,6};

        double t = System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        double x =  System.currentTimeMillis();
        System.out.println("Time taken by normal: "+(x-t)+" ms");
    }
}
