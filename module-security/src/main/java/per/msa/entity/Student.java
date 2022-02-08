package per.msa.entity;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Student {

    private final Integer studentId;
    private final String studentName;
}
