package org.ProjetoSpringBoot.Docs;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Erro retornado pela API")
public class ProblemResponse {

    @Schema(example = "404")
    public int status;

    @Schema(example = "Recurso não encontrado")
    public String title;

    @Schema(example = "Comida com id 10 não encontrada")
    public String detail;

    @Schema(example = "/api/v1/comidas/10")
    public String instance;
}