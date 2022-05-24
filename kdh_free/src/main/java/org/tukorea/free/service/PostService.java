package org.tukorea.free.service;

import org.tukorea.free.domain.PostVO;

import java.util.List;

public interface PostService {
    public PostVO readPost(Integer id) throws Exception;
    public List<PostVO> readPostList() throws Exception;
    public void addPost(PostVO post) throws Exception;
    public void deletePost(Integer id) throws Exception;
}
