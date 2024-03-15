<template>
  <main>
    <h1 class="headtxt">Reservation</h1>
    <h1></h1>

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
            placeholder="select a date
"
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
            placeholder="select a date"
          ></VueDatePicker>
        </div>
      </div>
      <div class="tw-box">
        <div class="room">
          <p>객실수</p>
          <select name="room" id="room" caption="객실수">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
          </select>
        </div>

        <div class="person">
          <p>인원수</p>
          <select name="member" id="member" caption="인원수">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
          </select>
        </div>
      </div>
      <button class="res">검색</button>
    </div>

    <div class="reservation">
      <div class="headtxt2">
        <h4>객실예약</h4>
      </div>
      <div class="list" v-for="list in room" :key="list">
        <div class="content">
          <div class="img">
            <img :src="list.img" width="253px" />
          </div>
          <div class="txt-group">
            <h4>{{ list.title }}</h4>
            <ul>
              <li>{{ list.type }}</li>
              <li>최대 인원: {{ list.member }}</li>
            </ul>
          </div>
          <div class="price">
            <h3 class="rm-price-box">
              <span class="rm-price">{{ list.price }}</span>
            </h3>
            <p>원/1박</p>
            <a href="/reservation/pay" class="resBtn">예약하기</a>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import { ref } from "vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import "@vuepic/vue-datepicker/dist/main.css";
import "../assets/css/root.css";

export default {
  components: { VueDatePicker },
  methods: {
    // inp() {
    //   let val = document.getElementsByClassName("dp__pointer")[1].value;
    //   document.getElementById("mama").innerText = val;
    // },
    // printCheckin() {
    //   document.getElementById("ppp").innerText = this.checkin;
    // },
  },
  setup() {
    const checkin = ref(new Date());
    const checkout = ref(new Date());
    const format = (date) => {
      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      return `${year}/${month}/${day}`;
    };
    const format2 = (date) => {
      const day = date.getDate();
      const month = date.getMonth() + 1;
      const year = date.getFullYear();

      return `${year}/${month}/${day}`;
    };
    // const searchDate = ref();
    return {
      checkin,
      checkout,
      format,
      format2,
    };
  },
  data() {
    return {
      room: [
        {
          img: require("../assets/img/hotel-1.webp"),
          title: "그랜드 럭셔리 더블 시티뷰",
          type: "더블 3개",
          member: 2,
          price: "200,000",
        },
        {
          img: require("../assets/img/hotel-2.webp"),
          title: "그랜드 럭셔리 더블 오션뷰",
          type: "더블 3개",
          member: 2,
          price: "200,000",
        },
      ],
    };
  },
  computed: {
    // store에서 fromDate에 접근하는 computed 속성을 추가합니다.
    setYmd() {
      return this.$store.state.fromDate;
    },
    setYmd2() {
      return this.$store.state.fromDate2;
    },
  },
  mounted() {
    // Vuex store의 값을 input 요소의 값에 설정
    this.checkin = this.setYmd;
    this.checkout = this.setYmd2;
  },
};
</script>
<!-- {

  title: "디럭스",
  type: "더블 2개",
  member: 2,
  price: "200,000",
},
{
  img: require("../assets/img/hotel-1.webp"),
  title: "디럭스",
  type: "더블 3개",
  member: 2,
  price: "200,000",
}, -->
<style scoped>
main {
  width: 100%;
}
.check-box {
  background-color: white;
  width: 1180px;
  height: 130px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 10px 15px;
  padding: 0px 80px;
  display: flex;
  z-index: 1;
  margin: auto;
  border-radius: 12px;
  align-items: center;
  margin-bottom: 50px;
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
.txt-group {
  text-align: left;
  padding-left: 35px;
}
.txt-group h4 {
  font-size: 20px;
  color: #323232;
  text-align: left;
  font-weight: 500;
  margin-bottom: 12px;
}
.headtxt {
  text-align: center;
  font-size: 38px;
  font-weight: bold;
  margin-bottom: 10px;
  margin-top: 85px;
}
.reservation {
  width: 1180px;
  background-color: white;
  padding: 40px;
  margin: auto;
}
.headtxt2 {
  border-bottom: 1px solid lightgray;
}
.headtxt2 h4 {
  font-size: 20px;
  color: #323232;
  text-align: left;
  font-weight: bold;
  margin-bottom: 12px;
}
ul {
  list-style: none;
}
ul > li {
  font-size: 14px;
  color: #666;
  line-height: 1.6em;
}
.price {
  width: auto;
  text-align: right;
}
.rm-price-box {
  display: inline-block;
  color: #323232;
  margin-bottom: 3px;
}
.rm-price {
  font-size: 30px;
  font-weight: 500;
  display: block;
  margin-top: -3px;
}
.price p {
  color: #666;
  text-align: right;
  font-size: 14px;
  line-height: 1.6rem;
}
.list {
  padding: 20px 15px 30px;
  border-bottom: 1px solid #e5e5e5;
  margin-bottom: 10px;
}
.content {
  display: table;
  width: 100%;
  table-layout: fixed;
}
.img,
.txt-group,
.price {
  display: table-cell;
  vertical-align: top;
}
.img {
  text-align: left;
  width: 253px;
}
.price {
  width: auto;
  text-align: right;
}
.resBtn {
  text-align: center;
  font-size: 15px;
  cursor: pointer;
  font-weight: 300;
  background: #d4af37;
  color: white;
  padding: 10px;
  text-decoration: none;
  line-height: 90px;
}
</style>
