package ch02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/***
 * 
 * @author 赵惹儿
 * @Title Staff.java
 * @Description:定义支付工资
 * @version创建时间：2018年10月21日下午4:31:48
 */
/***
 *      实现支付工资和查询工资记录的功能
 * 			属性:	    1.所有经理和员工的工资奖金之和 account 
 * 					2.职工列表 list，存放所有员工，包括员工、经理、股东对象
 * 					
 * 
 * 			方法:	    1.发工资pay()
 * 					2.查询某员工的工资记录findRecord()
 */
public class PaySalary{     // 除股东外的所有工资支出
	static double account=0;
	static Map<String,Employee>list=new HashMap();// 职工列表 存放所有员工，包括员工、经理、股东对象
	public void pay(double income) {   //全年盈利
		Scanner input=new Scanner(System.in);
		System.out.println("需要发放工资的月份");
		int year=input.nextInt();     //获取年月
		int month=input.nextInt();
		
		for(Map.Entry<String,Employee>entry:list.entrySet()){   //直接遍历整个职工列表，先给所有员工发工资
			if(entry.getValue() instanceof Staff) {            //判断value是否是Staff类型
				Staff person=(Staff)entry.getValue();          //强制类型转换成Staff,才可以调用子类特有函数
				String name=entry.getValue().toString();       //获取员工姓名
				System.out.println("【"+entry.getKey()+"】"+name+"工资:");  //输出职位，姓名，提示用户发工资
				double salary=input.nextDouble();             //获取发放的工资金额
				person.setSalary(year, month, salary);        //设置工资信息到工资记录中
				account+=salary;
			}else {                                           //若当前不是Staff类型，则跳出此次循环，进行下次循环，直至找遍所有Staff
				continue;	
			}			
		}
		
		for(Map.Entry<String,Employee>entry:list.entrySet()) {    //直接遍历整个职工列表,给所有经理发工资
			if(entry.getValue() instanceof Manager) {         // 判断value是否是Manager类型
				Manager person=(Manager)entry.getValue();      //强制类型转换成Manager,才可以调用子类特有的函数
			String name=entry.getValue().toString();        //获取经理姓名
			System.out.println("【"+entry.getKey()+"】"+name+"工资+奖金:");
			
			double salary=input.nextDouble();              //获取工资金额和奖金
			double bonus=input.nextDouble();
			
			person.setSalary(year, month, salary,bonus);   //设置工资到工资记录中
			//person.getSalary(year,month);测试
			
			account+=bonus+salary;      //将工资加入到工资支出	
			}else {                     //若当前不是Manager类型，则跳出此次循环，进行下次循环，直至找遍所有Manager
				continue;
			}
		}
		for(Map.Entry<String, Employee>entry:list.entrySet()) {   //直接遍历整个职工列表,给所有股东发年底分红
			if(entry.getValue() instanceof Shareowner) {       //判断value是否是Shareowner类型
				if(month!=12) {                                 //若输入月份不是12月份，则跳出，没有分红
					continue;
				}else {
					double money=(income-account)*0.1;
					Shareowner person=(Shareowner)entry.getValue();  //强制类型转换成Shareowner,才可调用子类特有的函数
					String name=entry.getValue().toString();         //获取股东姓名
					double share=person.getShare();                  //获取股东股份
					person.setSalary(year,month,money,share);        //设置某年12月的分红到工资记录中
					System.out.println("【"+entry.getKey()+"】"+name+"年底分红!");
				}
			}
		}
	}
	
	

	/***
	 * 查询某职工的工资记录
	 */
	public void findRecord() {      //提示用户输入要查询的职工名
		Scanner input=new Scanner(System.in);
		System.out.println("\n输入职工名:");
		String str=input.next();    //获取职工名
		boolean status=false;       //查找结果状态标志，false表示没找到
		
		for(Map.Entry<String, Employee>entry:list.entrySet()) {   //直接遍历整个职工列表
		if(str.equals(entry.getValue().toString())) {             //判断输入的职工名是否与某职工对象的姓名相同
			status=true;                                          //若相同，则先置状态标志为true
			System.out.println(entry.getValue().toString()+"发放记录:");//输出职工姓名
			Map<String,Double>bill=entry.getValue().getSalaryBill();  //获取该职工的工资记录
			for(Map.Entry<String, Double>object:bill.entrySet()) {    //遍历工资记录，输出所有的工资
				System.out.println(" "+object.getKey()+" 工资:"+object.getValue()+" ");
				
			}
			
		}else {                 //若当前循环找不到相同姓名的职工对象，则跳出此次，继续下一次循环
			continue;
		}
		}
		if(!status) {
			System.out.println("员工名不存在！");
		}
	}

}
