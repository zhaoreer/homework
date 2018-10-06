//模块一：定义一个战舰类，初始化战舰基本信息

import java.util.ArrayList;

public class Ship {
	  ArrayList<String> shipposition=new ArrayList<String>();
	    String shipName;

	    public void setShipName(String name){
	        shipName=name;
	    }
	    public String getShipName(){
	        return shipName;
	    }
	    public ArrayList<String> getShipString(){
	        return shipposition;
	    }
	    public void addPosition(String pos){
	        shipposition.add(pos);
	    }

	    void removeposition(String pos,int index){
	        shipposition.remove(index);
	    }
	    boolean arraylislIsEmpty(){
	        if(shipposition.isEmpty())
	            return true;
	        return false;
	    }



	}




//模块二：定义一个StarGame类，实现游戏运行主方法
import java.util.ArrayList;
import java.util.Scanner;

public class StarGame {
	 private static Scanner scan;

	public static void main(String[] args){

         int  i=0,rad,randomX,randomY,tempX=0,tempY=0,tryTimes=0;
         String str=null;
         boolean ber=false,berHit;           

         ArrayList<Ship> ships=new ArrayList<Ship>();    //存储ship对象的Arraylist
         scan = new Scanner(System.in);

         Game myGame=new Game();                         //分别创建三个船对象，名字分别为shipone、shiptwo、shipthree
         Ship ship1=new Ship();                      
         ship1.setShipName("shipone");
         ships.add(ship1);   

         Ship ship2=new Ship();          
         ship2.setShipName("shiptwo");
         ships.add(ship2);   

         Ship ship3=new Ship();
         ship3.setShipName("shipthree");
         ships.add(ship3);

         Object o=new Object();                         //用于拿出来Arraylist中的某个对象

         
         for(Ship sh:ships){                           //产生船所在的随机位置                       
                 randomX=(int)(Math.random()*7);
                 randomY=(int)(Math.random()*7);
                 tempX=randomX+3;
                 tempY=randomY+3;
                 while(tempX>10||tempY>10){           //用循环筛去计算机随机产生的船首位置+3后(船长度为3，加三后为船尾)溢出数组的随机数，这里数组最大值为7
                     randomX=(int)(Math.random()*7);
                     randomY=(int)(Math.random()*7);
                     tempX=randomX+3;
                     tempY=randomY+3;
                 }       
                 rad=(int)Math.random()*7;           //随机一个数，以此设置船占三个位置的方向（上下或左右）
                 if(rad%2==0){
                	                                //产生的随机数即为二维数组中的行列号，按照该行列号将Game类中字符数组对应位置元素添加至Ship类中String类型的Arrayli中
                      sh.addPosition(myGame.xyIntoString(randomX, randomY));
                      sh.addPosition(myGame.xyIntoString(randomX+1, randomY));  
                      sh.addPosition(myGame.xyIntoString(randomX+2, randomY)); 
                     if(!sh.arraylislIsEmpty()){     //打印随机产生的船位置
                         System.out.println(sh.shipName+"in sight"); 
                         for(i=0;i<3;i++){
                             o=sh.shipposition.get(i);
                             System.out.println(o);
                         }
                      }                   
                 }
                 else{
                      sh.addPosition(myGame.xyIntoString(randomX, randomY));
                      sh.addPosition(myGame.xyIntoString(randomX, randomY+1));   
                      sh.addPosition(myGame.xyIntoString(randomX, randomY+2));  
                      if(!sh.arraylislIsEmpty()){     //打印随机产生的船位置
                             System.out.println(sh.shipName+"in sight"); 
                             for(i=0;i<3;i++){
                                 o=sh.shipposition.get(i);
                                 System.out.println(o);
                             }
                          }      
                 }                                                                 
         }//end
         
         System.out.println("\n :) Ready for the Game,Let's do it!!\n");//准备开始游戏
         //依据输入击沉船           
         while(!ships.isEmpty()){
             berHit=true;                                              //用于标记击中与否
             System.out.println("input your attack:)\n");
             tryTimes++;                                               //记录尝试次数
             str=scan.nextLine();                                      //用户输入打击目标

             for(Ship shi:ships){                                      //遍历存储Ship对象的ArrayList              
                 for(String st:shi.getShipString()){                   //遍历存储Ship对象的ArrayList中的，每个存储String类型对象的Arraylist               
                     if(st.equals(str)){
                         System.out.println("You have hit "+shi.shipName+"!!");
                         shi.getShipString().remove(st);               //击中后将ship中的击中位置删去
                         if(shi.getShipString().isEmpty()){
                             System.out.println("OH GOD!You have sunk "+shi.shipName+"!!\nLet's sink next ship!\n");
                             ships.remove(shi);                         //从存储Ship对象的Arraylist中，删去某个被三个位置都击中的船对象
                         }
                         ber=true;
                         berHit=false;
                         break;
                     }

                 }
                 if(ber){                                               //若击中一只船，直接跳出两层循环
                     ber=false;
                     break;
                 }               
             }                                               
                if(berHit){                                            //未击中提示
                    System.out.println(" missed !\nCome on! try again! :) ");
                }
         } //游戏结束
         System.out.println("After "+tryTimes+" times hits\nI can't believe it...\n OMG!!YOU HAVE WON !!!!");         
      do {
    	  System.out.println("...");
    	  System.out.println("Input YES to continue or NO to break"); 
       }while(scan.next().equalsIgnoreCase("YES"));
     
	 }
     }//main()      



//模块三： 初始化游戏区域7*7的网络                   
public class Game {
	String[][] sea2d={
            {"A1","A2","A3","A4","A5","A6","A7"},
            {"B1","B2","B3","B4","B5","B6","B7"},
            {"C1","C2","C3","C4","C5","C6","C7"},
            {"D1","D2","D3","D4","D5","D6","D7"},
            {"E1","E2","E3","E4","E5","E6","E7"},
            {"F1","F2","F3","F4","F5","F6","F7"},
            {"G1","G2","G3","G4","G5","G6","G7"},
           
         };
public String xyIntoString(int x,int y){                
return sea2d[x][y];   
}
}
