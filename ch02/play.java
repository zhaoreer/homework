import java.util.InputMismatchException;                            //java程序抛出异常
import java.util.Scanner;                                                     //导入java.util包下的Scanner类，导入后才能使用
public class play {
	
	       
			private static Scanner sc;

			public static void main(String[] args) {
	          int number = (int)( Math.random()*10);                    //产生一个随机数，此随机数为0~9之间的整数
	                 int count = 0;                                                  //定义一个整型的变量，并赋初值为0
	                int max = 9;
	                int min = 0;
	                while (true) {
	                	 sc = new Scanner(System.in);                   //定义scanner，等待输入
	                        System.out.println("请输入你要猜的数据：(" + min + "~" + max + ")");
	                        try {
	                                count++;
	                                int guessNumber = sc.nextInt();
	                                
	                                if (guessNumber > number) {         //判断猜的数是不是正确
	                                        max = guessNumber;
	                                        System.out.println("你猜大了");
	                                } else if (guessNumber < number) {
	                                        min = guessNumber;
	                                        System.out.println("你猜小了");
	                                } else {
	                                        System.out.println("恭喜你,花了" + count + "次就猜中了");
	                                        System.out.println("请问还要继续吗？(yes)");
	                                        sc = new Scanner(System.in);
	                                        String str = sc.nextLine();                  //要获取输入的内容，则需要调用Scanner的nextLine()
	                                        if ("Yes".equals(str)) {                       //如果读取到Yes ,则继续
	                                              
	                                                number = (int) (Math.random() * 10);  //重新赋值生成随机数
	                                                count = 0;
	                                                max = 9;
	                                                min = 0;
	                                        } else {
	                                                break;
	                                        }
	                                }
	                        } catch (InputMismatchException e) {
	                                System.out.println("你输入的数据有误");
	                        }
	                }
	        }
	}




                             

                                