package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import org.animal_api.db.entities.LionsEntity;
import org.animal_api.db.repositories.LionsRepository;
import org.animal_api.rest.dtos.LionsDto;
import org.animal_api.utils.enums.FoodType;
import org.animal_api.utils.mapper.LionsMapper;
import org.animal_api.db.services.service.impl.LionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lions")
public class LionsController extends BaseController<LionsRepository, LionService, LionsEntity, LionsDto, LionsMapper>{

    protected LionsController(LionsMapper mapper, LionService service) {
        super(mapper, service);
    }

    @PostMapping("/create/{name}")
    public ResponseEntity<LionsDto> createLion(@RequestBody @Valid LionsDto dto) {
        dto.setId(null);
        dto.setCreatingDate(LocalDateTime.now());
        dto.setLastModificationDate(LocalDateTime.now());
        return super.create(dto);
    }

    @GetMapping("list")
    public ResponseEntity<List<LionsDto>> getAllLions() {
        return super.getAll();
    }

    @GetMapping("searchById/{id}")
    public ResponseEntity<LionsDto> getLionById(@PathVariable Long id) {
        return super.getById(id);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<LionsDto> getLionByName(@PathVariable String name) {
        return super.getByName(name);
    }

    @PutMapping("/{name}/feed")
    public ResponseEntity<Void> feed(@PathVariable String name,
                                     @RequestParam String foodName,
                                     @RequestParam @Valid FoodType foodType) {
        service.eat(name, foodName, foodType);
        return ResponseEntity.noContent().build();
    }

}
