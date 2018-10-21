package ch02;

import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:定义股东类
 * @version创建时间：2018年10月21日下午6:24:25
 */
/***
 * 定义 Shareowner类的相关属性及方法
 * 			属性:	1.职工号(继承)
 * 					2.姓名(继承)
 * 					3.出生月份(继承)
 * 					4.工资记录(继承)
 * 					5.股份 share
 * 					6.年底分红annualBonus
 * 
 * 			方法:	1.设置奖金setBonus()
 * 					2.获得股份getShare()
 * 					3.添加某年某月的工资到工资记录中setSalary()
 *					4.从工资记录中获得某年某月的工资getSalary()	
 * 					5.增加股东addShareholder()	
 *					6.获得股东姓名toString()
 */
public class Shareowner extends Employee{
	private double share;  //股份
	private double annualBonus;   //年底分红
	
	public Shareowner(String name,double share) {   //构造Shareowner对象
		super(name);
		this.share=share;
	}
	public double getShare() {
		return share;
	}
    public void setSalary(int year,int month,double money,double share) {
    	if(month!=12) {   //判断是否为12 月份，若不是12月份没有分红
    		super.setSalary(year,month,0);
    	}else {
    		super.setSalary(year,month,money*share);
    	}
    }
    
    public String toString() {
    	return super.toString();
    }
    
    public void addShareowner(Map<String,Employee>list) {    //增加股东
    	Scanner input=new Scanner(System.in);   //从用户那里获取股东数
    	System.out.println("输入股东数:");
    	int num=input.nextInt();
    	
    	double totalShare=0;    //总股份
    	if(num!=0) {
    		System.out.println("输入股东信息(id,姓名,生日月份,股份):");    //录入股东信息(id、姓名、生日月份、股份)
    		for (int i=0;i<num;i++) {
    		int id=input.nextInt();
    		String name=input.next();
    		int month=input.nextInt();
    		
    		double share=0;     //最终有效股东
    		double temShare=input.nextDouble();  //用户输入的股份
    		totalShare+=temShare;      //股份和，用来判断股份是否合法
    		if(totalShare>1) {         //总股份>1,重新录入
    			System.out.println("股份不合理，请从新输入该股东股份！");
    			double newShare=input.nextDouble();
    			share=newShare;
    		}else {
    		share=temShare;	           //股份合理，则用户输入的股份为最终有效股份
    		}
    		
    		Shareowner employee=new Shareowner(name,share);  //将获得的信息实例化成Shareholder对象
    		employee.setID(id);
    		employee.setbirthMonth(month);
    		list.put("股东"+(i+1), employee);
    		}
    	}
    }
}
