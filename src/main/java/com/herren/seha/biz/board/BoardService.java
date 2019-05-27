package com.herren.seha.biz.board;

import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsLike;
import com.herren.seha.domain.boards.anony.AnonyBoardsLikeRepository;
import com.herren.seha.domain.boards.anony.AnonyBoardsRepository;
import com.herren.seha.domain.boards.notice.NoticeBoards;
import com.herren.seha.domain.boards.notice.NoticeBoardsRepository;
import com.herren.seha.dto.boards.BoardsLikeSaveRequestDto;
import com.herren.seha.dto.boards.BoardsSaveRequestDto;
import com.herren.seha.dto.boards.NoticeBoardsSaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author seha
 * @date 2019-05-15
 */

@AllArgsConstructor
@Service
@Log4j2
public class BoardService {
    private AnonyBoardsRepository anonyBoardsRepository;
    private AnonyBoardsLikeRepository anonyBoardsLikeRepository;
    private NoticeBoardsRepository noticeBoardsRepository;

    @Transactional
    public Long regAnonyBoards(BoardsSaveRequestDto dto) {
        return anonyBoardsRepository.save(dto.toEntity()).getBoardNo();
    }

    @Transactional(readOnly = true)
    public AnonyBoards getAnonyBoardsDetail(Long boardNo) {
        return anonyBoardsRepository.getBoardDetail(boardNo);
    }

    @Transactional
    public int modAnonyBoards(Long boardNo, String title, String content, String passwd, String category, String sendyn) {
        String uuid = UUID.randomUUID().toString();
        return anonyBoardsRepository.modBoard(boardNo, title, content, passwd, category, sendyn, uuid);
    }

    @Transactional
    public int delAnonyBoards(Long boardNo) {
        return anonyBoardsRepository.delBoard(boardNo);
    }

    @Transactional(readOnly = true)
    public Page<NoticeBoards> getNoticeBoardsLists(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size, new Sort(Sort.Direction.DESC, "boardNo"));
        return noticeBoardsRepository.findAll(pageable);
    }

    @Transactional
    public Long regNoticeBoards(NoticeBoardsSaveRequestDto dto) {
        return noticeBoardsRepository.save(dto.toEntity()).getBoardNo();
    }

    @Transactional
    public int modNoticeBoards(Long boardNo, String title, String content, String category) {
        String uuid = UUID.randomUUID().toString();
        return noticeBoardsRepository.modBoard(boardNo, title, content, uuid, category);
    }

    @Transactional
    public int delNoticeBoards(Long boardNo) {
        return noticeBoardsRepository.delBoard(boardNo);
    }

    @Transactional(readOnly = true)
    public NoticeBoards getNoticeBoardsDetail(Long boardNo) {
        return noticeBoardsRepository.getBoardDetail(boardNo);
    }

    @Transactional(readOnly = true)
    public String getBoardsCheckPasswd(Long boardNo, String passwd) {
        return anonyBoardsRepository.getBoardsCheckPasswd(boardNo, passwd);
    }

    @Transactional
    public int doBoardsLikeCountPlus(Long boardNo, Long userNo) {
        AnonyBoards ab = new AnonyBoards();
        ab.setBoardNo(boardNo);

        BoardsLikeSaveRequestDto dto = new BoardsLikeSaveRequestDto();
        dto.setBoardNo(ab);
        dto.setUserNo(userNo);

        anonyBoardsLikeRepository.save(dto.toEntity());
        return anonyBoardsRepository.doBoardsLikeCountPlus(boardNo);
    }

    @Transactional(readOnly = true)
    public int getBoardsNowLikeCount(Long boardNo) {
        return anonyBoardsRepository.getBoardsNowLikeCount(boardNo);
    }

    @Transactional(readOnly = true)
    public Page<AnonyBoards> getAnonyBoardsLikeTop5Lists() {
        Pageable pageable = PageRequest.of(0, 5, new Sort(Sort.Direction.DESC, "hit"));
        return anonyBoardsRepository.findAll(pageable);
    }

    @Transactional
    public int modAnonyBoardsSetSendYn(Long boardNo, String yn) {
        return anonyBoardsRepository.modAnonyBoardsSetSendYn(boardNo, yn);
    }

    @Transactional(readOnly = true)
    public int getTodaysNewAnonyPostCount(LocalDateTime currentDate) {
        return anonyBoardsRepository.getTodaysNewAnonyPostCount(currentDate);
    }

    @Transactional(readOnly = true)
    public Object findByBoardNo(Long boardNo) {
        AnonyBoards an = new AnonyBoards();
        an.setBoardNo(boardNo);
        return anonyBoardsLikeRepository.findByBoardNo(an);
    }

    @Transactional(readOnly = true)
    public AnonyBoardsLike findByBoardNoAndUserNo(Long boardNo, Long userNo) {
        AnonyBoards an = new AnonyBoards();
        an.setBoardNo(boardNo);
        return anonyBoardsLikeRepository.findByBoardNoAndUserNo(an, userNo);
    }

    @Transactional(readOnly = true)
    public Page<AnonyBoards> getAnonyBoardsAllList(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size, new Sort(Sort.Direction.DESC, "boardNo"));
        return anonyBoardsRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public Page<NoticeBoards> getNoticeBoardsAllList(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size, new Sort(Sort.Direction.DESC, "boardNo"));
        return noticeBoardsRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    public List<String> getAnonyBoardsCategoryList() {
        return anonyBoardsRepository.getAnonyBoardsCategoryList();
    }

    @Transactional(readOnly = true)
    public List<Integer> getAnonyBoardsCategoryCountList() {
        return anonyBoardsRepository.getAnonyBoardsCategoryCountList();
    }

    @Transactional(readOnly = true)
    public int thisWeekRegNoticePostCount(LocalDateTime currentDate) {
        return noticeBoardsRepository.getThisWeekRegNoticePostCount(currentDate);
    }

}
