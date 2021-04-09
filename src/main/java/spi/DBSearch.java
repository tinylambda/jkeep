package spi;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DBSearch implements ISearch {
    @Override
    public List<String> search(String keyword) {
        log.info("DBSearch: " + keyword);
        return null;
    }
}
