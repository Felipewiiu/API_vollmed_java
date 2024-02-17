package med.voll.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)// O Bean validation lança essa exception
    public ResponseEntity tratarError400(MethodArgumentNotValidException ex){// capturando a exception
        var errors = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErrorValidacao::new).toList());
    }

    private record DadosErrorValidacao(String campo, String mensagem){
        public DadosErrorValidacao(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }
}
