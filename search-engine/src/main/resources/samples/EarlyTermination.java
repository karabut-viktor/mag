
public class EarlyTermination {
	public String a() {
		String h = "h";
		String e = "e";
		String l = "l";
		String o = "o";
		String w = "w";
		String r = "r";
		String d = "d";
		StringBuilder hello = new StringBuilder();
		hello.append(h).append(e).append(l).append(l).append(o);
		
		StringBuilder world = new StringBuilder();
		world.append(w).append(o).append(r).append(l).append(d);
		
		return hello.toString() + " " + world.toString();
	}
	
	public String b() {
		String h = "h";
		String e = "e";
		String l = "l";
		String o = "o";
		String w = "w";
		String r = "r";
		String d = "d";
		StringBuilder hello = new StringBuilder();
		hello.append(h).append(e).append(l).append(l).append(o);
		
		if ("hello".equals(hello.toString())) return "";
		
		StringBuilder world = new StringBuilder();
		world.append(w).append(o).append(r).append(l).append(d);
		
		return hello.toString() + " " + world.toString();
	}
}
