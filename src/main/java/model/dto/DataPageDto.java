package model.dto;

import java.io.Serializable;

/**
 * ��̨�����÷�ҳ���ݽṹ
 * Created by wenqing on 2016/6/2.
 */
public class DataPageDto implements Serializable {
    private Long recordsTotal;
    private Object data;

    public DataPageDto() {
        super();
    }

    public Long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
