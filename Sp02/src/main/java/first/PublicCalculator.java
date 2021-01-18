package first;

public class PublicCalculator {
	int fNum, sNum;
	Calculator cal;
	
	PublicCalculator(int fn, int sn, Calculator c) {
		this.fNum = fn;
		this.sNum = sn;
		this.cal = c;
	}
	
	public void result() {
		int value = cal.cal(this.fNum, this.sNum);
		System.out.println("result : " + value);
	}
}
