package com.gradle.mustache.sblike;

import com.gradle.mustache.commons.inif.IServiceCRUD;

public interface ISbLikeService extends IServiceCRUD<ISbLike> {
    Boolean deleteByTableUserBoard(SbLikeDto dto);
    Integer countByTableUserBoard(ISbLike searchDto);
}
