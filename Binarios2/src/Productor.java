

public class Productor implements Runnable{
	private int n;
	private Thread hilo;
	private Cola cola;
	public final static int BINARIO=2,OCTAL=8,HEXADECIMAL=16;
	
	Productor(int n,Cola cola){
		this.n=n;
		this.cola=cola;
		hilo=new Thread(this);
		hilo.start();
	}
	
	
	@Override
	public void run() {
		int base=(int)(Math.random()*3);
		if (base==0)base=BINARIO;
		else if (base==1) base=OCTAL; else base=HEXADECIMAL;
		String enOtraBase=convierte(n,base);
		Numeros nNumero=new Numeros(base,enOtraBase );
		cola.ponNumero(nNumero);
		System.out.println("el decimal "+n+" en base: "+base+" numero: "+enOtraBase);
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