public class Main {

    public static void main(String[] args) {
        long sum=0, i=1;
        for(; i<Integer.MAX_VALUE; i++) {
            sum+=i;
            if(sum==i*i)
                System.out.println(i);
        }
        System.out.println("The program ended at "+i);
    }
}
