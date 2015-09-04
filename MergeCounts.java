import java.util.Scanner;
import java.io.*;
public class MergeCounts {

    public static void main(String[] args)throws IOException {
	// write your code here
        InputStreamReader pipein= new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(pipein);
        String x = null;
		int i=0,t=0;
		int ccount=0,ecount=0,gcount=0,mcount=0;
   		String temp= null;
    	int count=0;
    	int [][]classc=new int [4][2];
    	int ctemp=0;
		while((x = input.readLine())!=null){
				String []w1=x.split("--");
				
				ctemp=Integer.parseInt(w1[1]);
				classc[ctemp][0]=classc[ctemp][0]+1;
				if(x.equals(temp)){ 
					count=count+1;
				}
				else{
					if(temp!=null){ 
					classc[ctemp][1]=classc[ctemp][1]+1;
					System.out.println(temp+ "," + String.valueOf(count));
					count = 1;
					temp = x;
					}
					else{ 
					temp = x;
					count = 1;
					}
				}


      						//s2[1] = String.valueOf(Integer.parseInt(s2[1])+1);
      						
		}
		classc[ctemp][1]=classc[ctemp][1]+1;
		System.out.println(temp+ "," + String.valueOf(count));
		
	File outFile =  new File ("class.txt");
    FileWriter fWriter = new FileWriter (outFile);
    PrintWriter pWriter = new PrintWriter (fWriter);
    pWriter.println ("0--"+classc[0][0]+"--"+classc[0][1]);
    pWriter.println ("1--"+classc[1][0]+"--"+classc[1][1]);
    pWriter.println ("2--"+classc[2][0]+"--"+classc[2][1]);
    pWriter.println ("3--"+classc[3][0]+"--"+classc[3][1]);
    pWriter.close();
    }
}
