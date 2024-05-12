package com.hiring.devs.mappers;


import com.hiring.devs.dto.DeveloperDto;
import com.hiring.devs.entity.Developer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeveloperMapper {


    DeveloperMapper INSTANCE = Mappers.getMapper( DeveloperMapper.class );
    DeveloperDto developerToDeveloperDto(Developer developer);

}
