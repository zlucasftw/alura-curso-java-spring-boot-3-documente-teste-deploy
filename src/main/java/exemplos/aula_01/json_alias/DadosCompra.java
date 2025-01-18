package exemplos.aula_01.json_alias;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.time.LocalDate;

public record DadosCompra(
        @JsonAlias({"produto_id", "id_produto"}) Long idProduto,
        @JsonAlias({"data_da_compra", "data_compra"}) LocalDate dataCompra
) {}
