package org.animal_api.rest.controllers;

import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.rest.dtos.CowsDto;
import org.animal_api.utils.mapper.CowsMapper;
import org.animal_api.db.services.service.impl.CowsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/cows")
public class CowsController extends BaseController<CowsRepository, CowsService, CowsEntity, CowsDto, CowsMapper> {


    protected CowsController(CowsMapper mapper, CowsService service) {
        super(mapper, service);
    }

    @PostMapping("/create/{name}")
    public ResponseEntity<CowsDto> createCow(@PathVariable String name) {
        CowsDto dto = new CowsDto();
        dto.setId(null);
        dto.setName(name);
        dto.setCreatingDate(LocalDateTime.now());
        dto.setLastModificationDate(LocalDateTime.now());
        return super.create(dto);
    }

    @GetMapping("list")
    public ResponseEntity<List<CowsDto>> getAllCows() {
        return super.getAll();
    }

    @GetMapping("searchById/{id}")
    public ResponseEntity<CowsDto> getCowById(@PathVariable Long id) {
        return super.getById(id);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<CowsDto> getCowByName(@PathVariable String name) {
        return super.getByName(name);
    }

    @PutMapping("/{name}/feed")
    public ResponseEntity<Void> feed(@PathVariable String name) {
        service.grassEatBy(name);
        return ResponseEntity.noContent().build();
    }
}
