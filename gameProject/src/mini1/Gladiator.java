package mini1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Gladiator{
	String[] user = new String[4]; //{"상우","주옥", "현정", "연정"}; //입력받은 유저정보
	String[][] result = new String[4][2]; //최종결과
	String[] bin = new String[3];
	
	//1.생성자 회원들의 정보를 매개변수로 받음
	public Gladiator(String[] user) {  //String[] user
		this.user = user;
	}
	
	//2.게임시작
	public void gameStart1(){
		int[][] num = new int[4][2];
		boolean boo = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("\n***********************글레디에이터 카드 게임***********************");
		System.out.println("             게이머 여러분 게임에 오신 것을 환영합니다!");
		System.out.println("             여러분 앞에는 <4장>의 기사 카드가 있습니다.");
		System.out.println("이 게임은 하나의 기사 카드를 뽑아 상대방과 전투를 벌이는 게임입니다.");
		System.out.println("********************************************************************\n");
		System.out.println("\n ============================게임 룰=================================");
		System.out.println("||      1.게임은 3턴이 주어집니다.                                  ||");
		System.out.println("||      2.여러분의 선택한 기사의 체력은 현재 100입니다.             ||");
		System.out.println("||      3.턴마다 공격과 방어를 선택할 수 있습니다.                  ||");
		System.out.println("||      4.<공격시> 상대방의 체력에 20만큼을 손상시킵니다.           ||");
		System.out.println("||      5.<방어시> 상대방의 공격을 10만큼 방어할 수 있게됩니다.     ||");
		System.out.println("||      **승리 방법** 3턴이 종료되고 최대한 많은 체력을 유지        ||");
		System.out.println(" ====================================================================\n");
		
		//2.1 카드를 부여받음
		System.out.println("그럼 카드<1~4>중 한 장을 뽑아주세요.");
		//카드번호 값을 배열안의 첫번째 배열오소에 하나씩 받아서 저장
		for(int i=0; i<4;i++){
			System.out.println(user[i] +"님 카드 번호를 입력해주세요: ");
			num[i][0] =  sc.nextInt();   //i번째 사용자의 카드번호가 각 배열의 첫번째 요소에 들어감
			
			//2.1.1 카드번호 입력범위 유효성 검사
			if(num[i][0]<1 || num[i][0]>4 ){
				System.out.println("<<<<<1~4에서 다시 입력해주세요.>>>>>");
				i--;
				continue;
			}
			
			//2.1.2 중복되는 카드 검사
			//두번째 카드부터 이전카드와 뽑은 숫자가 같으면 다시 뽑기
			if( i>0 && num[i][0] == num[i-1][0]){   //바로 앞 것과 중복시
				System.out.println("<<<<<이미 뽑힌 카드입니다. 다시 선택해주세요.>>>>>");
				i--;
				continue;
			}else if( i>1 && num[i][0] == num[i-2][0] ){ //앞앞 것과 중복시
				System.out.println("<<<<<이미 뽑힌 카드입니다. 다시 선택해주세요.>>>>>");
				i--;
				continue;	
			}else if( i>2 && num[i][0] == num[i-3][0] ){ //앞앞앞 것과 중복시
				System.out.println("<<<<<이미 뽑힌 카드입니다. 다시 선택해주세요.>>>>>");
				i--;
				continue;
			}
		}			
	
		
		//2.3 번호값에 맞는 카드의 종류를 보여주는 부분
		System.out.println("\n======================카드선택 결과=======================");
		for(int i=0; i<4;i++){
			if(num[i][0] == 1){  //배열의 요소비교 equals			
				System.out.println(user[i]+"님의 카드는 <방패기사>입니다.");
				System.out.println("능력: 방패로 인해 <방어의 기능이 5향상>된다. ");
				System.out.println("----------------------------------------------------------");
				
			}else if(num[i][0] == 2){
				System.out.println(user[i]+"님의 카드는 <창기사>입니다.");
				System.out.println("능력: 창으로 인해 <공격의 기능이 5향상>된다.");
				System.out.println("----------------------------------------------------------");
				
			}else if(num[i][0] == 3){
				System.out.println(user[i]+"님의 카드는 <성기사>입니다.");
				System.out.println("능력: 기도의 힘으로 싸움이 끝날 때마다 <체력이 4회복>된다.");
				System.out.println("----------------------------------------------------------");
				
			}else if(num[i][0] == 4){
				System.out.println(user[i]+"님의 카드는 <기마기사>입니다.");
				System.out.println("능력: 하늘에 날아 공격하기때문에 <공격 3, 방어 3>이 향상된다.");
				System.out.println("----------------------------------------------------------");
			}
		}			
		System.out.println("==========================================================\n\n");
		
		//2.3.2 랜덤 조 매칭
		System.out.println("==========================================================");
		System.out.println("      조 매칭을 시작합니다. 아무키나 입력해주세요.");
		System.out.println("==========================================================\n");
		bin[0] = sc.next();
		
		Collections.shuffle(Arrays.asList(user));
		Arrays.toString(user);
		
		System.out.println("=====================================================");
		System.out.println("           <<<조 매칭이 이루어졌습니다.>>>");
		System.out.println("              <1조>  "+ user[0] + "님, "+ user[1]+"님");
		System.out.println("              <2조>  "+ user[2] + "님, "+ user[3]+"님");
		System.out.println("       경기 준비가 되셨으면 <준비>를 쳐주세요.");
		System.out.println("=====================================================");
		bin[1] = sc.next();  
		
		//2.4 전쟁 시작 부분
		Battle bat = new Battle(user, num);
		 //공격,방어 정보가 배열 안의 두번째 배열요소에 들어간다.
		
		//2.4.1 <3턴>의 전쟁을 반복
		for(int j=0; j<3; j++){ 
			System.out.println("\n-------------------<준결승>-"+(j+1)+"턴--------------------------");	
			
			for(int i=0; i<4;i++){ //4명의 공격,방어 정보를 얻음
				System.out.println(user[i] +" 님 공격(1)을 할지, 방어(2)를 할지 선택해주세요: ");
				num[i][1] =  sc.nextInt();
				
				//2.4.2 공격,방어 숫자의 유효성 검사
				if(num[i][1]!=1 && num[i][1]!=2){
					System.out.println("<<<<<공격(1)과 방어(2)중에서 골라주세요.>>>>>");
					i--;
					continue;
				}
			}	
			//2.4.3 준결승 전쟁을 실행하는 메서드로 넘어간다.
			System.out.println("\n---------------------------------------------------------");
			System.out.println("<<<<<<1. "+user[0]+ "님과 " + user[1] + "님이 승부를 나누었습니다.>>>>>>" );
			System.out.println("<<<<<<2. "+user[2]+ "님과 " + user[3] + "님이 승부를 나누었습니다.>>>>>>" );
			System.out.println("---------------------------------------------------------");
			bat.battle1(); 
		}
		
		//2.5 준결승 종합결과출력
		bat.resultView1(); 
		
		System.out.println("\n\n================================================");
		System.out.println("   <결승전> 준비가 되셨으면 <준비>를 쳐주세요.");
		System.out.println("================================================");
		bin[2] = sc.next(); 

		//2.6 결승전 시작
		int[] finUser = bat.resultGet1(); //결승참가 유저번호를 받음
		System.out.println("\n\n******************!!결승전을 시작합니다.!!******************");
		
		for(int j=0; j<3; j++){ //3턴 반복
			System.out.println("\n-------------------<결승전>-"+(j+1)+"턴--------------------------");
			for(int i=0; i<2;i++){ //결승 진출한 2명의 공격,방어 정보를 얻음
				System.out.println(user[finUser[i]] +" 님 공격(1)을 할지, 방어(2)를 할지 선택해주세요: ");
				num[finUser[i]][1] =  sc.nextInt(); //결승진출한 유저의 번호가 들어감
				
				if(num[finUser[i]][1]!=1 && num[finUser[i]][1]!=2){
					System.out.println("<<<<<공격(1)과 방어(2)중에서 골라주세요.>>>>>");
					i--;
					continue;
				}//유효성 검사(문자도 검사안됨)
				
			}
			System.out.println("\n\n---------------------------------------------------------");
			System.out.println("    <<<<<< "+user[finUser[0]]+ "님과 " + user[finUser[1]] + "님이 승부를 나누었습니다.>>>>>>" );
			System.out.println("---------------------------------------------------------");
			//추가- 체력100으로 다시 주기
			bat.battle2(); 
		}
		
		//2.5 결승 종합결과출력
		bat.resultView2(); 
		System.out.println("<Battle이 끝났습니다.>");
		
		
		//5.게임의 결과를 받아오는 부분
		int[] score = bat.resultGet2(); 		
		for(int i =0;i<4;i++){
			result[i][0] = user[i];
			result[i][1] = Integer.toString(score[i]); 
		}
		
//		//결과값 확인용
//		for(int i=0;i<4;i++){
//			for(int j=0;j<2;j++){
//				System.out.println(result[i][j]);
//			}
//		}	
		
	}	
	public String[][] resultGet1(){
		return result;
	}

}

//Integer정수를 변환할때
//기존배열을 다른 배열로 바꾸기=> 기존 배열요소를 뽑아서 래퍼클래스로 하나하나 바꿀 배열의 타입으로 변환시켜 담는다.
//타입 변환 1. 래퍼클래스의 메서드 2.강제 변환 3.배열은 Arrays클래스의 메서드 이용(주로 문자열로변환) 
