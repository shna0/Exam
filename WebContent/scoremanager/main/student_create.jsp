<%-- 学生一覧JSP --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/common/base.jsp">
	<c:param name="title">
	得点管理システム
	</c:param>

	<c:param name="scripts"></c:param>

	<c:param name="content">
		<section class="me-4">
			<h2 class="h3 mb-3 fw-norma bg-secondary bg-opacity-10 py-2 px-4">学生登録</h2>
			<form method="get">
				<div class="row border mx-3 mb-3 py-2 align-items-center rounded" id="filter">
					<div class="col-4">
						<p><label class="form-label" for="student-f1-select">入学年度</label></p>
						<p><select class="form-select" id="student-f1-select" name="f1">
							<option value="0">--------</option>
							<c:forEach var="year" items="${ent_year_set}">
								<%-- 現在のyearと選択されていたf1が一致していた場合selectedを追記 --%>
								<option value="${year}" <c:if test="${year==f1}">selected</c:if>>${year}</option>
							</c:forEach>
						</select></p>
					</div>
					<br>
					<div class="col-4">
						<p><label class="form-label" for="student-f2-input">学生番号</label></p>
						<p><input class="form-label" for="student-f2-input" name="f2" placeholder="学生番号を入力してください"></input></p>
					</div>
					<div class="col-4">
						<p><label class="form-label" for="student-f3-input">氏名</label></p>
						<p><input class="form-label" for="student-f3-input" name="f3" placeholder="学生番号を入力してください"></input></p>
					</div>
					<p><div class="col-4">
						<p><label class="form-label" for="student-f4-select">クラス</label></p>
						<p><select class="form-select" id="student-f4-select" name="f4">
						<option value="0">--------</option>
							<c:forEach var="num" items="${class_num_set}">
								<%-- 現在のnumと選択されていたf2が一致していた場合selectedを追記 --%>
								<option value="${num}" <c:if test="${num==f2}">selected</c:if>>${num}</option>
							</c:forEach>
						</select></p>
					</div>
					<div class="mt-2 text-warning">${errors.get("f1")}</div>
				</div>
			</form>
		</section>
		<a href="StudentList.action">戻る</a>
	</c:param>
</c:import>