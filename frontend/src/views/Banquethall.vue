<template>
  <main>
    <h4 class="head-tit">Banquet Hall</h4>
    <p class="head-sub">
      저희 킹스 호텔의 연회장은 호텔 숙박하는 고객님에 한해서 예약이 가능합니다
    </p>
    <div class="img-box">
      <img
        src="https://www.esuncruise.com/SunCruiseMain_common/images/homepage/visual/launge2.jpg"
      />
    </div>

    <div class="info-tit">
      <p>Information</p>
    </div>

    <div class="info-con">
      <div class="f-info">
        <p class="info-subti"><strong>위치</strong></p>
        <p class="info-sub">킹스호텔 5층</p>
      </div>
      <div class="t-info t2">
        <p class="info-subti"><strong>가격</strong></p>
        <p class="info-sub">100,000원</p>
      </div>
      <div class="t-info">
        <p class="info-subti"><strong>예약문의</strong></p>
        <p class="info-sub">Tel. 031-123-4567</p>
      </div>
      <div class="t-info t2">
        <p class="info-subti"><strong>이용가능</strong></p>
        <p class="info-sub">킹스 호텔에 숙박하는 고객님들만 예약 가능합니다</p>
      </div>
    </div>
  </main>
</template>

<script>
export default {};
</script>

<style scoped>
main {
  width: 1200px;
  margin: auto;
}
.f-info,
.t-info {
  display: flex;
  align-items: center;
  line-height: 50px;
}
ul {
  list-style: none;
}
.info-con {
  display: flex;
  justify-content: space-between;
  border-bottom: 1px solid #d9d9d9;
  padding: 24px 0;
  margin-bottom: 80px;
  align-items: center;
  flex-wrap: wrap;
}
.info-subti {
  width: 120px;
  font-size: 15px;
  font-weight: 500;
  color: #201f1f;
}
.info-sub {
  width: 480px;
  font-size: 15px;
  color: #666;
}
.information {
  outline: 0;
}
.info-tit {
  border-bottom: 2px solid #454545;
}
.info-tit p {
  margin-bottom: 15px;
}

.info-tit p {
  text-decoration: none;
  font-weight: 500;
  font-size: 28px;
  color: #000000;

  padding: 14px 0 3px;
}
.head-tit {
  font-family: "Noto Sans KR", sans-serif;
  text-align: center;
  font-size: 40px;
  font-weight: bold;
  margin: 0;
  margin-bottom: 10px;
}
.head-sub {
  text-align: center;
  color: #696969;
  font-size: 15px;
  margin-top: 19px;
  line-height: 150%;
  margin-bottom: 50px;
}
.img-box {
  width: 1200px;
  margin: auto;
}
</style>
