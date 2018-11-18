<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 报销单详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">事由</div>
                        <div class="col-md-6">${claimVoucher.cause}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建人</div>
                        <div class="col-md-4">${claimVoucher.creator.name}</div>
                        <div class="col-md-2">创建时间</div>
                        <div class="col-md-4"><spring:eval expression="claimVoucher.createTime"/></div>
                        <%--<div class="col-md-4">${claimVoucher.createTime}</div>--%>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">待处理人</div>
                        <div class="col-md-4">${claimVoucher.dealer.name}</div>
                        <div class="col-md-2">状态</div>
                        <div class="col-md-4">${claimVoucher.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 费用明细 </span>
                    </div>

                    <c:forEach items="${items}" var="item">
                        <div class="section row">
                            <span style="float: left;margin-left: 11px">花销类型：&nbsp;</span>
                            <div class="col-md-3">${item.item}</div>
                            <span style="float: left;margin-left: 11px">费用：&nbsp;</span>
                            <div class="col-md-3">${item.amount}</div>
                            <span style="float: left;margin-left: 11px">备注：&nbsp;</span>
                            <div class="col-md-3">${item.comment}</div>
                        </div>
                    </c:forEach>

                    <div class="section row">
                        <div class="col-md-2" style="width: auto">总金额：&nbsp;</div>
                        <div class="col-md-6"><strong>${claimVoucher.totalAmount}</strong></div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>

                    <c:forEach items="${recodes}" var="record">
                        <div class="section row">
                            <span style="float: left;margin-left: 11px">处理人：&nbsp;</span>
                            <div class="col-md-3">${record.dealer.name}</div>
                            <span style="float: left;margin-left: 11px">处理时间：&nbsp;</span>
                            <div class="col-md-3"><spring:eval expression="record.dealTime"/></div>
                            <span style="float: left;margin-left: 11px">处理类型：&nbsp;</span>
                            <div class="col-md-3">${record.dealWay}</div>
                            <span style="float: left;margin-left: 11px">处理结果：&nbsp;</span>
                            <div class="col-md-3">${record.dealResult}</div>
                            <span style="float: left;">备注：&nbsp;</span>
                            <div class="col-md-3">${record.comment}</div>
                        </div>
                    </c:forEach>

                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
