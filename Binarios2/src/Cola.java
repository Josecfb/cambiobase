import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	private Queue<Numeros> miCola;
	
	public Cola() {
		miCola=new LinkedList<Numeros>();
	}
	
	public synchronized void ponNumero(Numeros numero) {
		miCola.add(numero);
	}

	
}
