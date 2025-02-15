package com.buyogo.assignment.converter;

import com.buyogo.assignment.dto.TrainingCenterDto;
import com.buyogo.assignment.entity.TrainingCenter;

/**
 * @author Ankit Khatri
 */
public class TrainingCenterConverter {

    public static TrainingCenter prepareEntityFromDto(final TrainingCenterDto dto){
        return TrainingCenter.builder().centerCode(dto.getCenterCode()).centerName(dto.getCenterName())
                .address(dto.getAddress()).contactEmail(dto.getContactEmail()).contactPhone(dto.getContactPhone())
                .coursesOffered(dto.getCoursesOffered()).studentCapacity(dto.getStudentCapacity()).build();
    }

    public static TrainingCenterDto prepareDtoFromEntity(final TrainingCenter entity){
        return TrainingCenterDto.builder().id(entity.getId().toHexString()).createdAt(entity.getCreatedOn().getEpochSecond()).centerCode(entity.getCenterCode()).centerName(entity.getCenterName())
                .address(entity.getAddress()).contactEmail(entity.getContactEmail()).contactPhone(entity.getContactPhone())
                .coursesOffered(entity.getCoursesOffered()).studentCapacity(entity.getStudentCapacity()).build();
    }
}
