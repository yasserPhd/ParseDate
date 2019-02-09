package pack;
import java.util.* ;
public class MonthMap {
	
	public static final Map<String, String> MonthMap;
    static
    {
    	MonthMap = new HashMap<String, String>();
    	MonthMap.put("1", "January");
		MonthMap.put("2", "February");
		MonthMap.put("3", "March");
		MonthMap.put("4","April");
		MonthMap.put("5","May");
		MonthMap.put("6","June");
		MonthMap.put("7","July");
		MonthMap.put("8","August");
		MonthMap.put("9","September");
		MonthMap.put("10","October");
		MonthMap.put("11","November");
		MonthMap.put("12","December");
    }
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    return true;
	}
	public static int numberOfMonths(DateType[] nm){
		int cn = 0; 
		
		for(int i=0; i< nm.length ; i++)
		{
			int nr = 0 ;
			for(int j=0; j< nm.length; j++)
			{
				
				if(sameMonth(nm[i].month, nm[j].month))
						{
					//System.out.println(nr);
					nr ++ ;
						}
			}
			        cn ++;
					i = i + (nr-1) ;
		}
		return cn ;
	}
	public static int numberOfyears(DateType[] nm){
int cn = 0; 
		
		for(int i=0; i< nm.length ; i++)
		{
			int nr = 0 ;
			for(int j=0; j< nm.length; j++)
			{
				
				if(nm[i].year == nm[j].year)
						{
					nr ++ ;
						}
			}
			        cn ++;
					i = i + (nr-1) ;
		}
		return cn ;
	}
	public static int numberOfDays(DateType[] nm){
int cn = 0; 
		
		for(int i=0; i< nm.length ; i++)
		{
			int nr = 0 ;
			
			nr= nr + countDate(nm[i], nm );
			  cn ++;
			i = i + (nr-1) ;
		}
		
		return cn ;
		
	}
public static int getMonthValue(String m){
	int v = 0 ;
	if(isInteger(m))
	    v = Integer.parseInt(m) ;
	else
	{
		for(int i=1; i<= 12 ; i++) 
		 
		{
			if(sameMonth(String.valueOf(i), m))
			{
				v = i ;
			    i=13;
			}
		}
	}
	return v ;
}
	public static boolean sameMonth(String m1,String m2){
		boolean rst = false ;
		if(m1.equals(m2) || ((isInteger(m1.toString()) && isInteger(m2.toString()) && Integer.parseInt(m1.toString())== Integer.parseInt(m2.toString()))) )
			rst = true;
		else
		{
			 Set set = MonthMap.entrySet();
		      Iterator iterator = set.iterator();
		      while(iterator.hasNext() && rst == false) {
		    	  Map.Entry mentry = (Map.Entry)iterator.next(); 
		    	  if( isInteger(m1) && !isInteger(m2) )
		    	  {
		    		  
		    		  if((Integer.parseInt(m1) == Integer.parseInt(mentry.getKey().toString())) && (mentry.getValue().equals(m2)))
		    	  {
		    		  rst = true ;
		    	  }
		    	  }
		    	  else
		    	  {
		    		  if( isInteger(m2) && !isInteger(m1) )
		    		  {
		    		    if(Integer.parseInt(mentry.getKey().toString())== Integer.parseInt(m2.toString()) && mentry.getValue().equals(m1) )
		    			  rst = true ;
		    		  }
		          } 
		      }
		}
		return rst;
	}

public static boolean monthExist(String m, int y, DateType[] dtl ){
	boolean rst=false ; 
	for(int i=0; i < dtl.length; i++)
		if(dtl[i].year== y && sameMonth(dtl[i].month, m))
	      rst = true ;
	return rst ;
}

	 public static int countDate(DateType d,DateType[] dta ){
			int cd = 0 ;
			for(int i=0; i < dta.length; i++)
			{ 
				if(Integer.parseInt(d.day) == Integer.parseInt(dta[i].day) && sameMonth(d.month,dta[i].month) && d.year==dta[i].year)
					cd ++;
			}
			return cd ;
		}

}
