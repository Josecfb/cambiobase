
public class Consumidor implements Runnable{
	private Thread hilo;
	private Cola cola;
	public Consumidor(Cola cola) {
		super();
		hilo = new Thread(this);
		this.cola = cola;
		hilo.start();
	}
	
	@Override
	public void run() {
		Numeros num=cola.sacaNumero();
		int decimal=0;
		char digito;
		int base=num.getBase();
		String cadena=num.getNumero();
		int valorDig;
		for(int c=cadena.length()-1;c>=0;c--) {
			digito=num.getNumero().charAt(c);
			if (digito>='A') 
				valorDig=(int)digito-55;
			else 
				valorDig=Character.getNumericValue(digito);
			decimal+=valorDig*Math.pow(base,(cadena.length()-1-c));		
		}
		System.out.println(cadena+" en base "+ base+" es "+decimal+" en decimal");
	}
}
