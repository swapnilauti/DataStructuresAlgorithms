public class LexographicRank{
long calFact(int n){
    if(n<=1)
        return n;
    long temp =n,temp1 = 0,temp2 =1;
    for(int i=n-1;i>0;i--){
        temp*=i;
    }
    return temp;
}
int findLess(String s,char c){
    int count = 0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)<c)
            count++;
    }
  	return count;
}
String removeChar(String s,char c){
    char ch[] = new char[s.length()-1];
    int count = 0;
    for(int i=0;i<s.length();i++){
        if(s.charAt(i)!=c)
            ch[count++]=s.charAt(i);
    }
    return new String(ch);
}
public long findRank(String s){
    int length = s.length(),lessChar =0,divisor=0;
    long factorial = calFact(length),pos =0;
    String temp = s;
    char c;
    for(int i=0;i<length;i++){
        c = s.charAt(i);
        lessChar = findLess(temp,c);
        temp = removeChar(temp,c);
      	factorial/=length-i;
        pos+=(factorial*lessChar);
    }    
    return pos+1;
}
public static void main(String args[]){
    LexographicRank obj = new LexographicRank();
    System.out.println(obj.findRank("string"));
}
}