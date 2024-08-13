package com.gradle.mustache.board;

import com.gradle.mustache.commons.dto.SearchAjaxDto;
import com.gradle.mustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IBoardMybatisMapper extends IMybatisCRUD<BoardDto> {
    void addViewQty(Long id);
    void addLikeQty(Long id);

    Integer countAllByNameContains(SearchAjaxDto searchAjaxDto);
    List<BoardDto> findAllByNameContains(SearchAjaxDto searchAjaxDto);
}
