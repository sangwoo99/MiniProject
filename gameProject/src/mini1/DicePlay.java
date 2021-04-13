package mini1;

	import java.util.Arrays;

	public class DicePlay extends Dice  {
	   Player[] players = new Player[4];
	   int playerCnt = 0;
	   String[] winner = new String[2];
	   int winCnt = 0;

	   Dice dice = null;
	   
	   public DicePlay(Dice dice){
	      this.dice = dice;
	   }
	   
	   public void showPlayers(){
	      for (int i = 0; i < players.length; i++) {
	         System.out.println(players[i].toString());
	      }
	   }
	   
	   //1라운드 게임시작------------------------------------------------------------------------------------------------
	   void roundOne(String[] Team) {

	      String[] player = {Team[0], Team[1]};            //1조 먼저 시작

	      System.out.println("\n_____________________ S T A R T ! !________________________\n");      
	      System.out.println("|                    2개의 주사위를 예측해라.                    |");
	      System.out.println("|     [1] A주사위   |     [2] B주사위    |      [3] C주사위    |\n");
	      
	      int[] diceRan =diceChoice();         //난수 발생 주사위 2개 선택      

	      System.out.println("|___________________________________________________________|");
	      String[][] uDice = new String[2][];         
	      System.out.println("\n\n\n1라운드 진행 유저입니다." +"\n"+ player[0]+"\n"+player[1]+"\n\n");
	      
	      //게임시작
	      for (int i = 0; i < player.length; i++) {
	         System.out.println("▶▶▶"+player[i] + "님 시작합니다.");
	         System.out.println(" 예측할 주사위의 값2가지 입력하세요 >>");
	         String[] uDiceMem = new String[3];
	         //첫번째 index에는 무조건 user가 들어가게
	         uDiceMem[0] = player[i];
	         
	         for (int j = 1; j < uDiceMem.length; j++) {
	            System.out.print(">>");
	            uDiceMem[j] = sc.next();   
	         }
	         uDice[i] = uDiceMem;
	         System.out.println("\n"+player[i]+"님이 입력한 값입니다.\n"
	                              +uDiceMem[1]+" , "+uDiceMem[2]+"\n\n");
	         }
	      System.out.println(Arrays.deepToString(uDice));

	      
	      
	      //2명의 player 주사위 값을 받을 1차원배열 공간생성
	      String to[] = new String[uDice.length * uDice[0].length];
	   
	         for(int i=0; i<uDice.length; i++) {
	               for(int j=0; j<uDice[i].length; j++) {
	                 //2차원 배열의 원소를 1차원 배열의 원소로 이동.
	                  to[( i * uDice[i].length ) + j ] = uDice[i][j];
	               }
	             }
	      
	         System.out.println("랜덤 주사위의 값"+ diceRan[0]+","+diceRan[1]);

	         
	         //결과 발표
	          if(Integer.parseInt(to[1]) == diceRan[0] && Integer.parseInt(to[2]) == diceRan[1]){
	             System.out.println("\n★★★★★★★★★"+to[0]+"결승 진출! ★★★★★★★★★");
	             //패자 점수부여를
	             players[playerCnt++] = new Player(to[3], 30);
	             checkUser(to[0]);   
	   
	             
	          }else if(Integer.parseInt(to[4]) == diceRan[0] && Integer.parseInt(to[5]) == diceRan[1]){
	             System.out.println("\n★★★★★★★★★"+to[3]+"결승 진출!! ★★★★★★★★★");
	             players[playerCnt++] = new Player(to[0], 30);
	             checkUser(to[3]);         

	          }else{
	             System.out.println("여기까진 아직 몬했슴등!");
	          }

	  }


	   private void checkUser(String to) {
	      
	      // 결승진출자 check
	      if(winCnt==0)
	         winner[0] = to;
	      else {
	         winner[1] = to;         
	         System.out.println("결승 진출 유저입니다 :  " + winner[0] + ", " + winner[1] + "");
	         finalRun(winner);
	      }
	      winCnt++;      
	      
	   }
	   
	   
	   private void finalRun(String[] winner) {

	      String[] player = {winner[0], winner[1]};

	      System.out.println("\n____________________결   승   전______________________\n");      
	      System.out.println("|                  2개의 주사위를 예측해라                    |");
	      System.out.println("|    [1] A주사위   |    [2] B주사위    |     [3] C주사위    |\n");      
	      int[] diceRan =diceChoice();
	      System.out.println("|_________________________________________________________|");

	      String[][] uDice = new String[2][];   
	   
	      for (int i = 0; i < player.length; i++) {
	         System.out.println("\n▶▶▶"+player[i] + "님 시작합니다.");
	         System.out.println(" 예측할 주사위의 값2가지 입력하세요 >>");
	         String[] uDiceMem = new String[3];
	         //첫번째 index에는 무조건 user가 들어가게
	         uDiceMem[0] = player[i];
	         
	         for (int j = 1; j < uDiceMem.length; j++) {
	            System.out.print(">>");
	            uDiceMem[j] = sc.next();   
	         }
	         uDice[i] = uDiceMem;
	         System.out.println("\n"+player[i]+"님이 입력한 값입니다.\n"
	                              +uDiceMem[i]+" , "+uDiceMem[i+1]+"\n\n");
	         }


	      
	      String to1[] = new String[uDice.length * uDice[0].length];
	         for(int i=0; i<uDice.length; i++) {
	               for(int j=0; j<uDice[i].length; j++) {
	                 //2차원 배열의 원소를 1차원 배열의 원소로 이동.
	                  to1[( i * uDice[i].length ) + j ] = uDice[i][j];
	               }
	             }
	      
	            System.out.println("랜덤 주사위의 값 : "+ diceRan[0]+" , "+diceRan[1]);

	          if(Integer.parseInt(to1[1]) == diceRan[0] && Integer.parseInt(to1[2]) == diceRan[1]){
	             System.out.println("★★★★★★최종 승자★★★★★★★");      
	             System.out.println();
	             System.out.println("( ๑˃̶ ꇴ ˂̶)♪⁺   : :   "+to1[0]+"  : :    ( ๑˃̶ ꇴ ˂̶)♪⁺ ");   
	             players[playerCnt++] = new Player(to1[0], 100);
	             players[playerCnt] = new Player(to1[3], 60);

	          }else if(Integer.parseInt(to1[4]) == diceRan[0] && Integer.parseInt(to1[5]) == diceRan[1]){
	             System.out.println("★★★★★★최종 승자★★★★★★★");      
	             System.out.println("( ๑˃̶ ꇴ ˂̶)♪⁺   : :   "+to1[3]+"  : :    ( ๑˃̶ ꇴ ˂̶)♪⁺ ");   
	             players[playerCnt++] = new Player(to1[3], 100);
	             players[playerCnt] = new Player(to1[0], 60);
	          }
	          
	          System.out.println("꒰( ˵¯͒ꇴ¯͒˵ )꒱ 축하합니다------end------");
	          showPlayers();
	          dice.setChoice(false);
	          
	   }   
}