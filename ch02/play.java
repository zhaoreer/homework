import java.util.InputMismatchException;                            //java�����׳��쳣
import java.util.Scanner;                                                     //����java.util���µ�Scanner�࣬��������ʹ��
public class play {
	
	       
			private static Scanner sc;

			public static void main(String[] args) {
	          int number = (int)( Math.random()*10);                    //����һ����������������Ϊ0~9֮�������
	                 int count = 0;                                                  //����һ�����͵ı�����������ֵΪ0
	                int max = 9;
	                int min = 0;
	                while (true) {
	                	 sc = new Scanner(System.in);                   //����scanner���ȴ�����
	                        System.out.println("��������Ҫ�µ����ݣ�(" + min + "~" + max + ")");
	                        try {
	                                count++;
	                                int guessNumber = sc.nextInt();
	                                
	                                if (guessNumber > number) {         //�жϲµ����ǲ�����ȷ
	                                        max = guessNumber;
	                                        System.out.println("��´���");
	                                } else if (guessNumber < number) {
	                                        min = guessNumber;
	                                        System.out.println("���С��");
	                                } else {
	                                        System.out.println("��ϲ��,����" + count + "�ξͲ�����");
	                                        System.out.println("���ʻ�Ҫ������(yes)");
	                                        sc = new Scanner(System.in);
	                                        String str = sc.nextLine();                  //Ҫ��ȡ��������ݣ�����Ҫ����Scanner��nextLine()
	                                        if ("Yes".equals(str)) {                       //�����ȡ��Yes ,�����
	                                              
	                                                number = (int) (Math.random() * 10);  //���¸�ֵ���������
	                                                count = 0;
	                                                max = 9;
	                                                min = 0;
	                                        } else {
	                                                break;
	                                        }
	                                }
	                        } catch (InputMismatchException e) {
	                                System.out.println("���������������");
	                        }
	                }
	        }
	}




                             

                                