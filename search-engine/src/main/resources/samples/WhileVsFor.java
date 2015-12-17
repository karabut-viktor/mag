package samples;

import StrBuilder;
import java.util.logging.Logger;

public class WhileVsFor {
	
	public int a(int n) {
		int i = 0;
		while (i < n) {
			System.out.println(n);
			i = i + 1;
		}
	}

	public int b(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(i);
		}
	}
}
