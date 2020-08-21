
import java.util.*;

public class Main
{
    static int prefix(HashSet<String> vec, String s)
    {
        for (String i : vec)
        {
            int count=0;
            for(int j=0;j<i.length() && j<s.length();j++, count++)
            {
                if(i.charAt(j) != s.charAt(j)) break;
            }
            if(count==i.length()) return count;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter paragraph: ");
        String para=input.nextLine();
        System.out.println("Enter size of vector: ");
        int vecSize=input.nextInt();
        HashSet<String> vec=new HashSet<String>();
        System.out.println("Enter "+vecSize+" Strings:");
        for(int i=0;i<vecSize;i++)
        {
            String s=input.next();
            vec.add(s);
        }
        input.close();
        int n=para.length();
        int j=0;
        System.out.println("Paragraph after formatting:");
        String ours="";
        while(j<n)
        {
            String s="";
            while(j<n && para.charAt(j)!=' ')
            {
                s+=para.charAt(j);
                j++;
            }
            int temp=prefix(vec, s);
            if(temp!=-1)
            {
                ours+=s.charAt(0);
                for(int i=1;i<temp;i++)
                {
                    ours+='*';
                }
                for(int i=temp;i<s.length();i++) ours+=s.charAt(i);
            }
            else
            {
                ours+=s;
            }
            if(j<n && para.charAt(j)==' ')
            {
                ours+=" ";
            }
            j++;
        }
        System.out.println(ours);
    }

}
