package com.gradle.mustache.category;

import com.gradle.mustache.ICommonService;
import com.gradle.mustache.SearchAjaxDto;

import java.util.List;

public interface ICategoryService<T> extends ICommonService<T> {
    ICategory findByName(String name);
    List<ICategory> findAllByNameContains(SearchAjaxDto dto);
    int countAllByNameContains(SearchAjaxDto searchAjaxDto);
}

