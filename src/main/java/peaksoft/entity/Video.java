package peaksoft.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "videos")
@NoArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @SequenceGenerator(name = "videos_gen",sequenceName = "videos_seq",allocationSize = 1)
    @GeneratedValue(generator = "videos_gen", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "video_name")
    private String videoName;
    private String link;

    @OneToOne(cascade = {
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
            CascadeType.DETACH})
    private Lesson lesson;

    public Video(String videoName, String link) {
        this.videoName = videoName;
        this.link = link;
    }
}
