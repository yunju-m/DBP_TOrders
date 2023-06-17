package com.example.torder.service;

import com.example.torder.controller.MatchingForm;
import com.example.torder.domain.Content;
import com.example.torder.repository.ContentRepository;

public class ContentService {
    private final ContentRepository contentRepository;

    public ContentService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    /* 게시글 정보 가져오기 */
    public Content getContentInfo(MatchingForm matchingForm) {
        return contentRepository.getContentInfo(matchingForm);
    }
}
