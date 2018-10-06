//ģ��һ������һ��ս���࣬��ʼ��ս��������Ϣ

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




//ģ���������һ��StarGame�࣬ʵ����Ϸ����������
import java.util.ArrayList;
import java.util.Scanner;

public class StarGame {
	 private static Scanner scan;

	public static void main(String[] args){

         int  i=0,rad,randomX,randomY,tempX=0,tempY=0,tryTimes=0;
         String str=null;
         boolean ber=false,berHit;           

         ArrayList<Ship> ships=new ArrayList<Ship>();    //�洢ship�����Arraylist
         scan = new Scanner(System.in);

         Game myGame=new Game();                         //�ֱ𴴽��������������ֱַ�Ϊshipone��shiptwo��shipthree
         Ship ship1=new Ship();                      
         ship1.setShipName("shipone");
         ships.add(ship1);   

         Ship ship2=new Ship();          
         ship2.setShipName("shiptwo");
         ships.add(ship2);   

         Ship ship3=new Ship();
         ship3.setShipName("shipthree");
         ships.add(ship3);

         Object o=new Object();                         //�����ó���Arraylist�е�ĳ������

         
         for(Ship sh:ships){                           //���������ڵ����λ��                       
                 randomX=(int)(Math.random()*7);
                 randomY=(int)(Math.random()*7);
                 tempX=randomX+3;
                 tempY=randomY+3;
                 while(tempX>10||tempY>10){           //��ѭ��ɸȥ�������������Ĵ���λ��+3��(������Ϊ3��������Ϊ��β)��������������������������ֵΪ7
                     randomX=(int)(Math.random()*7);
                     randomY=(int)(Math.random()*7);
                     tempX=randomX+3;
                     tempY=randomY+3;
                 }       
                 rad=(int)Math.random()*7;           //���һ�������Դ����ô�ռ����λ�õķ������»����ң�
                 if(rad%2==0){
                	                                //�������������Ϊ��ά�����е����кţ����ո����кŽ�Game�����ַ������Ӧλ��Ԫ�������Ship����String���͵�Arrayli��
                      sh.addPosition(myGame.xyIntoString(randomX, randomY));
                      sh.addPosition(myGame.xyIntoString(randomX+1, randomY));  
                      sh.addPosition(myGame.xyIntoString(randomX+2, randomY)); 
                     if(!sh.arraylislIsEmpty()){     //��ӡ��������Ĵ�λ��
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
                      if(!sh.arraylislIsEmpty()){     //��ӡ��������Ĵ�λ��
                             System.out.println(sh.shipName+"in sight"); 
                             for(i=0;i<3;i++){
                                 o=sh.shipposition.get(i);
                                 System.out.println(o);
                             }
                          }      
                 }                                                                 
         }//end
         
         System.out.println("\n :) Ready for the Game,Let's do it!!\n");//׼����ʼ��Ϸ
         //�������������           
         while(!ships.isEmpty()){
             berHit=true;                                              //���ڱ�ǻ������
             System.out.println("input your attack:)\n");
             tryTimes++;                                               //��¼���Դ���
             str=scan.nextLine();                                      //�û�������Ŀ��

             for(Ship shi:ships){                                      //�����洢Ship�����ArrayList              
                 for(String st:shi.getShipString()){                   //�����洢Ship�����ArrayList�еģ�ÿ���洢String���Ͷ����Arraylist               
                     if(st.equals(str)){
                         System.out.println("You have hit "+shi.shipName+"!!");
                         shi.getShipString().remove(st);               //���к�ship�еĻ���λ��ɾȥ
                         if(shi.getShipString().isEmpty()){
                             System.out.println("OH GOD!You have sunk "+shi.shipName+"!!\nLet's sink next ship!\n");
                             ships.remove(shi);                         //�Ӵ洢Ship�����Arraylist�У�ɾȥĳ��������λ�ö����еĴ�����
                         }
                         ber=true;
                         berHit=false;
                         break;
                     }

                 }
                 if(ber){                                               //������һֻ����ֱ����������ѭ��
                     ber=false;
                     break;
                 }               
             }                                               
                if(berHit){                                            //δ������ʾ
                    System.out.println(" missed !\nCome on! try again! :) ");
                }
         } //��Ϸ����
         System.out.println("After "+tryTimes+" times hits\nI can't believe it...\n OMG!!YOU HAVE WON !!!!");         
      do {
    	  System.out.println("...");
    	  System.out.println("Input YES to continue or NO to break"); 
       }while(scan.next().equalsIgnoreCase("YES"));
     
	 }
     }//main()      



//ģ������ ��ʼ����Ϸ����7*7������                   
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
