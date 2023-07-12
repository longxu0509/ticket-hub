package com.ustc.train.business.mapper.cust;

import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface DailyTrainTicketMapperCust {

    void updateCountBySell(@Param("trainDate") Date date
            , String trainCode
            ,@Param("seatTypeCode") String seatTypeCode
            , Integer minStartIndex
            , Integer maxStartIndex
            , Integer minEndIndex
            , Integer maxEndIndex);
}
