package com.nieyue.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.nieyue.bean.TemplateMessage;
import com.nieyue.service.TemplateMessageService;
import com.nieyue.util.MyDom4jUtil;
import com.nieyue.util.StateResultList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;


/**
 * 模板消息控制类
 * @author yy
 *
 */
@Api(tags={"templateMessage"},value="模板消息",description="模板消息管理")
@RestController
@RequestMapping("/templateMessage")
public class TemplateMessageController extends BaseController<TemplateMessage,Long> {
	@Resource
	private TemplateMessageService templateMessageService;
	
	/**
	 * 模板消息分页浏览
	 * @param orderName 商品排序数据库字段
	 * @param orderWay 商品排序方法 asc升序 desc降序
	 * @return
	 */
	@ApiOperation(value = "模板消息列表", notes = "模板消息分页浏览")
	@ApiImplicitParams({
		@ApiImplicitParam(name="subscriptionId",value="公众号id",dataType="long", paramType = "query"),
		@ApiImplicitParam(name="pageNum",value="页头数位",dataType="int", paramType = "query",defaultValue="1"),
		@ApiImplicitParam(name="pageSize",value="每页数目",dataType="int", paramType = "query",defaultValue="10"),
		@ApiImplicitParam(name="orderName",value="排序字段",dataType="string", paramType = "query",defaultValue="updateDate"),
		@ApiImplicitParam(name="orderWay",value="排序方式",dataType="string", paramType = "query",defaultValue="desc")
	  })
	@RequestMapping(value = "/list", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<TemplateMessage>> list(
			@RequestParam(value="subscriptionId",required=false)Long subscriptionId,
			@RequestParam(value="pageNum",defaultValue="1",required=false)int pageNum,
			@RequestParam(value="pageSize",defaultValue="10",required=false) int pageSize,
			@RequestParam(value="orderName",required=false,defaultValue="updateDate") String orderName,
			@RequestParam(value="orderWay",required=false,defaultValue="desc") String orderWay)  {
		Wrapper<TemplateMessage> wrapper=new EntityWrapper<TemplateMessage>();
	 	Map<String,Object> map=new HashMap<String,Object>();
	 	map.put("subscription_id", subscriptionId);
	 	wrapper.allEq(MyDom4jUtil.getNoNullMap(map));
		StateResultList<List<TemplateMessage>> rl = super.list(pageNum, pageSize, orderName, orderWay,wrapper);
			return rl;
	}
	/**
	 * 模板消息修改
	 * @return
	 */
	@ApiOperation(value = "模板消息修改", notes = "模板消息修改")
	@RequestMapping(value = "/update", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<TemplateMessage>> update(@ModelAttribute TemplateMessage templateMessage,HttpSession session)  {
		templateMessage.setUpdateDate(new Date());
		StateResultList<List<TemplateMessage>> u = super.update(templateMessage);
		return u;
	}
	/**
	 * 模板消息增加
	 * @return 
	 */
	@ApiOperation(value = "模板消息增加", notes = "模板消息增加")
	@RequestMapping(value = "/add", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<TemplateMessage>> add(@ModelAttribute TemplateMessage templateMessage, HttpSession session) {
		templateMessage.setCreateDate(new Date());
		templateMessage.setUpdateDate(new Date());
		StateResultList<List<TemplateMessage>> a = super.add(templateMessage);
		return a;
	}
	/**
	 * 模板消息删除
	 * @return
	 */
	@ApiOperation(value = "模板消息删除", notes = "模板消息删除")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="templateMessageId",value="模板消息ID",dataType="long", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/delete", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<TemplateMessage>> delete(@RequestParam("templateMessageId") Long templateMessageId,HttpSession session)  {
		StateResultList<List<TemplateMessage>> d = super.delete(templateMessageId);
		return d;
	}
	/**
	 * 模板消息浏览数量
	 * @return
	 */
	@ApiOperation(value = "模板消息数量", notes = "模板消息数量查询")
	@ApiImplicitParams({
		@ApiImplicitParam(name="subscriptionId",value="公众号id",dataType="long", paramType = "query"),
	  })
	@RequestMapping(value = "/count", method = {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody StateResultList<List<Integer>> count(
			@RequestParam(value="subscriptionId",required=false)Long subscriptionId,
			HttpSession session)  {
		Wrapper<TemplateMessage> wrapper=new EntityWrapper<TemplateMessage>();
	 	Map<String,Object> map=new HashMap<String,Object>();
	 	map.put("subscription_id", subscriptionId);
	 	wrapper.allEq(MyDom4jUtil.getNoNullMap(map));
		StateResultList<List<Integer>> c = super.count(wrapper);
		return c;
	}
	/**
	 * 模板消息单个加载
	 * @return
	 */
	@ApiOperation(value = "模板消息单个加载", notes = "模板消息单个加载")
	@ApiImplicitParams({
		  @ApiImplicitParam(name="templateMessageId",value="模板消息ID",dataType="long", paramType = "query",required=true)
		  })
	@RequestMapping(value = "/load", method = {RequestMethod.GET,RequestMethod.POST})
	public  StateResultList<List<TemplateMessage>> loadTemplateMessage(@RequestParam("templateMessageId") Long templateMessageId,HttpSession session)  {
		 StateResultList<List<TemplateMessage>> l = super.load(templateMessageId);
		 return l;
	}
	
}
