package controller.dto;

import controller.enumerate.ResponseStatusEnum;

/**
 * Created by wenqing on 2016/5/26.
 * 返回结果包装DTO
 */
public class ResponsePackDto {
    private Integer status;
    private String error;
    private Object data;

    public ResponsePackDto() {
       this(new String(""));
    }

    public ResponsePackDto(Object data) {
        this.status = ResponseStatusEnum.OK.value();
        this.error = "";
        this.data = data;
    }

    /**
     * 返回结果状态，如果没有异常则读取body，如果有异常则读取error字段，查看具体问题。
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 错误原因
     * @return
     */
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * 返回的详细内容，如果成功返回则读取这个字段。
     * @return
     */
    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
