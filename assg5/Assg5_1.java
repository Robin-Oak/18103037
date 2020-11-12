public class Assg5_1{
public static void main(String... args){
        Thread thread=new Thread(){
            public void run(){
                int cnt=0;
                while(cnt<101){
                    cnt++;
                    System.out.print(cnt+" ");
                    if((cnt%10)==0)
                    {   System.out.println();
                        System.out.println("10 second message");
                        System.out.println();
                    }
                    try{
                        Thread.sleep(1000);
                    } catch (Exception err){
                        err.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }}
