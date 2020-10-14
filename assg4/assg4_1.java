import java.util.*;

class assg4_1 {

    public static boolean isValid(String[] crops, int i, int j) {
        return !(
                ((i>0)? crops[i].charAt(j)==crops[i-1].charAt(j): false)
                ||
                ((j>0)? crops[i].charAt(j)==crops[i].charAt(j-1): false)
        );
    }

    public static boolean validate(String[] crops, char x, int r, int c) {
        if(r>0)
            if(x==crops[r-1].charAt(c))
                return false;
        if(c>0)
            if(x==crops[r].charAt(c-1))
                return false;
        if(r<crops.length)
            if(x==crops[r+1].charAt(c))
                return false;
        if(c<crops[0].length())
            if(x==crops[r].charAt(c+1))
                return false;
        return true;
    }

    public static char available(String crops, int r, int c) {
        for(char x='a'; x<='z'; x++)
            if(validate(crops, x, r, c))
                return x;
    }

    public static boolean triangle (String[] crops, int r, int c) {
        return (r+1<crops.length && crops[r].charAt(c)==crops[r+1].charAt(c)
                &&
                c+1<crops[0].length() && crops[r].charAt(c)==crops[r].charAt(c+1));
    }

    public static int replant(String[] crops) {
        int n=crops.length, m=crops[0].length();
        String[] c= new String[n];
        if(n>=0)
        System.arraycopy(crops, 0, c, 0, n);
        int res1=0, res2=0;
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(!isValid(crops, i, j)) {
                    crops[i] = crops[i].substring(0, j) + available(crops, i, j) + crops[i].substring(j + 1);
                    res1++;
                }
            }

        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++) {
                if(!isValid(c, i, j) || triangle(crops, i, j)) {
                    c[i] = c[i].substring(0, j) + available(c, i, j) + c[i].substring(j + 1);
                    res2++;
                }
            }

        return Math.min(res1, res2);
    }

    public static void main(String[] args)
    {
        int n;
        Scanner obj = new Scanner(System.in);
        n = obj.nextInt();
        obj.nextLine();
        String[] crops = new String[n];
        for (int i=0;i<n;i++){
            crops[i]=obj.nextLine().trim();
        }
        System.out.print(replant(crops);
    }

}
