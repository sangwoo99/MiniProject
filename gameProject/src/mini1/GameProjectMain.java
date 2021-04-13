package mini1;

import java.util.Arrays;
import java.util.Scanner;

public class GameProjectMain {

	public static void main(String[] args) {
		String[][] result1 = {{"장길산","90"},{"홍길동","80"},{"김길동","70"},{"임꺽정", "87"}};
		String[][] result2 = {{"장길산","100"},{"홍길동","90"},{"김길동","70"},{"임꺽정", "77"}};
		String[] user=new String[4];
		boolean boo = true;
		
		Gladiator glad = new Gladiator(user);
		Dice dicegame = new Dice();
		
		System.out.println("\n*************************** 게임 프로젝트 **************************");
		System.out.println("\n환영합니다. 당신을 포함한 4명의 플레이어가 함께할 게임이 시작됩니다.\n먼저, 여러분을 나타낼 ID를 지어주세요.\n");
				
		/*---------------------------------- ID 수집 -------------------------------*/	
			Scanner sc=new Scanner(System.in);	// Scanner로 sc1 사용
			
			for(int i=0; i<4; i++){
				user[i]="user"+(i+1);			// user1, user2, user3, user4
				System.out.println((i+1)+"번째 플레이어의 ID를 입력하세요 : ");
				user[i]=sc.nextLine();
			}
			System.out.println("참가한 플레이어는 "+Arrays.toString(user)+"입니다.\n\n********************************************************************");
			System.out.println("\n게임을 선택해주세요.\n");
		/*---------------------------------- 게임 선택 -------------------------------*/
	
		while(boo){
			System.out.println("[1]게임1  [2]게임2  [3]점수조회 [4]종료");
			int b = sc.nextInt();
			if(b>4 || b<0)continue;
			switch (b) {
			//게임1(상우)
			case 1:
				glad.gameStart1();
				break;
			//게임2(주옥)
			case 2:						      
			    dicegame.dice();
				
			//조회
			case 3:	
				ScoreManager sm = new ScoreManager();	
				for(int i=0 ; i<4 ;i++){
					for(int j=0; j<4;j++){
						if(result1[i][0] == result2[j][0]){						
								String user1 = result1[i][0];
								int scoreA =  Integer.parseInt(result1[i][1]);
								int scoreB = Integer.parseInt(result2[j][1]);
								//System.out.println(user1+ scoreA+ scoreB);
								sm.addScore(user1, scoreA, scoreB);									
						}
					}
				}
				sm.Sort();
				sm.showScore();
				break;
				//user==user
				//user[0];
				//a[1];
				//b[2];
				
			case 4:	
				System.out.println("프로그램이 종료되었습니다.");
				boo = false;
			}//스위치끝
			
			result1 = glad.resultGet1();
			for (int i = 0; i <4; i++) {
				for (int j = 0; j < 2; j++) {
					System.out.println((result1[i][j]));	
				}
			}
		}//while끝		
	}
}
