import java.util.Scanner;
public class GenerateParenthesis {
    static int paren_num;
    static String res[]=new String[100];
    static int k=0;
    
    
    static void gen_par(char []output,int lp,int rp,int j)
    {
        if(lp==paren_num-1)
        {
            output[j++]='(';
            StringBuilder sb=new StringBuilder("");
            for(int temp=0;temp<j;temp++)
            {
                sb.append(output[temp]);
            }
            while(rp<paren_num)
            {
                sb.append(')'); 
                rp++;
            }
            System.out.print(sb);
            res[k++]=sb.toString();
            return;  
            
        }
        if(lp<paren_num)
        {
            output[j]='(';
            gen_par( output, lp+1, rp, j+1);
        }
        if(rp<lp)
        {
            output[j]=')';
            gen_par(output,lp,rp+1,j+1);
        }
    }
    public static void main(String args[])
    {
        System.out.print("Enter the no of parenthesis:\t");
        Scanner sc=new Scanner(System.in);
        paren_num=sc.nextInt();
        char output[]=new char[100];
        gen_par(output,0,0,0);
        for(int i=0;i<k;i++)
        {
            System.out.print(res[i]);
            System.out.print("\n");

        }

        
    }
}
