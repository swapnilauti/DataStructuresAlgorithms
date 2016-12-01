package Array;

/*This program returns 3 numbers in an array occurring odd number of times, given that all the other numbers occur even number of times
author: Swapnil Sudam Auti
email: sauti@buffalo.edu
*/
class FindThreeNo{

    private int a[];
    private int x,y,z;
    public FindThreeNo(int a[])
    {
        this.a=a;
        x=y=z=0;
    }
    /*This is the function to find the first number occurring odd number of times*/
    public void findFirstNo()
    {
        int bit0=0,bit1=0;
        for(int count=0;count<32;count++)
        {
            bit0=bit1=0;
            for(int i=0;i<a.length;i++)
            {
                if((a[i]&(1<<count))==0)
                {
                    //System.out.println("a["+i+"]= "+a[i]);
                    bit0^=a[i];
                }
                else
                {
                    bit1^=a[i];
                }
            }
            if(bit0!=0 && bit1!=0)
                break;
        }
        if(!find (bit0))
        {
            find(bit1);
            findTwoNo(bit0);
            return;
        }
        findTwoNo(bit1);
    }
    /*This function checks whether num is occurring odd number of times, if yes, then it returns true*/
    public boolean find(int num)
    {
        int count=0;
        for(int i=0;i<a.length;i++)
            if(a[i]==num)
                count++;
        if(count==0 || count %2==0)
            return false;
        x=num;
        return true;
    }
    /*This function finds the remaining two numbers occurring odd number of times.*/
    public void findTwoNo(int xor)
    {
        int setBit = ((xor)&(xor-1))^xor;
        for(int i:a)
        {
            if(i!=x)
            {
                if((i&setBit)==0)
                    y^=i;
                else
                    z^=i;
            }
        }
    }
    public void printArray()
    {
        for(int i=0;i<a.length;i++)
            System.out.println("a["+i+"]= "+a[i]);
    }
    public void printNo()
    {
        System.out.println("The three numbers occuring odd number of times are "+x+" , "+y+" , "+z);
    }
    public static void main(String args[])
    {
        FindThreeNo obj = new FindThreeNo(new int[]{7,7,7,6,6,6,5,1,1,2,2,3,3});
        System.out.println("Original Array ");
        obj.printArray();
        obj.findFirstNo();
        obj.printNo();

    }
}