import java.util.*;

public class PhoneNumberLetter {
    static ArrayList<String> res=new ArrayList<>();
    static int count=0;
    public static void PhoneNumberLetters(char a[],char b[],String output[],int i,int j)
    {
        if(b[j]=='\0')
        {
            res.add(output.toString());
            return;

        }

        // Appending and calling the function to generate results recursively:-
        StringBuilder sb=new StringBuilder(null);
        sb.append(a[i]);
        sb.append(b[j]);
        // output[count++]=sb.toString();
        PhoneNumberLetters(a, b, output, i, j);

        // Recursively calling the array a until all its elements are traversed:-
        if(a[i]!='\0' && j==0)
            PhoneNumberLetters(a, b, output, i+1, 0);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i;
        System.out.println("Enter the first string:\t");
        String s1=sc.nextLine();
        System.out.println("Enter the second string:\t");
        String s2=sc.nextLine();
        char a[]=new char[100];
        char b[]=new char[100];
        int grt=s1.length();
        if(s2.length()>grt)
            grt=s2.length();
        for(i=0;i<grt;i++)
        {
            if(i<s1.length())
                a[i]=s1.charAt(i);
            if(i<s2.length())
                b[i]=s2.charAt(i);
        }
        int temp=s1.length();
        a[temp]='\0';
        temp=s2.length();
        b[temp]='\0';
        String output[] = new String[100];
        PhoneNumberLetters(a,b,output,0,0);
      
        for(String s:res)
            System.out.print(s);


    }
    
}
