
public class Principal {

	public static void main(String[] args) {
		Cola cola =new Cola();


		for(int v=1;v<=10;v++) {
			new Productor((int)(Math.random()*1000+1), cola);
		}

	}

}
