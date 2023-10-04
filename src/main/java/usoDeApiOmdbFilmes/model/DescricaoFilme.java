package usoDeApiOmdbFilmes.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DescricaoFilme(@JsonAlias("Plot") String resumo) {
    public DescricaoFilme {
        resumo = resumo.replace(",", ",\n");
    }

}