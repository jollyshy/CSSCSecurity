package controller.dto;

import controller.enumerate.ResponseStatusEnum;

/**
 * Created by wenqing on 2016/5/26.
 * ���ؽ����װDTO
 */
public class ResponsePackDto {
    private Integer status;
    private String error;
    private Object body;

    public ResponsePackDto() {
       this(new Object());
    }

    public ResponsePackDto(Object body) {
        this.status = ResponseStatusEnum.OK.value();
        this.error = "";
        this.body = body;
    }

    /**
     * ���ؽ��״̬�����û���쳣���ȡbody��������쳣���ȡerror�ֶΣ��鿴�������⡣
     * @return
     */
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * ����ԭ��
     * @return
     */
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    /**
     * ���ص���ϸ���ݣ�����ɹ��������ȡ����ֶΡ�
     * @return
     */
    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
