<template>
  <div class="wrap">
    <section class="page-header-container">
        <h1 class="header">Location</h1>
    </section>
    <!-- 지도 섹션 -->
    <section class="map-container">
      <div id="map" class="map">
        <div class="overlay">
          <p class="addr"><img src="../assets/img/location.png">&ensp;경기도 안산시 단원구 중앙대로 921</p>
          <p><img src="../assets/img/tel.png">&ensp;031-1234-5678</p>
        </div>
      </div>
    </section>
    <section class="locate-container">
      <table class="locate">
        <h1 class="path">오시는 길</h1>
        <tr class="subway">
          <th>
            <div class="icon"><img src="../assets/img/subway.png"></div>
            <div class="location-text">지하철 이용시</div>
          </th>
          <td>4호선, 수인선 중앙역 1번 출구 하차 후 도보 10분 이내</td>
        </tr>
        <tr class="bus">
          <th>
            <div class="icon"><img src="../assets/img/bus.png"></div>
            <div class="location-text">버스 이용시</div>
          </th>
          <td>일반  &ensp;123, 3, 35, 50, 7, 77, 80B, 9-1, 99-1, 70A, 9<br/>
              직행  &ensp;300(2층버스)(토,일,공휴일)</td>
        </tr>
      </table>
    </section>
  </div>
</template>

<script>
export default {
  mounted() {
    window.kakao && window.kakao.maps
      ? this.initMap()
      : this.addKakaoMapScript();
  },
  methods: {
    addKakaoMapScript() {
      const script = document.createElement("script");
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        "http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=3b7f26af60406871998ff2336ce17a3f";
      document.head.appendChild(script);
    },
    initMap() {
      var container = document.getElementById("map"); //지도를 담을 영역
      var options = {
        center: new kakao.maps.LatLng(37.3170, 126.8395), //중심좌표
        level: 4 //지도의 레벨(확대, 축소)
      };

      var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

      //좌표에 마커 생성해서 표시
      var markerPosition = new kakao.maps.LatLng(37.3170, 126.8395);
      var marker = new kakao.maps.Marker({
        position: markerPosition
      });
      marker.setMap(map);
    }
  }
};
</script>

<style scoped>
*{
  font-family: "Noto Sans KR", sans-serif;
}

  .wrap {
    max-width: 1200px;
    margin: auto;
  }

  .header {
    font-size: 40px;
    text-align: center;
    font-weight: bold;
  }

  .map {
    position: relative;
    margin: 0 auto;
    width: 100%;
    height: 500px;
    border: 1px solid #ccc;
  }

  .overlay {
    position: absolute;
    top: 20px;
    left: 20px;
    background: white;
    z-index: 10;
    padding: 20px 24px;
    line-height: 1.6;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    color: rgb(102, 102, 102);
  }

  p {
    font-size: 14px;
  }

  .addr {
    font-size: 14px;
    margin-bottom: 10px;
  }

  .overlay img {
    margin-top: -3px;
    vertical-align: middle;
    width: 16px;
    color: #b3b3b3;
  }

  .locate-container {
    margin-top: 50px;
    margin-bottom: 96px;
  }

  .locate {
    width: 1200px;
  }

  .location-text {
    font-weight: 400;
    font-size: 18px;
  }

  .path {
    font-size: 28px;
    margin-bottom: 40px;
  }

  .subway th, .subway td{
    border-top: 2px solid #454545;
  }

  .icon img {
    width: 100px;
    margin-bottom: 10px;
  }

  th {
    width: 25%;
    border-bottom: 1px solid #d9d9d9;
    border-right: 1px solid #d9d9d9;
    font-size: 18px;
    padding: 40px 60px;
    color: #3a3a3a;
  }

  td {
    width: 75%;
    border-bottom: 1px solid rgb(221, 221, 221);
    padding: 40px 60px;
    font-size: 16px;
    line-height: 1.6;
    color: #686868;
  }
</style>