package med.voll.api.controller;

import med.voll.api.paciente.DadosCadatroPaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paciente")
public class Pacientecontroller {
    @PostMapping
    public void cadastrar(@RequestBody DadosCadatroPaciente dados){
        System.out.println(dados);

    }
}
