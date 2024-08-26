package com.gradle.mustache.commentlike;

import com.gradle.mustache.commons.inif.IMybatisCRUD;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ICommentLikeMybatisMapper extends IMybatisCRUD<CommentLikeDto> {
    void deleteByCommentTableUserBoard(CommentLikeDto dto);
    Integer countByCommentTableUserBoard(CommentLikeDto searchDto);
}
