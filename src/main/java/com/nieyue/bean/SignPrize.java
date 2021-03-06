package com.nieyue.bean;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 签到奖品
 * @author yy
 *
 */
@ApiModel(value="签到奖品",description="签到奖品")
@TableName("sign_prize_tb")
public class SignPrize implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * 签到奖品id
     */
    @ApiModelProperty(value="签到奖品id",example="签到奖品id")
    @TableId("sign_prize_id")
    private Long signPrizeId;
    /**
     * 连续天数
     */
    @ApiModelProperty(value="连续天数",example="连续天数")
    private Integer dayNumber;
    /**
     * 签到奖品名称
     */
    @ApiModelProperty(value="签到奖品名称",example="签到奖品名称")
    private String name;
    /**
     * 签到奖品数量
     */
    @ApiModelProperty(value="签到奖品数量",example="签到奖品数量")
    private Integer number;
    /**
     * 签到奖品图标
     */
    @ApiModelProperty(value="签到奖品图标",example="签到奖品图标")
    private String imgAddress;
    /**
     * 签到奖品内容
     */
    @ApiModelProperty(value="签到奖品内容",example="签到奖品内容")
    private String content;
    /**
     * 领奖时间
     */
    @ApiModelProperty(value="领奖时间",example="领奖时间")
    private Date prizeDate;
    /**
     * 状态，1待领取，2已申请，3领取成功，4拒绝发送
     */
    @ApiModelProperty(value="状态，1待领取，2已申请，3领取成功，4拒绝发送",example="状态，1待领取，2已申请，3领取成功，4拒绝发送")
    private Integer status;
    /**
     * 微信openid
     */
    @ApiModelProperty(value="微信openid",example="微信openid")
    private String openid;
    /**
     * 奖品id外键
     */
    @ApiModelProperty(value="奖品id外键",example="奖品id外键")
    private Long prizeId;
    /**
     * 公众号id外键
     */
    @ApiModelProperty(value="公众号id外键",example="公众号id外键")
    private Long subscriptionId;
    /**
     * 公众号
     */
    @ApiModelProperty(value="公众号",example="公众号")
    @TableField(exist=false)
    private Subscription subscription;
    /**
     * 领奖人id外键
     */
    @ApiModelProperty(value="领奖人id外键",example="领奖人id外键")
    private Long accountId;
    /**
     * 领奖人
     */
    @ApiModelProperty(value="领奖人",example="领奖人")
    @TableField(exist=false)
    private Account account;
	public Long getSignPrizeId() {
		return signPrizeId;
	}
	public void setSignPrizeId(Long signPrizeId) {
		this.signPrizeId = signPrizeId;
	}
	public Integer getDayNumber() {
		return dayNumber;
	}
	public void setDayNumber(Integer dayNumber) {
		this.dayNumber = dayNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getImgAddress() {
		return imgAddress;
	}
	public void setImgAddress(String imgAddress) {
		this.imgAddress = imgAddress;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPrizeDate() {
		return prizeDate;
	}
	public void setPrizeDate(Date prizeDate) {
		this.prizeDate = prizeDate;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getPrizeId() {
		return prizeId;
	}
	public void setPrizeId(Long prizeId) {
		this.prizeId = prizeId;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
}
