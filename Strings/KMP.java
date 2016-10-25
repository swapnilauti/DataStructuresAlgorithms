public class KMP{
int[] fun(String a)
{
    int j=0,i=1;
    int arr[] = new int[a.length()];
    arr[j]=0;
    for(;i!=a.length();i++)
    {
        if(a.charAt(i)==a.charAt(j))
        {
         arr[i] = ++j;
        }
        else
        {
            while(j!=0 && arr[i]!=arr[j])
            {
                j = arr[j-1];
            }
             if(arr[i]==arr[j])
             {
                 arr[i] = ++j;
             }
             else
             {
                 arr[i]=0;
             }
        }
    }
    return arr;
}
void fun2(String text,String pat)
{
    int arr[] = fun(pat);
    int j=0;
    for(int i=0;i<text.length();i++)
    {
        if(text.charAt(i) == pat.charAt(j))
        {
            j++;

        }
        else
        {
            while(j!=0 && text.charAt(i) != pat.charAt(j))
            {
                j=arr[j-1];
            }
            if(text.charAt(i) == pat.charAt(j))
            {
                j++;
            }
             
        }    
        
        if(j==pat.length())
        {
             System.out.println("FOund at "+(i-j+1)); 
             j=0;
        }
    }
}
public static void main(String []args)
{
    KMP abc = new KMP();
    abc.fun2("ababababadabcabrabcab","abc");
}
}