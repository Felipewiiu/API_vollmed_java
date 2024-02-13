package med.voll.api.paciente;

import jakarta.validation.Valid;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.Endereco;

public record DadosAtualizaPaciente(Long id, String nome, String telefone, @Valid DadosEndereco endereco) {
}
