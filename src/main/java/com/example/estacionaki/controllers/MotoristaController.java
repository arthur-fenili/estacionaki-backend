package com.example.estacionaki.controllers;

import com.example.estacionaki.dtos.MotoristaRequest;
import com.example.estacionaki.dtos.MotoristaResponse;
import com.example.estacionaki.models.Motorista;
import com.example.estacionaki.repositories.MotoristaRepository;
import com.example.estacionaki.services.MotoristaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    private MotoristaMapper motoristaMapper;

    @Autowired
    private MotoristaRepository motoristaRepository;


    @Operation(summary = "Cadastra um motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motorista cadastrado"),
            @ApiResponse(responseCode = "404", description = "Motorista não cadastrado")})
    @PostMapping
    public ResponseEntity<MotoristaResponse> createMotorista(@Valid @RequestBody MotoristaRequest motoristaRequest){
        Motorista motoristaConvertido = motoristaMapper.requestToMotorista(motoristaRequest);
        Motorista motoristaCriado = motoristaRepository.save(motoristaConvertido);

        MotoristaResponse motoristaResponse = motoristaMapper.motoristaToResponse(motoristaCriado);
        return ResponseEntity.ok(motoristaResponse);
    }


    @Operation(summary = "Busca todos os motoristas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motoristas encontrados"),
            @ApiResponse(responseCode = "404", description = "Motoristas não encontrados")})
    @GetMapping
    public ResponseEntity<List<MotoristaResponse>> getAllMotoristas(){
        List<Motorista> motoristas = motoristaRepository.findAll();
        List<MotoristaResponse> motoristaResponses = new ArrayList<>();
        for (Motorista motorista : motoristas) {
            motoristaResponses.add(motoristaMapper.motoristaToResponse(motorista));
        }
        return ResponseEntity.ok(motoristaResponses);
    }


    @Operation(summary = "Busca um motorista por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motorista encontrado"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")})
    @GetMapping("/{id}")
    public ResponseEntity<MotoristaResponse> getMotoristaById(@PathVariable Long id){
        Motorista motorista = motoristaRepository.findById(id).orElse(null);
        if(motorista == null){
            return ResponseEntity.notFound().build();
        }
        MotoristaResponse motoristaResponse = motoristaMapper.motoristaToResponse(motorista);
        return ResponseEntity.ok(motoristaResponse);
    }


    @Operation(summary = "Atualiza um motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Motorista atualizado"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")})
    @PutMapping("/{id}")
    public ResponseEntity<MotoristaResponse> updateMotorista(@PathVariable Long id, @Valid @RequestBody MotoristaRequest motoristaRequest){
        Optional<Motorista> motorista = motoristaRepository.findById(id);
        if (motorista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        Motorista motoristaAtualizado = motoristaMapper.requestToMotorista(motoristaRequest);
        motoristaAtualizado.setId(motorista.get().getId());
        Motorista motoristaSalvo = motoristaRepository.save(motoristaAtualizado);
        return ResponseEntity.ok(motoristaMapper.motoristaToResponse(motoristaSalvo));
    }


    @Operation(summary = "Deleta um motorista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Motorista deletado"),
            @ApiResponse(responseCode = "404", description = "Motorista não encontrado")})
    @DeleteMapping("/{id}")
    public ResponseEntity<MotoristaResponse> deleteMotorista(@PathVariable Long id){
        Optional<Motorista> motorista = motoristaRepository.findById(id);
        if (motorista.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        motoristaRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
