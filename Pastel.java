public class Pastel {
	private boolean configurado;
	private int alto;
	private int radio;
	private String saborCubierta;
	private String colorCubierta;

	

	public synchronized void hacerPedido(int alto, int radio, String saborCubierta, String colorCubierta) {
		/*
		 * Configura los atributos del pastel
		 */
		this.alto = alto;
		this.radio = radio;
		this.saborCubierta = saborCubierta;
		this.colorCubierta = colorCubierta;
		this.configurado = true;

	}

	public synchronized void consultarDetallesPedido() {
		/*
		 * Consulta los atributos del pastel 
		 */
		System.out.println("Pedido -> alto: "+ this.alto + " radio: " + this.radio + " color: "+  this.colorCubierta + " sabor: "+ this.saborCubierta);
	}

	public synchronized boolean consultarEstadoPedido() {
		/*
		 *indica si ya configuró los atributos del pastel  
		 */
		return configurado;
	}
}