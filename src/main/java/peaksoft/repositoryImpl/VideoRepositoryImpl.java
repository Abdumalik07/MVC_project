package peaksoft.repositoryImpl;

import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Video;
import peaksoft.repository.VideoRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class VideoRepositoryImpl implements VideoRepository {
    @PersistenceContext
    private EntityManager manager;
    @Override
    public List<Video> getAllVideo(Long id) {
        return manager.createQuery("select v from Video v where v.lesson.id = :id",Video.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void addVideo(Long lessonId, Video video) {
        Lesson lesson = manager.find(Lesson.class, lessonId);
        lesson.setVideo(video);
        video.setLesson(lesson);
        manager.persist(video);
    }

    @Override
    public Video getVideoById(Long id) {
        return manager.find(Video.class,id);
    }

    @Override
    public void updateVideo(Long id, Video video) {
        Video video1 = manager.find(Video.class, id);
        video1.setVideoName(video.getVideoName());
        video1.setLink(video.getLink());
        manager.merge(video1);
    }

    @Override
    public void deleteVideo(Long id) {
        Video video = manager.find(Video.class, id);
        video.setLesson(null);
        manager.remove(video);
    }
}
