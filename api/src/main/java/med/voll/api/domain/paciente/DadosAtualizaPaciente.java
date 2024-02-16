package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosAtualizaPaciente(Long id, String nome, String telefone, @Valid DadosEndereco endereco) {
}
