package list;


import org.junit.jupiter.api.Test;

public class TestUnit {

	public TestUnit() {
		// TODO Auto-generated constructor stub
	}
	//@Test
	public void testLinkList() {

		Object[] objects = new Object[26];
		char a = 'a';
		int j = (int) a;
		for (int i = 0; i < 26; i++) {
			objects[i] = (char) (j + i);
		}
		MyListedList linkList = new MyListedList(objects);
		System.out.println(linkList.size);
		System.out.println(linkList.toString());
		Object t1 = 'c';
		Object t2 = 'C';
		Object t3 = 'a';
		System.out.println(linkList.indexOf(t1));
		System.out.println(linkList.indexOf(t2));
		System.out.println(linkList.indexOf(t3));
	}
	
	@Test
	public void testSqListClear() {
		SqList sqList = new SqList(26);
		char a = 'a';
		int j = (int) a;
		for (int i = 0; i < 26; i++) {
			//System.out.println("插入i>>>"+i);
			sqList.insert(i,(char) (j + i));
		}
		//sqList.display();
		sqList.clear();
		System.out.println(sqList.get(0));
	}

}
