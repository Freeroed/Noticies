package vlsu.ru.freeroed.notices.constants;

import org.springframework.context.annotation.Configuration;

@Configuration
public  class MySQLConstants {
    public static final String NOTICE_CREATE_REQUEST = "INSERT INTO notice(name, description) values(?,?)";
    public static final String NOTICE_UPDATE_REQUEST = "UPGRADE notice SET name = ?, description = ? WHERE id = ?";
    public static final String NOTICE_DELETE_REQUEST = "DELETE FROM notice WHERE id = ?";
    public static final String NOTICE_FIND_BY_ID_REQUEST  = "SELECT * FROM notice WHERE id = ?";
    public static final String NOTICE_FIND_ALL_REQUEST = "SELECT * FROM notice";
}
