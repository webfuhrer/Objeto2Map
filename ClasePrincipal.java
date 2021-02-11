package paquete.reflection;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ClasePrincipal {
public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
Perro p=new Perro("Mastín", "Marron", 10);
Map mapa=objetoAMapa(p);

System.out.println(mapa);
}

public static Map<String, Object> objetoAMapa(Object c) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
{
	Map<String, Object> mapa=new HashMap();
	Field[] campos=c.getClass().getDeclaredFields();
	for(Field campo: campos)
	{
	String nombre_campo=campo.getName();
	Field f=c.getClass().getDeclaredField(nombre_campo);
	f.setAccessible(true);
	Object valor_campo=f.get(c);
	mapa.put(nombre_campo, valor_campo);
	System.out.println(nombre_campo+" VALOR: "+valor_campo);
	}
	return mapa;
}

}
