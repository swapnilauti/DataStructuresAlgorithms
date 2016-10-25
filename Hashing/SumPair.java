/*
Given array of integers and a sum, find pair of numbers whose total is equal to 'sum'
*/

import java.io.*;
import java.util.*;

class SumPair{
    int a[];
    int x,y;
    SumPair(int a[])
    {
        this.a=a;
    }
    boolean function(int sum)
    {
        HashSet<Integer> h= new HashSet<Integer>();
        for(int i:a)
        {
            if(h.contains(sum-i))
            {
                x=i;
                y=sum-i;
                return true;
            }
            else
            {
                h.add(i);
            }
        }
        return false;
    }
    void printNum()
    {
                    System.out.println("x= "+x+" y= "+y);
    }
    public static void main(String []args)
    {
        SumPair fp = new SumPair(new int[]{1,2,3,4,5,6});
        if(fp.function(11))
        {
            fp.printNum();
        }
        else
            System.out.println("Not found");
        
    }    
}