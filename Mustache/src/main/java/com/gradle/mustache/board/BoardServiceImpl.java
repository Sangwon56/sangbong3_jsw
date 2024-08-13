package com.gradle.mustache.board;

import com.gradle.mustache.commons.dto.CUDInfoDto;
import com.gradle.mustache.commons.dto.SearchAjaxDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements IBoardService {
    @Autowired
    private IBoardMybatisMapper boardMybatisMapper;

    @Override
    public void addViewQty(Long id) {
        if ( id == null || id <= 0 ) {
            return;
        }
        this.boardMybatisMapper.addViewQty(id);
    }

    @Override
    public void addLikeQty(Long id) {
        if ( id == null || id <= 0 ) {
            return;
        }
        this.boardMybatisMapper.addLikeQty(id);
    }

    @Override
    public Integer countAllByNameContains(SearchAjaxDto searchAjaxDto) {
        if ( searchAjaxDto == null ) {
            return 0;
        }
        Integer count = this.boardMybatisMapper.countAllByNameContains(searchAjaxDto);
        return count;
    }

    @Override
    public List<BoardDto> findAllByNameContains(SearchAjaxDto searchAjaxDto) {
        if ( searchAjaxDto == null ) {
            return List.of();
        }
        searchAjaxDto.setOrderByWord( (searchAjaxDto.getSortColumn() != null ? searchAjaxDto.getSortColumn() : "id")
                + " " + (searchAjaxDto.getSortAscDsc() != null ? searchAjaxDto.getSortAscDsc() : "DESC") );
        // SQL select 문장의 ORDER BY 구문을 만들어 주는 역할
        if ( searchAjaxDto.getRowsOnePage() == null ) {
            // 한 페이지당 보여주는 행의 갯수
            searchAjaxDto.setRowsOnePage(10);
        }
        List<BoardDto> list = this.boardMybatisMapper.findAllByNameContains(searchAjaxDto);
        return list;
    }

    private List<IBoard> getInterfaceList(List<BoardDto> list) {
        if( list == null ) {
            return List.of();
        }
        List<IBoard> result = list.stream().map(item -> (IBoard)item).toList();
        return result;
    }

    @Override
    public BoardDto insert(CUDInfoDto info, BoardDto dto) {
        if ( info == null || dto == null ) {
            return null;
        }
        BoardDto insert = BoardDto.builder().build();
        insert.copyFields(dto);
        info.setCreateInfo(insert);
        this.boardMybatisMapper.insert(insert);
        return insert;
    }

    @Override
    public BoardDto update(CUDInfoDto info, BoardDto dto) {
        if ( info == null || dto == null ) {
            return null;
        }
        BoardDto update = BoardDto.builder().build();
        update.copyFields(dto);
        info.setUpdateInfo(update);
        this.boardMybatisMapper.update(update);
        return update;
    }

    @Override
    public Boolean deleteFlag(CUDInfoDto info, BoardDto dto) {
        if ( info == null || dto == null ) {
            return false;
        }
        BoardDto delete = BoardDto.builder().build();
        delete.copyFields(dto);
        info.setDeleteInfo(delete);
        this.boardMybatisMapper.deleteFlag(delete);
        return true;
    }

    @Override
    public Boolean deleteById(Long id) {
        if ( id == null || id <= 0 ) {
            return false;
        }
        this.boardMybatisMapper.deleteById(id);
        return true;
    }

    @Override
    public BoardDto findById(Long id) {
        if ( id == null || id <= 0 ) {
            return null;
        }
        BoardDto find = this.boardMybatisMapper.findById(id);
        return find;
    }
}