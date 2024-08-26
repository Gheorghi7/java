package main; 

interface Aladin  {
	default Animal animal() {
		System.out.println("It just a experiment "+ getClass().getSimpleName());
		return null;
	}
	
	static void log(String description) {
		System.out.println("Date: "+new java.util.Date()+"\n"+description);
	}
}

abstract class Animal{
	public abstract void type();
	public abstract void name();
}

class Monkey extends Animal implements Aladin{
	private String type ; 
	private String name;
	
	
	
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void type() {
		System.out.println("Type: "+type);
		
	}

	@Override
	public void name() {
		this.name = this.getClass().getSimpleName();
		System.out.println("Name: "+ name+" , he just a litle "+type);
	}
	
	
}


class jtest{
	
	public static void main(String... args) {
		Monkey prob = new Monkey();
		getString(prob);
		Aladin.log("great time");
	}
	
	
	
	public static void getString(Monkey probeg) {
		probeg.setType("monkey");
		probeg.name();
		probeg.type();
		probeg.animal();
		
	}
	
	
}