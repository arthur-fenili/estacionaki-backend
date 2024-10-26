package com.example.estacionaki.controllers;

import com.example.estacionaki.dtos.CarroRequest;
import com.example.estacionaki.dtos.CarroResponse;
import com.example.estacionaki.models.Carro;
import com.example.estacionaki.repositories.CarroRepository;
import com.example.estacionaki.services.CarroMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroMapper carroMapper;

    @Autowired
    private CarroRepository carroRepository;


    @Operation(summary = "Cadastra um carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro cadastrado"),
            @ApiResponse(responseCode = "404", description = "Carro não cadastrado")})
    @PostMapping
    public ResponseEntity<CarroResponse> createCarro(@Valid @RequestBody CarroRequest carroRequest){
        Carro carroConvertido = carroMapper.requestToCarro(carroRequest);
        Carro carroCriado = carroRepository.save(carroConvertido);

        CarroResponse carroResponse = carroMapper.carroToResponse(carroCriado);
        return ResponseEntity.ok(carroResponse);
    }

    @Operation(summary = "Busca todos os carros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carros encontrados"),
            @ApiResponse(responseCode = "404", description = "Carros não encontrados")})
    @GetMapping
    public ResponseEntity<List<CarroResponse>> getAllCarros(){
        List<Carro> carros = carroRepository.findAll();
        List<CarroResponse> carroResponses = new ArrayList<>();
        for (Carro carro : carros) {
            carroResponses.add(carroMapper.carroToResponse(carro));
        }
        return ResponseEntity.ok(carroResponses);
    }

    @Operation(summary = "Busca um carro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrado"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")})
    @GetMapping("/{id}")
    public ResponseEntity<CarroResponse> getCarroById(@PathVariable Long id){
        Carro carro = carroRepository.findById(id).orElse(null);
        if (carro == null) {
            return ResponseEntity.notFound().build();
        }
        CarroResponse carroResponse = carroMapper.carroToResponse(carro);
        return ResponseEntity.ok(carroResponse);
    }

    @Operation(summary = "Atualiza um carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro atualizado"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")})
    @PutMapping("/{id}")
    public ResponseEntity<CarroResponse> updateCarro(@PathVariable Long id, @Valid @RequestBody CarroRequest carroRequest){
        Optional<Carro> carroSalvo = carroRepository.findById(id);
        if (carroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Carro carroConvertido = carroMapper.requestToCarro(carroRequest);
        carroConvertido.setId(id);
        Carro carroAtualizado = carroRepository.save(carroConvertido);
        CarroResponse carroResponse =carroMapper.carroToResponse(carroAtualizado);
        return new ResponseEntity<>(carroResponse, HttpStatus.OK);
    }

    @Operation(summary = "Deleta um carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Carro deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado")})
    @DeleteMapping("/{id}")
    public ResponseEntity<CarroResponse> deleteCarro(@PathVariable Long id){
        Optional<Carro> carroSalvo = carroRepository.findById(id);
        if (carroSalvo.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        carroRepository.deleteById(id);
        CarroResponse carroResponse = carroMapper.carroToResponse(carroSalvo.get());
        return new ResponseEntity<>(carroResponse, HttpStatus.NO_CONTENT);
    }

}
