<%@page import="com.jin.model.StoreDTO"%>
<%@page import="com.jin.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<!-- CSS FILES -->
<link rel="preconnect" href="https://fonts.googleapis.com" />

<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />

<link
	href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,400;0,500;0,700;1,400&display=swap"
	rel="stylesheet" />

<link href="css/bootstrap.min.css" rel="stylesheet" />

<link href="css/bootstrap-icons.css" rel="stylesheet" />

<link href="css/tooplate-clean-work.css" rel="stylesheet" />
<link href="css/login.css" rel="stylesheet">
<link href="css/kakaoMap.css" rel="stylesheet">
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=683c7e08c86fe41ea5c21dd7148dc9f3&libraries=services,clusterer,drawing"></script>
</head>
<body>
	<%
	String email = null;
	String name = null;
	String addr = null;
	Double lat = 0.0;
	Double lng = 0.0;
	MemberDTO member = (MemberDTO) session.getAttribute("member");
	StoreDTO storeMember = (StoreDTO) session.getAttribute("storemember");
	if (member.getMB_EMAIL() != null) {
		email = member.getMB_EMAIL();
		name = member.getMB_NAME();
		addr = member.getMB_ADDR();
		lat = member.getLAT();
		lng = member.getLNG();
	} else if (storeMember.getSTORE_EMAIL() != null) {
		email = storeMember.getSTORE_EMAIL();
		name = storeMember.getSTORE_NAME();
		addr = storeMember.getSTORE_ADDR();
		lat = storeMember.getLAT();
		lng = storeMember.getLNG();
	}
	%>

	<form action="myPageUpdate" method="post">
		<div class="mb-3 row">
			<label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
			<div class="col-sm-10">
				<input type="text" readonly class="form-control-plaintext"
					id="staticEmail" value="<%=email%>" name="myPageEmail">
			</div>
		</div>
		<!-- 현재 비밀번호 확인 -->
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword"
					name="myPagePw">
			</div>
		</div>

		<!-- 수정 할 비밀번호 -->
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputUpdatePw"
					name="myPageUpdatePw">
			</div>
		</div>

		<!-- 수정 할 비밀번호 체크 -->
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPwChk">
			</div>
		</div>
		<!-- 수정 할 주소 -->
		<div class="mb-3 row">
			<label for="inputPassword" class="col-sm-2 col-form-label">Address</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputAddr"
					name="myPageUpdateAddr">
			</div>
		</div>
		<div class="form-outline mb-4">
			<label class="form-label" for="sample5_roadAddress">Address</label> <input
				type="text" id="sample5_address" name="joinAddr"
				class="form-control form-control-lg" placeholder="주소" disabled>
			<input type="button" class="btn btn-primary btn-lg btn-block"
				onclick="sample5_execDaumPostcode()" value="주소 검색"><br>
			<!-- <input type="text" id="sample4_roadAddress"
												placeholder="도로명주소" name="joinAddr"
												class="form-control form-control-lg" />
											<input
												type="button" onclick="sample4_execDaumPostcode()"
												class="btn btn-primary btn-lg btn-block" value="주소 찾기" /><br /> -->
		</div>

		<div id="map"
			style="width: 300px; height: 300px; margin-top: 10px; display: none"></div>
		<div id="searchLat" style="display: none;">
			<!-- class="dp-none;" -->
		</div>
		<div id="searchLng" style="display: none;">
			<!-- class="dp-none;" -->
		</div>
		<script>
			function sample4_execDaumPostcode() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

								// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								var roadAddr = data.roadAddress; // 도로명 주소 변수
								var extraRoadAddr = ""; // 참고 항목 변수

								// 법정동명이 있을 경우 추가한다. (법정리는 제외)
								// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
								if (data.bname !== ""
										&& /[동|로|가]$/g.test(data.bname)) {
									extraRoadAddr += data.bname;
								}
								// 건물명이 있고, 공동주택일 경우 추가한다.
								if (data.buildingName !== ""
										&& data.apartment === "Y") {
									extraRoadAddr += extraRoadAddr !== "" ? ", "
											+ data.buildingName
											: data.buildingName;
								}
								// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
								if (extraRoadAddr !== "") {
									extraRoadAddr = " (" + extraRoadAddr + ")";
								}

								// 우편번호와 주소 정보를 해당 필드에 넣는다.

								document.getElementById("sample4_roadAddress").value = roadAddr;

								// 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
							},
						}).open();
			}
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div
			mapOption = {
				center : new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
				level : 5
			// 지도의 확대 레벨
			};

			//지도를 미리 생성
			var map = new daum.maps.Map(mapContainer, mapOption);
			//주소-좌표 변환 객체를 생성
			var geocoder = new daum.maps.services.Geocoder();
			//마커를 미리 생성
			var marker = new daum.maps.Marker({
				position : new daum.maps.LatLng(37.537187, 127.005476),
				map : map
			});

			function sample5_execDaumPostcode() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								var addr = data.address; // 최종 주소 변수

								// 주소 정보를 해당 필드에 넣는다.
								document.getElementById("sample5_address").value = addr;
								// 주소로 상세 정보를 검색
								geocoder
										.addressSearch(
												data.address,
												function(results, status) {
													// 정상적으로 검색이 완료됐으면
													if (status === daum.maps.services.Status.OK) {

														var result = results[0]; //첫번째 결과의 값을 활용

														// 해당 주소에 대한 좌표를 받아서
														var coords = new daum.maps.LatLng(
																result.y,
																result.x);
														// 지도를 보여준다. 지워야함 TODO
														map.relayout();
														// 지도 중심을 변경한다.
														map.setCenter(coords);
														// 마커를 결과값으로 받은 위치로 옮긴다.
														marker
																.setPosition(coords)

														var userLat = document
																.getElementById('searchLat');
														userLat.innerHTML = '<input type="text" name="userLatInput" id="userLat-input">';
														var userLats = document
																.getElementById('userLat-input');
														userLats.value = coords
																.getLat();
														var userLng = document
																.getElementById('searchLng');
														userLng.innerHTML = '<input type="text" name="userLngInput" id="userLng-input">';
														var userLngs = document
																.getElementById('userLng-input');
														userLngs.value = coords
																.getLng();
													}
												});
							}
						}).open();
			}
		</script>
		<button type="submit"
			class="btn btn-primary btn-lg btn-block modal-btn">Update</button>

	</form>








	<!-- JAVASCRIPT FILES -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.backstretch.min.js"></script>
	<script src="js/counter.js"></script>
	<script src="js/countdown.js"></script>
	<script src="js/init.js"></script>
	<script src="js/modernizr.js"></script>
	<script src="js/animated-headline.js"></script>
	<script src="js/custom.js"></script>
	<script src="js/kakaoMap.js"></script>
	<script src="js/btnScroll.js"></script>
</body>
</html>