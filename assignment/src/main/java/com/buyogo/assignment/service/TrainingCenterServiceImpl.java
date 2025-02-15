package com.buyogo.assignment.service;

import com.buyogo.assignment.converter.TrainingCenterConverter;
import com.buyogo.assignment.dto.TrainingCenterDto;
import com.buyogo.assignment.entity.TrainingCenter;
import com.buyogo.assignment.enums.ExceptionCode;
import com.buyogo.assignment.exceptions.InputValidationException;
import com.buyogo.assignment.repository.TrainingCenterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ankit Khatri
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class TrainingCenterServiceImpl implements TrainingCenterService{

    private final TrainingCenterRepository trainingCenterRepository;

    @Override
    public TrainingCenterDto saveNewTrainingCenterDetails(final TrainingCenterDto request) {
        log.info("Request received to save new training center details:{}", request);
        TrainingCenter trainingCenter = TrainingCenterConverter.prepareEntityFromDto(request);
        trainingCenter = this.trainingCenterRepository.save(trainingCenter);
        return TrainingCenterConverter.prepareDtoFromEntity(trainingCenter);
    }

    @Override
    public List<TrainingCenterDto> getAllTrainingCenter() {
        return this.trainingCenterRepository.findAll().stream().map(TrainingCenterConverter::prepareDtoFromEntity).collect(Collectors.toList());
    }

    @Override
    public TrainingCenterDto getTrainingCenterDetails(final String id) {
        Optional<TrainingCenter> trainingCenterOptional = this.trainingCenterRepository.findById(new ObjectId(id));
        if(trainingCenterOptional.isPresent()){
            return TrainingCenterConverter.prepareDtoFromEntity(trainingCenterOptional.get());
        }
        throw new InputValidationException(ExceptionCode.TRAINING_CENTER_NOT_FOUND);
    }
}
