
import java.io.*;
public class NBTrain {

    public static void main(String[] args)throws IOException {
    	 File finalFile = new File ("finalresult.txt");
    FileWriter finalwriter = new FileWriter (finalFile);
    PrintWriter pfinalWriter = new PrintWriter (finalwriter);
    long a = System.currentTimeMillis();    
    pfinalWriter.println ("The begin time is :" + a );
    pfinalWriter.close();	
	// write your code here
    
        InputStreamReader pipein= new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(pipein);
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        String x = null,w=null;
		int i=0,t=0,m=0;
		int []classc = new int [4]; 
		String classEnd = new String("CAT");
		while((x = input.readLine())!=null){
			String []s1 = x.split("	",2);
			String []c1 = s1[0].split(",");
			String []w1 = s1[1].split(" ");
			int ctemp=0;
			
			for(m=0;m<c1.length;m++){
				if((c1[m].indexOf(classEnd))!=-1){

					if(c1[m].equals("CCAT")){ 
						ctemp=0;
					}
					else{ 
						if (c1[m].equals("ECAT")) {
							ctemp=1;
						}
						else{ 
							if (c1[m].equals("GCAT")) {
								ctemp=2;
							}
							else{ 
								ctemp=3;
							}
						}
					}
					for(t=0;t<w1.length;t++){
						w=w1[t].replaceAll("[^A-Za-z ]","").toLowerCase()+"--"+String.valueOf(ctemp);
						

						//System.out.println(i+c1[0]);
	    		    	System.out.println(w);
  						//output.write(w1[t],0,w1[t].length());
	    		    }
	    		    classc[ctemp]=classc[ctemp]+1;
	    		}
			}
			
		}
		File outFile =  new File ("classcounts.txt");
    FileWriter fWriter = new FileWriter (outFile);
    PrintWriter pWriter = new PrintWriter (fWriter);
    pWriter.println ("0--"+classc[0]);
    pWriter.println ("1--"+classc[1]);
    pWriter.println ("2--"+classc[2]);
    pWriter.println ("3--"+classc[3]);
    pWriter.close();

		input.close();
		output.close();
    }
}
