
package com.dw.driverapp.service;

import com.dw.driverapp.exception.ResourceNotFoundException;
import com.dw.driverapp.model.Notice;
import com.dw.driverapp.model.User;
import com.dw.driverapp.repository.NoticeRepository;
import com.dw.driverapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    UserRepository userRepository;


    // 유저- 공지사항 전체를 조회
    public List<Notice> getAllNotice() {
        return noticeRepository.findAll();
    }

    // 유저- 공지사항을 id로 조회
    public Notice noticeIdFind(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("해당 공지사항이 없습니다."));
    }

    // 유저- 공지사항(제목) 검색 조회
    public List<Notice> noticeTitleFind(String title) {
        String title1 = "%" + title + "%";
        return noticeRepository.findByTitleLike(title1)
                .filter(notices -> !notices.isEmpty())
                .orElseThrow(() -> new ResourceNotFoundException("입력하신 공지사항이 없습니다."));

    }

    public Notice noticeAdd(Notice notice, String username) {
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new ResourceNotFoundException("회원이 올바르지 않습니다"));

        // 공지사항 추가 로직
        Notice notice1 = new Notice();
        notice1.setTitle(notice.getTitle());
        notice1.setContent(notice.getContent());
        notice1.setCreatedDate(LocalDateTime.now());
        // 공지사항의 작성자는 관리자로 설정해도 됩니다 (원하는대로 설정 가능)
        notice1.setCreatedBy(user.getUserName());

        return noticeRepository.save(notice1);
    }
}
