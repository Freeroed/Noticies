package vlsu.ru.freeroed.notices.dao;

import vlsu.ru.freeroed.notices.domain.Notice;

import java.util.List;


public interface NoticieDAO {
    int create(Notice notice);

    List<Notice> getAll();

    Notice findById(int id);

    int update(Notice notice);

    void delete(int id);
}
