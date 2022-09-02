package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tasks")
@Getter@Setter
@NoArgsConstructor
public class Task {
    @Id
    @SequenceGenerator(name = "tasks_gen",sequenceName = "tasks_seq",allocationSize = 1)
    @GeneratedValue(generator = "tasks_gen",strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text")
    private String taskText;
    @Column(name = "local_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Lesson lesson;


    public Task(String taskName, String taskText, LocalDate localDate) {
        this.taskName = taskName;
        this.taskText = taskText;
        this.localDate = localDate;
    }
}
