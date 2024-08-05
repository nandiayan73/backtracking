import java.util.ArrayList;
import java.util.HashMap;

public class WonderfulSubString {
    static ArrayList <String> arr=new ArrayList<>();
    static int res=0;
    static boolean isWonderful(String s)
    {
        int odd_count=0;
        HashMap <Character,Integer>hp=new HashMap<>();
        System.out.print(s);
        for(int i=0;i<s.length();i++)
        {
           
            if(hp.containsKey(s.charAt(i)))
            {
                hp.put(s.charAt(i),hp.get(s.charAt(i))+1);
            }
            else
            {
                hp.put(s.charAt(i), 1);
            }
        }
        System.out.print(hp);
        for(char key:hp.keySet())
        {

            if(hp.get(key)%2!=0 && odd_count!=1)
                odd_count=1;
            else if(hp.get(key)%2!=0 && odd_count==1)
                return false;
        }
        return true;
        }
    public static void generateSubString(int i,int j,char []input,char []output)
    {
        if(input[i]=='\0')
        {
            StringBuilder sb=new StringBuilder();
            for(int  k=0;k<j;k++)
            {
                sb.append(output[k]);
            }
            if (isWonderful(sb.toString()))
            {
                res++;
            }
            return;

        }
        output[j]=input[i];
        // accepting the string:
        generateSubString(i+1, j+1, input, output);

        // rejecting the string:
        generateSubString( input.length-1, j,input,output);
        // generateSubString(i+1, j, input, output);
    }
    public static void main(String[] args) {
        String word="abc";
        char input[]=new char[word.length()+1];
        char output[]=new char[word.length()+1];
        int i=0;
        for( i=0;i<word.length();i++)
        {
            input[i]=word.charAt(i);
        }
        input[i]='\0';
        generateSubString(0, 0, input, output);
        System.out.print(res);
    }
}
