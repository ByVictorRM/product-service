package com.technica_studio.product_service.service;

import com.technica_studio.product_service.model.Summary;

public interface SummaryService {
    Summary getSummary();

    Summary insertSummary();

    Summary updateSummary();

    Summary removeSummary();
}
