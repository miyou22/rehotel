<template>
  <!-- <AHeader /> -->
  <div class="board-container">
    <div class="page-header-container">
      <h1 class="page-header">관리자 홈</h1>
    </div>
    <div class="adminPreView">
      <h3>예약정보</h3>
      <ul class="adminReservation">
        <li class="w3-card w3-bottombar w3-border-red notice">
          <p>총 예약된 객실</p>
          <h1>{{ resList.length }}/30</h1>
        </li>
        <li class="w3-card w3-bottombar w3-border-yellow notice">
          <p>총 수익</p>
          <h1>{{ numberWithCommas(totalRoomPrice) }}원</h1>
        </li>
        <li class="w3-card w3-bottombar w3-border-blue notice">
          <p class="roomP">남은 방 수</p>
          <Bar id="my-chart-id" :options="chartOptions" :data="chartData" />
        </li>
      </ul>

      <!--{{ countDeluxeVilla }}-->
      <h3>최근소식</h3>
      <div>{{ categoryBoard }}</div>
      <ul class="adminNotice">
        <li
          class="w3-card notice"
          v-for="(categoryItems, categoryKey) in categorizedItems"
          :key="categoryKey"
        >
          <h4>
            {{ categoryNames[categoryKey] }}
            {{ categoryKey }}
            <a href="admin/board">자세히보기</a>
          </h4>
          <ul class="adminDetailView">
            <li
              v-for="(item, index) in getLastThreeItems(categoryItems)"
              :key="index"
            >
              <p
                class="linkMove"
                @click="$router.push(`/admin/board/detail/${item.boardSn}`)"
              >
                {{ item.boardTitle }}
              </p>
              <span>{{ formatDate(item.createdAt) }}</span>
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import { Bar } from "vue-chartjs";
import {
  Chart as ChartJS,
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale,
} from "chart.js";

ChartJS.register(
  Title,
  Tooltip,
  Legend,
  BarElement,
  CategoryScale,
  LinearScale
);

export default {
  components: {
    Bar,
  },
  data() {
    return {
      roomName: "",
      resList: [],
      boardList: [],
      // faqList: [],
      // noticeList: [],
      // inquiryList: [],
      PriceList: [],
      totalRoomPrice: 0,
      chartData: {
        labels: ["공지사항", "문의사항", "faq"],
        datasets: [{ data: [2, 6, 3] }],
      },
      chartOptions: {
        responsive: true,
        plugins: {
          legend: {
            display: false,
          },
        },
      },
    };
  },
  computed: {
    countDeluxeVilla() {
      // 'resList'에서 'roomName'이 '디럭스 풀빌라'인 항목의 개수를 계산하여 반환합니다.
      return this.resList.filter((item) => item.roomName === "디럭스 풀빌라")
        .length;
    },
    categorizedItems() {
      const categories = {
        notice: [],
        inquiry: [],
        faq: [],
      };
      for (const item of this.boardList) {
        if (categories[item.boardCategory]) {
          categories[item.boardCategory].push(item);
        }
      }
      console.log("categories::::", categories);
      return categories;
    },
    categoryNames() {
      return {
        notice: "공지사항",
        inquiry: "문의사항",
        faq: "FAQ",
      };
    },
  },
  mounted() {
    this.getResList();
    this.getPriceList();
    this.getBoardList();
    console.log(this.boardList);
  },
  methods: {
    formatDate(dateTimeString) {
      return dateTimeString.slice(0, 10);
    },
    updateChartData() {
      // 'countDeluxeVilla()' 메소드를 호출하여 '디럭스 풀빌라'로 예약된 객실의 개수를 가져옵니다.
      const count = this.countDeluxeVilla();
      // 'chartData'의 'datasets' 배열의 'data' 속성에 'count' 값을 할당합니다.
      this.chartData.datasets[0].data = [count];
      // 차트를 업데이트합니다.
      if (this.$refs.myChart && this.$refs.myChart.update) {
        this.$refs.myChart.update();
      }
    },
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    calculateTotalRoomPrice() {
      // PriceList에 있는 roomPrice의 총 합계 계산
      this.totalRoomPrice = this.PriceList.reduce((total, item) => {
        return total + parseFloat(item.roomPrice);
      }, 0);
    },
    getResList() {
      const today = new Date();
      today.setHours(0, 0, 0, 0); // 오늘 날짜의 시간을 00:00:00 으로 설정

      this.$axios
        .get("http://localhost:8081/api/reservation/resInfo")
        .then((res) => {
          // checkout 날짜가 오늘 이후인 데이터만 필터링하여 resList에 할당
          console.log("res.data::::", res.data);
          this.resList = res.data.filter((item) => {
            const checkoutDate = new Date(item.resCheckout);
            checkoutDate.setHours(0, 0, 0, 0); // checkout 날짜의 시간을 00:00:00 으로 설정
            return checkoutDate >= today && item.payCheck === 1;
          });
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
    getPriceList() {
      this.$axios
        .get("http://localhost:8081/api/reservation/resInfo")
        .then((res) => {
          this.PriceList = res.data.filter((item) => item.payCheck === 1);

          this.calculateTotalRoomPrice();
          console.log(res.data);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => {
          console.log("항상 마지막에 실행");
        });
    },
    getBoardList() {
      this.$axios
        .get("http://localhost:8081/api/admin/board")
        .then((res) => {
          this.boardList = res.data;
          console.log(res.data);
        })
        .catch((err) => {
          console.log("에러닷:", err);
        });
    },

    getLastThreeItems(categoryItems) {
      console.log(categoryItems);
      return categoryItems.slice(-3).reverse();
    },
  },
};
</script>

<style scoped>
.board-container {
  max-width: 1200px;
  margin-top: 80px;
  margin: 0 auto;
}
.page-header {
  margin: 0;
  font-size: 32px;
  text-align: left;
  margin-top: 85px;
  margin-bottom: 80px;
}
.page-header-container {
  text-align: center;
}
.adminPreView h3 {
  border-bottom: 1px solid rgb(238, 238, 238);
  padding-bottom: 20px;
  margin-bottom: 32px;
  font-size: 18px;
  font-weight: bold;
  color: rgb(156, 131, 106);
  margin-top: 80px;
}
.adminPreView h3:first-child {
  margin-top: 0;
}
.adminNotice,
.adminReservation {
  display: flex;
  justify-content: space-between;
  margin-bottom: 85px;
}
.notice,
.inquiry,
.faq {
  width: 30%;
  height: 230px;
  padding: 30px 20px;
  font-weight: 50;
  background-color: rgb(247, 247, 247);
  list-style: none;
}

h4 {
  display: flex;
  justify-content: space-between;
  margin-bottom: 30px;
  font-size: 16px;
}

h4 a {
  text-decoration: underline;
  font-size: 15px;
}
.adminDetailView li {
  display: flex;
  justify-content: space-between;
  margin-bottom: 7px;
  font-size: 15px;
}
.adminDetailView li p {
  width: 70%;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  cursor: pointer;
  font-size: 15px;
}
.adminDetailView li span {
  font-size: 15px;
  line-height: 1.5;
}
.roomP {
  margin-bottom: 10px;
}
</style>
