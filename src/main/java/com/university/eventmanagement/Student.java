package com.university.eventmanagement;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[A-Z][a-zA-Z]*", message = "First name should start with a capital letter")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 25, message = "Age cannot exceed 25")
    private int age;

    @Enumerated(EnumType.STRING)
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }
}