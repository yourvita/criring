kakao.maps
	.load(function() {
		// 지도 생성 및 중심 설정
		var mapContainer = document
			.getElementById('map');
		var mapOptions = {
			center: new kakao.maps.LatLng(
				37.5665, 126.9780), // 서울시청 좌표
			level: 2
		};
		var map = new kakao.maps.Map(
			mapContainer, mapOptions);

		// 검색 버튼 클릭 이벤트 처리
		var searchBtn = document
			.getElementById('button-addon2');
		searchBtn.addEventListener('click',
			function() {
				searchKeyword();
			});

		// 키워드로 장소 검색하는 함수
		function searchKeyword() {
			var keyword = document
				.getElementById('keyword').value;
			var geocoder = new kakao.maps.services.Geocoder();

			geocoder
				.addressSearch(
					keyword,
					function(
						result,
						status) {
						if (status === kakao.maps.services.Status.OK) {
							var coords = new kakao.maps.LatLng(
								result[0].y,
								result[0].x);
							map
								.setCenter(coords);
						}
					});
		}
	});