package med.voll.api.paciente;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadatroPaciente(
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco
) {
}
