package charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.mozilla.universalchardet.UniversalDetector;

import lombok.extern.slf4j.Slf4j;


/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-11-05
 */
@Slf4j
public class CharsetDetector {
    public static String guessEncoding(byte[] bytes) {
        String defaultEncoding = "UTF-8";
        UniversalDetector detector = new UniversalDetector(null);
        detector.handleData(bytes, 0, bytes.length);
        detector.dataEnd();
        String encoding = detector.getDetectedCharset();
        detector.reset();
        if (encoding == null) {
            encoding = defaultEncoding;
        }
        return encoding;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = "字段含义,用户ID,这是一些测试数据";
        byte[] gbk = text.getBytes("GBK");
        byte[] utf8 = text.getBytes(StandardCharsets.UTF_8);

        log.info("{}", guessEncoding(gbk));
        log.info("{}", guessEncoding(utf8));
    }
}
