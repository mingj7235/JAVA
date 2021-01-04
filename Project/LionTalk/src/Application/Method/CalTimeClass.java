package Application.Method;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;


public class CalTimeClass {

	public CalTimeClass() {
		// TODO Auto-generated constructor stub
	}
	

	static public String CalToTime(Calendar cal){
		String dayOfWeek [] = {"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		int year = cal.get(Calendar.YEAR);
		String month = Append0(cal.get(Calendar.MONTH)+1);
		String day = Append0(cal.get(Calendar.DATE));
		
		int date = cal.get(Calendar.DAY_OF_WEEK)-1;
		String hour = Append0(cal.get(Calendar.HOUR_OF_DAY));
		String min = Append0(cal.get(Calendar.MINUTE));
		String sec = Append0(cal.get(Calendar.SECOND));
		
		return year+""+month+day+" "+dayOfWeek[date]+" "+hour+" "+min+" "+sec;
	}
	static public String Append0(int num){
		if(num <10) return 0+""+num;
		else return num+"";
	}
	// 시간에 맞게 포맷을 변경하는 메서드
	static public String CalTime(String cal) {
		// TODO Auto-generated method stub
		String []time = cal.split(" ");
		
		
		String ymd = time[0];
		
		String year = ymd.substring(0, 4);
		String month = ymd.substring(4,6);
		String day = ymd.substring(6,8);
		
		String date = time[1];
		String hour = time[2];
		String min = time[3];
		
		Calendar today = Calendar.getInstance();
		Calendar chat = Calendar.getInstance();
		chat.set(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		
		long difference = // 두 날짜 사이를 초로 변환
				(today.getTimeInMillis() - chat.getTimeInMillis()) / 1000;
		
		int diff = (int)difference/(24*60*60);
		
		if(diff < 1 ){ // 1일  이하 이면 
			if(Integer.parseInt(hour) < 12 ){
				return "오전 "+hour+"시 "+min+"분";
			}else{
				
				return "오후 "+(Integer.parseInt(hour)-12)+"시 "+min+"분";
			}
			 
		}else if(diff > 1 && diff <7) 
		{
			return date;
		}else{
			return year+"-"+month+"-"+day;
		}
	}//end of CalTime
	// 시간 순으로 정렬하기 위한 시간 계산 메서드
	static public int CalTime(String cal1, String cal2) {
		
		Calendar cal1Cal = Calendar.getInstance();
		String cal1Hour = null;
		String cal1Min = null;
		String cal1Sec = null;
		
		
		Calendar cal2Cal = Calendar.getInstance();
		String cal2Hour = null;
		String cal2Min = null;
		String cal2Sec = null;
		// 첫번째 cal1값 계산
		{
		String []time = cal1.split(" ");
		
		String ymd = time[0];
		
		String calYear = ymd.substring(0, 4);
		String calMonth = ymd.substring(4,6);
		String calDay = ymd.substring(6,8);
		
		cal1Cal.set(Integer.parseInt(calYear), Integer.parseInt(calMonth), Integer.parseInt(calDay));
		cal1Hour = time[2];
		cal1Min = time[3];
		cal1Sec = time[4];
		}
		// 두번째 cal2 값 계산
		{
			String []time = cal2.split(" ");
			
			String ymd = time[0];
			
			String calYear = ymd.substring(0, 4);
			String calMonth = ymd.substring(4,6);
			String calDay = ymd.substring(6,8);
			
			cal2Cal.set(Integer.parseInt(calYear), Integer.parseInt(calMonth), Integer.parseInt(calDay));
			cal2Hour = time[2];
			cal2Min = time[3];
			cal2Sec = time[4];
		}
		
		
		long difference = // 두 날짜 사이를 초로 변환
				(cal1Cal.getTimeInMillis() - cal2Cal.getTimeInMillis()) / 1000;
		
		int diff = (int)difference/(24*60*60);
		
		if(diff == 0){ // 같은 날짜 라면
			int cal1TotalSec = 3600 * Integer.parseInt(cal1Hour) + 60 * Integer.parseInt(cal1Min) + Integer.parseInt(cal1Sec);
			int cal2TotalSec = 3600 * Integer.parseInt(cal2Hour) + 60 * Integer.parseInt(cal2Min) + Integer.parseInt(cal2Sec);
			
			return cal1TotalSec - cal2TotalSec;
		}else {
			return diff;
		}
	}//end of CalTime
	
	
}
