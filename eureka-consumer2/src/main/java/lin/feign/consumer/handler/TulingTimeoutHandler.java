package lin.feign.consumer.handler;

import lin.feign.consumer.dto.ResultDTO;
import lin.feign.consumer.exception.TulingTimeoutException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2019/4/24.
 */
@ControllerAdvice
public class TulingTimeoutHandler {

    @ExceptionHandler(value = TulingTimeoutException.class)
    @ResponseBody
    public Object dealException() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setUserName("ABCDEFD");
        return resultDTO;
    }
}
