package in.Crud.MethodObject;

import in.Crud.Method.CrudMethodImpl;
import in.Crud.Method.ICrudMethod;

public class CrudMethodObject {
	private CrudMethodObject() {
		
	}
	public static ICrudMethod crudMethod=null;
	public static ICrudMethod crudUtilMethod() {
		if(crudMethod==null)
		crudMethod=new CrudMethodImpl();
		
		return crudMethod;
	}
}
