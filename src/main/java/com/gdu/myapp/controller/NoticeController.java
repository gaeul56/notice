package com.gdu.myapp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.gdu.myapp.dto.NoticeDto;
import com.gdu.myapp.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Controller
public class NoticeController {

	private final NoticeService noticeService;
	
	  @RequestMapping(value="/notice/list.do", method=RequestMethod.GET)
	  public String list(Model model) {
	    List<NoticeDto> noticeList = noticeService.getNoticeList();
	    model.addAttribute("noticeList", noticeList);
	    return "notice/list";
	  }
	  @RequestMapping(value="/notice/write.do", method=RequestMethod.GET)
	  public String write() {
	    return "notice/write";
	  }
	  
	  @RequestMapping(value="/notice/add.do", method=RequestMethod.POST)
	  public String add(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
	    log.info("add:" + noticeDto);
	    int addResult = noticeService.addNotice(noticeDto);
	    redirectAttributes.addFlashAttribute("addResult", addResult);
	    return "redirect:/notice/list.do";
	  }

	  @RequestMapping(value="/notice/detail.do", method=RequestMethod.GET)
	  public String detail(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, Model model) {
	    log.info("detail:" + notice_no);
	    model.addAttribute("notice", noticeService.getNoticeByNo(notice_no));
	    return "notice/detail";
	  }
	  
	  @RequestMapping(value="/notice/modify.do", method=RequestMethod.POST)
	  public String modify(NoticeDto noticeDto, RedirectAttributes redirectAttributes) {
	    log.info("modify:" + noticeDto);
	    int modifyResult = noticeService.modifyNotice(noticeDto);
	    redirectAttributes.addFlashAttribute("modifyResult", modifyResult);
	    return "redirect:/notice/detail.do?notice_no=" + noticeDto.getNotice_no();
	  }
	  
	  @RequestMapping(value="/notice/delete.do", method=RequestMethod.POST)
	  public String delete(@RequestParam(value="notice_no", required=false, defaultValue="0") int notice_no, RedirectAttributes redirectAttributes) {
	    log.info("delete:" + notice_no);
	    int deleteResult = noticeService.deleteNotice(notice_no);
	    redirectAttributes.addFlashAttribute("deleteResult", deleteResult);
	    return "redirect:/notice/list.do";
	  }
	  
}
