<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/claim_voucher/update" method="put" modelAttribute="info">
                    <form:hidden path="claimVoucher.id"/>
                    <form:hidden path="claimVoucher.createSn"/>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section">
                            <label for="claimVoucher.cause" class="field prepend-icon">
                                <form:input path="claimVoucher.cause" cssClass="gui-input" placeholder="事由..."/>
                                <label for="claimVoucher.cause" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section-divider mt20 mb40">
                            <span> 费用明细 </span>
                        </div>
                        <div class="section row" id="items">

                            <c:forEach items="${info.items}" varStatus="vs">
                            <div>
                                <div class="col-md-3">
                                    <label class="field prepend-icon">
                                        <form:hidden path="items[${vs.index}].id"/>
                                        <form:select path="items[${vs.index}].item" items="${costs}" cssClass="gui-input" placeholder="花销类型...">

                                        </form:select>
                                    </label>
                                </div>
                                <div class="col-md-3">
                                    <label class="field prepend-icon">
                                        <form:input path="items[${vs.index}].amount" class="gui-input money" placeholder="金额..."/>
                                        <label class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-5">
                                    <label class="field prepend-icon">
                                        <form:input path="items[${vs.index}].comment" class="gui-input" placeholder="备注..."/>
                                        <label class="field-icon">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </label>
                                </div>
                                <div class="col-md-1" style="text-align:right;">
                                    <button type="button" class="button"> X </button>
                                </div>
                            </div>
                            </c:forEach>

                        </div>
                        <div class="section row">
                            <div class="col-md-3">
                                <label for="totalMoney" class="field prepend-icon">
                                    <form:input id="totalMoney" path="claimVoucher.totalAmount" cssClass="gui-input" placeholder="总金额..." readonly="readonly"/>
                                    <label for="totalMoney" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="text-align:right;">
                                <div class="col-md-9">
                                    <button type="button" class="button" id="addItemButton"> + </button>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>
