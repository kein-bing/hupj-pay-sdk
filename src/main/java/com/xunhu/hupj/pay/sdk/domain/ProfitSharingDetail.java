package com.xunhu.hupj.pay.sdk.domain;

import lombok.Data;

/**
 * 项目名称：hupj-pay-sdk
 * 类 名 称：ProfitSharingDetail
 * 类 描 述：分账明细
 * 创建时间：2020-07-17 00:22
 * 创 建 人：louis
 */
@Data
public class ProfitSharingDetail {
    String type;
    String account;
    Integer amount;
    String description;
}
