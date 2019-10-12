import java.util.LinkedList;
import java.util.Queue;

public class Cola {
	private Queue<Numeros> miCola;
	public final static int MAXIMO = 5;
	public Cola() {
		
		miCola=new LinkedList<Numeros>();
	}
	
	public synchronized void ponNumero(Numeros numero) {
		if (miCola.size()==MAXIMO)
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}	
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
		if (!miCola.isEmpty()) {
			notify();
			return miCola.remove();
		}
		else return null;
	}
}
