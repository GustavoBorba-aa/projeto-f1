package com.f1.management.controller; // Define o endereço (pacote) onde este arquivo mora.

// Importações: Trazem as ferramentas e classes necessárias de outros lugares do projeto.
import com.f1.management.dto.CreateCarDTO;
import com.f1.management.model.Car;
import com.f1.management.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController // Diz ao Spring que esta classe é uma "porta de entrada" para APIs (retorna JSON).
@RequestMapping("/car") // Define que todos os endereços aqui começam com http://localhost:8080/car.
public class CarController {

    @Autowired // "Injeção de Dependência": O Spring cria e gerencia o CarService para você automaticamente.
    private CarService carService;

    // POST: Usado para CRIAR novos dados.
    @PostMapping
    public ResponseEntity<Car> create(@RequestBody CreateCarDTO dto){
        // @RequestBody: Pega o JSON que você enviou no Postman e transforma no objeto 'dto'.
        Car savedCar = carService.saveCar(dto);
        // Retorna o carro criado com status 200 OK.
        return ResponseEntity.ok(savedCar);
    }

    // GET: Usado para BUSCAR/LISTAR dados.
    @GetMapping
    public ResponseEntity<List<Car>> listAll(){
        // Chama o service para buscar todos os carros no banco de dados.
        return ResponseEntity.ok(carService.findAll());
    }

    // PUT: Usado para ATUALIZAR dados existentes.
    @PutMapping("{id}") // O {id} na URL (ex: /car/1) identifica qual carro será alterado.
    public ResponseEntity<Car> update(@PathVariable Long id, @RequestBody CreateCarDTO dto){
        // @PathVariable: Pega o ID da URL.
        // @RequestBody: Pega os novos dados do corpo do JSON.
        Car updateCar = carService.updateCar(id, dto);

        // DICA: Aqui no seu código está .noContent(). Se quiser ver o carro atualizado no Postman,
        // mude para ResponseEntity.ok(updateCar).
        return ResponseEntity.noContent().build();
    }

    // DELETE: Usado para REMOVER dados.
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        // Chama o service para deletar o registro com aquele ID.
        carService.deleteCar(id);
        // Retorna status 204 No Content (sucesso, mas sem corpo de resposta).
        return ResponseEntity.noContent().build();
    }
}