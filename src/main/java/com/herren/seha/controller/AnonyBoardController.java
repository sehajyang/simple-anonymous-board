package com.herren.seha.controller;

import com.herren.seha.biz.User.UserService;
import com.herren.seha.biz.board.BoardService;
import com.herren.seha.domain.boards.anony.AnonyBoards;
import com.herren.seha.domain.boards.anony.AnonyBoardsLikeRepository;
import com.herren.seha.domain.boards.notice.NoticeBoards;
import com.herren.seha.util.CommonUtil;
import com.herren.seha.util.Constant;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private UserService userService;

    @Autowired
    private AnonyBoardsLikeRepository anonyBoardsLikeRepository;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @GetMapping("/lobby")
    @ResponseBody
    public Object lobbyPage(Model model, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        ModelAndView mv = new ModelAndView("jsonView");
        Long anonyBoardTotalCount = boardService.getAnonyBoardsAllList(0,10 ).getTotalElements();
        Page<NoticeBoards> noticeBoardList = boardService.getNoticeBoardsLists(0, Constant.boardListCountDefault);
        List<AnonyBoards> anonyBoardListLikeTop5 = boardService.getAnonyBoardsLikeTop5Lists().getContent();
        List<String> loginHistoriesDateTimeList = userService.getdateTimeLoginHistoriesByDateTime().getContent();
        List<Integer> loginHistoriesCountList = userService.getCountLoginHistoriesByDateTime().getContent();
        List<Integer> AnonyBoardsCategoryCountList = boardService.getAnonyBoardsCategoryCountList();
        int todaysNewAnonyPostCount = boardService.getTodaysNewAnonyPostCount(LocalDateTime.of
                (CommonUtil.getTodayyyyyMMdd("year"), CommonUtil.getTodayyyyyMMdd("month"), CommonUtil.getTodayyyyyMMdd("day"),
                        00, 00, 00));
        int thisWeekRegAnonyPostCount = boardService.thisWeekRegNoticePostCount(LocalDateTime.of
                (CommonUtil.getTodayyyyyMMdd("year"), CommonUtil.getTodayyyyyMMdd("month"), CommonUtil.getTodayyyyyMMdd("day")-7,
                        00, 00, 00));

        model.addAttribute("anonyBoardTotalCount", anonyBoardTotalCount);
        model.addAttribute("noticeBoardTotalCount", noticeBoardList.getTotalElements());
        model.addAttribute("boardList", noticeBoardList.getContent());
        model.addAttribute("anonyBoardListLikeTop5", anonyBoardListLikeTop5);
        model.addAttribute("todaysNewAnonyPostCount", todaysNewAnonyPostCount);
        model.addAttribute("loginHistoriesDateTimeList", loginHistoriesDateTimeList);
        model.addAttribute("loginHistoriesCountList", loginHistoriesCountList);
        model.addAttribute("AnonyBoardsCategoryList", Constant.AnonyBoardsCategoryList);
        model.addAttribute("AnonyBoardsCategoryCountList", AnonyBoardsCategoryCountList);
        model.addAttribute("thisWeekRegAnonyPostCount", thisWeekRegAnonyPostCount);

        model.addAttribute("ssId", session.getAttribute("ssId"));

        map.put("lists",boardService.getAnonyBoardsLikeTop5Lists().getContent());
        return map;
    }

    @GetMapping("/boards/anony")
    public String getAnonyBoardsListPage(Model model, @RequestParam(value = "pageNo", defaultValue = "0") int pageNo) {
        Page<AnonyBoards> boardList = boardService.getAnonyBoardsAllList(pageNo, Constant.boardListCountDefault);
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
