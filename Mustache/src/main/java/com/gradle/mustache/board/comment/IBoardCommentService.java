package com.gradle.mustache.board.comment;

import com.gradle.mustache.commons.dto.CUDInfoDto;
import com.gradle.mustache.commons.dto.SearchAjaxDto;
import com.gradle.mustache.commons.inif.IServiceCRUD;
import com.gradle.mustache.member.IMember;

import java.util.List;

public interface IBoardCommentService extends IServiceCRUD<BoardCommentDto> {
    void addLikeQty(CUDInfoDto cudInfoDto, Long id);
    void subLikeQty(CUDInfoDto cudInfoDto, Long id);

    Integer countAllByBoardId(SearchAjaxDto search);
    List<BoardCommentDto> findAllByBoardId(IMember loginUser, SearchBoardCommentDto dto);
}
