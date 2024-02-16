package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadatroPaciente(
        @NotNull(message = "O campo id não pode ser nulo")
        Long id,
        @NotBlank(message = "O campo nome não pode estar em branco")
        String nome,
        @NotBlank(message = "O campo email não pode estar em branco")
        @Email
        String email,
        @NotBlank(message = "O campo telefone não pode estar em branco")
        String telefone,
        @NotNull(message = "O campo cpf não pode ser nulo")
        @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}")
        String cpf,
        @NotNull(message = "O campo cpf não pode ser nulo")
        @Valid
        DadosEndereco endereco
) {
}
