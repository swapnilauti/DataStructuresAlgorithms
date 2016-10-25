public class RabinKarp {
    String text,pattern;
    int prime = 59;
    RabinKarp(String text,String pattern){
        this.text=text;
        this.pattern=pattern;        
    }
    boolean checkSize(){
        if(pattern==null || text == null)
            return false;
        if(pattern.length()>text.length())
            return false;
        return true;
    }
    long calcHash(String s){
        int length = s.length();
        long hashCode = 0;
        for(int i=0;i<length;i++){
            hashCode += (i==0?1:Math.pow(prime,i))*s.charAt(i);
        }
        return hashCode;
    }
    boolean isSame(String s1,String s2){
        return s1.equals(s2);
    }
    void printPat(){
        if(!checkSize()){
            System.out.println("Invalid Parameters");
            return;
        }
        int i=0;
        long textHash = calcHash(text.substring(0,pattern.length()));
        long patHash = calcHash(pattern);
        long multFactor = (long)Math.pow(prime, pattern.length()-1);
        System.out.println("Pattern Hash "+patHash);
        for(i=pattern.length();i<text.length();i++){
        	System.out.println("Text Hash "+textHash);
            if(textHash==patHash && isSame(text.substring(i-pattern.length(),i),pattern))
            {
               System.out.println("found at position "+(i-pattern.length()));
            }
            textHash-=text.charAt(i-pattern.length());
            textHash/=prime;            
            textHash+=multFactor*text.charAt(i);
        }
        if(textHash==patHash && isSame(text.substring(i-pattern.length(),i),pattern))
            {
               System.out.println("found at position "+(i-pattern.length()));
            }
    }
    public static void main(String[] args){
        RabinKarp ps = new RabinKarp("abccbacbaabcd","abc");
        ps.printPat();
    }
    
    
}