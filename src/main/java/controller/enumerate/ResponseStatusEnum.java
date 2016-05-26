package controller.enumerate;

/**
 * Created by wenqing on 2016/5/26.
 * ����״̬ö��ֵ
 */
public enum ResponseStatusEnum {
    /** ���óɹ� */
    OK(0),
    /** �����������쳣 */
    SERVER_ERROR(1),
    /** ���ݿ�����쳣 */
    DB_ERROR(2),
    /** δ��½״̬���ܷ��� */
    NO_LOGIN(3);

    private int value;

    ResponseStatusEnum(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
