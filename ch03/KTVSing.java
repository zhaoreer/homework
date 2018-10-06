import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author john
 *
 * @version����ʱ�䣺2018��10��3������10:37:47
 */
/**
 * KTV���ϵͳ��
 * ��ҪӦ��  LinkedList   ��ɾ�Ĳ�
 * ���ģ�飺
 * ģ��һ��      ��ʼ���б�
 * ģ���:  �û� ��Ӹ������б�
 * ģ������     ������ ����������
 * ģ���ģ�    �����˽�����ǰ��һλ
 * ģ���� ��     �˳�ϵͳ
 * */
public class KTVSing {
	private static Scanner scanner;
	private static Scanner scanner2;
	private static Scanner scanner3;
	private static Scanner scanner4;
	
	public static void main(String[]args) {
		//TODO Auto-generated method stud
		//��ʼ���б�
		System.out.println("------��ӭ����KTV���ϵͳ-----");
		System.out.println("0------����Ӹ������б�");
		System.out.println("1------�������ö�");
		System.out.println("2------������ǰ��һλ");
		System.out.println("3------����������");
		System.out.println("4------�˳�ϵͳ");
		//�����û�������
		System.out.println("����������ʵ����Ӧ�Ĺ��ܣ�");
		//���������б�
		LinkedList<Object> linkedList=new LinkedList<>();
		//��ʼ���б�
		addListMusic(linkedList);
		while(true) {
			 scanner = new Scanner(System.in);
			 int number=scanner.nextInt();
			 switch(number) {
			 case 0:
				 addMuic(linkedList);
				 break;
			 case 1:
				 setTop(linkedList);
				 break;
			 case 2:
				 setBefore(linkedList);
				 break;
			 case 4:
				 exit();
				 break;
				 default:
					 System.out.println("����������������룡");
					 break;
			 }
		}
	}
	
	


	//ģ��һ����ʼ���б�

	private static void addListMusic(LinkedList<Object> linkedlist) {
		// TODO Auto-generated method stub
		linkedlist.add("������"+"  ����   :"+"Сʱ����");
		linkedlist.add("��Waiting In The Weeds��"+"  ����  :"+"Eagles");
		linkedlist.add("�����"+"  ����  :"+"ë����");
		linkedlist.add("����������ϲ����"+"  ����  :"+"��ȫ&������");
		linkedlist.add("������"+"  ����  :"+"���غ�");
	    linkedlist.add("��ŷ������"+"  ����  :"+"���غ�");
	    linkedlist.add("�����㡷"+"  ����  :"+"�ܽ���");
	    linkedlist.add("��That Girl��"+"  ���� :"+"Olly Murs");
	    linkedlist.add("��ԡ���ʫ��"+"  ���� :"+"�����Ȱ�&ë����");
	    linkedlist.add("��һ������"+"  ���� :"+"���Ө");
	    linkedlist.add("���������Ǻ���"+"  ���� :"+"��Դ&���ܻ�");
	    linkedlist.add("���ɲ����ԡ�"+"  ����    :"+"���Ϻ�");
	    linkedlist.add("�����ˡ�"+"  ����  :"+"����");
	    linkedlist.add("��һ��������ܡ�"+"  ����  :"+"Christine Welch");
	    linkedlist.add("��ȥ�����졷"+"  ����  :"+"����ë");
	    linkedlist.add("��ʱ��ͣ�ˡ�"+"  ����  :"+"¹��");
	    linkedlist.addLast("��Panama��"+"  ����  :"+"Matteo");
	    linkedlist.addFirst("��Wolves��"+"  ���� :"+"Selena Gonmez&marshmello");
	    linkedlist.add("��Solo��"+"  ���� :"+"Clean Bandit&Demil Lovato");
	    linkedlist.add("��Lemon��"+"  ����  :"+"�׽���ʦ");
	    linkedlist.add("���Ⱥ������"+"  ����  :"+"�ܻ���");
	    linkedlist.add("��Money Money��"+"  ����  :"+"����γ");
	  System.out.println("�赥���и�����"+linkedlist.size()+"�ף�");
	  System.out.println("�赥�б�Ϊ��");
	  Iterator<Object> itertor=linkedlist.iterator();
	  while(itertor.hasNext()) {
		  Object object=(Object)itertor.next ();
		  System.out.println(object);
		  
	  }
   	}
	  
	
	 //ģ���: ʵ�ֽ�������ӵ��б�
	
	private static void addMuic(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
		System.out.println("������Ҫ��Ӹ��������ƣ�");
		scanner2 = new Scanner(System.in);
		String addMusicName=scanner2.nextLine();
		//����ڣ������룬��֮��ӳɹ�
		if 
		(((linkedList.indexOf(addMusicName))==-1)) {
			//�������ڣ��򽫸������������ĩβ
			linkedList.addLast(addMusicName);
			System.out.println("��ӳɹ���");
		}else {
			System.out.println("��Ҫ��ӵĸ��������б���");
		}
		System.out.println("�����ǰ�赥��");
		for(Object object:linkedList) {
			System.out.println(object);
		}
		}
	
	
	//ģ�������������ö�
	
	private static void setTop(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
	    System.out.println("�����뽫Ҫ�ö��ĸ��������ƣ�");
	    scanner3 = new Scanner(System.in);
	    String topMusicName=scanner3.nextLine();
	    //��ø������б��е�λ��
	    int position;
	    position = linkedList.indexOf(topMusicName);
     	//�ж��Ƿ����ڵ�һλ
	    if (position==0) {
		System.out.println("�ø����Ѿ��ڵ�һλ��");
	    }else {
		linkedList.remove(topMusicName);
		linkedList.addFirst(topMusicName);
		System.out.println("�ö��ɹ���");
		System.out.println("�����ǰ�赥");
		for (Object object:linkedList) {
			System.out.println(object);
		}
	}
	}
	    
	
	
	
	//ģ���ģ�������ǰ��һλ

	private static void setBefore(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
		System.out.println("��������Ҫǰ�Ƶĸ��������ƣ�");
		scanner4 = new Scanner(System.in);
		String setBeforeMusicName=scanner4.nextLine();
		//���ָ���������б��е�λ��
		int position;
		 position = linkedList.indexOf(setBeforeMusicName);
		//�жϸ����Ƿ��ڵ�һλ
		if(position==0) {
			System.out.println("�ø����ѽ��ڵ�һλ���޷�ǰ�ƣ�");
		}else if(position<0) {
			System.out.println("�ø��������б��У����������룺");
		}else if(position>0) {
			//�������ڣ��Ҳ��ڵ�һλ������ǰ��
			linkedList.remove(setBeforeMusicName); 
			linkedList.add(position-1,setBeforeMusicName);
			System.out.println("ǰ��һλ�ɹ���");
			System.out.println("�����ǰ�赥");
			  Iterator<Object> iterator = linkedList.iterator();
		        while (iterator.hasNext()) {
		            Object object = (Object) iterator.next();
		            System.out.println(object);
				}
			}
	}
		
	

	//ģ���壺ʵ��ϵͳ�˳�
	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("��л����ʹ�ã�");
		System.out.println("------���Ѿ��˳�ϵͳ------");
		//�˳�����
		System.exit(0);
	}
}