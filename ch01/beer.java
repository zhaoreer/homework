public class beer {
	public static void main(String[]agrs) {
		int beernum=99;                             //�������ͱ�������ֵ
		String word="bottles";                     
		while (beernum>0) {                         //ѭ��������beernum�Ƿ����0
			if (beernum==1) {
			word="bottle";                          //���beernum��ֵΪ1�����Word��ֵ��Ϊbottle
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


