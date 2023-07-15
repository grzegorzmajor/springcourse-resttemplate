package ovh.major.springcourseresttemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ITunesResults(String trackName, String artistName) {
}
