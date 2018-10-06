import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author john
 *
 * @version创建时间：2018年10月3日上午10:37:47
 */
/**
 * KTV点歌系统：
 * 主要应用  LinkedList   增删改查
 * 五个模块：
 * 模块一：      初始化列表
 * 模块二:  用户 添加歌曲至列表
 * 模块三：     主持人 将歌曲至顶
 * 模块四：    主持人将歌曲前移一位
 * 模块五 ：     退出系统
 * */
public class KTVSing {
	private static Scanner scanner;
	private static Scanner scanner2;
	private static Scanner scanner3;
	private static Scanner scanner4;
	
	public static void main(String[]args) {
		//TODO Auto-generated method stud
		//初始化列表
		System.out.println("------欢迎来到KTV点歌系统-----");
		System.out.println("0------请添加歌曲至列表");
		System.out.println("1------将歌曲置顶");
		System.out.println("2------将歌曲前移一位");
		System.out.println("3------将歌曲乱序");
		System.out.println("4------退出系统");
		//接受用户的输入
		System.out.println("请输入数字实现相应的功能：");
		//创建歌曲列表
		LinkedList<Object> linkedList=new LinkedList<>();
		//初始化列表
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
					 System.out.println("输入错误，请重新输入！");
					 break;
			 }
		}
	}
	
	


	//模块一：初始化列表

	private static void addListMusic(LinkedList<Object> linkedlist) {
		// TODO Auto-generated method stub
		linkedlist.add("《忘》"+"  歌手   :"+"小时姑娘");
		linkedlist.add("《Waiting In The Weeds》"+"  歌手  :"+"Eagles");
		linkedlist.add("《消愁》"+"  歌手  :"+"毛不易");
		linkedlist.add("《不仅仅是喜欢》"+"  歌手  :"+"萧全&孙语赛");
		linkedlist.add("《阿刁》"+"  歌手  :"+"张韶涵");
	    linkedlist.add("《欧若拉》"+"  歌手  :"+"张韶涵");
	    linkedlist.add("《稻香》"+"  歌手  :"+"周杰伦");
	    linkedlist.add("《That Girl》"+"  歌手 :"+"Olly Murs");
	    linkedlist.add("《浴火成诗》"+"  歌手 :"+"迪丽热巴&毛不易");
	    linkedlist.add("《一爱难求》"+"  歌手 :"+"徐佳莹");
	    linkedlist.add("《我想我是海》"+"  歌手 :"+"王源&刘宪华");
	    linkedlist.add("《可不可以》"+"  歌手    :"+"张紫豪");
	    linkedlist.add("《流浪》"+"  歌手  :"+"半阳");
	    linkedlist.add("《一百万个可能》"+"  歌手  :"+"Christine Welch");
	    linkedlist.add("《去年夏天》"+"  歌手  :"+"王大毛");
	    linkedlist.add("《时间停了》"+"  歌手  :"+"鹿晗");
	    linkedlist.addLast("《Panama》"+"  歌手  :"+"Matteo");
	    linkedlist.addFirst("《Wolves》"+"  歌手 :"+"Selena Gonmez&marshmello");
	    linkedlist.add("《Solo》"+"  歌手 :"+"Clean Bandit&Demil Lovato");
	    linkedlist.add("《Lemon》"+"  歌手  :"+"米津玄师");
	    linkedlist.add("《橙红年代》"+"  歌手  :"+"周华健");
	    linkedlist.add("《Money Money》"+"  歌手  :"+"杨宗纬");
	  System.out.println("歌单中有歌曲："+linkedlist.size()+"首！");
	  System.out.println("歌单列表为：");
	  Iterator<Object> itertor=linkedlist.iterator();
	  while(itertor.hasNext()) {
		  Object object=(Object)itertor.next ();
		  System.out.println(object);
		  
	  }
   	}
	  
	
	 //模块二: 实现将歌曲添加到列表
	
	private static void addMuic(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
		System.out.println("请输入要添加歌曲的名称：");
		scanner2 = new Scanner(System.in);
		String addMusicName=scanner2.nextLine();
		//如存在，则不输入，反之添加成功
		if 
		(((linkedList.indexOf(addMusicName))==-1)) {
			//若不存在，则将歌曲添加至集合末尾
			linkedList.addLast(addMusicName);
			System.out.println("添加成功！");
		}else {
			System.out.println("您要添加的歌曲已在列表中");
		}
		System.out.println("输出当前歌单：");
		for(Object object:linkedList) {
			System.out.println(object);
		}
		}
	
	
	//模块三：将歌曲置顶
	
	private static void setTop(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
	    System.out.println("请输入将要置顶的歌曲的名称：");
	    scanner3 = new Scanner(System.in);
	    String topMusicName=scanner3.nextLine();
	    //获得歌曲在列表中的位置
	    int position;
	    position = linkedList.indexOf(topMusicName);
     	//判断是否已在第一位
	    if (position==0) {
		System.out.println("该歌曲已经在第一位！");
	    }else {
		linkedList.remove(topMusicName);
		linkedList.addFirst(topMusicName);
		System.out.println("置顶成功！");
		System.out.println("输出当前歌单");
		for (Object object:linkedList) {
			System.out.println(object);
		}
	}
	}
	    
	
	
	
	//模块四：将歌曲前移一位

	private static void setBefore(LinkedList<Object> linkedList) {
		// TODO Auto-generated method stub
		System.out.println("请输入您要前移的歌曲的名称：");
		scanner4 = new Scanner(System.in);
		String setBeforeMusicName=scanner4.nextLine();
		//获得指定歌曲在列表中的位置
		int position;
		 position = linkedList.indexOf(setBeforeMusicName);
		//判断歌曲是否在第一位
		if(position==0) {
			System.out.println("该歌曲已将在第一位，无法前移！");
		}else if(position<0) {
			System.out.println("该歌曲不在列表中，请重新输入：");
		}else if(position>0) {
			//歌曲存在，且不在第一位，进行前移
			linkedList.remove(setBeforeMusicName); 
			linkedList.add(position-1,setBeforeMusicName);
			System.out.println("前移一位成功！");
			System.out.println("输出当前歌单");
			  Iterator<Object> iterator = linkedList.iterator();
		        while (iterator.hasNext()) {
		            Object object = (Object) iterator.next();
		            System.out.println(object);
				}
			}
	}
		
	

	//模块五：实现系统退出
	private static void exit() {
		// TODO Auto-generated method stub
		System.out.println("感谢您的使用！");
		System.out.println("------您已经退出系统------");
		//退出程序
		System.exit(0);
	}
}