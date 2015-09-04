import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List; 
import java.util.HashSet;
import java.util.HashMap;
public class NBTest {

    public static void main(String[] args)throws IOException {
	// write your code here
        InputStreamReader pipein= new InputStreamReader(System.in);
        BufferedReader input = new BufferedReader(pipein);
        String x = null;
		File outFile =  new File ("trainresult.txt");
	    FileWriter fWriter = new FileWriter (outFile);
	    PrintWriter pWriter = new PrintWriter (fWriter);		
		while((x = input.readLine())!=null){
				pWriter.println (x);					
		}
		pWriter.close();

		int m = 0,t=0;
		File classFile = new File ("classcounts.txt");
		double []classc = new double [4]; 
    	Scanner sclass = new Scanner (classFile);
    	double totalclass = 0;
    	while (sclass.hasNextLine())
    	{
	      String cline = sclass.nextLine();
	      String []classtemp = cline.split("--");
	      classc[Integer.parseInt(classtemp[0])]=Integer.parseInt(classtemp[1]); 
	      totalclass = totalclass + Integer.parseInt(classtemp[1]);
	    }
	    sclass.close();

	    double [][]wordc=new double [4][2];
	    File wordFile = new File ("class.txt");
    	Scanner sword = new Scanner (wordFile);
    	while (sword.hasNextLine())
    	{
	      String wline = sword.nextLine();
	      String []wordtemp = wline.split("--");
	      wordc[Integer.parseInt(wordtemp[0])][0]=Integer.parseInt(wordtemp[1]); 
	      wordc[Integer.parseInt(wordtemp[0])][1]=Integer.parseInt(wordtemp[2]); 
	    }
	    sword.close();



		String textname = args[0];

		File inFile = new File (textname);
		
	    Scanner sc = new Scanner (inFile);
	    
	    int testcase = 0, testcorrect = 0;

	    double []testresult = new double [4];
    		for(m=0;m<4;m++){
    				//double doubletemp = (classc[m]+0.25)/(totalclass+1);
    			double doubletemp = (classc[m])/(totalclass);
    				testresult[m]= Math.log(doubletemp);
    				
    				
    		}
	    while (sc.hasNextLine())
	    {
	    	
	    	//String [][]words = new String [3000][5];
	    	testcase= testcase + 1;
	    	String line = sc.nextLine();
	      	String []s1 = line.split("	",2);
			String []c1 = s1[0].split(",");
			String []w1 = s1[1].split(" ");

			List<String> awords = new ArrayList<String>();
			HashSet <String> hwords= new HashSet<String>();
			HashMap<String, Integer> wcount = new HashMap<String, Integer>();
			for(t=0;t<w1.length;t++){
				awords.add(w1[t].replaceAll("[^A-Za-z ]","").toLowerCase());
				hwords.add(w1[t].replaceAll("[^A-Za-z ]","").toLowerCase());		
	    	}
	    	

	    	
    		Scanner cr = new Scanner (outFile);
    		while (cr.hasNextLine())
    		{
      			String crline = cr.nextLine();
      			String []crtemp = crline.split("--",2);
      			
      				if(hwords.contains(crtemp[0])){ 

      					String []temp = crline.split(",");
      					//String []temp2 = creline.split("--",2);
      					wcount.put(temp[0],Integer.parseInt(temp[1]));
      					//int classn = Integer.parseInt(temp[0]);
      					//words[t][classn]= temp[1];

      				}
      			

    		}
      			

    				
    		for(t=0;t<awords.size();t++){ 
    			for(m=0;m<4;m++){
    				//System.out.println(words[t][m]);
    				String temp = awords.get(t)+"--"+m;
    				if(wcount.containsKey(temp)){ 
    					//double doubletemp = (wcount.get(temp)+1/wordc[m][1])/(wordc[m][0]+1);
    					double doubletemp = (wcount.get(temp))/(wordc[m][0]);
    					testresult[m]= testresult[m]+Math.log(doubletemp);
    					
    				}
    				//else{ 
    				//	double doubletemp = (1/wordc[m][1])/(wordc[m][0]+1);
    				//	testresult[m]= testresult[m]+Math.log(doubletemp);

    				//}
    			
    			}
    		}
    		int category = 0;
    		double largest = testresult[0];
    		//System.out.println(testresult[0]);
    		for(t=1;t<4;t++){
    			//System.out.println(testresult[t]);
    			if(testresult[t]>largest){ 
    				
    				largest = testresult[t];
    				category = t;
    			} 
    		}
    		//System.out.println(testresult[category]);
    		String scategory = null;
    		//System.out.println(category);
    		if(category==0){ 
					scategory="CCAT";
				}
				else{ 
					if (category==1) {
						scategory="ECAT";
					}
					else{ 
						if (category==2) {
							scategory="GCAT";
						}
						else{ 
							scategory="MCAT";
						}
					}
				}
		
			
			for(t=0;t<c1.length;t++){ 
				//System.out.println(c1[t]);
				if(c1[t].equals(scategory)){ 
					testcorrect= testcorrect + 1;
					
				}

			}



    		cr.close();

	     
	    }
	    sc.close();

	 File finalFile = new File ("finalresult.txt");
    FileWriter finalwriter = new FileWriter (finalFile,true);
    PrintWriter pfinalWriter = new PrintWriter (finalwriter,true);
    long a = System.currentTimeMillis(); 
     pfinalWriter.println ("The end time is :" + a );
    pfinalWriter.println ("This is the final result:");
    pfinalWriter.println ("The accuracy is :" + testcorrect + "/" + testcase);
    pfinalWriter.close();	
    
    }

   

}
