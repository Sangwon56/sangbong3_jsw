package com.gradle.mustache.category;

import com.gradle.mustache.SearchAjaxDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMybatisMapper {
    void insert(CategoryDto dto);

    void update(CategoryDto dto);

    void deleteById(Long id);

    CategoryDto findById(long id);

    CategoryDto findByName(String name);

    List<CategoryDto> findAll();

    int countAllByNameContains(SearchAjaxDto searchAjaxDto);
    List<CategoryDto> findAllByNameContains(SearchAjaxDto searchAjaxDto);
}
