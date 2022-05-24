package org.tukorea.free.persistence;

import org.tukorea.free.domain.PostVO;

import java.util.List;

public interface PostDAO {
    public void add(PostVO postVO) throws Exception;
    public PostVO read(Integer id) throws  Exception;
    public List<PostVO> readList() throws Exception;
    public void update(PostVO post) throws Exception;
    public void delete(Integer id) throws Exception;
}
