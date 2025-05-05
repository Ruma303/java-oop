package generics;

class NoGeneric {
	private Object obj;
	public Object getObject() { return obj;	}
	public void setObject(Object obj) { this.obj = obj; }
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

public class GenericClass {
	public static void main(String[] args) {
		
		// Senza Generics
		NoGeneric noGeneric = new NoGeneric();
		noGeneric.setObject("Hello");
		String str = (String) noGeneric.getObject(); // Cast necessario
		System.out.println(str);

		noGeneric.setObject(123); // Ora può contenere un intero
		int num = (Integer) noGeneric.getObject(); // Cast necessario
		//str = (String) noGeneric.getObject(); // Errore di compilazione
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