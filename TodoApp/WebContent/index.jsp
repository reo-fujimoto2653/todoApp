<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メイン画面</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<header class="page-header d-flex wrapper">
		<h1>ToDo APP</h1>
		<nav>
			<ul class="main-nav d-flex">
				<li><a href="archive" class="button2">終了済みタスク一覧</a></li>
			</ul>
		</nav>
	</header>
	<main class="container">

		<div class="task-card">
			<form method="post" action="index">
				<div class="item">
					<textarea name="text" rows="3" cols="30" required></textarea>
				</div>
				<div class="item">
					<label>期日 <input name="deadline" type="date" required></label>
				</div>
				<div class="item">
					<label>担当者名 <select name="member">
							<option value="kubota">kubota</option>
							<option value="reo">reo</option>
							<option value="nana">nana</option>
							<option value="maronana">maronana</option>
							<option value="kaho">kaho</option>
							<option value="yoshie">yoshie</option>
					</select>
					</label>
				</div>
				<div class="d-flex justify-content-end add">
					<label><input type="submit" value="追加" class="button2"></label>
				</div>
			</form>
		</div>

		<h2>[未完了タスク一覧]</h2>

		<form method="get" action="index" class="not-done-form d-flex">

			<!-- 繰り返し -->
			<c:forEach items="${sessionScope.list}" var="task">
				<c:if test="${ task.isCompleted == false }">
					<div class="not-done d-flex">
						<div class="task-element">
							<label><input type="checkbox" name="id" value="${ task.id }"></label>
							<div>
								<p><c:out value="${ task.text }"></c:out></p>
								<p>期日 <fmt:formatDate value="${ task.deadline }" pattern="yyyy/mm/dd" /></p>
								<p>担当者名 <c:out value="${ task.member }"></c:out></p>
							</div>
							<div class="d-flex buttons">
								<a href="delete?id=${ task.id }" class="button2">削除</a>
								<a href="edit?id=${ task.id }" class="button2">編集</a>
								<a href="index?id=${ task.id }" class="button2">タスク完了</a>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
			<!-- 繰り返し終了 -->
			<div class="d-flex justify-content-end wrapper">
				<input type="submit" value="一括完了" class="button2">
			</div>
		</form>

	</main>
</body>
</html>