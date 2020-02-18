package vlsu.ru.freeroed.notices.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import vlsu.ru.freeroed.notices.constants.MySQLConstants;
import vlsu.ru.freeroed.notices.dao.NoticieDAO;
import vlsu.ru.freeroed.notices.domain.Notice;
import vlsu.ru.freeroed.notices.web.rest.NoticeResource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
public class NoticeDAOImpl implements NoticieDAO {

    @Autowired
    JdbcTemplate template;
    private static final Logger logger = Logger.getLogger(NoticeDAOImpl.class);

    MySQLConstants mySQLConstants;

    @Override
    public int create(Notice notice){
        String request = mySQLConstants.NOTICE_CREATE_REQUEST;
        Object[] params = {notice.getName(), notice.getDescription()};
        int[] types = {Types.VARCHAR, Types.VARCHAR};
        int result = template.update(request, params, types);
        System.out.println(result);
        logger.debug("DAO request to create notice: {}" + notice.toString() );
        return  result;
    }

    @Override
    public List<Notice> getAll() {
        String request = mySQLConstants.NOTICE_FIND_ALL_REQUEST;
        List<Notice> result = template.query(request, new NoticeRowMapper());
        logger.debug("DAO request to get All Noticies");
        return result;
    }

    @Override
    public Notice findById(int id) {
        String request = mySQLConstants.NOTICE_FIND_BY_ID_REQUEST;
        logger.debug("DAO request to find notice by id: {} " + id);
        return template.queryForObject(request, new Object[]{id}, new BeanPropertyRowMapper<Notice>(Notice.class));
    }

    @Override
    public int update(Notice notice) {
        String request = mySQLConstants.NOTICE_UPDATE_REQUEST;
        Object[] params = {notice.getName(), notice.getDescription(), notice.getId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        int result = template.update(request, params, types);
        logger.debug("DAO request to update notice: {}" + notice.toString() );
        return result;
    }

    @Override
    public void delete(int id) {
        String request = mySQLConstants.NOTICE_DELETE_REQUEST;
        Object[] params = {id};
        int[] types = {Types.VARCHAR};
        logger.debug("DAO request to delete notice: {}" + id );
        template.update(request,params,types);
    }
    public class NoticelResultSetExtractor implements ResultSetExtractor{
        @Override
        public Object extractData(ResultSet rs) throws SQLException{
            Notice notice = new Notice();
            notice.setId(rs.getInt(1));
            notice.setName(rs.getString(2));
            notice.setDescription(rs.getString(3));
            return notice;
        }
    }

    public class  NoticeRowMapper implements RowMapper {
        @Override
        public  Object mapRow(ResultSet rs, int line) throws SQLException{
            NoticelResultSetExtractor extractor = new NoticelResultSetExtractor();
            return extractor.extractData(rs);
        }
    }
}
