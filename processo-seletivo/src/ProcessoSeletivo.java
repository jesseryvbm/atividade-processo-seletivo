import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos ={ "Vitor", "Jessica", "Paulo", "Myllena", "Andrea"};

        for (String candidato:candidatos){
            entrandoEmContato(candidato);
        }
    }
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas =1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
            tentativasRealizadas++;
            else
            System.out.println("Contato realizado com sucesso!");
        }while (continuarTentando && tentativasRealizadas < 3);
        
        if(atendeu)
        System.out.println("Conseguimos o contato com o " + candidato + "na " + tentativasRealizadas);
        else
        System.out.println("Não conseguimos o contato com o " + candidato + "foram feitas " + tentativasRealizadas);
    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirCandidatos(){
        String [] candidatos ={ "Vitor", "Jessica", "Paulo", "Myllena", "Andrea"};
        System.out.println("Imprimindo a lista de candidados, informando o indice do elemento");
        for(int indice =0;indice < candidatos.length;indice++){
            System.out.println("O candidato de nº " + indice + " é " + candidatos[indice]);
        }
    }
    static void selecaoCandidatos(){
        String [] candidatos = {"Jõao", "Karla", "Vitor", "Jessica", "Paulo", "Myllena", "Andrea", "Arthur"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase =2000.0;

        while (candidatosSelecionados < 0) {
            String candidato =candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();
            System.out.println("O candidato " + candidato + "solicitou essa proposta de salário" + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + "foi selecionado para a vaga");
                candidatosSelecionados ++;
            }
            candidatosAtual ++;
        }
        
    }
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    static void analizarCandidato(double salarioPretendido){
        Double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido){
            System.out.println("Ligar para o Candidato");
        }else if(salarioBase == salarioPretendido)
            System.out.println("Ligar para o candidato com uma contra proposta");
        else{
            System.out.println("Aguardando os resultados dos outros candidatos");
        }
            
    }
}
