package  com.api.payment.logger;

public interface Log {
    void logerror(String msg);
    void logwarn(String msg);
    void loginfo(String msg);
    void logdebug(String msg);
}
