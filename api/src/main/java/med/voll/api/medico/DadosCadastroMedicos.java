package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedicos(
        @NotBlank//garante te o campo não seja vazio ou em branco e ele precisa ser uma string
        String nome,
        @Email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,
        @NotNull//
        Especialidade especialidade,

       @NotNull @Valid DadosEndereco endereco // garante que ocorra a validação dentro do DTO DadosEndereco
) {

}
