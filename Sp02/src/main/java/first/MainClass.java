package first;

public class MainClass {
	public static void main(String[] args) {
		
		/*
		CalMul cm = new CalMul();
		c = cm;
		int result = c.cal(10, 30);
		System.out.println("Mul. result: " + result);
		
		CalDiv cd = new CalDiv();
		c = cd;
		result = c.cal(30, 4);
		System.out.println("Div. result: " + result);
		
		CalSum cs = new CalSum();
		c = cs;
		result = c.cal(30, 4);
		System.out.println("Sum. result: " + result);
		
		CalSub cb = new CalSub();
		c = cb;
		result = c.cal(30, 4);
		System.out.println("Sub. result: " + result);
		*/
		
		PublicCalculator cal = new PublicCalculator(30, 20, new CalSum());
		cal.result();
		cal = new PublicCalculator(30, 20, new CalSub());
		cal.result();
		cal = new PublicCalculator(30, 20, new CalMul());
		cal.result();
		cal = new PublicCalculator(30, 20, new CalDiv());
		cal.result();
		
	}
}
