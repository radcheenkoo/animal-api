package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import org.animal_api.db.entities.GoatsEntity;
import org.animal_api.db.repositories.GoatsRepository;
import org.animal_api.rest.dtos.GoatsDto;
import org.animal_api.utils.enums.FoodType;
import org.animal_api.utils.mapper.GoatsMapper;
import org.animal_api.db.services.service.impl.GoatService;
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
    public GoatsDto createByName(@PathVariable String name){

        GoatsDto dto = new GoatsDto();
        dto.setId(null);
        dto.setName(name);
        dto.setCreatingDate(LocalDateTime.now());
        dto.setLastModificationDate(LocalDateTime.now());

        return super.create(dto);

    }

    @GetMapping("/list")
    public List<GoatsDto> getAllGoats(){
        return super.getAll();
    }

    @GetMapping("/{id}")
    public GoatsDto getGoatById(@PathVariable Long id){
        return super.getById(id);
    }

    @GetMapping("/get/{name}")
    public GoatsDto getGoatByName(@PathVariable  String name){
        return super.getByName(name);
    }
    @PutMapping("/feed/{name}")
    public void feed(@PathVariable String name){
        service.grassEatBy(name);
    }


}
