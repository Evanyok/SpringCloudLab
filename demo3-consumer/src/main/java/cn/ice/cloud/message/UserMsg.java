package cn.ice.cloud.message;

import com.google.common.base.MoreObjects;

public class UserMsg {

    public static final String UA_UPDATE = "update";

    public static final String UA_DELETE = "delete";

    private String action;

    private Long userId;

    private String traceId;

    public UserMsg(){
        // ignore
    }

    public UserMsg(String action, Long uid, String traceId) {
        this.action = action;
        this.userId = uid;
        this.traceId = traceId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("action", action)
                .add("userId", userId)
                .add("traceId", traceId)
                .toString();
    }
}
