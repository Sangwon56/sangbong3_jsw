package com.gradle.mustache.board;

import com.gradle.mustache.commons.dto.CUDInfoDto;
import com.gradle.mustache.commons.dto.SearchAjaxDto;
import com.gradle.mustache.commons.inif.IServiceCRUD;

import java.util.List;

public interface IBoardService extends IServiceCRUD<BoardDto> {
    void addViewQty(Long id);
    void addLikeQty(CUDInfoDto cudInfoDto, Long id);

    Integer countAllByNameContains(SearchAjaxDto searchAjaxDto);
    List<BoardDto> findAllByNameContains(SearchAjaxDto searchAjaxDto);
}
