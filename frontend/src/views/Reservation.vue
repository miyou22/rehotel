<template>
  <main>
    <h1 class="headtxt">Reservation</h1>

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
      <button class="res" @click="filterList">검색</button>
    </div>

    <div class="reservation">
      <div class="headtxt2">
        <h4>객실예약</h4>
      </div>
      <div class="list" v-for="list in filteredRoom" :key="list">
        <div class="content">
          <div class="img">
            <img :src="list.img" width="253px" />
          </div>
          <div class="txt-group">
            <h4>{{ list.title }}</h4>
            <ul>
              <li>{{ list.type }}</li>
              <li>최대 인원: {{ list.member }}</li>
              <li>
                남은 객실 수: <b>{{ list.count }}</b>
              </li>
            </ul>
          </div>
          <div class="price">
            <h3 class="rm-price-box">
              <span class="rm-price">{{ numberWithCommas(list.price) }}</span>
            </h3>
            <p>원/1박</p>
            <a href="/payment" class="resBtn" @click.prevent="reserveRoom(list)"
              >예약하기</a
            >
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
    filterList() {
      const selectedMember = parseInt(document.getElementById("member").value); // 선택된 인원수 가져오기
      this.selectedRoom = this.room.filter(
        (item) => item.member >= selectedMember
      );
    },
    reserveRoom(roomData) {
      const selectedMember = parseInt(document.getElementById("member").value);

      // 선택된 객실 데이터
      const selectedRoom = this.room.find(
        (item) => item.title === roomData.title
      );

      if (selectedMember > selectedRoom.member) {
        // 선택된 인원이 최소 인원보다 적을 때 경고창 표시
        alert("선택된 인원이 객실의 수용 가능한 최대 인원보다 많습니다.");
      } else {
        this.$store.commit("setSelectedRoomData", roomData);
        this.$store.commit("setCheckinDate", this.checkin);
        this.$store.commit("setCheckoutDate", this.checkout);
        this.$store.dispatch("saveSelectedRoomImageData", roomData.img);
        const selectedMember = parseInt(
          document.getElementById("member").value
        ); // 선택된 인원수 가져오기
        this.$store.commit("setTotalMember", selectedMember);
        this.$router.push("/payment");
      }
      this.$nextTick(() => {
        window.scrollTo(0, 0);
      });
    },
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
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

    return {
      checkin,
      checkout,
      format,
      format2,
    };
  },
  data() {
    return {
      selectedRoom: null,
      room: [
        {
          img: require("../assets/img/deluxRoom.jpg"),
          title: "디럭스 룸",
          type: "더블 1개",
          member: 2,
          price: 140000,
          count: 6,
        },
        {
          img: require("../assets/img/deluxFull.jpg"),
          title: "디럭스 풀빌라",
          type: "더블 2개",
          member: 2,
          price: 260000,
          count: 6,
        },
        {
          img: require("../assets/img/loyalsweet.jpg"),
          title: "로얄 스위트",
          type: "더블 1개",
          member: 2,
          price: 280000,
          count: 6,
        },
        {
          img: require("../assets/img/deluxsweet.jpg"),
          title: "디럭스 스위트 룸",
          type: "더블 2개",
          member: 3,
          price: 230000,
          count: 6,
        },
        {
          img: require("../assets/img/grandDelux.jpg"),
          title: "그랜드 디럭스 룸",
          type: "더블 3개",
          member: 4,
          price: 400000,
          count: 6,
        },
      ],
    };
  },
  computed: {
    setYmd() {
      return this.$store.state.fromDate;
    },
    setYmd2() {
      return this.$store.state.fromDate2;
    },
    setSelectedMembers() {
      return this.$store.state.selectedMembers;
    },
    filteredRoom() {
      return this.selectedRoom || this.room;
    },
  },
  mounted() {
    this.checkin = this.setYmd;
    this.checkout = this.setYmd2;
    this.selectedMembers = this.setSelectedMembers;
  },
};
</script>

<style scoped>
* {
  font-family: "Noto Sans KR", sans-serif;
}
main {
  width: 100%;
}
.txt-group b {
  color: #d4af37;
}
.check-box {
  background-color: white;
  width: 1200px;
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
  font-size: 40px;
  font-weight: bold;
  margin: 0;
  margin-top: 85px;
  margin-bottom: 10px;
}
.reservation {
  width: 1200px;
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
