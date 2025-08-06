package org.animal_api.rest.controllers;

import jakarta.validation.Valid;
import org.animal_api.db.entities.CowsEntity;
import org.animal_api.db.repositories.CowsRepository;
import org.animal_api.rest.dtos.CowsDto;
import org.animal_api.utils.mapper.CowsMapper;
import org.animal_api.db.services.service.impl.CowsService;
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
    public CowsDto createCow(@PathVariable String name) {

        CowsDto dto = new CowsDto();
        dto.setId(null);
        dto.setName(name);
        dto.setCreatingDate(LocalDateTime.now());

        return super.create(dto);
    }

    @GetMapping("/list")
    public List<CowsDto> getAllCows(){
        return super.getAll();
    }

    @GetMapping("/{id}")
    public CowsDto getCowById(@PathVariable  Long id){
        return super.getById(id);
    }

    @GetMapping("/get/{name}")
    public CowsDto getCowByName(@PathVariable  String name){
        return super.getByName(name);
    }

    @PutMapping("/feed/{name}")
    public void feed(@PathVariable String name){
        service.grassEatBy(name);
    }
}
