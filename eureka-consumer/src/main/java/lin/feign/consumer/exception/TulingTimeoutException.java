package lin.feign.consumer.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Administrator on 2019/4/24.
 */
@Data
@AllArgsConstructor
public class TulingTimeoutException extends RuntimeException {

    private String code;
    private String msg;

}
