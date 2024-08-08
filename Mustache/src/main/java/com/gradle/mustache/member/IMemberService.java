package com.gradle.mustache.member;

import com.gradle.mustache.ICommonService;
import com.gradle.mustache.SearchAjaxDto;
import com.gradle.mustache.security.config.dto.LoginRequest;
import com.gradle.mustache.security.config.dto.SignUpRequest;

import java.util.List;

public interface IMemberService extends ICommonService<MemberDto> {
    IMember login(LoginRequest dto);
    IMember addMember(SignUpRequest dto);
    IMember findByLoginId(String loginId);
    List<IMember> findAllByLoginIdContains(SearchAjaxDto dto);
    int countAllByLoginIdContains(SearchAjaxDto dto);
}
