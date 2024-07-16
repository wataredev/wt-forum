package com.watare.wt.forum.controller;

import com.watare.wt.forum.domain.autor.Autor;
import com.watare.wt.forum.domain.autor.AutorRepository;
import com.watare.wt.forum.domain.autor.DadosAutor;
import com.watare.wt.forum.domain.autor.DadosCadastroAutor;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("autores")
@SecurityRequirement(name = "bearer-key")
public class AutorController {
    @Autowired
    private AutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroAutor(@RequestBody @Valid DadosCadastroAutor dados, UriComponentsBuilder uriBuilder){
        var autor = new Autor(dados);
        repository.save(autor);
        var uri = uriBuilder.path("/autores/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosAutor(autor));
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarAutor(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosAutor(user));
    }

    @GetMapping
    public ResponseEntity<Page<DadosAutor>> listarAutores(@PageableDefault(size = 10, sort = {"id"}) Pageable pageable){
        var page = repository.findAll(pageable).map(DadosAutor::new);
        return ResponseEntity.ok(page);
    }

}