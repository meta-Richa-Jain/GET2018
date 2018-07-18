import java.util.Calendar;

public class CurrentDate {	
	
	int getDate(){
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return day;
	}
}
