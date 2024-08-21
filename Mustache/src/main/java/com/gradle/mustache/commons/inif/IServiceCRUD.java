package com.gradle.mustache.commons.inif;

import com.gradle.mustache.commons.dto.CUDInfoDto;

public interface IServiceCRUD<T> {
    T insert(CUDInfoDto cudInfoDto, T dto);
    T update(CUDInfoDto cudInfoDto, T dto);
    Boolean updateDeleteFlag(CUDInfoDto cudInfoDto, T dto);
    Boolean deleteById(Long id);
    T findById(Long id);
}
