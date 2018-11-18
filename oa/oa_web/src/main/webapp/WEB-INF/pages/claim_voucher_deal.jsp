<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="com.lvjing.oa.global.Contant"%>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 待处理报销单 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel  heading-border">
                <div class="panel-menu">
                    <div class="row">
                        <div class="hidden-xs hidden-sm col-md-3">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-refresh"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-trash"></i>
                                </button>
                            </div>
                        </div>
                        <div class="col-xs-12 col-md-9 text-right">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-left"></i>
                                </button>
                                <button type="button" class="btn btn-default light">
                                    <i class="fa fa-chevron-right"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body pn">
                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="text-center hidden-xs">Select</th>
                            <th class="hidden-xs">事由</th>
                            <th>状态</th>
                            <th class="hidden-xs">创建人</th>
                            <th class="hidden-xs">金额</th>
                            <th class="text-left">创建时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>

                        <c:forEach items="${claimVouchers}" var="claimVoucher">
                            <tr class="message-unread">
                                <td class="hidden-xs">
                                    <label class="option block mn">
                                        <input type="checkbox" name="mobileos" value="FR">
                                        <span class="checkbox mn"></span>
                                    </label>
                                </td>
                                <td>${claimVoucher.cause}</td>
                                <td class="hidden-xs">
                                    <span class="badge badge-warning mr10 fs11">${claimVoucher.status}</span>
                                </td>
                                <td>${claimVoucher.creator.name}</td>
                                <td><strong>${claimVoucher.totalAmount}</strong></td>
                                <td><spring:eval expression="claimVoucher.createTime"/></td>
                                <td>
                                    <c:if test="${claimVoucher.status == Contant.CLAIMVOUCHER_CREATED || claimVoucher.status == Contant.CLAIMVOUCHER_BACK}">
                                        <form action="/claim_voucher/to_update/${claimVoucher.id}" method="post" style="float: left;">
                                            <input type="hidden" name="_method" value="get">
                                            <input type="submit" value="修改" style="border: none; color: #4babff; background: none;">
                                        </form>
                                        <form action="/claim_voucher/submit/${claimVoucher.id}" method="post" style="float: left;">
                                            <input type="hidden" name="_method" value="put">
                                            <input type="submit" value="提交" style="border: none; color: #4babff; background: none;">
                                        </form>
                                    </c:if>
                                    <c:if test="${claimVoucher.status == Contant.CLAIMVOUCHER_SUBMIT}">
                                        <form action="/claim_voucher/to_check/${claimVoucher.id}" method="post" style="float: left;">
                                            <input type="hidden" name="_method" value="get">
                                            <input type="submit" value="审核" style="border: none; color: #4babff; background: none;">
                                        </form>
                                    </c:if>
                                    <c:if test="${claimVoucher.status == Contant.CLAIMVOUCHER_APPROVED}">
                                        <form action="/claim_voucher/to_check/${claimVoucher.id}" method="post" style="float: left;">
                                            <input type="hidden" name="_method" value="get">
                                            <input type="submit" value="打款" style="border: none; color: #4babff; background: none;">
                                        </form>
                                    </c:if>
                                    <form action="/claim_voucher/detail/${claimVoucher.id}" method="post" style="float: left;">
                                        <input type="hidden" name="_method" value="get">
                                        <input type="submit" value="详细信息" style="border: none; color: #4babff; background: none;">
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</section>
