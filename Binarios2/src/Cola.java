import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	private Queue<Numeros> miCola;
	
	public Cola() {
		miCola=new LinkedList<Numeros>();
	}
	
	public synchronized void ponNumero(Numeros numero) {
		miCola.add(numero);
		notify();
	}

	public synchronized Numeros sacaNumero() {
		while (miCola.isEmpty()) {
			try {
				wait();
			}catch (InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
		if (!miCola.isEmpty())
			return miCola.remove();
		else return null;
	}
}
