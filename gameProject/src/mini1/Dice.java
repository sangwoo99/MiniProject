package mini1;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
public class Dice {

	   DicePlay dPlay = null;
	   
	   //사용이 비교적 자주 발생하는 클래스 전역화
	   Scanner sc = new Scanner(System.in);
	   Random rm = new Random();
	    boolean choice = true;
	    
	   public void setChoice(boolean cho) {
	      this.choice = cho;
	   }   
	//주사위 게임
	   //게임방식 : 유저 4명은 각각 2라운드의 토너먼트를 원칙으로한다.
	//   룰 : 3가지 종류의 주사위가 있다.
	//   유저들은 각각 두가지의 주사위에서 나올 값을 예측하여 선택한다.
	//   주사위를 돌렸을때, 같은 값이 나오면 다음 경기로 올라간다.
	//   최종결승에서 유저는 3가지 주사위를 예측해야하며 한다.
	//   1등 : 100점 , 2등 : 50점(1등을 제외한 2라운드 진출자). 3등 : 0점(주사위의 값이 근사값인 사람.), 4등 : 0점
	   
	public void dice() {
	   

	   //유저값 받아오기
	   String[][] pCols = new String[4][2];
	   String[] player ={}; 
	   

	   do {
	      System.out.println("               :::::게임을 시작 하시겠습니까?:::::               ");
	      System.out.println("               :::::[  1 : YES   /   2 : NO ]:::::               ");
	      System.out.print("번호를 입력하세요 >>");
	      int answer = sc.nextInt();

	      //아니라면 무한반복 실행 x
	      if(answer == 2) { 
	         choice = false; 
	         }else {
	            
	            System.out.println("-----------------------------------------------------------------------------");
	            System.out.println("|                            [  게   임   방   법 !! ]                                       |");
	            System.out.println("|                                                                                               |");
	            System.out.println("|   게임을 시작하기 전, 룰을 설명드리겠습니다.                                 |");
	            System.out.println("|   진행방식 :  토너먼트                                                                 |");
	            System.out.println("|                                                                                                |");
	            System.out.println("|   룰 : 아래에 3 가지의 1~10의 숫자를 가진 주사위가 있다.                 |");
	            System.out.println("|    ★ 주사위 A : 정수로만 이루어져 있다.                                         |");
	            System.out.println("|    ★ 주사위 B : 짝수로만 이루어져 있다.                                         |");
	            System.out.println("|    ★ 주사위 C : 홀수로만 이루어져 있다.                                         |");
	            System.out.println("|                                                                                                |");
	            System.out.println("|   유저들은 각각 두가지의 주사위에서 나올 값을 예측하여 선택한다.    |");
	            System.out.println("|   주사위를 돌렸을때, 예측한 값이 맞으면 다음라운드로 진출한다.       |");
	            System.out.println("|                                                                                               |");
	            System.out.println("-----------------------------------------------------------------------------\n");
	            
	            
	            System.out.println("__________________토너먼트를 진행할 조를 선정하겠습니다.____________________");
	            System.out.println("|                                                                                                     |");
	            //1~4숫자의 랜덤 배정을 받아 a조 b조로 나눈다.            
	            String[] user = { "user1", "user2", "user3","user4" };
	            Collections.shuffle(Arrays.asList(user));
	            //System.out.println(Arrays.toString(user));
	            
	            //랜덤으로 만든 배열을 2인 1조로 쪼개서 넘긴다.
	            String[] firstTeam = {user[0], user[1]};            
	            String[] secondTeam = {user[2], user[3]};
	            System.out.println("|                               1조  : "+ Arrays.toString(firstTeam)+"                                            |");
	            System.out.println("|                               2조  : "+Arrays.toString(secondTeam)+"                                            |");
	            System.out.println("|                                                                                                     |");
	            System.out.println("----------------------------------------------------------------------------------\n\n");
	            System.out.println(" 게임 방법과, 조를 확인하셨습니까? \n   [  1 : YES   /   2 : NO ]");
	            System.out.print("확인이 완료 되었다면, 번호를 입력하세요 >>");
	            int yn = sc.nextInt();
	            
	            //조와 방법을 확인했다면, 게임으로 넘어간다.
	            dPlay = new DicePlay(this);
	            
	            if(yn == 1){
	               
	               //팀을 번갈아 가면서 넣어준다.  (나중에 게임이 끝나면 값을 다시 넣어주는 변수로 i를 책정하자)
	               for (int i = 0; i < 2; i++) {

	                  if(i == 0){                     
	                     dPlay.roundOne(firstTeam);
	                     
	                  }else if(i==1){
	                     dPlay.roundOne(secondTeam);      
	                  }                  

	               }//for end
	               
	            }else{
	               System.out.println("게임을 나갔습니다.");
	               choice = false;
	            }
	            
	            
	      }//if end
	   } while (choice);   //게임이 끝나거나, 중간에 종료할거면 나갈수 있음.   
	}



	   //랜덤 주사위
	   protected int[] diceChoice() {
	      
	      int random = 0;//랜덤 주사위의 넘버값
	      int[] diceNum = new int[2];   //주사위를 선택할 번호
	      int[] diceRan = new int[2];

	   
	      //주사위 선택 ------------------------------------------------------------------
	      random = rm.nextInt(3);
	      diceNum[0] = random;
	      boolean isRun = true;
	      
	      while(isRun)
	      {
	         random = rm.nextInt(3);
	         if(random != diceNum[0]){
	            diceNum[1] = random;
	            isRun = false;
	         }
	      }

	      System.out.println("             선택된 주사위의 번호는 >>"+ (diceNum[0]+1)+","+(diceNum[1]+1));
	      
	      
	      
	      //범위내의 난수발생 -----------------------------------------------------------   
	      for (int i = 0; i < diceRan.length; i++) {
	         
	         if(diceNum[i] == 0){
	            System.out.print("난 정수 :"); 
	            diceRan[i] = (int)rm.nextInt(10)+1;
	         }else if(diceNum[i]== 1){
	            System.out.print("난 짝수 : ");
	            diceRan[i] = (int)2*rm.nextInt(6)+2;
	         }else if(diceNum[i]== 2){
	            System.out.print("난 홀수 : ");
	            diceRan[i] = (int)2*rm.nextInt(5)+1;
	         }
	         System.out.println(diceRan[i]);
	      }
	   
	      return diceRan;

	      
	   }
	   

	}//diceChoice end

