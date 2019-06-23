package abstractClass;

public class TestAbstract {
	public static void main(String[] args) {
		People p = new Worker(33);
		System.out.println(p.getI());
		Worker w = new Worker(44);
		System.out.println(w.getI());
	}

}

abstract class People {
	String name;
	private int i;

	public abstract void eat();

	public abstract void walk();

	public People() {

	}

	//凡是类都有构造器
	public People(String name) {
		this.name = name;
	}

	public People(int i) {
		this.i = i;
	}

	public int getI() {

		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

}

class Worker extends People {
	//必须要重写所有抽象类
	@Override
	public void eat() {
		System.out.println("eat");
	}

	@Override
	public void walk() {
		System.out.println("walk");
	}

	public Worker() {
		super();
	}

	public Worker(int i) {
		super(i);
	}
}