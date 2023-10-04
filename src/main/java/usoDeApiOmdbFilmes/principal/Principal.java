package usoDeApiOmdbFilmes.principal;

import usoDeApiOmdbFilmes.model.DadosFilme;
import usoDeApiOmdbFilmes.model.DescricaoFilme;
import usoDeApiOmdbFilmes.service.ConsumoApi;
import usoDeApiOmdbFilmes.service.ConverteDados;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=6585022c";

    public void exibeMenu(){
        System.out.println("Digite o nome do filme");
        var nomeFilme = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeFilme.replace(" ","+") + API_KEY);
        DadosFilme dados = conversor.obterDados(json , DadosFilme.class);
        DescricaoFilme descricaoFilme = conversor.obterDados(json, DescricaoFilme.class);
        System.out.println(dados);
        System.out.println(descricaoFilme);

    }
}
