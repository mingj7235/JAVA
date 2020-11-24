package ams;

public class AmsField_Test {
	//항공사, 항공기번호, 최대승객수, 출발지, 도착지
	
	String [][] arrPlane = new String [100][5];
	int cnt;
	int showCnt;
	int cLength = arrPlane[0].length;
	String result = "";
	int updateIndex;
	
	//추가하기
	void insert (String [] arPlane) {
		arrPlane [cnt] = arPlane;
		cnt ++;
	}
	
	//검색하기
	String search (String keyword, int index) {
		int arIndex [];
		String result = "";
		int searchCnt = 0;
		for (int i = 0; i < cnt; i++) {
			if (keyword.equals(arrPlane[i][index])) {
				searchCnt++;
				updateIndex = i;
				result += "" + i + ",";
			}
		}
		arIndex = new int[searchCnt];
		for (int i = 0; i < arIndex.length; i++) {
			arIndex[i] = Integer.parseInt(result.split(",")[i]);
		}
		return show(arIndex); 
	}
	
	//수정하기
	void update (int btnIndex, String newValue) {
				arrPlane[updateIndex][btnIndex + 3] = newValue;
				//btnIndex
				//출발지 : 0
				//도착지 : 1
				//열 index 번호
				//출발지 : 3
				//도착지 : 4
			}
		
	
	
	//삭제하기
	boolean delete (String keyword) {
		boolean deleteCheck = false;
		
		for (int i = 0; i < cnt; i++) {
			if (arrPlane[i][1].equals(keyword)) {
				//cnt -1 : 마지막 정보가 담김 행
				//cnt : null이 담긴 행
				for (int j = i; j < cnt; j++) {
					arrPlane[j] = arrPlane[j+1];
					
				}
				deleteCheck = true;
				cnt--;
				break;
			}
		}
		return deleteCheck;
	}
	
	//목록보기
	String show () {
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";
		
		for (int i = 0; i < cnt; i++) {
			result += " ☆ ";
			for (int j = 0; j < cLength; j++) {
				//3항연산자 공식 :  '조건식 ? true : false' 
				result += j == cLength -1 ? arrPlane[i][j] : arrPlane[i][j] + ",  ";
				
			}
			result += "\n";
		}
		if (cnt == 0 ) result = "목록 없음";
		return result;
	}
	
	//검색결과 보기
	String show (int [] arIndex) {
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";
		
		for (int i = 0; i < arIndex.length; i++) {
			result += " ☆ ";
			for (int j = 0; j < cLength; j++) {
				result += arrPlane[arIndex[i]][j] ;
				result += j == cLength -1 ? "" : ",  ";
			}
			result += "\n";
		}
		if (arIndex.length == 0 ) result = "검색 결과 없음";
		return result;
	}


}
