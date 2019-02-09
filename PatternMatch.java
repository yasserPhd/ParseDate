package pack;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch  {
	 public static  String in = " ";
	 public static DateType[]  getDate(String desc) {
	    int count=0;
	    Matcher  m = Pattern.compile("(19\\d\\d|20\\d\\d)[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])").matcher(desc);
	    Matcher  m2 = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.]([a-zA-Z]{3,9})[- /.](19\\d\\d|20\\d\\d)").matcher(desc);
	    Matcher  m3 = Pattern.compile("([a-zA-Z]{3,9})[- /.](0[1-9]|[12][0-9]|3[01])[- /.,]\\s(19\\d\\d|20\\d\\d)").matcher(desc);
	    DateType[] allMatches = new DateType[desc.length()];

	    while (m.find()) {
	    	 allMatches[count]= new DateType(m.group(3), m.group(2), Integer.parseInt(m.group(1)));
	        count ++;
	    } 
	    while (m2.find()) {
	    	allMatches[count]= new DateType(m2.group(1).toString(), m2.group(2).toString(), Integer.parseInt(m2.group(3)));
		        count ++;
		    } 
	   while (m3.find()) {
		   allMatches[count]= new DateType(m3.group(2).toString(), m3.group(1).toString(), Integer.parseInt(m3.group(3)));
		        count ++;
		    } 
	   DateType[] result= new DateType[count];
	    for(int i=0; i< count; i++)
	    	result[i]= allMatches[i]; 
	    return result;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		in = ReadFileCl.readFile("C:\\Users\\HP NOTEBOOK\\workspace\\ParseDate\\src\\input.txt");
		AfficheFile.displayDate(getDate(in));
		
		}
	}



