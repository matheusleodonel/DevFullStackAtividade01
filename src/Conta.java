
public class Conta {
	private Pessoa cliente;
	private int nrConta;
	private double saldo;
	
	Conta(Pessoa cliente, int nrConta, double saldo){
		this.cliente = cliente;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}
	
	public Pessoa getCliente() {
		return cliente;
	}
	
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	
	public int getNrConta() {
		return nrConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void sacar(double valor) {
		if (this.temSaldo(valor) == true) {
			this.debitar(valor);
		}
		else {
			System.out.println("Não há saldo suficiente! Saldo atual: R$ "+ getSaldo());
		}
	}
	
	protected boolean temSaldo(double valor) {
		if (this.saldo >= valor) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void debitar(double valor) {
		this.saldo-= valor;
		System.out.println("R$ "+valor+" debitados de "+this.cliente.getNome()+"!\nNovo saldo de "+this.cliente.getNome()+
				": R$ "+this.getSaldo());
	}
	
	public void depositar(double valor) {
		this.saldo+= valor;
		System.out.println("Depositado o valor de R$ "+valor+" na conta de "
		+this.cliente.getNome()+"\nNovo saldo: R$ "+getSaldo());
	}
	
	public void transferir(double valorTransferencia, Conta contaDestino) {
		if(this.temSaldo(valorTransferencia) == true) {
			this.sacar(valorTransferencia);
			contaDestino.depositar(valorTransferencia);
			System.out.println("O valor de R$ "+valorTransferencia+" foi transferido com sucesso para "+contaDestino.cliente.getNome()+"!");
		}
		else {
			System.out.println("Não há saldo suficiente para realizar a transferência bacária.\nSaldo atual: R$ "+this.getSaldo());
		}
	}
}
