package ch05;

import java.util.Scanner;

/*�����飺
 * ���ŷɻ��Ľ��ۺ͸����Ĺ㷺��ͨ������Ҳ�кܶ�ѡ��
 * ����ʵ�ִӳ����ص�Ŀ�ĵأ����ֽ�ͨ��ʽ��죬���÷ֱ��Ƕ��١�
 * ����Ҫ��
 * 1.���һ�������࣬���������������������һ�����󷽷���������ʱ��ͼ۸�һ��ʵ���������ó��󷽷������
 * 2.�ó������н�ͨ��ʽ���ơ�����վ��������ʱ�䡢�ӳ�վ������������ʱ�䡢ȡƱʱ�䡢����ʱ�䡢 ��ʱ�䡢
 * 	���١����ۣ�����0.32Ԫ/�������������0.45Ԫ/����ɻ�0.75Ԫ/��������ԡ�
 * 3.�ֱ�׫д�������������ɻ�����ʵ���࣬ʵ�������������ࡣ
 * 4.��дһ���ܿ����࣬���û���������ء�Ŀ�ĵغ;���������Ϣ���Զ����㲢���ÿһ�ֽ�ͨ���������ʱ�䡣
 * 
 * */
/***
 *
 * 
 *
 * @author ���Ƕ�
 * @date 2018��10��27������9:30:45
 * @version Oxygen.3a Release (4.7.3a)
 * @Description: ���������
 */


/****
 * @ClassName:Control
 * @Description:�û���������ء�Ŀ�ĵغ;���������Ϣ���Զ����㲢���ÿһ�ֽ�ͨ���������ʱ��ͷ���
 *
 */

public class Control {
	
	public static void main(String []args) {
		
		/*�½�Car�����ٶ�Ϊ100����ÿСʱ������0.32Ԫÿ����*/
		Car car=new Car(100,0.32);
		
		/*�½�HighSpeedTrain�����ٶ�Ϊ250����ÿСʱ������0.45Ԫÿ����*/
		HighSpeedTrain highspeedtrain=new HighSpeedTrain(250,0.45);
		
		/*�½�Plane�����ٶ�Ϊ870����ÿСʱ������0.75Ԫÿ����*/
		Plane plane=new Plane(870,0.75);
		
		/*�û���������ء�Ŀ�ĵء�����*/
		Scanner input=new Scanner(System.in);
		System.out.println("����������ء�Ŀ�ĵء�����:");
		
		/*��ó����ء�Ŀ�ĵء�����*/
		String from=input.next();
		String destination=input.next();	
		double distance=input.nextDouble();
		
		/*���ݾ��룬�������ַ�ʽ����ʱ��ͷ��ã�����ʾ*/
		car.show(distance);
		highspeedtrain.show(distance);
		plane.show(distance);
	}

}


