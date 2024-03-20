<template>
  <main>
    <div class="container-full">
      <h2 class="accName">부대시설</h2>

      <div class="menu">
        <a v-for="(fac, index) in menus" :key="index">{{ fac }}</a>
      </div>

      <div v-for="(fac, index) in products" :key="index">
        <div class="fac-information">
          <div class="fac-name">
            <div class="name">{{ fac.name }}</div>
            <div class="sub-information">{{ fac.information }}</div>
            <div class="fac-bottom">
              <p>
                <img src="../assets/img/time.png" alt="" />운영시간:
                <img src="../assets/img/place.png" alt="" />
              </p>
              {{ fac.time }}
            </div>
            <swiper ref="{swiperRef}" :slidesPerView="1" :slidesPerGroup="1" :centeredSlides="false" :spaceBetween="14"
              :navigation="true" :loop="true" :modules="modules" :autoHeight="true" class="mySwiper">
              <swiper-slide>
                <img class="img" v-bind:src="fac.img" />
              </swiper-slide>
              <swiper-slide>
                <img class="img" v-bind:src="fac.img2" />
              </swiper-slide>
              <swiper-slide>
                <img class="img" v-bind:src="fac.img3" />
              </swiper-slide>
              <swiper-slide>
                <img class="img" v-bind:src="fac.img4" />
              </swiper-slide>
            </swiper>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { Swiper, SwiperSlide } from "swiper/vue";
import { Navigation } from "swiper/modules";
// import Swiper and modules styles
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";

export default {
  data() {
    return {
      products: [
        {
          name: "다이닝",
          information:
            "해외 각국 주요 도시에 진출하여 한식의 아름다움을 전하고 있는 본가가 제주의 훌륭한 식재료와 만나 한층 업그레이드 된 정통 한식을 선보입니다.",
          time: "11:30~22:00",
          img: require("../assets/img/dining1.jpg"),
          img2: require("../assets/img/dining2.jpg"),
          img3: require("../assets/img/dining3.jpg"),
          img4: require("../assets/img/dining4.jpg"),
        },
        {
          name: "피트니스 센터",
          information:
            "Techno Gym사의 최신 운동기구를 비치하여 여행에 지친 몸과 마음에 활력을 충전할 수 있는 공간입니다. 유산소 운동에 적합한 실내 사이클과 각종 근력운동을 위한 기구들이 준비되어 있습니다.",
          time: "11:30~22:00",
          img: require("../assets/img/health1.jpg"),
          img2: require("../assets/img/health2.jpg"),
          img3: require("../assets/img/health3.jpg"),
          img4: require("../assets/img/health4.jpg"),

        },
        {
          name: "편의점",
          information:
            "언제나 쉽게 찾을 수 있는 상품과 서비스를 갖춘 편의시설인 CU가 지하 1층에서 운영되고 있습니다.",
          time: "11:30~22:00",
          img: require("../assets/img/store1.jpg"),
          img2: require("../assets/img/store2.jpg"),
          img3: require("../assets/img/store3.jpg"),
          img4: require("../assets/img/store4.jpg"),
        },
        {
          name: "셀프 세탁실",
          information:
            "드럼 세탁기와 건조기가 구비된 최신식 세탁실입니다. 여행의 불편을 덜어드리고 포근함과 청결을 전해주는 공간입니다.",
          time: "11:30~22:00",
          img: require("../assets/img/clean1.jpg"),
          img2: require("../assets/img/clean2.jpg"),
          img3: require("../assets/img/clean3.jpg"),
          img4: require("../assets/img/clean4.jpg"),
        },
      ],
    };
  },
  methods: {},
  components: { Swiper, SwiperSlide },

  setup() {
    return {
      modules: [Navigation],
    };
  },
};
</script>


<style scoped>
@import "../assets/css/Facility.css";

.container-full {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1.5rem 0.5rem;
}

.sub-gnb {
  display: flex;
  height: 60px;
  outline: 1px solid #d3d1d1;
  align-items: center;
  /* color: #d4af37; */
}

.sub-gnb-name {
  font-weight: bold;
  font-size: 18px;
  margin: 0 140px 0 40px;
}

.sub-gnb-list {
  display: flex;
  list-style: none;
}

.sub-gnb-list li {
  margin: 0 20px 0 20px;
}

.sub-gnb-list li a {
  font-size: 16px;
  text-decoration: none;
}

.img {
  width: 800px;
  height: 370px;
}

.accName {
  margin-bottom: 50px;
  font-weight: bold;
  font-size: 40px;
  text-align: center;
}
</style>
