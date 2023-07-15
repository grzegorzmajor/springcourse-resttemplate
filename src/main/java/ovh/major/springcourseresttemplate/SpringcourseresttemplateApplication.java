package ovh.major.springcourseresttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@Log4j2
public class SpringcourseresttemplateApplication {

    @Autowired
    ITunesProxy iTunesProxy;


    public static void main(String[] args) {
        SpringApplication.run(SpringcourseresttemplateApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequest() throws JsonProcessingException {
        String json = iTunesProxy.search("shawnmendes",3);
        if (json != null) {
            ITunesResponse response = mapJsonToITunesResponse(json);
            log.info(response);

        }
    }
    private ITunesResponse mapJsonToITunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ITunesResponse.class);
    }

}

