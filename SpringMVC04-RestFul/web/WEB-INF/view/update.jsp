<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改員工信息</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath }/css/index_work.css" />
</head>
<body>
				<%-- 要寫成絕對路徑不然在跳轉後會出現訪問路徑錯誤
				     http://localhost:8080/SpringMVC04_RestFul/emp/emp(URI路徑錯誤)
				--%>
	<form action="${pageContext.servletContext.contextPath }/emp" method="post">
		<input type="hidden" name="id" value="${emp.id}" />
		<input type="hidden" name="_method" value="PUT" />
		<table>
			<tr>
				<th colspan="2">修改員工信息</th>
			</tr>
			<tr>
				<td>LASTNAME</td>
				<td>
					<input type="text" name="lastName" value="${emp.lastName }" />
				</td>
			</tr>
			<tr>
				<td>EMAIL</td>
				<td>
					<input type="text" name="email" value="${emp.email }" />
				</td>
			</tr>
			<tr>
				<td>GENDER</td>
				<td>
                                        <%--  設定回顯: 如果當前對象的性別==表單中的性別 則被checked  --%>
					<input type="radio" name="gender" value="1" ${emp.gender == 1?'checked':'' } />男
					<input type="radio" name="gender" value="0" ${emp.gender == 0?'checked':'' } />女
					<%-- <input type="radio" name="gender" value="1" <c:if test="${emp.gender == 1 }">checked="checked"</c:if> />男
					<input type="radio" name="gender" value="0" <c:if test="${emp.gender == 0 }">checked="checked"</c:if> />女 --%>
				</td>
			</tr>
			<tr>
				<td>DEPARTMENT</td>
				<%--修改員工訊息也會更動部門資訊,所以也要顯示所有部門信息供用戶選擇--%>
				<td>
					<select name="department.id">
						<option>-SELECT DEPARTMENT-</option>
						<c:forEach items="${depts }" var="dept">
							<%--	設定回顯: 如果表單選項中的部門id == 當前對象的部門id,則被顯示	--%>
							<option value="${dept.id }" ${dept.id == emp.department.id?'selected':'' }>${dept.departmentName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="UPDATE" />
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
