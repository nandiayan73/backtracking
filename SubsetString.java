
import java.util.*;
public class SubsetString
{
    static String res[]=new String[500];
    static int k =0;
    public static void StringSet(char input[],char output[],int i,int j){
        // Termination condition:-
        if(input[i]=='\0'){
            
            StringBuilder sc= new StringBuilder("");
            int temp=0;
            while(temp<j)
            {
                sc.append(output[temp]);
                temp+=1;
            }
            System.out.print(sc);
            res[k++]=sc.toString();
            return;
        }

        // Accepting the char:-
        output[j]=input[i];
        StringSet(input,output, i+1, j+1);

        // Rejecting the String:-
        StringSet(input,output, i+1, j);
        
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
       
        int i;
        System.out.print("Enter the string\t");
        String data=sc.nextLine();

        char input[]=new char[data.length()+1];
        char output[]=new char[data.length()+1];
        for(i=0;i<data.length();i++){
            input[i]=data.charAt(i);
        }
        input[i]='\0';

        StringSet(input,output, 0, 0);

        // Print the subsets from the 'res' array
        System.out.println("\nAll subsets of the string:");
        for (i = 0; i < k; i++) {
            System.out.println(res[i]);
        }


    }
}