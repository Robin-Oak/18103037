import java.util.*;

public class editing_q2 
{

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
			if(vec.contains(s))
			{
				ours+=s.charAt(0);
				for(int i=1;i<s.length();i++)
				{
					ours+='*';
				}
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