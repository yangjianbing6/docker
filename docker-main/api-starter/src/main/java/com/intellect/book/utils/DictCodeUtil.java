package com.intellect.book.utils;

import com.intellect.book.dao.DictCodeMapper;
import com.intellect.book.domain.entity.DictCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yangjianbing
 *
 * @date 2019/11/2 12:28
 */
@Component
public class DictCodeUtil {

    @Autowired
    DictCodeMapper dictCodeMapper;

    public String getDictCodeName(String codeTypeId, String codeId) {
        DictCode param = new DictCode();

        DictCode dictCode = dictCodeMapper.selectOne(param);
        if (dictCode == null) {
            return null;
        }
        return dictCode.getCodeName();
    }


}
