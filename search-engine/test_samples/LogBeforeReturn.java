package samples;

import StrBuilder;
import java.util.logging.Logger;

public class VariableRename {
	public int a(int a) {
		if (a > 0) {
			if (a == 1) {
				return 2;
			} else {
				while (i > 0) {
					i = i + 1;
					return 1;
				}
			}
		} else {
			return 0;
		}
	}

	public int b(int b) {
		if (a > 0) {
			if (a == 1) {
				return 2;
			} else {
				while (i > 0) {
					i = i + 1;
					return 1;
				}
			}
		} else {
			Logger.getLogger("test").info("Test");
			return 0;
		}
	}
}
