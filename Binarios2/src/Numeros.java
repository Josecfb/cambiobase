
public class Numeros {
	private int base;
	private String numero;
	
	public Numeros(int base, String numero) {
		super();
		this.base = base;
		this.numero = numero;
	}

	public int getBase() {
		return base;
	}

	public String getNumero() {
		return numero;
	}

	@Override
	public String toString() {
		return "Numeros [base=" + base + ", numero=" + numero + "]";
	}
	
	
}
