package com.gradle.mustache.sbfile;

import com.gradle.mustache.board.BoardDto;
import com.gradle.mustache.commons.inif.IServiceCRUD;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ISbFileService extends IServiceCRUD<ISbFile> {
    List<ISbFile> findAllByTblBoardId(ISbFile search);
    Boolean insertFiles(BoardDto boardDto, MultipartFile[] files);
    Boolean updateFiles(BoardDto boardDto, List<SbFileDto> sbFileDtoList);
    byte[] getBytesFromFile(ISbFile down);
}
