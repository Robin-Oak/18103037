import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner obj=new Scanner (System.in);
        String s1=obj.nextLine();
        String s2=obj.nextLine();
        int i1=0;
        int flag=0;
        while(i1<s1.length() && i1<s2.length())
        {
            if(s1.charAt(i1)<s2.charAt(i1)) {
                System.out.println(s1 + " is lexicographically smaller than " + s2);
                flag=1;
                break;
            }
            else if(s1.charAt(i1)>s2.charAt(i1)) {
                System.out.println(s2 + " is lexicographically smaller than " + s1);
                flag=1;
                break;
            }
            else {
                i1++;
            }
        }
        if(flag==0)
        {
            if(i1!=s1.length() && i1==s2.length())
                System.out.println(s2 + " is lexicographically smaller than " + s1);
            else if(i1==s1.length() && i1!=s2.length())
                System.out.println(s1 + " is lexicographically smaller than " + s2);
            else System.out.println(s2 + " and " + s1 + " are lexicographically equal");
        }
    }
}
