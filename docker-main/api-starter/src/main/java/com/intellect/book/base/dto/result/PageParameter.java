package com.intellect.book.base.dto.result;

import com.intellect.book.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yangjianbing on 17-10-27.
 */
@ApiModel(description = "分页请求参数")
@Data
@NoArgsConstructor
public class PageParameter extends BaseDTO {

    @ApiModelProperty(value = "page", example = "1", notes = "页码，默认为1")
    private Integer page;

    @ApiModelProperty(value = "limit", example = "20", notes = "每页条数，默认为20")
    private Integer limit;

    public PageParameter(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public Integer getPage() {
        if (page == null || page <= 0) {
            return DEFAULT_PAGE;
        }
        return page;
    }

    public Integer getLimit() {
        if (limit == null || limit <= 0 || limit >= DEFAULT_LIMIT) {
            return DEFAULT_LIMIT;
        }
        return limit;
    }


    public int getFrom() {
        return (getPage() - 1) * getLimit();
    }

   /* @Override
    public boolean validation() {
        if (getPage() > BaseDTO.MAX_PAGE) {
            return false;
        }
        return super.validation();
    }*/


}
