<template>
  <main>
    <div class="sub-gnb">
      <p class="sub-gnb-name">시설 소개</p>
      <ul class="sub-gnb-list">
        <li><a href="#">객실</a></li>
        <li><a href="#">부대시설</a></li>
        <li><a href="#">연회장</a></li>
      </ul>
    </div>
    <div class="container">
      <h2 class="accName">객실</h2>

      <div class="menu">
        <a v-for="(info, index) in menus" :key="index">{{ info }}</a>
      </div>

      <div v-for="(info, index) in products" :key="index">
        <div class="information">
          <div class="left-information">
            <img v-bind:src="info.img" />
          </div>
          <div class="right-information">
            <div class="name">{{ info.name }}</div>
            <div class="sub-information">{{ info.information }}</div>
            <div class="sub-bottom">
              <p>침대 크기:</p>
              {{ info.type }}
            </div>
            <div class="sub-bottom">
              <p>투숙인원:</p>
              {{ info.member }}
            </div>
            <div class="sub-bottom">
              <p>체크아웃:</p>
              {{ info.check }}
            </div>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
// import switchRooms from "../assets/js/switchRooms";
export default {
  data() {
    return {
      products: [
        {
          name: "디럭스룸",
          information:
            "2인 이하 여행객이 가장 선호하며, 여유로운 수납 공간과 Simmons Beautyrest® 의 킹 사이즈 침대 1조가 제공되는 객실입니다.침구는 100% 오리털, 100% 코튼 소재의 린넨으로 최상의 편안함을 경험할 수 있습니다.청정 제주의 감귤 추출물을 담은 호텔더본의 특별한 감귤 어메니티를 만나 보세요.",
          img: require("../assets/img/deluxRoom.jpg"),
          type: "더블/트윈",
          member: "2명",
          check: "15:00/11:00",
        },
        {
          name: "디럭스 스위트",
          information:
            "가족 및 3인 이하 여행객이 가장 선호하며 여유로운 수납 공간과 Simmons Beautyrest®의 퀸 사이즈,싱글 사이즈 침대가 각 1조 제공되는 객실입니다.100% 오리털 침구와 100% 코튼소재의 린넨은 최상의 편안함을 경험할 수 있습니다.청정 제주의 감귤 추출물을 담은 호텔더본의 특별한 감귤 어메니티를 만나 보세요.",
          img: require("../assets/img/deluxsweet.jpg"),
          type: "더블/트윈",
          member: "2명",
          check: "15:00/11:00",
        },
        {
          name: "디럭스 풀",
          information:
            "가족 및 4인 이하 여행객이 가장 선호하며 여유로운 수납 공간과 Simmons Beautyrest®의퀸 사이즈 침대가 2조 제공되는 객실입니다. 100% 오리털 침구와 100% 코튼소재의 린넨은 최상의 편안함을 경험할 수 있습니다.청정 제주의 감귤 추출물을 담은 호텔더본의 특별한 감귤 어메니티를 만나 보세요.",
          img: require("../assets/img/deluxFull.jpg"),
          type: "더블/트윈",
          member: "2명",
          check: "15:00/11:00",
        },
        {
          name: "그랜드 디럭스",
          information:
            "2인 이하 프리미엄을 선호하는 여행객에게 최선의 선택으로, 여유로운 수납 공간과 Simmons Beautyrest® 의킹 사이즈 침대 1조가 제공되는 객실입니다. 침구는 100% 오리털, 100% 코튼 소재의 린넨으로 최상의 편안함을 경험할 수 있습니다.청정 제주의 감귤 추출물을 담은 호텔더본의 특별한 감귤 어메니티를 만나 보세요.",
          img: require("../assets/img/grandDelux.jpg"),
          type: "더블/트윈",
          member: "2명",
          check: "15:00/11:00",
        },
        {
          name: "로얄스위트",
          information:
            "2인 이하 프리미엄을 선호하는 여행객에게 최선의 선택으로, 여유로운 수납 공간과 Simmons Beautyrest® 의킹 사이즈 침대 1조가 제공되는 객실입니다. 침구는 100% 오리털, 100% 코튼 소재의 린넨으로 최상의 편안함을 경험할 수 있습니다.청정 제주의 감귤 추출물을 담은 호텔더본의 특별한 감귤 어메니티를 만나 보세요.",
          img: require("../assets/img/loyalsweet.jpg"),
          type: "더블/트윈",
          member: "2명",
          check: "15:00/11:00",
        },
      ],
    };
  },
  methods: {},
};
</script>

<style scoped>
@import "../assets/css/Rooms.css";

.container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 1.5rem 0.5rem;
}
</style>