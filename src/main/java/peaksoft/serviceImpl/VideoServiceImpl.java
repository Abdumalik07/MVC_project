package peaksoft.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Video;
import peaksoft.repository.VideoRepository;
import peaksoft.service.VideoService;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class VideoServiceImpl implements VideoService {

    private final VideoRepository videoRepository;

    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideo(Long id) {
        return videoRepository.getAllVideo(id);
    }

    @Override
    public void addVideo(Long id, Video video) {
    videoRepository.addVideo(id, video);
    }

    @Override
    public Video getVideoById(Long id) {
        return videoRepository.getVideoById(id);
    }

    @Override
    public void updateVideo(Long id, Video video) {
    videoRepository.updateVideo(id, video);
    }

    @Override
    public void deleteVideo(Long id) {
    videoRepository.deleteVideo(id);
    }
}
