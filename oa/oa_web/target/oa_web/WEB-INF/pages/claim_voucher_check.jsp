<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.lvjing.oa.global.Contant"%>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 处理报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">事由:</div>
                        <div class="col-md-6">${claimVoucher.cause}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">创建人:</div>
                        <div class="col-md-4">${claimVoucher.creator.name}</div>
                        <div class="col-md-2">创建时间:</div>
                        <div class="col-md-4"><spring:eval expression="claimVoucher.createTime"/></div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">待处理人:</div>
                        <div class="col-md-4">${claimVoucher.dealer.name}</div>
                        <div class="col-md-2">状态:</div>
                        <div class="col-md-4">${claimVoucher.status}</div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 费用明细 </span>
                    </div>

                    <c:forEach items="${items}" var="item">
                    <div class="section row">

                        <div class="col-md-3">${item.item}</div>
                        <div class="col-md-3">${item.amount}</div>
                        <div class="col-md-3">${item.comment}</div>

                    </div>
                    </c:forEach>

                    <div class="section row">
                        <div class="col-md-2">总金额</div>
                        <div class="col-md-6"><strong>${claimVoucher.totalAmount}</strong></div>
                    </div>
                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>
                    <c:forEach items="${recodes}" var="recode">
                    <div class="section row">
                    <span class="col-md-3">处理人：&nbsp;</span>
                        <div class="col-md-3">${recode.dealer.name}</div>
                        <span class="col-md-3">处理时间：&nbsp;</span>
                        <div class="col-md-3"><spring:eval expression="recode.dealTime"/></div>
                        <span class="col-md-3">处理方式：&nbsp;</span>
                        <div class="col-md-3">${recode.dealWay}</div>
                        <span class="col-md-3">处理结果：&nbsp;</span>
                        <div class="col-md-3">${recode.dealResult}</div>
                        <span class="col-md-3">备注：&nbsp;</span>
                        <div class="col-md-3">${recode.comment}</div>
                    </div>
                    </c:forEach>

                    <form:form id="admin-form" name="addForm" action="/claim_voucher/check" method="put" modelAttribute="recode">
                        <form:hidden path="claimVoucherId"/>
                        <%--<form:hidden path="dealWay"/>--%>
                        <div class="panel-body bg-light">
                            <div class="section-divider mt20 mb40">
                                <span> 基本信息 </span>
                            </div>
                            <div class="section">
                                <label class="field prepend-icon">
                                    <form:input path="comment" cssClass="gui-input" placeholder="备注..."/>
                                    <label for="comment" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="panel-footer text-right">

                                <c:if test="${sessionScope.employee.post != Contant.POST_CASHIER}">
                                    <button type="submit" class="button" name="dealWay" value="${Contant.DEAL_PASS}">${Contant.DEAL_PASS}</button>
                                    <button type="submit" class="button" name="dealWay" value="${Contant.DEAL_BACK}">${Contant.DEAL_BACK}</button>
                                    <button type="submit" class="button" name="dealWay" value="${Contant.DEAL_REJECT}">${Contant.DEAL_REJECT}</button>
                                </c:if>
                                <c:if test="${sessionScope.employee.post == Contant.POST_CASHIER}">
                                    <button type="submit" class="button" name="dealWay" value="${Contant.DEAL_PAID}">${Contant.DEAL_PAID}</button>
                                </c:if>
                                <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>

                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</section>
