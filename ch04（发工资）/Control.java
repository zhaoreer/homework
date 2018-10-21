package ch02;

import java.util.Random;
import java.util.Scanner;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:实现发工资的具体流程
 * @version创建时间：2018年10月21日上午9:49:58
 * 
 */
/***
 * 【程序简介】
 * 对于一家公司而言，发工资和各种福利是必须要做的工作，请编程实现这个功能。
 * 【要求】
 * 1.公司有员工、经理、股东三种角色
 * 2.每个角色都有姓名、工资、生日等属性
 * 3.每月15号发工资，普通员工仅发工资，经理除了工资外还有当月奖金
 * 4.公司利润为总营业额（随机运算）减去全年工资支出
 * 5.股东有股份，没有当月奖金，但有年终分红（12月份），年终分红为全年利润的10%，全部股东按照股份分红。
 * 6.全部股东的股份加起来要小于或等于100%
 * 7.每月发工资时，需要给当月过生日的员工和经理发礼物，股东没有礼物。
 * 【实现】
 * 1.员工信息在程序启动时输入
 * 2.将要发的是哪年哪月的工资由用户指定
 * 3.工资信息输出时，按照先员工，再经理，最后股东的顺序输出
 * 【改进】添加两个查询功能
 * 1.允许用户根据用户姓名，查询一个用户所有的工资、奖金和分红发放记录
 * 2.也可以查看所有员工的工资、奖金和分红发放记录
 */

public class Control {
	public static void main(String []args) {
		Random random=new Random();             //随机计算总营业额，范围5万-14万
		double income=random.nextInt(10)*10000+600000;
		System.out.println("总营业额:"+income);   //输出总营业额
		Scanner input=new Scanner(System.in);
		PaySalary pay=new PaySalary();         //完善职工列表
		Staff staff=new Staff(null);               //调用子类的空构造函数，前提是基类必有空构造函数
		staff.addStaff(PaySalary.list);        //增加员工，通过类名调用静态变量
		System.out.println("-------");
		Manager manager=new Manager(null);         //增加经理
		manager.addManager(PaySalary.list);
		System.out.println("--------");
		Shareowner shareowner=new Shareowner(null, income); //增加股东
		shareowner.addShareowner(PaySalary.list);
		System.out.println("--------");
		
		
		
		//将所有职工的信息写入EmployeeMsg.txt文件，\\是转义字符
		WriteTxt txt=new WriteTxt("D:\\Test\\EmployeeMsg.txt",PaySalary.list);  
		txt.WriteMsg();
		
		//将所有职工信息从EmployeeMsg.txt文件中读出
		ReadTxt readtxt=new ReadTxt("D:\\Test\\EmployeeMsg.txt");  
		try {
			readtxt.getMap();
		}catch(Exception e) {
			
		}
		
		System.out.println("--------");
		
		for (int i=0;i<3;i++) {
			pay.pay(income);
		}
		System.out.println("--------");
		
		
		//将所有职工工资记录写入SalaryRecord.txt文件
		WriteTxt txt1=new WriteTxt("D:\\Test\\SalaryRecord.txt",PaySalary.list);
		txt1.WriteSalary();
		
		//将所有职工工资记录从SalaryRecord.txt文件中读出
		ReadTxt readtxt1=new ReadTxt("D:\\Text\\SalaryRecord.txt");
		try {
			readtxt1.getMap();
		}catch(Exception e) {
			
		}
		
		//根据职工的姓名，查询职工的工资记录
		pay.findRecord();
		}

}
