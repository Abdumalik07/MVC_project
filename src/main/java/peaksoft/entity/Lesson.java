package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@NoArgsConstructor
@Getter
@Setter
public class Lesson {
    @Id
    @SequenceGenerator(name = "lessons_gen", sequenceName = "lessons_seq",allocationSize = 1)
    @GeneratedValue(generator = "lessons_gen",strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name ="lesson_name")
    private String lessonName;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lesson")
    private List<Task> tasks;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "lesson")
    private Video video;

    public void addTasks(Task task) {
        if(tasks == null) {
            tasks = new ArrayList<>();
        } else {
            this.tasks.add(task);
        }
    }

    public Lesson(String lessonName) {
        this.lessonName = lessonName;
    }
}
