import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String args[]) {
      
        PessoaFisica matheus = new PessoaFisica(1, "Matheus", "Trindade", "111.111.323-24", "12/07/1999" , "Masculino");        
        PessoaFisica lucy = new PessoaFisica(2, "Lucy", "Goiânia", "231.244.212-24", "10/03/1971", "Feminino");
        
        System.out.println("Idade "+matheus.getNome()+": "+matheus.getIdade());
        System.out.println("Idade "+lucy.getNome()+": "+lucy.getIdade());
        
        PessoaJuridica cocacola = new PessoaJuridica(3, "Coca-Cola", "Barcelona", "321.323.444-23", "Refrigerante");
        PessoaJuridica hut = new PessoaJuridica(4, "Pizza Hut", "Milão", "444.421.412-42", "Pizzaria");
        
        ContaEspecial ceMatheus = new ContaEspecial(matheus, 111, 10000, 15000);
        ContaPoupanca cpLucy = new ContaPoupanca(lucy, 222, 5000, 10);
        
        ContaEspecial ceCocacola = new ContaEspecial(cocacola, 333, 20000, 40000);
        ContaPoupanca cpHut = new ContaPoupanca(hut, 333, 20000, 20);
     
        System.out.println("----------------------------------");
        System.out.println("Saldo Matheus: R$ "+ceMatheus.getSaldo());
        ceMatheus.sacar(500);
        System.out.println("----------------------------------");
        System.out.println("Saldo Lucy: R$ "+cpLucy.getSaldo());
        cpLucy.depositar(500);
        System.out.println("----------------------------------");
        System.out.println("Saldo Coca-Cola: R$ "+ceCocacola.getSaldo());
        ceCocacola.transferir(30000, cpLucy);
        System.out.println("Saldo Coca-Cola: R$ "+ceCocacola.getSaldo());
        System.out.println("----------------------------------");
        System.out.println("Saldo Pizza Hut: R$ "+cpHut.getSaldo());
        cpHut.atualizaSaldoRendimento();
        System.out.println("----------------------------------");
        
        List<Conta> listConta = new ArrayList<Conta>();
        listConta.add(ceMatheus);
        listConta.add(cpLucy);
        listConta.add(ceCocacola);
        listConta.add(cpHut);
        
        double total = 0;
        
        for(Conta conta : listConta) {
        	System.out.println("Nome: "+conta.getCliente().getNome()+" | Saldo: R$ "+conta.getSaldo());
        	total+= conta.getSaldo();
        }
        System.out.println("----------------------------------");
        System.out.println("Total: R$ "+total);
    }
}

