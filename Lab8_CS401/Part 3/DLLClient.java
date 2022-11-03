package lab8;

public class DLLClient {

	public static void main(String[] args) {
		DLL<Integer> list = new DLL<Integer>();
		System.out.println("Teting add, contains, and remove meothds");
		list.add(1);
		list.add(2);
		System.out.println("Numbers 1 & 2 added to DLL");
		boolean a = list.contains(1);
		System.out.println("Test if contains work, out put has to be true");
		System.out.println("Output: " + a);
		System.out.println("Testing remove method");
		list.remove(1);
		a = list.contains(1);
		System.out.println("1 was removed, thus contain method should return false now");
		System.out.println("Output: " + a);
	}

}
