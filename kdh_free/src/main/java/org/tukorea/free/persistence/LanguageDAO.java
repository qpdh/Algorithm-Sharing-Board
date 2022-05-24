package org.tukorea.free.persistence;

import org.tukorea.free.domain.LanguageVO;

import java.util.List;

public interface LanguageDAO {
    public LanguageVO read(String id) throws  Exception;
    public List<LanguageVO> readList() throws Exception;
}
