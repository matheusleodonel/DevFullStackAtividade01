
public class ContaEspecial extends Conta{
	private double limite;

	ContaEspecial(Pessoa cliente, int nrConta, double saldo, double limite){
		super(cliente, nrConta, saldo);
		this.limite = limite;
	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	protected boolean temSaldo(double valor) {
		if (super.getSaldo() + this.limite >= valor) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
