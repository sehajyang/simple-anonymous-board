package com.herren.seha.controller;

import com.herren.seha.biz.board.BoardService;
import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsLikeRepository;
import com.herren.seha.dto.boards.BoardsMainResponseDto;
import com.herren.seha.dto.boards.NoticeBoardsMainResponseDto;
import com.herren.seha.util.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author seha
 * @date 2019-05-15
 */

@Controller
@AllArgsConstructor
@Log4j2
public class AnonyBoardController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AnonyBoardsLikeRepository anonyBoardsLikeRepository;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }
    @GetMapping("/lobby")
    public String lobbyPage(Model model, HttpSession session) {
        List<BoardsMainResponseDto> boardList = boardService.getAnonyBoardsLists();
        List<NoticeBoardsMainResponseDto> noticeBoardList = boardService.getNoticeBoardsLists();
        List<BoardsMainResponseDto> anonyBoardListLikeTop5 = boardService.getAnonyBoardsLikeTop5Lists();

        int todaysNewAnonyPostCount = boardService.getTodaysNewAnonyPostCount(LocalDateTime.of
                (CommonUtil.getTodayyyyyMMdd("year"), CommonUtil.getTodayyyyyMMdd("month"), CommonUtil.getTodayyyyyMMdd("day"),
                        00, 00, 00));

        model.addAttribute("anonyBoardTotalCount", boardList.size());
        model.addAttribute("noticeBoardTotalCount", noticeBoardList.size());
        model.addAttribute("boardList", CommonUtil.makeLimitListForNotice(noticeBoardList, 10));
        model.addAttribute("boardListLimit", CommonUtil.makeLimitList(boardList, 5));
        model.addAttribute("anonyBoardListLikeTop5", anonyBoardListLikeTop5);
        model.addAttribute("todaysNewAnonyPostCount", todaysNewAnonyPostCount);

        model.addAttribute("ssId", session.getAttribute("ssId"));

        return "lobby";
    }

    @GetMapping("/boards/anony")
    public String getAnonyBoardsListPage(Model model,@RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        Page<AnonyBoards> boardList = boardService.getAnonyBoardsAllList(pageNo, 3);
        model.addAttribute("boardList", boardList.getContent());
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageLastNum", boardList.getTotalPages());
        return "anony/boardList";
    }

    @GetMapping("/boards/anony/{boardNo}")
    public String getAnonyBoardsDetail(@PathVariable("boardNo") Long boardNo,
                                       Model model, HttpSession session) {
        model.addAttribute("boardDetail", boardService.getAnonyBoardsDetail(boardNo));
        model.addAttribute("boardLikeList", boardService.findByBoardNo(boardNo));
        model.addAttribute("ssId", session.getAttribute("ssId"));

        return "anony/boardDetail";
    }

    @GetMapping("/boards/anony/editor")
    public String getAnonyBoardsEditorPage() {
        return "anony/editor";
    }

    @GetMapping("/boards/anony/{boardNo}/editor")
    public String getAnonyBoardsModEditorPage(@PathVariable("boardNo") Long boardNo, Model model) {
        model.addAttribute("boardDetail", boardService.getAnonyBoardsDetail(boardNo));
        return "anony/modEditor";
    }

}
