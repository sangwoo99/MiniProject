package mini1;

public class Battle {
	String[] user;
	int[][] num;
	String[] glad = new String[4];
	int[] attack = new int[4];
	int[] shield = new int[4];
	int[] finUser = new int[2];
	int[] health = {100,100,100,100};
	int[] score = new int[4];
	String[] move = new String[4];
	
	public Battle(String[] user, int[][] num) {
		this.user = user;
		this.num = num;
	}
	
	//1.선택한 카드에따라 각 유저마다 기사의 종류,공격력, 방어력을 부여함
	public void charSet(){
		
		for(int i=0; i<4; i++){
			if(num[i][0] == 1 ){
				glad[i] = "방패기사";
				shield[i] = 5;
					
			}else if(num[i][0] == 2 ){
				glad[i] = "창기사";
				attack[i] = 5;
			}else if(num[i][0] == 4 ){
				glad[i] = "기마기사";
				attack[i] = 3;
				shield[i] = 3;
			}else {
				glad[i] = "성기사";
			}
		}
	}
	
	//2.토너먼트 방식-준결승
	public void battle1(){
		charSet();  //카드 능력치 설정
		//유저1,2 매칭
		//두번째 배열요소의 의미는 공격인지 방어인지
			if(num[0][1] == 1 && num[1][1] == 1){
				health[0] = health[0] + shield[0] - 20 - attack[1];
				health[1] = health[1] + shield[1] - 20 - attack[0]; //딜을 교환하니까 공격이 서로 반대로 적어야
				move[0] = "공격";
				move[1] = "공격";
			}else if(num[0][1] == 1 && num[1][1] == 2){
				health[1] = health[1] + shield[1] - 10 - attack[0]; //방어한 쪽만 계산하면 됨
				move[0] = "공격";
				move[1] = "방어";
			}else if(num[0][1] == 2 && num[1][1] == 1){
				health[0] = health[0] + shield[1] - 10 - attack[1];  //방어한 쪽만 계산하면 됨
				move[0] = "방어";
				move[1] = "공격";
			}else{
				//둘다 막았을 때는 두 유저의 체력변화가 없음
				move[0] = "방어";
				move[1] = "방어";
			}
			
			//유저3,4매칭
			if(num[2][1] == 1 && num[3][1] == 1){
				health[2] = health[2] + shield[2] - 20 - attack[3]; //공격만 남의 것
				health[3] = health[3] + shield[3] - 20 - attack[2];
				move[2] = "공격";
				move[3] = "공격";
			}else if(num[2][1] == 1 && num[3][1] == 2){
				health[3] = health[3] + shield[3] - 10 - attack[2];
				move[2] = "공격";
				move[3] = "방어";
			}else if(num[2][1] == 2 && num[3][1] == 1){
				health[2] = health[2] + shield[2] - 10 - attack[3];
				move[2] = "방어";
				move[3] = "공격";
			}else {
				//둘다 막았을 때는 두 유저의 체력변화가 없음
				move[2] = "방어";
				move[3] = "방어";
			}
			
			//성기사 체력 회복 턴 종료시 체력회복
			for(int i=0; i<4;i++){
				if(num[i][0]==3 && health[i]<100){			
					health[i] +=4;
					System.out.println("***성기사가 기도를 하여 자신의 체력을 4회복합니다.***");
				} 
			}
				
			System.out.println("\n\n====================<1경기장> 승부결과===================");
			System.out.println(user[0]+ "님의 <"+ glad[0]+">가 " + move[0]+"을(를) 하고 <체력이 "+health[0]+"> 남았습니다.");
			System.out.println(user[1]+ "님의 <"+ glad[1]+">가 " + move[1]+"을(를) 하고 <체력이 "+health[1]+"> 남았습니다.");
			System.out.println("=========================================================\n");

			System.out.println("====================<2경기장> 승부결과===================");
			System.out.println(user[2]+ "님의 <"+ glad[2]+">가 " + move[2]+"을(를) 하고 <체력이 "+health[2]+"> 남았습니다.");
			System.out.println(user[3]+ "님의 <"+ glad[3]+">가 " + move[3]+"을(를) 하고 <체력이 "+health[3]+"> 남았습니다.");
			System.out.println("=========================================================");
	}
	//3.토너먼트-준결승전 결과 반환
	public void resultView1(){
		
		//승자를 판별하여 결승진출 유저 선정과 패배 점수 배점
		System.out.println("\n\n====================준결승전 종합 결과===================");
		//준결승 1경기장 결과
		if(health[0]>health[1]){
			finUser[0]= 0;   //결승진출 유저 변수에 담음
			score[1] = 70;   //패배한 유저에게 70점 부여
			health[0] = 100; //다음 경기를 위해 체력 리셋
			System.out.println("      <1경기장>"+user[0]+"님이 승리하셨습니다.!!!!!!!!!");
		}else if(health[0]<health[1]){
			finUser[0]= 1;
			score[0] = 70;
			health[1] = 100;  
			System.out.println("      <1경기장>"+user[1]+"님이 승리하셨습니다.!!!!!!!!!");
		}else{			
			score[0] = 80;
			score[1] = 80;
			System.out.println("      <1경기장>"+user[0]+"님과 "+user[1]+"님은 무승부입니다.~~~~~");
		}
		//준결승 2경기장 결과
		if(health[2]>health[3]){
			finUser[1]= 2;
			score[3] = 70;
			health[2] = 100;
			System.out.println("      <2경기장>"+user[2]+"님이 승리하셨습니다.!!!!!!!!!");
		}else if(health[2]<health[3]){
			finUser[1]= 3;
			score[2] = 70;
			health[3] = 100;
			System.out.println("      <2경기장>"+user[3]+"님이 승리하셨습니다.!!!!!!!!!");
		}else{
			score[2] = 80;
			score[3] = 80;
			System.out.println("      <2경기장>"+user[2]+"님과 "+user[3]+"님은 무승부입니다.~~~~~");
		}
		System.out.println("=========================================================");
	}
	
	public int[] resultGet1(){
		return finUser; //준결승전 승리 유저의 번호를 정수배열로 넘김
	}
	
	//4.토너먼트-결승전
	public void battle2(){
		//승리한 유저를 받아야함
		//승리한 유저들의 카드 체력 리셋
		int i = finUser[0]; 
		int j = finUser[1]; 

		if(num[i][1] == 1 && num[j][1] == 1){
			health[i] = health[i] + shield[i] - 20 - attack[j];
			health[j] = health[j] + shield[j] - 20 - attack[i]; //딜을 교환하니까 공격을 서로 반대로 적어야
			move[i] = "공격";
			move[j] = "공격";
		}else if(num[i][1] == 1 && num[j][1] == 2){
			health[j] = health[j] + shield[j] - 10 - attack[i];  //방어한 쪽만 계산하면 됨
			move[i] = "공격";
			move[j] = "방어";
		}else if(num[i][1] == 2 && num[j][1] == 1){
			health[i] = health[i] + shield[i] - 10 - attack[j];  //방어한 쪽만 계산하면 됨
			move[i] = "방어";
			move[j] = "공격";
		}else{
			//둘다 막았을 때는 두 유저의 체력변화가 없음
			move[i] = "방어";
			move[j] = "방어";
		}
		
		//결승진출 유저의 카드가 성기사이고 체력이 100보다 작을때
		//성기사 체력 회복 턴 종료시 체력회복
		if(num[i][0]==3 && health[i]<100){			
			health[i] +=4;
			System.out.println("***성기사가 기도를 하여 자신의 체력을 4회복합니다.***");
		} 
		if(num[j][0]==3 && health[j]<100 ){			
			health[j] +=4;
			System.out.println("***성기사가 기도를 하여 자신의 체력을 4회복합니다.***");
		} 	
																
		System.out.println("\n\n====================<결승 경기장> 승부결과===================");
		System.out.println(user[i]+ "님의 <"+ glad[i]+">가 " + move[i]+"을(를) 하고 <체력이 "+health[i]+"> 남았습니다.");
		System.out.println(user[j]+ "님의 <"+ glad[j]+">가 " + move[j]+"을(를) 하고 <체력이 "+health[j]+"> 남았습니다.");
		System.out.println("============================================================");
	}
	
	//5.경기결과 출력 및 반환
	public void resultView2(){
		int i = finUser[0];
		int j = finUser[1];
		System.out.println("\n\n=============================결승전 종합 결과==========================");
		//경기 후 점수 산정                           
		if(health[i]>health[j]){
			score[i] = 100;
			score[j] = 85;
			System.out.println("***********************************************************************");
			System.out.println("*****<"+user[i]+">님이 <최종 승리>하셨습니다.!!!!!!!!! 축하합니다!!!!!*****");
			System.out.println("***********************************************************************");
		}else if(health[i]<health[j]){
			score[i] = 85;
			score[j] = 100;
			System.out.println("***********************************************************************");
			System.out.println("*****<"+user[j]+">님이 <최종 승리>하셨습니다.!!!!!!!!! 축하합니다!!!!!*****");
			System.out.println("***********************************************************************");
		}else{
			score[i] = 95;
			score[j] = 95;
			System.out.println("            "+user[i]+"님과 "+user[j]+"님은 무승부입니다.~~~~~");
		}
		System.out.println("=======================================================================");
	}
	public int[] resultGet2(){
		return score;
	}
}
