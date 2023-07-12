package com.ustc.train.business.req;

import com.ustc.train.common.req.PageReq;
import lombok.Data;

@Data
public class TrainStationQueryReq extends PageReq {
    private String trainCode;
}
