package ams;

import javax.swing.JOptionPane;

public class AmsField {
	//항공사, 항공기번호, 최대승객수, 출발지, 도착지
	
	String [][] arrPlane = new String [100][5];
	int cnt;
	int showCnt;
	int cLength = arrPlane[0].length;
	int updateIndex;

	//추가하기
	void insert (String [] arPlane) {
		arrPlane[cnt] = arPlane;
		cnt++;
	}
	
	//검색하기
	String search (String keyword, int index) {
		int [] arIndex;
		String result = "";
		int searchCnt = 0;
		
		for (int i = 0; i < cnt; i++) {
			if(keyword.equals(arrPlane[i][index])) {
				searchCnt++;
				updateIndex = i;
				result = "" + i + ",";
			}
		}
		arIndex = new int [searchCnt];
		for (int i = 0; i < arIndex.length; i++) {
			arIndex [i] = Integer.parseInt(result.split(",")[i]);
		}
		return show(arIndex);
	}
	
	//수정하기
		void update (int btnIndex, String newValue) {
				arrPlane[updateIndex][btnIndex+3] = newValue;
			}
	
	//삭제하기
	boolean delete (String keyword) {
		boolean deleteCheck = false;
		
		for (int i = 0; i < cnt ; i++) {
			if (arrPlane[i][1].equals(keyword)) {
				for(int j = i ; j < cnt; j++) {
					//통째로 행을 바꿔주려고 하는 것. 
					arrPlane [j] = arrPlane [j+1];
				}
				deleteCheck = true;
				cnt --;
				break;
			}
		}
		return deleteCheck;
	}
	
	//목록보기
	String show () {
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";
		
		for (int i = 0; i < cnt ; i++) {
			result += "☆";
			for (int j = 0; j < cLength; j++) {
				result += j == cLength -1 ? arrPlane[i][j] : arrPlane[i][j] + ",  ";
			}
			result += "\n";
		}
		if (cnt == 0) result = "목록 없음";
		return result;
	}
	
	//검색결과 보기
	String show (int [] arIndex) {
		//arIndex라는 것은 search 메서드에서 검색된 행번호를 arIndex라는 배열에 담겠다는 것이다.
		//대한항공을 검색했는데, 내가 insert에서 집어넣은 대한항공 비행기들이 1, 3, 5 번 행에 있다면
		//arIndex = {1, 3, 5} 로 담길 것이다. 
		
		String result = "항공사, 항공기번호, 최대승객수(명), 출발지, 도착지\n";
		for (int i = 0; i < arIndex.length; i++) {
			result += "☆";
			for (int j = 0; j < cLength; j++) {
				result += arrPlane[arIndex[i]][j];
				result += j == cLength-1 ? "" : ",";
			}
			result += "\n";
		}
		if (arIndex.length == 0) result = "검색 결과 없음";
		return result;
	}
}
