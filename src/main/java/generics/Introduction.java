package generics;

class MyClass {
	private Object obj;
	
	public Object getObject() {
		return obj;
	}
	
	public void setObject(Object obj) {
		this.obj = obj;
	}
}

public class Introduction {
	public static void main(String[] args) {
		
		// Senza Generics
		MyClass myClass = new MyClass();
		myClass.setObject("Hello");
		String str = (String) myClass.getObject(); // Cast necessario
		System.out.println(str);

		myClass.setObject(123); // Ora può contenere un intero
		int num = (Integer) myClass.getObject(); // Cast necessario
		//str = (String) myClass.getObject(); // Errore di compilazione
		System.out.println(num);
		
		
		System.out.println("\n-------------------\n");

		// Con Generics
		
		MyGenericClass<String> myGenericClass = new MyGenericClass<String>();
		// MyGenericClass<String> myGenericClass = new MyGenericClass<>(); In alternativa
		myGenericClass.setObject("Hello");
		String strGeneric = myGenericClass.getObject(); // Nessun cast necessario
		System.out.println(strGeneric);
		
		MyGenericClass<Integer> myGenericClassInt = new MyGenericClass<>();
		myGenericClassInt.setObject(123); // Ora può contenere un intero
		int numGeneric = myGenericClassInt.getObject(); // Nessun cast necessario
		System.out.println(numGeneric);
	}
	
}

class MyGenericClass<T> {
	private T obj;

	public T getObject() {
		return obj;
	}

	public void setObject(T obj) {
		this.obj = obj;
	}
}
