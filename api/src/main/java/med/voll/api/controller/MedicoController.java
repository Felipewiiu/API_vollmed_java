package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicoController {
    @Autowired
    public MedicoRepository repository;

    @PostMapping
    @Transactional// é devido a escrita, atualização ou exclusão no banco de dados(concorrência)
    public void cadastrar(@RequestBody @Valid DadosCadastroMedicos dados) {
        repository.save(new Medico(dados));// aqui foi passado um construtor(dados)

    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        // para mudar a quantidade recebida basta usar a anotação @PageableDefault
        // esquema de paginação devolvendo um <Page>
        // converção de Medico para DadosListagmMedico, não precisa do Stream e da converção para o toList()
        return repository.findAll(paginacao)
                .map(DadosListagemMedicos::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }
}
