package me.dio.coding.votacaobbb.api.Controller;

import me.dio.coding.votacaobbb.api.model.ParameterModel;
import me.dio.coding.votacaobbb.api.repository.ParameterRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Parameter;
import java.util.Optional;

@RestController
@RequestMapping("/api/parameters")
public class ParameterController {
    private final ParameterRepository repository;

    public ParameterController(ParameterRepository repository) {
        this.repository = repository;
    }
    @PostMapping("/salvar")
    public ResponseEntity<ParameterModel> salvar(@RequestBody ParameterModel parameter){
     ParameterModel entidade = repository.save(parameter);
    return ResponseEntity.ok(entidade);
    }
    @GetMapping("/consultar")
    public  ResponseEntity<ParameterModel> consulta(@RequestParam String key){
        Optional<ParameterModel> optParameter = repository.findById(key);
        if (optParameter.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optParameter.get());
    }
}
