package samples;

public class EasySample {
	String s = "a";
	
	public String testMethodBody(String a) {
		String c, d;
		String b = a;
		c = b;
		a = c.substr(1,3);
		return a;
	}
	
	public void testMethodCall() {
		a.toString();
	}
	
	public int testIf(int a) {
		if (a == 1) {
			return 2;
		}
		else {
			return 3;
		}
	}
	
	public int testIf2(int a) {
		if (a > 0) {
			if (a == 1) {
				return 2;
			}
			else {
				return 3;
			}
		}
		else {
			return 0;
		}
	}
	
	public int testIf3(int a) {
		if (a > 0) {
			return 0;
		}
		return 1;
	}
	
	public int testIf4(int a) {
		if (a > 0)
			return 0;
		else 
			return 1;
	}
	
	public int testWhile1(int a) {
		int i = 1;
		while (i > 0) {
			i = i + 1;
		}
		return i;
	}
}
