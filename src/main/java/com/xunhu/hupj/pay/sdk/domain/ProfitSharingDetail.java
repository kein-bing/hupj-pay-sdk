package com.xunhu.hupj.pay.sdk.domain;

import lombok.Data;

/**
 * 分账明细
 *
 * @author wuhb
 */
@Data
public class ProfitSharingDetail {
    String type;
    String account;
    Integer amount;
    String description;
}
