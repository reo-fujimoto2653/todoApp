<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<main class="container">
		<h2>編集画面</h2>
		<div class="task-card">
			<form method="post" action="edit">
			    <input type="hidden" name="id" value="${editTask.id }"/>
				<div class="item">
					<textarea name="text" rows="3" cols="30">${editTask.text }</textarea>
				</div>
				<div class="item">
					<label>期日 <input name="deadline" type="date"></label>
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
				<div class="d-flex buttons">

					<a href="index" class="button2">キャンセル</a>
					<label><input type="submit" value="更新" class="button2"></label>
				</div>
			</form>
		</div>
	</main>
</body>
</html>