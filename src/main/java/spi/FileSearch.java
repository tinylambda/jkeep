package spi;


import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSearch implements ISearch {
    @Override
    public List<String> search(String keyword) {
        log.info("FileSearch: " + keyword);
        return null;
    }
}
