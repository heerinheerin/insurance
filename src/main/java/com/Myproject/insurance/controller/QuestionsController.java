package com.Myproject.insurance.controller;

import com.Myproject.insurance.dto.CommentDto;
import com.Myproject.insurance.dto.QuestionsDto;
import com.Myproject.insurance.entity.Comment;
import com.Myproject.insurance.entity.Member;
import com.Myproject.insurance.entity.Questions;
import com.Myproject.insurance.repository.QuestionsRepository;
import com.Myproject.insurance.service.CommentService;
import com.Myproject.insurance.service.MemberService;
import com.Myproject.insurance.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionsController {
    @Autowired
    QuestionsRepository questionsRepository;
    @Autowired
    private QuestionsService questionsService;
    @Autowired
    private CommentService commentService;

    @Autowired
    private MemberService memberService;



    @GetMapping("/questions")
    public String getQuestionsPage(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        int pageSize = 5; // 페이지당 항목 수 (원하는 숫자로 수정 가능)
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Questions> questionsPage = questionsRepository.findAll(pageable);

        List<Questions> questions = questionsPage.getContent();
        model.addAttribute("questionsList", questions);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", questionsPage.getTotalPages());

        return "questions/questions";
    }

    @GetMapping("/writeForm")
    public String writeForm(Model model, Principal principal) {
        Member member = memberService.memberload(principal.getName());
        QuestionsDto questionsDto = new QuestionsDto();
        questionsDto.setWriter(member.getName());
        model.addAttribute("questionsDto", questionsDto);
        return "questions/writeForm";
    }

    @PostMapping("/writeForm")
    public String write(QuestionsDto questionsDto, Principal principal) {
        String email = principal.getName();
        questionsService.save(questionsDto);
        return "redirect:/questions";
    }

    @GetMapping(value ="/view")
    public String viewQuestion(@RequestParam("id") Long id, Model model, Principal principal) {
        Member member = memberService.memberload(principal.getName());
        Questions question = questionsService.getQuestionById(id);
        List<Comment> comments = commentService.getCommentsByQuestionId(id);
        CommentDto commentDto = new CommentDto();
        commentDto.setWriter(member.getName());

        model.addAttribute("question", question);
        model.addAttribute("comments", comments);
        model.addAttribute("commentDto", commentDto);
        return "questions/view";
    }
    @GetMapping(value ="/view/{id}")
    public String viewQuestionId(@PathVariable("id") Long id, Model model, Principal principal) {
        Member member = memberService.memberload(principal.getName());

        Questions question = questionsService.getQuestionById(id);
        List<Comment> comments = commentService.getCommentsByQuestionId(id);
        CommentDto commentDto = new CommentDto();
        commentDto.setWriter(member.getName());

        model.addAttribute("question", question);
        model.addAttribute("comments", comments);
        model.addAttribute("commentDto", commentDto);
        return "questions/view";
    }
    @PostMapping("/questions/delete")
    public String deleteQuestion(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 현재 사용자의 권한 확인
        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            questionsService.deleteQuestionById(id);
            redirectAttributes.addFlashAttribute("message", "게시글이 삭제되었습니다.");
        } else {
            redirectAttributes.addFlashAttribute("message", "권한이 없습니다.");
        }
        return "redirect:/questions";
    }

}
