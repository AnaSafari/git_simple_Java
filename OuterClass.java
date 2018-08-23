//We are creating an outer class enclosing two nested classes.
// A static nested class and a non-static nested class (inner class).
// In the main class and also while defining the nested classes (static class and inner class), 
//we examine the capabilities of each nested class in terms of access to the methods and 
// members defined in the outer class and also in terms of the need to a reference of outer class.
// In-line comments determine the lines of code which cause compilation errors and the reseaon for 
// those errors.
public class OuterClass {
	private static String note = "initial static message";
	private String nonStaticNote = " initial non-static message";

	private static void staticPrintOuter(){
		System.out.println("This message is generated from outside the nested classes within a static method");
	}

	private void nonStaticPrintOuter(){
		System.out.println("This message is generated from outside the nested classes within a non-static method");
	}

	public static class NestedStaticClass {
		public void printMethod(){
			
			//The following commented line of code causes compilation error since static classed canNot access the non-static 
			//methods and variables in the OuterClass directly. They can only access the static methods.
			// nonStaticPrintOuter();
			//System.out.println("This message is generated from Nested Static class: " + nonStaticNOte);
			
			//The follwing lines are ok, since static nested classed can access __ONLY__ static members in the outerclass.
			System.out.println("This message is generated from Nested Static class: " + note); // accessing a static variable
			staticPrintOuter(); // accessing a static method.
			
		}
	}

	public class InnerClass {
		
		public void printMethod(){
		
		//The following lines does not cause any compilation error since inner classed CAN access any method in the 
		//OuterClass directly.
		nonStaticPrintOuter();  //<-accessing a nonstatic method from outerclass
		staticPrintOuter();		// <- accessing a static method from outerclass 
		
		System.out.println("This message is generated from Inner class: " + nonStaticNote);//<-accessing a non-static variable
		System.out.println("This message is generated from Inner class: " + note); // accessing a static variable.
		}
	}
}

class main{
	public static void main(String args[]){
		//The folowing commented line yields a compilation error. An instance of inner class needs an instance of outer class.
		// OuterClass.InnerClass inerInstance = new OuterClass().InnerClass();
		OuterClass.InnerClass inerInstance = new OuterClass().new InnerClass(); //create instance of inner class
		// or we can do:
		// OuterClass outerInstance = new OuterClass();        
  		// OuterClass.InnerClass inerInstance  = outerInstance.new InnerClass();
		// Anyways, In order to create an instance of Inner class we need an instance of Outerclass 
       
       OuterClass outer = new OuterClass();        
       OuterClass.InnerClass inner  = outer.new InnerClass();
		inerInstance.printMethod();



		// To create an instance of a static nested class we do not need an instance of the outer class. 
		OuterClass.NestedStaticClass nestedStaticInstance = new OuterClass.NestedStaticClass(); // create instance of nested Static class
		nestedStaticInstance.printMethod();


	}
}