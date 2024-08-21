import java.util.Random;

public class Pastelero extends Thread {
	private static Random rand = new Random();

	private Pastel pastel;

	public Pastelero(Pastel pastel) {
		this.pastel = pastel;
	}

	public void run() {
		this.revisarPastelPedido();
		this.hacerPastel();
	}

	private void revisarPastelPedido() {
		while(!pastel.consultarEstadoPedido())
			System.out.println("Esperando a que se haga pedido pastel");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
	}

	private void hacerPastel() {
		System.out.println("Haciendo pastel");
		try {
			Thread.sleep(rand.nextInt(10000) + 5000);
		} catch (InterruptedException e) {}
		synchronized(pastel) {
			pastel.notify();
		}
	}
}