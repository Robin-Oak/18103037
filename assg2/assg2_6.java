import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String n = obj.nextLine();
        int flag=0;
        do {
            flag=0;
            for (int i = 0; i < n.length(); i++)
                if (n.charAt(i) <= '0' || n.charAt(i) >= '9') {
                    flag = 1;
                    break;
                }
            if (flag == 1) {
                System.out.println("Better chose a positive number. Try again?");
                n = obj.nextLine();
            }
        }
        while(flag!=0);
        long nk=Long.valueOf(n);
        while(nk<0) {
            System.out.println("Negative numbers are so not allowed. Better chose a positive number. Try again?");
            nk = obj.nextInt();
        }
        while (nk != 1) {
            if (nk % 2 == 0)
                nk /= 2;
            else {
                nk = nk * 3 + 1;
            }
            System.out.println(nk);
        }
    }
}
//Integer n=new Integer(string);
//valueOf
//int a=Integer.valueOf(string);
//string buffer class
