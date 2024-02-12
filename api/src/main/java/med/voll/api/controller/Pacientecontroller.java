package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadatroPaciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class Pacientecontroller {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadatroPaciente dados) {
        repository.save(new Paciente(dados));

    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPaciente(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosCadatroPaciente dados){

    }
}
