<template>
  <div class="wrap">
    <section class="page-header-container">
      <h1 class="header">About</h1>
    </section>
    <!-- 객실 소개 섹션 -->
    <section class="info room">
      <div class="content">
        <div class="text">
          <h2>Room</h2>
          <p>
            편안하며 모던함과 클래식이 결합된 공간<br/>
            현대적인 인테리어의 모던한 디럭스 객실과<br/>
            세련되고 우아한 감성의 스위트 객실, <br/>
            그리고 최고급 풀빌라까지<br/>
            다양한 객실에서 특별한 순간과 최상의 휴식과 여유를 경험해 보세요.
          </p>
        </div>
        <button class="btn b1" @click="$router.push('/accommodation'), inp">
          자세히보기
        </button>
      </div>
      <div class="img-wrapper">
        <img src="../assets/img/hotel5.jpg" alt="객실 소개 이미지">
        <div class="overlay over1"></div>
      </div>
    </section>

    <!-- 다이닝 소개 섹션 -->
    <section class="info dining">
      <div class="img-wrapper">
        <img src="../assets/img/hotel2.jpg" alt="다이닝 소개 이미지">
        <div class="overlay over2"></div>
      </div>
      <div class="content">
        <div class="text">
          <h2>Dining</h2>
          <p>
            셰프의 손맛이 느껴지는 다채로운 요리와 함께 편안한 식사를 즐겨보세요.<br/>
            정갈한 인테리어와 함께 편안한 식사를 즐길 수 있습니다.<br/>
            여행에 특별한 맛과 기억을 더해보세요 .
          </p>
        </div>
        <button class="btn b2" @click="$router.push('/dining'), inp">
          자세히보기
        </button>
      </div>
    </section>

    <!-- 부대 시설 소개 섹션 -->
    <section class="info facility">
      <div class="content">
        <div class="text">
          <h2>Facility</h2>
          <p>
            다양한 행사를 위한 최적의 장소를 제공합니다.<br/>
            넓고 현대적인 디자인과 최신 시설을 갖추고 있어<br/>
            비지니스 회의, 연회 및 기타 이벤트에 완벽한 장소입니다.<br/>
            휴식과 여행의 만족도를 높이는 다양한 편의시설과 함께하세요.
          </p>
        </div>
        <button class="btn b3" @click="$router.push('/facility'), inp">
          자세히보기
        </button>
      </div>
      <div class="img-wrapper">
        <img src="../assets/img/hotel1.jpg" alt="부대 시설 소개 이미지">
        <div class="overlay over3"></div>
      </div>
    </section>
  </div>
</template>

<script>

export default {
  name: 'about',

}
</script>

<style scoped>

.wrap {
  max-width: 1200px;
  margin: auto;
}

.header {
  font-size: 40px;
  text-align: center;
  font-weight: bold;
}


/* fadeup애니메이션 추가 */
.info {
  display: flex;
  align-items: center;
  justify-content:space-between;
  padding: 0 0 120px 0;
  box-sizing: border-box;
  opacity: 0;
  transform: translateY(10px);
  animation: fadeUpAnimation 3s ease forwards;
}

@keyframes fadeUpAnimation {
  from {
    opacity: 0;
    transform: translateY(10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

.room {
  animation-delay: 0.5s;
}

.dining{
  display: flex;
  align-items: center;
  animation-delay: 1s;
}

.facility{
  display: flex;
  align-items: center;
  animation-delay: 2s;
  margin-bottom: 96px;
}

.text {
  display: flex;
  flex: 2;
  margin-right: 50px;
  margin-left: 50px;
  flex-direction: column;
  justify-content: center;
}

img {
  flex: 2;
  position: relative;
  max-height: 400px;
  z-index: 1;
}

/* 이미지 뒤 gray-rectangle 추가 */
.img-wrapper {
  position: relative;
}

.over1, .over3 {
  position: absolute;
  top: 60px;
  left: 80px;
  width: 100vw;
  height: 100%;
  background-color: rgba(215, 217, 223, 0.2);
  z-index: 0;
}

.over2 {
  position: absolute;
  top: 60px;
  right: 80px;
  width: 100vw;
  height: 100%;
  background-color: rgba(215, 217, 223, 0.2);
  z-index: 0;
}

h2 {
  margin-bottom: 30px;
}

p {
  max-width: 100%;
  font-size: 16px;
  line-height: 1.5;
  color: #555555;
}

.btn {
  width: 140px;
  height: 50%;
  margin: 30px 50px;
  border: 0;
  font-size: 14px;
  background-color: #d4af37;
  border-radius: 0%;
  color: white;
  cursor: pointer;
}

.btn:hover {
  background-color: #c9a635;
}
</style>

