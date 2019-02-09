package pack;
import java.io.*;
import java.util.Arrays;

public class AfficheFile {
	static DateType dt ;
	public static void displayDate(DateType[] ld){
		PrintWriter out = null ;
		int[] ysa = new int[ld.length];
		int[] msa = new int[ld.length];
		int[] mda = new int[ld.length];
		int[] ys = new int[MonthMap.numberOfyears(ld)];
		int[] ms = new int[MonthMap.numberOfMonths(ld)];
		int[] md = new int[MonthMap.numberOfDays(ld)]; 
		
		for(int i=0; i < ld.length; i++)
		{
			ysa[i] = ld[i].year ;
		}
		for(int i=0; i < ld.length; i++)
		{
			msa[i] = MonthMap.getMonthValue(ld[i].month); 
		}
		for(int i=0; i < ld.length; i++)
		{
		 mda[i]= Integer.parseInt(ld[i].day) ;
		}
		 Arrays.sort(ysa);
		 Arrays.sort(msa);
		 Arrays.sort(mda) ;
		 
	 int c=0;
		for(int i=0; i <ysa.length ; i++)
		{
			ys[c] = ysa[i] ;
			c++ ;
			while(i+1 < ysa.length &&  ysa[i] == ysa[i+1])
				i++;
		    
		if(i == ysa.length-1)
			c = 0;
		} 
		
		for(int i=0; i <msa.length ; i++)
		{
			ms[c] = msa[i] ;
			c++ ;
			while(i+1 < msa.length &&  msa[i] == msa[i+1])
				i++;
		    
		if(i == msa.length-1)
			c = 0;
		}	
		for(int i=0; i <mda.length ; i++)
		{
			md[c] = mda[i] ;
			c++ ;
			while(i+1 < mda.length &&  mda[i] == mda[i+1])
				i++;
		    
		if(i == mda.length-1)
			c = 0;
			
		}
		
		 try
	        {
		File file = new File("C:\\Users\\HP NOTEBOOK\\workspace\\ParseDate\\src\\output2.txt"); 
		 out = new PrintWriter(file);
	         
	         for(int i=0; i <ys.length ; i++)
	 		{
	 			out.println((ys[i])); ; 
	 			for(int j=0; j< ms.length; j++ )
	 			{
	 				if(MonthMap.monthExist(String.valueOf(ms[j]),ys[i],ld))
	 					 out.println(ms[j]);
	 				for(int k=0; k< md.length; k++ )
	 		         {
	 				dt = new DateType(String.valueOf(md[k]),String.valueOf(ms[j]),ys[i]) ;
	 				//System.out.println(String.valueOf(md[k])+","+String.valueOf(ms[j])+","+ys[i]+"="+MonthMap.countDate(dt, ld) );
	 		     if(MonthMap.countDate(dt, ld) > 0)
	 		        out.println(md[k] + "(" + MonthMap.countDate(dt, ld)+")" );
	 			      }
	 			
	 		        }
	 			} 
	        }
	        catch (FileNotFoundException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if ( out != null ) 
	            {
	                out.close();
	            }
	        } 
	         
	      }
	
}
