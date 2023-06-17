package com.example.torder.repository;

import com.example.torder.controller.MatchingForm;
import com.example.torder.domain.Content;

public interface ContentRepository {
    Content getContentInfo(MatchingForm matchingForm);
}
