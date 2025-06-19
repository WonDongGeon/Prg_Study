package d0616_01;

public class Main1 {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setId(100);
		s1.setName("kim");
		s1.setSungjuk(new Sungjuk(90, 90, 90));
		System.out.println(s1.toString());
		
		Sungjuk sungjuk = new Sungjuk(60, 70, 80);
		Student s2 = new Student(1, "hongkildong", sungjuk);
		System.out.println(s2.toString());
	}

}
