package ch02;

import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:定义员工类
 * @version创建时间：2018年10月21日上午9:49:58
 * 
 */


  /***
   * 定义Employee的子类---员工类Staff的相关属性和方法
   *      属性： 1.职工号
   *          2.姓名
   *          3.出生月份
   *          4.工资记录
   *      方法： 1.设置工资setSalary()
   *          2.获得工资getSalary()
   *          3.获得名字toString()
   *          4.增加员工，信息输入addStaff()
   * 
   */
public class Staff extends Employee {    //构造Staff对象
	
	public Staff(String name) {          //调用基类构造函数
		super (name);	
	}
	
	public void setSalary(int year,int month,double salary) {   //设置工资到工资记录中
		if(super.getbirthMonth()==month){                       //先判断发工资的月份此员工是否过生日
			System.out.println("生日快乐！");                      //若当月过生日，则发送生日祝福礼物
		}
		//super.getSalary(year, month,salary);                          //调用基类setSalary方法                 
	}
	public void getSalary(int year,int month) {                      //调用基类setSalary方法
		super.getSalary(year, month);
	}
	 
	public String toString() {                                    //获取员工姓名
		return super.toString();
	}
	
	public void addStaff(Map<String,Employee>list) {             //增加员工
		Scanner input=new Scanner(System.in);                //从用户那里获取员工数量
		System.out.println("输入普工人数");
		int num=input.nextInt();
		if(num!=0) {   //判断员工数量是否为0
			System.out.println("输入普工的基本信息(id,姓名，生日月份):");
			for(int i=0;i<num;i++) {
				int id=input.nextInt();
			    String name=input.next();
				int month=input.nextInt();
				
				Staff employee=new Staff(name);  //用获取的信息实例化一个Staff对象
				employee.setID(id);
				employee.setbirthMonth(month);
				list.put("员工"+(i+1), employee);
			}
			
		}
	}

}
