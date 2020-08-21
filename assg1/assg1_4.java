import java.io.*;
import java.util.*;

class Main
{

    static int nchars = 256;

    static boolean areAnagram(char str1[], char str2[])
    {
        int count1[] = new int[nchars];
        Arrays.fill(count1, 0);
        int count2[] = new int[nchars];
        Arrays.fill(count2, 0);
        int i;

        for (i = 0; i < str1.length && i < str2.length; i++)
        {
            count1[str1[i]]++;
            count2[str2[i]]++;
        }

        if (str1.length != str2.length)
            return false;

        for (i = 0; i < nchars; i++)
            if (count1[i] != count2[i])
                return false;

        return true;
    }

    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter first string ");
        String s1 = obj.nextLine();
        System.out.println("Enter second string ");
        String s2 = obj.nextLine();
        char str1[] = s1.toCharArray();
        char str2[] = s2.toCharArray();

        if (areAnagram(str1, str2))
            System.out.println("anagrams");
        else
            System.out.println("not anagrams");
    }
}
