package com.gradle.mustache.member;

import com.gradle.mustache.commons.dto.SearchAjaxDto;
import com.gradle.mustache.commons.inif.IServiceCRUD;
import com.gradle.mustache.security.config.dto.LoginRequest;
import java.util.List;

public interface IMemberService extends IServiceCRUD<IMember> {
    IMember login(LoginRequest loginRequest);
    Boolean changePassword(IMember dto) throws Exception;
    IMember findByLoginId(String loginId);
    IMember findByNickname(String nickname);
    Integer countAllByNameContains(SearchAjaxDto dto);
    List<IMember> findAllByNameContains(SearchAjaxDto dto);
}
