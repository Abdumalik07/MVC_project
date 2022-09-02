package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @SequenceGenerator(name = "courses_gen",sequenceName = "courses_seq",allocationSize = 1)
    @GeneratedValue(generator = "courses_gen", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "course_name")
    private String courseName;
    @Column(name = "local_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate localDate;
    private int duration;
    private String image;
    private String description;


    @ManyToMany(cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.REMOVE}, mappedBy = "courses")
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lesson> lessons;

    @ManyToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Company company;

    public void addInstructors(Instructor instructor) {
        if (instructors == null) {
            instructors = new ArrayList<>();
        } else {
            this.instructors.add(instructor);
        }
    }

    public void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        } else {
            this.students.add(student);
        }
    }

    public void addLessons(Lesson lesson) {
        if (lessons == null) {
            lessons = new ArrayList<>();
        } else {
            this.lessons.add(lesson);
        }
    }

    public Course(String courseName, LocalDate localDate, int duration, String image, String description) {
        this.courseName = courseName;
        this.localDate = localDate;
        this.duration = duration;
        this.image = image;
        this.description = description;
    }
}
