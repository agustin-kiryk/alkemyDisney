package com.disney.alkemy.Service.impl;

import com.disney.alkemy.DTO.GeneroDTO;
import com.disney.alkemy.Entity.GeneroEntity;
import com.disney.alkemy.Repository.GeneroRepository;
import com.disney.alkemy.Service.GeneroService;
import com.disney.alkemy.mapper.GeneroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements GeneroService {
@Autowired
private GeneroMapper generoMapper;
@Autowired
 private    GeneroRepository generoRepository;


    public GeneroDTO save(GeneroDTO dto){
        GeneroEntity entity = generoMapper.generodto2Entity(dto); //convierto a entity
        GeneroEntity entitySaved = generoRepository.save(entity);    //guardardo
        GeneroDTO result = generoMapper.generoEntity2DTO(entitySaved);//convierto a DTO

        return result; //devuelvo DTO

    }


    @Override
    public List<GeneroDTO> getAllgeneros() {
        List<GeneroEntity> entities = generoRepository.findAll();
        List<GeneroDTO> result = generoMapper.generoEntityList2DTOList(entities);
        return result;
    }

    @Override
    public GeneroDTO getDetailsById(Long id) {
        Optional<GeneroEntity> entity = Optional.of(generoRepository.getReferenceById(id));
        GeneroDTO generoDTO = generoMapper.generoEntity2DTO(entity.get());
        return generoDTO;

    }

    @Override
    public void delete(Long id) {
        this.generoRepository.deleteById(id);
    }



    @Override
    public GeneroDTO update(Long id, GeneroDTO genero) {
        Optional<GeneroEntity> oldEntity = Optional.of(generoRepository.getReferenceById(id));
        GeneroEntity newEntity = generoMapper.generodto2Entity(genero);
        newEntity.setId(oldEntity.get().getId());
        GeneroEntity entitySaved = generoRepository.save(newEntity);
        GeneroDTO result = generoMapper.generoEntity2DTO(entitySaved);
        return result;
    }


}