package com.buyogo.assignment.repository;

import com.buyogo.assignment.entity.TrainingCenter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ankit Khatri
 */
public interface TrainingCenterRepository extends MongoRepository<TrainingCenter, ObjectId> {
}
