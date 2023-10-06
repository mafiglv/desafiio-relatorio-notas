import java.util.Scanner;


public class RelatorioNotas {
    public static void main(String[] args) {
        
        Scanner leitor = new Scanner(System.in);
        
        System.out.println("\nSeja bem-vindo ao gerador de relatorio de turma!\n"
                + "\nA seguir iremos solicitar algumas informaçoes para gerar seu relatorio. =)\n");
        
        //inserindo informações turma 
        System.out.println("Insira o nome da turma: ");
        String nomeTurma = leitor.nextLine();

        System.out.println("\nInsira a quantidade de disciplinas existentes: ");
        int quantidadeDisciplinas = leitor.nextInt(); 

        System.out.println("\n\nEntendi que o nome da turma e "+nomeTurma+" e quantidade de disciplinass e "+quantidadeDisciplinas+".\n\n");
        System.out.println("\nAgora vou precisar que você me forneça alguns dados =)\n");
        
        //armazenamento de informações
        String[] nomeDisciplina = new String[quantidadeDisciplinas];
        int[] quantidadeAlunosPorDisciplina = new int[quantidadeDisciplinas];
        int[] quantidadeReprovadosPorDisciplina = new int[quantidadeDisciplinas];
        int[] quantidadeAguardandoFinalPorDisciplina = new int[quantidadeDisciplinas];
        int[] quantidadeAprovadosPorDisciplina = new int[quantidadeDisciplinas];
        double[] mediaGeralPorDisciplina = new double[quantidadeDisciplinas];
        double[] menorMediaPorDisciplina = new double[quantidadeDisciplinas];
        double[] maiorMediaPorDisciplina = new double[quantidadeDisciplinas];
        
        int totalAlunosTurma=0;
        double somaMediasTurma=0;
        
        //início de iterações de dados de turma
        for (int i = 0; i<quantidadeDisciplinas; i++){
            System.out.println("\nInsira o nome da disciplina "+(i+1)+":");    
            leitor.nextLine();
            nomeDisciplina[i]=leitor.nextLine();
                                    
            System.out.println("\nInsira a quantidade de alunos na disciplina "+(i+1)+":");
            quantidadeAlunosPorDisciplina[i] = leitor.nextInt();


            //inserindo variáveis de calculo
            double somaMediasDisciplinas = 0;
            double menorMediaDisciplina = Double.MAX_VALUE;
            double maiorMediaDisciplina = Double.MIN_VALUE;
            int alunosReprovadosPorMedia = 0;
            int alunosAprovadosPorMedia = 0;
            int alunosNaFinal = 0;
            
            //iteração de leitura de notas
            for(int x=0;x<quantidadeAlunosPorDisciplina[i];x++){
                System.out.println("\nInsira a nota da primeira avaliação do aluno "+(x+1)+";");
                double nota1=leitor.nextDouble();

                System.out.println("\nInsira a nota da segunda avaliação do aluno "+(x+1)+":");
                double nota2=leitor.nextDouble();

                //calculando a média e fazendo a utilização de operadores de atribuição e soma
                double mediaAluno=(nota1+nota2)/2;                
                somaMediasDisciplinas+=mediaAluno;
                somaMediasTurma+=mediaAluno;
                totalAlunosTurma++;


                //condições para situação do aluno
                if(mediaAluno<4){
                    //utilizando operador unário ++
                    alunosReprovadosPorMedia++;
                    quantidadeReprovadosPorDisciplina[i]++;
                }else if(mediaAluno<7){
                    alunosNaFinal++;
                    quantidadeAguardandoFinalPorDisciplina[i]++;                                   
                }else {
                    alunosAprovadosPorMedia++;
                    quantidadeAprovadosPorDisciplina[i]++;
                }
                if(mediaAluno>maiorMediaDisciplina){
                    maiorMediaDisciplina=mediaAluno;
                }
                if(mediaAluno<menorMediaDisciplina){
                    menorMediaDisciplina=mediaAluno;
                }
                
                
                }

                //Calculando médias
                double mediaDisciplina=somaMediasDisciplinas/quantidadeAlunosPorDisciplina[i];
                mediaGeralPorDisciplina[i]=mediaDisciplina;
                maiorMediaPorDisciplina[i]=maiorMediaDisciplina;
                menorMediaPorDisciplina[i]=menorMediaDisciplina;

                //Imprimindo relatório da disciplina
                System.out.println("\n### RELATORIO DA DISCIPLINA ###\n");
                System.out.println("Disciplina: "+nomeDisciplina[i]);
                System.out.println("Quantidade total de alunos: "+quantidadeAlunosPorDisciplina[i]);
                System.out.println("Media geral da disciplina: "+mediaDisciplina);
                System.out.println("Maior media da disciplina: "+maiorMediaDisciplina);
                System.out.println("Menor media da disciplina: "+menorMediaDisciplina);
                System.out.println("Quantidade de alunos APROVADOS: "+alunosAprovadosPorMedia);
                System.out.println("Quantidade de alunos REPROVADOS: "+alunosReprovadosPorMedia);
                System.out.println("Quantidade de alunos AGUARDANDO FINAL: "+alunosNaFinal);            


            }

            //Calculo da média geral da turma
            double mediaGeralTurma=somaMediasTurma/totalAlunosTurma;

            //Imprimindo relatório da turma
            System.out.println("\n### RELATORIO DA TURMA ###\n");
            System.out.println("Turma: "+nomeTurma);
            System.out.println("Quantidade de disciplinas: "+quantidadeDisciplinas);
            System.out.println("Media geral da turma: "+mediaGeralTurma);

            //Encerrando o scanner
            leitor.close();

            
    }

    
    
}
