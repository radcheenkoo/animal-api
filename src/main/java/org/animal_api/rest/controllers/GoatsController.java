package org.animal_api.rest.controllers;

import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.rest.dtos.GoatsDto;
import org.animal_api.utils.mapper.GoatsMapper;
import org.animal_api.db.services.service.impl.GoatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/goats")
public class GoatsController extends BaseController<GoatsRepository, GoatService, GoatsEntity, GoatsDto, GoatsMapper>{

    protected GoatsController(GoatsMapper mapper, GoatService service) {
        super(mapper, service);
    }

    @PostMapping("/create/{name}")
    public ResponseEntity<GoatsDto> createByName(@PathVariable String name) {
        GoatsDto dto = new GoatsDto();
        dto.setId(null);
        dto.setName(name);
        dto.setCreatingDate(LocalDateTime.now());
        dto.setLastModificationDate(LocalDateTime.now());
        return super.create(dto);
    }

    @GetMapping("list")
    public ResponseEntity<List<GoatsDto>> getAllGoats() {
        return super.getAll();
    }

    @GetMapping("searchById/{id}")
    public ResponseEntity<GoatsDto> getGoatById(@PathVariable Long id) {
        return super.getById(id);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<GoatsDto> getGoatByName(@PathVariable String name) {
        return super.getByName(name);
    }

    @PutMapping("/{name}/feed")
    public ResponseEntity<Void> feed(@PathVariable String name) {
        service.grassEatBy(name);
        return ResponseEntity.noContent().build();
    }


}
