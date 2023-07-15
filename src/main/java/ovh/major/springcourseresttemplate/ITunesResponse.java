package ovh.major.springcourseresttemplate;

import java.util.List;

public record ITunesResponse (Integer resultCount, List<ITunesResults> results) {
}
