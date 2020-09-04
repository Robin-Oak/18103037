public class assg2_4 {
    public static void main(String[] args) {
        int sum=0, i=1;
        for(; i<Integer.MAX_VALUE; i++) {
            if(sum >= Integer.MAX_VALUE-i) break;
            sum+=i;
            if((int)Math.sqrt(sum)==i)
                System.out.println(i);
        }
        System.out.println("The program ended at "+i);
    }
}
