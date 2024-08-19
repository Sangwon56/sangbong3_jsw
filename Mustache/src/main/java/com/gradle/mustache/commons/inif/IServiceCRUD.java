package com.gradle.mustache.commons.inif;

import com.gradle.mustache.commons.dto.CUDInfoDto;

public interface IServiceCRUD<T> {
    T insert(CUDInfoDto info, T dto);
    T update(CUDInfoDto info, T dto);
    Boolean updateDeleteFlag(CUDInfoDto info, T dto);
    Boolean deleteById(Long id);
    T findById(Long id);
}
