package sdfjkasd;
import java.util.*;

public class DistPalindrome {
	

	    static int palindrome(String str) {
	    HashSet<String> hm = new HashSet<String>();
	    int len = str.length(),count=0;
	    String subStr = null;
	    boolean flag1=true,flag2=true;
	    for(int i=0;i<len;i++)
	    {
	    	flag1=flag2=true;
	         for(int j=0;j<(len-i)&&j<=i;j++)
	         {
	            if(str.charAt(i-j)!=str.charAt(i+j))
	                flag1=false;
	            if(flag1)
	            {	
	            	subStr=str.substring(i-j,i+j+1);          //check
	            	if(!hm.contains(subStr))    
	            	{
	            		hm.add(subStr);
	            		count++;   
	            	}
	            }
	            if(i+j-1>=0)
	            {
	            	if(str.charAt(i-j)!=str.charAt(i+j-1))			//check
	            		flag2=false;
	            	if(flag2)
	            	{	
	            		subStr=str.substring(i-j,i+j);          //check
	            		if(subStr.length()!=0 && !hm.contains(subStr))    
	            		{
	            			hm.add(subStr);
	            			count++;   
	            		}
	            	}
	            }
	            	
	         }
	    }
	    if(len%2==1&&!hm.contains(str.substring(len/2,len/2+1)))
	        count++;
	     return count;   

	    }


	public static void main(String[] args) {
		
		System.out.println(palindrome("ababbabababa"));			
	
	}
}
