/*
Find number of employees under every manager
*/
import java.util.*;
class EmpMng{
    private String s[][];
    private int size;
    HashMap<String,ArrayList<String>> mngEmp;
    HashMap<String,Integer> empMng;
    EmpMng(String s[][])
    {
        this.s=s;
        size=s.length;
        mngEmp= new HashMap<String,ArrayList<String>>();		//check 
        empMng= new HashMap<String,Integer>();
        fillMngEmp();        
        for(int i=0;i<size;i++)
        {
            if(!mngEmp.containsKey(s[i][0]))
                empMng.put(s[i][0],0);
            else
                empMng.put(s[i][0],-1);
        }

    }
    public void fillMngEmp()
    {
        for(int i=0;i<size;i++)
        {
            if(s[i][0]!=s[i][1])
            {
                if(mngEmp.containsKey(s[i][1]))
                {
                    mngEmp.get(s[i][1]).add(s[i][0]);
                }
                else
                {
                	ArrayList<String> al = new ArrayList<String>();
                	al.add(s[i][0]);
                    mngEmp.put(s[i][1],al);
                }
            }
        }
    }
    public int find(String emp)
    {
        ArrayList<String> al = mngEmp.get(emp);
        int count=0,value=0;
        for(String temp:al)
        {
            //count=value=0;
            if((value=empMng.get(temp))==-1)
            {
                count+=find(temp);
            }
            else
                count+=1+value;
        }
        empMng.put(emp,count);  
        return count;
    }
    public void calculate()
    {
        Set<String> mng = mngEmp.keySet();
        Iterator<String> it = mng.iterator();
        while(it.hasNext())
        {
            String temp=it.next();
           // if(empMng.get(temp)==-1)
                find(temp);
        }
    }
    public void printVal()
    {
        for(Map.Entry e:empMng.entrySet())
        {
            System.out.println(e.getKey()+" "+e.getValue());
        }
    
    }
    public static void main(String args[])
    {
        EmpMng em = new EmpMng(new String[][]{{"A","C"},{"B","C"},{"C","F"},{"D","E"},{"E","F"},{"F","F"}});
        em.calculate();
        em.printVal();
    }
    
}