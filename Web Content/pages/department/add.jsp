<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<div class="row">
  <div class="col-sm-6">
    <form id="editForm" method="post" data-parsley-validate="data-parsley-validate">
   	  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <div class="form-group row">
        <label class="form-control-label col-sm-3">Mã phòng ban<span class="required">*</span></label>
        <div class="col-sm-9">
          <input id="id" name="id" cssClass="form-control" required="required" />
        </div>
      </div>
      <div class="form-group row">
        <label class="form-control-label col-sm-3">Tên phòng ban<span class="required">*</span></label>
        <div class="col-sm-9">
          <input id="name" name="name" cssClass="form-control" required="required" />
        </div>
      </div>
      
      <div class="ln_solid"></div>
      <div class="form-group row">
        <div class="col-sm-8 col-sm-offset-1">
          <button type="submit" class="btn btn-primary" style="width: 100px;" id="btnSave">Thêm mới</button>
          <button type="button" class="btn btn-default">Hủy</button>
        </div>
      </div>
      <!-- hidden field -->
      <input type="hidden" name="crudaction" value="insert-update" />
    </form>
  </div>
</div>
