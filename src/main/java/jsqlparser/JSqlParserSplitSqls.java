package jsqlparser;

import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.Statements;

/**
 * @author felix <tinylambda@gmail.com>
 * Created on 2021-12-13
 */
@Slf4j
public class JSqlParserSplitSqls {
    public static void main(String[] args) throws JSQLParserException {
        String sqls = "select a from tableA;select b from tableB;select col2 from b;select col1, \"const \\;\" from a";
        Statements statements = CCJSqlParserUtil.parseStatements(sqls);
        for (Statement statement : statements.getStatements()) {
            log.info("{}", statement);
        }
    }
}
