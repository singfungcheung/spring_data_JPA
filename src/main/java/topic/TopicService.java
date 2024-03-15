package topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList( // Arrays.asList is immutable.
                    new Topic("spring", "Spring Framework", "Spring Framework Description"),
                    new Topic("java", "Core Java", "Core Java Description"),
                    new Topic("javascript", "JavaScript", "Javascript Description")
            )
    );

    public List<Topic> getAllTopics() {
        return this.topics;
    }

    public Topic getTopic(String id) {
        return this.topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for (int i = 0; i < topics.size(); i++)
        {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                break;
            }
        }
    }

    public void deleteTopic(Topic topic, String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
