package com.buyogo.assignment.controller;

import com.buyogo.assignment.dto.TrainingCenterDto;
import com.buyogo.assignment.enums.ExceptionCode;
import com.buyogo.assignment.exceptions.InputValidationException;
import com.buyogo.assignment.service.TrainingCenterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * @author Ankit Khatri
 */

@RestController
@RequestMapping("/training-center")
@RequiredArgsConstructor
public class TrainingCenterController {

    private final TrainingCenterService trainingCenterService;

    /**
     * @param request
     * @apiNote This api saves the training center details into the database.
     */
    @PostMapping
    public ResponseEntity<?> saveNewTrainingCenterDetails(@Valid @RequestBody TrainingCenterDto request, BindingResult result) {
        if(result.hasErrors()){
            final String errorMessage = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
            throw new InputValidationException(ExceptionCode.INVALID_INPUT_DATA, errorMessage);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(this.trainingCenterService.saveNewTrainingCenterDetails(request));
    }

    /**
     * @apiNote This api returns all training center details
     */
    @GetMapping
    public ResponseEntity<?> getAllTrainingCenter() {
        return ResponseEntity.ok(this.trainingCenterService.getAllTrainingCenter());
    }

    /**
     * @param trainingCenterId
     * @apiNote This api returns the training center details for the corresponding id.
     */
    @GetMapping("/{trainingCenterId}")
    public ResponseEntity<?> getTrainingCenterDetails(@PathVariable String trainingCenterId) {
        return ResponseEntity.ok(this.trainingCenterService.getTrainingCenterDetails(trainingCenterId));
    }
}
