package com.buyogo.assignment.service;

import com.buyogo.assignment.dto.TrainingCenterDto;

import java.util.List;

/**
 * @author Ankit Khatri
 */
public interface TrainingCenterService {

    TrainingCenterDto saveNewTrainingCenterDetails(final TrainingCenterDto request);

    List<TrainingCenterDto> getAllTrainingCenter();

    TrainingCenterDto getTrainingCenterDetails(final String id);
}
