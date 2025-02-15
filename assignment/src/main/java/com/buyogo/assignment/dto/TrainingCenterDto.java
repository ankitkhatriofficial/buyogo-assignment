package com.buyogo.assignment.dto;

import com.buyogo.assignment.entity.TrainingCenter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ankit Khatri
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingCenterDto implements Serializable {

    private static final long serialVersionUID = 32863873292L;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long createdAt;

    @NotEmpty(message = "Center name is required.")
    @Length(min = 3, max = 40, message = "Center name must be between 3 and 40 characters.")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Center name must contain only alphabetic characters and spaces.")
    private String centerName;

    @NotEmpty(message = "Center code is required.")
    @Length(min = 3, max = 12, message = "Center code must be between 3 and 12 characters.")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Center code must contain only alphanumeric characters.")
    private String centerCode;

    @Valid
    @NotNull(message = "Address details are required.")
    private TrainingCenter.Address address;

    @NotNull(message = "Student capacity is required.")
    @Min(value = 1, message = "Student capacity must be at least 1.")
    private Long studentCapacity;

    @NotEmpty(message = "At least one course must be offered.")
    private List<String> coursesOffered;

    @Email(message = "Invalid email format. Please enter a valid email address.")
    private String contactEmail;

    @NotEmpty(message = "Contact phone is required.")
    @Pattern(regexp = "^[6789]\\d{9}$", message = "Invalid phone number. Must be a 10-digit Indian mobile number starting with 6, 7, 8, or 9.")
    private String contactPhone;
}
