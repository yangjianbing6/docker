package com.intellect.book.base.dto.result;

import com.alibaba.fastjson.annotation.JSONField;
import com.intellect.book.base.dto.BaseDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wangzhiyong on 17-10-29.
 */
@Data
@NoArgsConstructor
public class PageResult<T extends Serializable> extends BaseDTO {

    private int totalCount;
    private int page;
    private int totalPage;
    private int limit;
    private boolean hasNextPage;
    private List<T> items;

    @JSONField(serialize = false)
    private boolean useMaxPageRestrict;


    public PageResult(int page, int limit, int totalCount, List<T> items, boolean useMaxPageRestrict) {
        PageParameter pageInfo = new PageParameter(page, limit);
        this.page = pageInfo.getPage();
        this.limit = pageInfo.getLimit();
        this.totalCount = totalCount;
        this.items = items;
        this.useMaxPageRestrict = useMaxPageRestrict;
        this.genMaxPageIndex();
    }

    public PageResult(PageParameter pageInfo, int totalCount, List<T> items, boolean useMaxPageRestrict) {
        this(pageInfo.getPage(), pageInfo.getLimit(), totalCount, items, useMaxPageRestrict);
    }

    public PageResult(PageParameter pageInfo, int totalCount, List<T> items) {
        this(pageInfo.getPage(), pageInfo.getLimit(), totalCount, items, true);
    }

    public PageResult(int page, int limit, int totalCount, List<T> items) {
        this(page, limit, totalCount, items, true);
    }

    public PageResult(RowBounds rowBounds, int totalCount, List<T> items) {
        this(rowBounds.getOffset() / rowBounds.getLimit() + 1, rowBounds.getLimit(), totalCount, items, true);
    }

    private void genMaxPageIndex() {
        if (limit > 0) {
            totalPage = ((totalCount % limit) == 0 ? (totalCount / limit) : (totalCount / limit + 1));
        }
        if (0 == totalPage) {
            totalPage = 1;
        }
        hasNextPage = page < totalPage;

        if (useMaxPageRestrict) {
            totalPage = totalPage >= MAX_PAGE ? MAX_PAGE : totalPage;
            totalCount = totalCount >= MAX_COUNT ? MAX_COUNT : totalCount;
            hasNextPage = !(page >= totalPage || page >= MAX_PAGE);
        }
    }

}