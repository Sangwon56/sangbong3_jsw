package com.gradle.mustache.boardlike;

import com.gradle.mustache.commons.inif.IServiceCRUD;

public interface IBoardLikeService extends IServiceCRUD<IBoardLike> {
    Boolean deleteByTableUserBoard(BoardLikeDto dto);
    Integer countByTableUserBoard(IBoardLike searchDto);
}
