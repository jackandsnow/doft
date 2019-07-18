package com.doft.common.ctrl;

import com.doft.common.ServerResponse;
import com.doft.common.exception.BusinessException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Supplier;

/**
 * Created by Jack at 14:28 2018/3/9
 * version 1.0
 */
public class CtrlHelper {

    protected static final Logger logger = LogManager.getLogger(CtrlHelper.class);

    /**
     * 通用ajax请求处理方法
     */
    public static <E> ServerResponse dealAjaxRequest(Supplier<E> supplier) {
        try {
            return ServerResponse.createBySuccess(supplier.get());
        } catch (BusinessException | IllegalArgumentException e) {
            logger.error("error occur while dealAjaxRequest " + e.getMessage()+ e.getCause(), e);
            return ServerResponse.createByErrorMessage(e.getMessage());
        }  catch (RuntimeException e) {
            logger.error("error occur while dealAjaxRequest " + e.getMessage() + e.getCause(), e);
            return ServerResponse.createByErrorMessage("system error,Please contact administrator!");
        }
    }

}
