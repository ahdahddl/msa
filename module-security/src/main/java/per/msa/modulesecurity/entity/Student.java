package per.msa.modulesecurity.entity;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
public class Student {

    private final Integer studentId;
    private final String studentName;


    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
