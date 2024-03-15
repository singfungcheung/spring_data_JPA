package topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired // Marks this as something that needs dependency injection.
    private TopicService topicService;
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        // Converts to Json automatically and returns as HTTP response.
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}") // {} is a variable portion.
    public Topic getTopic(@PathVariable String id) { // @PathVariable maps the {id} to the argument
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.deleteTopic(topic, id);
    }
}
