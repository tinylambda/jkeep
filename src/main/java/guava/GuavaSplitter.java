package guava;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Splitter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-08
 */
@Slf4j
public class GuavaSplitter {
    public static void main(String[] args) {
        Splitter splitter = Splitter.on(",");
        log.info("{}", splitter.splitToList(""));
        log.info("{}", splitter.splitToList("").contains("a"));

        log.info("{}", splitter.splitToList("u,y,df,a"));
        log.info("{}", splitter.splitToList("u,y,df,a").contains("a"));
    }
}
