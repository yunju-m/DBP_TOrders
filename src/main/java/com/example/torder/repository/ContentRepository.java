package com.example.torder.repository;

import com.example.torder.controller.MatchingForm;
import com.example.torder.domain.Category;
import com.example.torder.domain.Content;

public interface ContentRepository {
    // 해당 카테고리의 모든 게시글 가져오기
    String getCategoryContentInfo(Category category);

    // 특정 게시글 정보 가져오기
    Content getContentInfo(MatchingForm matchingForm);
}
