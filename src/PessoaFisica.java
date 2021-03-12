import java.util.Calendar;
import java.util.ArrayList;
import java.util.List;



public class PessoaFisica extends Pessoa {
	private String cpf;
	private String dtNascimento;
	private String genero;
	
	PessoaFisica(int id, String nome, String endereco, String cpf, String dtNascimento, String genero) {
		super(id, nome, endereco);
		this.cpf = cpf;
		this.dtNascimento = dtNascimento;
		this.genero = genero;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setdtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public String getDtNascimento() {
		return dtNascimento;
	}

	public Integer getIdade() {
		String[] dataNasc = this.getDtNascimento().split("/");
		int dia = Integer.parseInt(dataNasc[0]);
		int mes = Integer.parseInt(dataNasc[1]) - 1;
		int ano = Integer.parseInt(dataNasc[2]);
		Calendar cal = Calendar.getInstance();
		int dia_atual = cal.get(Calendar.DAY_OF_MONTH);
		int mes_atual = cal.get(Calendar.MONTH);
		int ano_atual = cal.get(Calendar.YEAR);
		int atual = ano_atual*365;
		atual+= mes_atual*31;
		atual+= dia_atual;
		
		int nasc = ano*365;
		nasc+= mes*31;
		nasc+= dia;
		
		int idade = (atual - nasc)/365;
		return idade;
	}
}