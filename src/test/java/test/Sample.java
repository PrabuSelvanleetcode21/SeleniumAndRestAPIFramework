package test;

import java.util.HashMap;
import java.util.Map;

public class Sample {
	
	private static  String name="Prabu";
	
	private static Map<String, String> hmap = new HashMap<String, String>();

//	eager loading before the execution  starts it will load all the necessary data
	static {
		name="Selvan";
		hmap.put("name", "dhanu");
	}
	
	public static void main(String[] args) {

		Sample obj = new Sample();
//		System.out.println("inside static method "+obj.name);
		System.out.println("inside static method "+ name);
		System.out.println(hmap.get("name"));
	}
}
