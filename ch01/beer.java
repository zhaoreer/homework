public class beer {
	public static void main(String[]agrs) {
		int beernum=99;                             //声明类型变量并赋值
		String word="bottles";                     
		while (beernum>0) {                         //循环条件，beernum是否大于0
			if (beernum==1) {
			word="bottle";                          //如果beernum的值为1，则把Word的值赋为bottle
			}
			System.out.println(beernum+" "+word+" "+"of beer on the wall");
			System.out.println(beernum+" "+word+" "+"of beer.");
			System.out.println("Take one down.");
			System.out.println("pass it around.");
			beernum=beernum-1;
			if(beernum>0) {
				System.out.println(beernum + " " + word+" "+ " of beer on the wall");
		}
			else {
				System.out.println("no more bottles of beer on the wall");
			}
		}
	}
}


