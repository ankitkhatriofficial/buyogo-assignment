package com.buyogo.assignment.entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * @author Ankit Khatri
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "training_centers")
public class TrainingCenter implements Serializable {

    private static final long serialVersionUID = 37938343833l;

    @Id
    @Field(name = "_id")
    private ObjectId id;

    private String centerName;
    private String centerCode;
    private Address address;
    private Long studentCapacity;
    private List<String> coursesOffered;
    private String contactEmail;
    private String contactPhone;

    @CreatedDate
    private Instant createdOn;

    @Data
    public static class Address {

        private String details;

        @NotEmpty(message = "City must not be empty.")
        private String city;

        @NotEmpty(message = "State must not be empty.")
        private String state;

        @NotNull(message = "Pincode must not be null.")
        @Min(value = 100000, message = "Pincode must be a 6-digit number.")
        @Max(value = 999999, message = "Pincode must be a 6-digit number.")
        private Integer pincode;
    }
}
