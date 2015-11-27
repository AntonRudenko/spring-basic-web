package ru.teamlabs.utils.db;

/**
 * Created by Anton Rudenko on 27.02.15.
 */
public class OracleDbUtils {

    private static final String paginationWrapper = "SELECT *\n" +
                                                "FROM (\n" +
                                                "       SELECT\n" +
                                                "         sub.*,\n" +
                                                "         ROWNUM rn\n" +
                                                "       FROM\n" +
                                                "         (\n" +
                                                "           %sql\n" +
                                                "         ) sub\n" +
                                                "       WHERE ROWNUM <= :toNumber\n" +
                                                "     ) sub2\n" +
                                                "WHERE sub2.rn > :fromNumber";

    private static final String countWrapper = "SELECT count(1)\n" +
                                                "FROM (\n" +
                                                "  %sql\n" +
                                                ")";


    public static String wrapWithPagination(String sql) {
        return paginationWrapper.replace("%sql", sql);
    }

    public static String wrapWithCount(String sql) {
        return countWrapper.replace("%sql", sql);
    }
}
