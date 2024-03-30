<template>
  <body class="scroll-bar">
    <div class="jumbotron-container">
      <div class="check-box">
        <div class="check">
          <div class="checkin">
            <p class="ch">Check in</p>
            <VueDatePicker
              v-model="checkin"
              :enable-time-picker="false"
              :format="format"
              auto-apply
              year-first
              locale="ko"
              cancelText="취소"
              selectText="선택"
              week-start="0"
              id="cal"
              Foreground="{TemplateBinding Foreground}"
              :min-date="new Date()"
            ></VueDatePicker>
          </div>

          <div class="checkout">
            <p>Check out</p>
            <VueDatePicker
              v-model="checkout"
              :enable-time-picker="false"
              :format="format2"
              auto-apply
              year-first
              locale="ko"
              cancelText="취소"
              selectText="선택"
              week-start="0"
              id="cal"
              Foreground="{TemplateBinding Foreground}"
              :min-date="checkin"
            ></VueDatePicker>
          </div>
        </div>
        <div class="tw-box">
          <div class="room">
            <p>객실수</p>
            <select name="room" id="room" caption="객실수">
              <option value="1">1</option>
            </select>
          </div>

          <div class="person">
            <p>인원수</p>
            <select
              name="member"
              id="member"
              caption="인원수"
              v-model="selectedMembers"
            >
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
            </select>
          </div>
        </div>
        <button class="res" @click="goToReservation">검색</button>
      </div>
    </div>

    <section class="special-offers">
      <!-- Top Text -->
      <div class="page-header-container">
        <h2 class="page-header">ROOMS & BANQUET HALL</h2>
      </div>
      <div class="row center-lg">
        <div class="side-by-side-container">
          <div class="large-image-container">
            <a href="/accommodation">
              <img
                src="../assets/img/hotel-4-large.webp"
                alt="room-image-large"
                class="large-image"
              />
            </a>
            <h4>ROOMS</h4>
            <a class="btn" style="color: #666" href="/accommodation"
              >자세히보기</a
            >
          </div>
        </div>

        <div class="side-by-side-container">
          <div class="large-image-container">
            <a href="/banquethall">
              <img
                src="https://www.esuncruise.com/SunCruiseMain_common/images/homepage/visual/launge2.jpg"
                alt="room-image-large"
                class="large-image"
              />
            </a>
            <h4>BANQUET HALL</h4>
            <a class="btn" style="color: #666" href="/banquethall"
              >자세히보기</a
            >
          </div>
        </div>
      </div>
    </section>

    <!-- Client Reviews -->
    <div class="review-container">
      <div class="review-header">
        <h2 class="review-title">Facility</h2>
      </div>
      <div class="cards-container">
        <div class="card c1">
          <a class="btn2" style="color: white" href="/Facility">&#10142;</a>
        </div>
        <div class="card c2">
          <a class="btn2" style="color: white" href="/Facility">&#10142;</a>
        </div>
        <div class="card c3">
          <a class="btn2" style="color: white" href="/banquethall">&#10142;</a>
        </div>
      </div>
    </div>

    <div class="location">
      <div class="review-header">
        <h2 class="review-title">Location</h2>
      </div>
     <!-- 지도 섹션 -->
        <section class="map-container">
          <h1 class="map-title">킹스호텔로 오시는 길을 안내해드립니다.</h1>
          <div id="map" class="map">
            <div class="overlay">
              <p class="addr"><img src="../assets/img/location.png">&ensp;경기도 안산시 단원구 중앙대로 921</p>
              <p><img src="../assets/img/tel.png">&ensp;031-1234-5678</p>
            </div>
          </div>
         <button class="btn" @click="goToLocation">자세히보기</button>
        </section>
    </div>
  </body>
</template>

<script>
import { ref, watch } from "vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import "../assets/css/root.css";
import store from "@/store";

export default {
  components: { VueDatePicker },
  mounted() {
      window.kakao && window.kakao.maps
        ? this.initMap()
        : this.addKakaoMapScript();
  },
  methods: {
    goToReservation() {
      // '/reservation' 경로로 이동
      this.$router.push("/reservation");

      // 컴포넌트가 마운트된 후에 최상단으로 스크롤 이동
      this.$nextTick(() => {
        window.scrollTo(0, 0);
      });
    },

    goToLocation() {
      // '/location' 경로로 이동
      this.$router.push("/location");

      // 컴포넌트가 마운트된 후에  1/4 위치에 스크롤 이동
      this.$nextTick(() => {
        window.scrollTo(0, window.innerHeight/4);
      });
    },

    // 카카오맵 추가
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
  },
  setup() {
    const checkin = ref(new Date());
    const checkout = ref(new Date());
    const selectedMembers = ref(1);

    watch(selectedMembers, (value) => {
      store.dispatch("updateSelectedMembers", value);
    });

    const format = (date) => {
      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      const ymd = `${year}/${month}/${day}`;
      store.commit("setYmd", ymd);
      return `${year}/${month}/${day}`;
    };
    const format2 = (date) => {
      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      const ymd2 = `${year}/${month}/${day}`;
      store.commit("setYmd2", ymd2);
      return `${year}/${month}/${day}`;
    };
    // const searchDate = ref();
    return {
      checkin,
      checkout,
      format,
      format2,
      selectedMembers,
    };
  },
};
</script>

<style scoped>
*{
  font-family: "Noto Sans KR", sans-serif;
}

.check-box {
  background-color: white;
  width: 1200px;
  height: 130px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 15px;
  padding: 0px 80px;
  display: flex;
  z-index: 1;
  position: absolute;
  bottom: 0px;
  transform: translate(-50%, 50%);
  left: 50%;
  border-radius: 12px;
  align-items: center;
}

.check {
  display: flex;
  align-items: center;
  border-right: 1px solid lightgray;
  justify-content: space-between;
}
.check p {
  color: #d4af37;
  text-align: center;
}
.checkout {
  margin: 0 30px;
}
.large-image {
  width: 400px;
  height: 300px;
}
.tw-box {
  display: flex;
  width: 300px;
  align-items: center;
  justify-content: space-between;
}
.room,
.person {
  width: 150px;
}
.special-offers {
  margin-top: 200px;
}
.tw-box p {
  color: #d4af37;
  text-align: center;
}
.tw-box select {
  border: none;
  max-width: 50px;
  margin-left: 60px;
  text-align-last: center;
  text-align: center;
  -ms-text-align-last: center;
  -moz-text-align-last: center;
}
.res {
  width: 50%;
  height: 50%;
  margin: 0 20px;
  border: 0;
  background-color: #d4af37;
  color: white;
  cursor: pointer;
}

/* 위에서부터 css시작*/
.dp__input {
  width: 170px;
  height: 74px;
  border: 1px solid red;
}
.large-image-container h4 {
  text-align: center;
}
.large-image-container a {
  cursor: pointer;
}
.large-image-container .btn {
  margin-left: 158px;
  width: 82px;
  padding: 6px 0;
  text-align: center;
  background-color: #fafafa;
  border: 1px solid #bcbcbc;
  border-radius: 15px;
  cursor: pointer;
  display: inline-block;
  font-size: 12px;
}
.large-image-container img:hover {
  filter: brightness(0.5);
  transition: all 0.5s;
}
.card .btn2 {
  position: absolute;
  right: 0;
  bottom: 10px;
  text-align: center;
  border-radius: 10px;
  cursor: pointer;
  display: inline-block;
  font-size: 30px;
  text-decoration: none;
  margin-right: 5px;
}
.c1 {
  background-image: url("../assets/img/dining.jpg");
}
.c2 {
  background-image: url("../assets/img/shop.jpg");
}
.c3 {
  background-image: url("../assets/img/work.jpg");
}
.card {
  background-size: cover;
  position: relative;
}

#loader svg {
  width: 200px;
}

#loader.none {
  visibility: hidden;
  opacity: 0;
}

.scroll-bar {
  overflow: hidden;
}

p {
  font-size: 18px;
}
h2 {
  font-size: 40px;
}
.row {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.col {
  padding: 5px;
  flex-wrap: nowrap;
}

.image-col {
  margin-right: 7%;
}

.image-col img {
  margin: 5px;
}

.small-image {
  height: 105px;
}

.side-by-side-container {
  display: flex;
}

.large-image-container {
  margin-right: 7px;
}

.stacked-image-container {
  display: flex;
  flex-direction: column;
  margin-top: 1px;
}
/* Header section--------------------- */
.page-header-container {
  margin-bottom: 70px;
}

.page-header-span {
  display: flex;
  justify-content: flex-end;
  padding-right: 100px;
}
.page-header {
  /* font-weight: 500; */
  text-align: center;
}

.page-sub-header {
  font-size: 75%;
  text-align: center;
  letter-spacing: 0.01em;
  font-weight: 300;
  color: #3b331a;
}

/* Header End-------------------------------- */

/* Jumbotron class */
.jumbotron-container {
  width: 100%;
  background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
    url("../assets/img/Homepage-jumbotron.webp");
  background-repeat: no-repeat;
  background-position: center;
  background-size: cover;
  opacity: 0.9;
  min-height: calc(100vh - 12vh);
  display: flex;
  color: white;
  position: relative;
}

.jumbotron-left > * {
  margin: 0.5rem;
}

.jumbotron-header {
  text-transform: capitalize;
}

.jumbotron-right {
  flex: 2;
  display: flex;
  justify-content: flex-start;
  align-items: center;
  /* border: 1px solid white; */
}

.jumbotron-form {
  color: black;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background: white;
  width: 70%;
  min-height: 60%;
  border-radius: 5px;
}
.jumbotron-form p {
  margin-bottom: 1em;
  text-align: center;
  font-size: 18px;
}
.jumbotron-form input {
  outline: none;
  width: 80%;
  height: 2.5em;
  padding: 0.5em;
}

.jumbotron-form button {
  background: #d8b74b;
  outline: none;
  width: 80%;
  padding: 0.5em;
  border-radius: 5px;
  cursor: pointer;
  color: white;
  border: none;
}

/* Beginning of enjoy your stay section */
.enjoy-container {
  width: 100%;
  display: flex;
  flex-direction: column;
}
.enjoy-header {
  width: 80%;
  margin: 1em auto;
}
.enjoy-header h1 {
  padding-top: 2em;
}
.enjoy-header > p {
  width: 40%;
}
.enjoy-services {
  display: flex;
  flex-direction: row;
  width: 80%;
  margin: 1em auto;
  margin-bottom: 5em;
  /* border: 1px solid black; */
}
.enjoy-services h2 {
  margin-bottom: 1em;
}
.first-col {
  /* border: 1px solid black; */
  flex: 1;
  margin-right: 2em;
}
.sec-col {
  /* border: 1px solid black; */
  flex: 1;
  margin-right: 2em;
}
.third-col {
  /* border: 1px solid black; */
  flex: 2;
  display: flex;
  justify-content: center;
  align-items: center;
  position: relative;
}

.upper,
.lower {
  padding-left: 2em;
  margin-bottom: 2em;
  position: relative;
}
.enjoy__clock-icon,
.enjoy__fitness-icon,
.enjoy__wifi-icon,
.enjoy__coffee-icon {
  position: absolute;
  top: 0px;
  left: -13px;
}

.enjoy__play-icon {
  position: absolute;
  cursor: pointer;
}

/* End----------------------- */

/* Beginning of simplicity is our watch word section styling */
.special-offers {
  padding: 0 0 80px;
}

.offers-title {
  font-size: 165%;
  margin: 25px 0 15px;
}

.offers-sub-title {
  font-size: 18px;
  color: #3b331a;
  font-weight: 300;
  margin-bottom: 20px;
}

.offers-list {
  list-style: none;
  margin-bottom: 30px;
}

.offers-list li {
  margin: 12px 0;
}

.list-icon {
  height: 17px;
  vertical-align: middle;
  margin-right: 5px;
}

.list-text {
  display: inline-block;
}

.btn {
  border-radius: 3px;
  border: 1px solid #d4af37;
  text-transform: uppercase;
  font-size: 55%;
  padding: 10px 18px;
  font-weight: 400;
  text-decoration: none;
  transition: all 0.3s;
  margin-right: 10px;
}

.btn-fill {
  background-color: #d4af37;
  color: #fff;
}
.rates {
  border-radius: 5px;
}

.rates:active,
.rates:hover {
  background-color: #c9a633;
  border: 1px solid #c9a633;
}

.btn-fill:hover,
.btn-fill:active {
  background-color: #c9a633;
  transform: translateY(-3px);
  border: 1px solid #c9a633;
}

.btn-ghost {
  color: #d4af37;
  background-color: #fff;
}

.btn-ghost:hover,
.btn-ghost:active {
  background-color: #d4af37;
  color: #fff;
}

.btn-large {
  font-size: 16px;
  width: 133px;
  padding: 12px 22px;
  border-radius: 4px;
}

/* End----------------------------*/

/* Beginning of client review section styles */
.review-container {
  width: 80%;
  margin: 1em auto;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.review-header {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.review-header > p {
  text-align: center;
}
.cards-container {
  display: flex;
  margin-top: 2em;
  margin-bottom: 4em;
}
.card {
  flex: 1;
  border: 1px solid rgb(158, 158, 158);
  min-height: 40vh;
  margin-right: 2em;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  padding: 1em 1em 1em 1em;
  line-height: 1.5em;
}
.card-title {
  font-size: 25px;
}
.card-avi {
  width: 30%;
  margin: 2em 0;
}
.card-subtitle {
  margin-bottom: 1em;
}
.card-desc {
  font-size: 18px;
  font-weight: 300;
}
.review-title {
  margin-bottom: 10px;
}
/* location start*/
.map-container {
    margin: auto;
    width: 1200px;
    text-align: center;
}
.map-container .map-title {
    font-size: 16px;
    color: #686868;
    margin-top: 0px;
    margin-bottom: 50px;
}
.map {
    position: relative;
    margin: 40px auto 50px;
    width: 100%;
    height: 500px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
.overlay {
    position: absolute;
    text-align: left;
    top: 20px;
    left: 20px;
    background: white;
    z-index: 10;
    padding: 20px 24px;
    line-height: 1.6;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    color: rgb(102, 102, 102);
}
.overlay p {
    font-size: 14px;
}
.addr {
    font-size: 12px;
    margin-bottom: 10px;
}
.overlay img {
    margin-top: -3px;
    vertical-align: middle;
    width: 16px;
    color: #b3b3b3;
}
.map-container .btn {
    width: 180px;
    height: 45px;
    margin-bottom: 96px;
    border: 0;
    font-size: 14px;
    background-color: #d4af37;
    border-radius: 0%;
    color: white;
    cursor: pointer;
}
.map-container .btn:hover {
  background-color: #c9a635;
}
/* location end*/

/* End----------------------------------------- */

/* @media queries */
/* Extra small devices (phones, 600px and down) */
@media only screen and (max-width: 600px) {
  .image-col {
    margin: auto;
  }
  .jumbotron-container {
    width: 100%;
    flex-direction: column;
    align-items: center;
  }

  .jumbotron-left {
    padding: 1rem;
    margin-top: 1rem;
  }

  .jumbotron-header {
    font-size: 30px;
    text-align: center;
  }

  .jumbotron-header br {
    display: none;
  }

  .enjoy-services {
    flex-direction: column;
  }
  .enjoy-header,
  .enjoy-container,
  .enjoy-header h1 {
    text-align: center;
  }
  .enjoy-header > p {
    width: 100%;
  }
  /* Enjoy section icons for mobile */
  .enjoy__clock-icon,
  .enjoy__fitness-icon,
  .enjoy__wifi-icon,
  .enjoy__coffee-icon {
    position: unset;
    padding: 0.5rem;
  }
  .page-header {
    text-align: center;
    padding: 1rem;
    font-size: 30px;
  }
  .cards-container {
    flex-direction: column;
  }
  .card {
    margin-bottom: 1em;
  }
  .page-header:after {
    margin: 0.5em auto 0 auto;
    height: 2px;
  }

  .page-header-container {
    margin-bottom: 10px;
  }
  .btn-large {
    margin-bottom: 1em;
    margin: auto;
    font-weight: 700;
    font-size: 77%;
    padding: 15px 27px;
  }

  .jumbotron-form {
    width: 90%;
    margin: 1em auto;
    padding: 1em 0.5em;
  }

  .jumbotron-form h3 {
    font-size: 20px;
    text-align: center;
  }
  .jumbotron-form p {
    font-size: 17px;
  }

  .jumbotron-form p br {
    display: none;
  }
  .jumbotron-left p {
    font-size: 18px;
    width: 100%;
    text-align: center;
    margin-bottom: 1em;
  }

  .jumbotron-right .jumbotron-left,
  .jumbotron-right {
    flex: 1;
  }
  .jumbotron-form button {
    margin-bottom: 1em;
  }

  .enjoy-services {
    margin-bottom: 0.5em;
  }

  .special-offers {
    padding: 0 0 35px;
  }

  .enjoy__play-icon {
    z-index: 2;
    width: 4rem;
    opacity: 0.9;
    height: 4rem;
  }

  .page-header,
  .enjoy-heading {
    text-transform: capitalize;
    text-align: center;
  }

  .horizontal {
    height: 2px;
    width: 39%;
  }

  .enjoy-heading {
    margin-top: 20px;
    font-size: 30px;
  }

  .enjoy-heading br {
    display: none;
  }

  .first-col,
  .sec-col {
    margin-right: unset;
  }

  .upper,
  .lower {
    padding-left: unset;
  }

  .third-col {
    order: -1;
    margin-bottom: 1rem;
  }

  .third-col-video {
    width: 100%;
    filter: drop-shadow(2px 4px 6px black);
  }

  .side-by-side-container {
    flex-direction: column;
  }

  .stacked-image-container {
    flex-direction: row;
  }

  .offers-sub-title {
    padding: 1rem;
  }

  .offers-sub-title br {
    display: none;
  }

  .offers-list {
    margin-left: 1.5rem;
  }

  .centered {
    margin: auto;
    display: block;
    width: 50%;
    text-align: center;
  }

  .img-hide {
    display: none;
  }
  .review-title {
    text-align: center;
    font-size: 30px;
  }

  .card {
    width: 100%;
  }

  .card-avi {
    width: 30%;
    display: block;
    margin: 1.5rem auto;
  }

  .card-title,
  .card-subtitle {
    width: 100%;
    text-align: center;
  }

  .card-subtitle {
    font-weight: 300;
  }
}

@media only screen and (max-width: 320px) {
  .small-image {
    display: none;
  }

  .large-image {
    width: 100%;
    object-fit: cover;
  }
}

/* Small devices (portrait tablets and large phones, 600px and up) */
@media only screen and (min-width: 600px) and (max-width: 700px) {
  .jumbotron-container {
    width: 100%;
    flex-direction: column;
    align-items: center;
  }
  .btn-large {
    margin: 0.5em auto 1em 1em;
  }
  .jumbotron-form {
    width: 100%;
    margin: 1em auto;
    padding: 1em 0.5em;
  }
  .enjoy-header,
  .enjoy-container,
  .enjoy-header h1 {
    text-align: center;
  }
  .enjoy-header > p {
    width: 100%;
  }
  .enjoy-services {
    flex-direction: column;
  }

  .page-header {
    padding: 0 100px 0 100px;
  }

  .card {
    margin-bottom: 1em;
  }
  .page-header:after {
    margin: 0.5em auto 0 auto;
  }
  .btn-large {
    margin-bottom: 1em;
  }
  .jumbotron-left h1 {
    font-size: 50px;
    margin-top: 1em;
  }
  .horizontal {
    margin: 1em auto 2em auto;
  }
}
@media only screen and (min-width: 700px) {
  .jumbotron-form {
    margin: 1em 0;
  }
  .jumbotron-form h3 {
    padding-top: 1em;
    font-size: 25px;
    text-align: center;
  }
  .jumbotron-form p {
    font-size: 18px;
  }

  .rates {
    margin-bottom: 1em;
  }
}
@media only screen and (min-width: 954px) {
  .jumbotron-container {
    width: 100%;
    flex-direction: row;
    align-items: center;
  }
  .enjoy-services {
    flex-direction: row;
  }
}
</style>
