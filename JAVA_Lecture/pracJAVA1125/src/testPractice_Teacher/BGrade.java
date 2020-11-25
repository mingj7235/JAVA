package testPractice_Teacher;

public class BGrade extends WirelessClass{
	//시간당 단가
		int unitPrice = 81;//시간당 단가
		int basePrice = 12000;
		String gradeCode="B";
		int discountRate= discountRateMethod(basePrice);//할인요금
		// TODO Auto-generated constructor stub
		String[] custName = new String[10];//고객명
		int[]  useTime = new int[10];//사용시간
		int[] communicationFee = new int[10];//이번달통신요금
		
	    //입력되는 인원수
	    static int cnt=0;
		public void input(String cN, int uT) {
			custName[cnt] = cN;
	        useTime[cnt] = uT;
	        communicationFee[cnt]= communicationFeeMethod(unitPrice, useTime[cnt],basePrice, discountRate );
	        cnt++;
		}
		public void output() {
			for(int i=0;i<cnt; i++) {
				System.out.print(custName[i]+ "  ");
				System.out.print(gradeCode+" ");
				System.out.print( unitPrice+" ");
				System.out.print( basePrice+" ");
				System.out.print( useTime[i]+" ");
				System.out.print( discountRate+" ");
				System.out.print( communicationFee[i]);
				System.out.println();
			}
			
			
		}
}

