package com.gradle.mustache.commentlike;

import com.gradle.mustache.commons.inif.IServiceCRUD;

public interface ICommentLikeService extends IServiceCRUD<ICommentLike> {
    Boolean deleteByCommentTableUserBoard(CommentLikeDto dto);
    Integer countByCommentTableUserBoard(ICommentLike searchDto);
}
