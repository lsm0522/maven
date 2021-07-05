package chap05;

public class ExeCalculator implements Calculator {
	private Calculator delegdate;
	
	public ExeCalculator(Calculator delegdate) {
		this.delegdate = delegdate;
	}
	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
		
		long result = delegdate.factorial(num);
		
		long end = System.nanoTime();
		System.out.println("Exe: " + (end-start));
		return result;
		
	}

}
