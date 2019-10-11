

public class Productor implements Runnable{
	private int n;
	private Thread hilo;
	private Cola cola;
	
	Productor(int n,Cola cola){
		this.n=n;
		this.cola=cola;
		hilo=new Thread(this);
		hilo.start();
	}
	
	
	@Override
	public void run() {
		int base=(int)(Math.random()*3);
		if (base==0)base=2;
		else if (base==1) base=8; else base=16;
		String binario=convierte(n,base);
		Numeros nNumero=new Numeros(base, binario);
		cola.ponNumero(nNumero);
		System.out.println("número "+n+" en base: "+base+" numero: "+binario);
	}

	private String convierte(int n,int base) {
		int divi=n;
		int num;
		String resultado="";
		do {
			num=(int)(divi/base);
			resultado=resto(divi%base).concat(resultado);
			divi=num;
		}while (divi>=base);
		resultado=resto(divi).concat(resultado);
		return resultado;
	}
	
	private String sacaLetra(int r) {
		return String.valueOf((char)((r-10)+'A'));
	}
	
	private String resto(int r) {
		if (r>9)
			return sacaLetra(r);
		else
			return String.valueOf(r);
	}
}