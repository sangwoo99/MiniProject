package mini1;

import java.util.ArrayList;
import java.util.Collections;

 public class ScoreManager {
      UserScore us = new UserScore();
      ArrayList<UserScore> arrList = new ArrayList<UserScore>();
 
      void addScore(String user, int scoreA, int scoreB) {
         arrList.add(new UserScore(user, scoreA, scoreB));
         
      }
      
      public void Sort(){
         Collections.sort(arrList);
      }
      void showScore() {
         System.out.println("순위"+"\t"+"이름"+"\t"+"게임A"+"\t"+"게임B"+"\t"+"총점");
         int rank =1;
         int fVal = arrList.size()-1;
         for (int i = fVal; i >= 0; i--) {
            
            System.out.println(" "+rank+"\t"+arrList.get(i).userTotal());

            if(i > 0){
               int nowTotal = arrList.get(i).total();
               int nextTotal = arrList.get(i-1).total();
               if(nowTotal > nextTotal)
                  rank++;
            }

         }
      }
   }//class end
   
   // 정렬하고 싶으면 Comparable을 상속받아라
   class UserScore implements Comparable<UserScore>{
      String user;
      int scoreA;
      int scoreB;
      int totalScore;
     
   
      public UserScore(){
    	  
      }
      public UserScore(String user, int scoreA, int scoreB) {
         this.user = user;
         this.scoreA = scoreA;
         this.scoreB = scoreB;
         this.totalScore = scoreA + scoreB;
      }
      
      public int total(){
         return this.totalScore;
      }

      public String userTotal() {
         return this.user + "\t" +this.scoreA+"\t"+ this.scoreB +"\t"+this.totalScore;
      }
   
      @Override  
      public int compareTo(UserScore o) {
         if(this.totalScore > o.totalScore)
            return 1;
         else if(this.totalScore < o.totalScore)
            return -1;
         else
            return 0;
      }
   }
   

