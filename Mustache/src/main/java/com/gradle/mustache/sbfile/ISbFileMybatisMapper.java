package com.gradle.mustache.sbfile;

import com.gradle.mustache.commons.dto.SearchAjaxDto;
import com.gradle.mustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ISbFileMybatisMapper extends IMybatisCRUD<SbFileDto> {
    Integer countAllByTblBoardId(SbFileDto search);
    List<SbFileDto> findAllByTblBoardId(SbFileDto search);

    int countAllByNameContains(SearchAjaxDto dto);
    List<SbFileDto> findAllByNameContains(SearchAjaxDto dto);
}
