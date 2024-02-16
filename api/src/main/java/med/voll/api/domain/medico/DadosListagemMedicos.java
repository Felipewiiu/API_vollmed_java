package med.voll.api.domain.medico;

public record DadosListagemMedicos(Long id, String nome, String email, String crm, Especialidade especialidade) {
   // é possível criar um construtor dentro de uma record
        public DadosListagemMedicos(Medico medico){
            this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
        }
}
