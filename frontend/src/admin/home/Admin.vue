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
          <h1>1/30</h1>
        </li>
        <li class="w3-card w3-bottombar w3-border-yellow notice">
          <p>수익</p>
          <h1>18만 2천원</h1>
        </li>
        <li class="w3-card w3-bottombar w3-border-blue notice">
          <p class="roomP">남은 방 수</p>
          <Bar id="my-chart-id" :options="chartOptions" :data="chartData" />
        </li>
      </ul>
      <h3>최근소식</h3>
      <ul class="adminNotice">
        <li class="w3-card notice">
          <h4>공지사항 <a>자세히보기</a></h4>
          <ul class="adminDetailView">
            <li>
              <p>
                <a href="/notice"
                  >도도도dddddddddddddddddddddddddddddddddddddd</a
                >
              </p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">레레레</a></p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">미미미</a></p>
              <span>2024/03/20</span>
            </li>
          </ul>
        </li>
        <li class="w3-card inquiry">
          <h4>문의사항 <a>자세히보기</a></h4>
          <ul class="adminDetailView">
            <li>
              <p>
                <a href="/notice"
                  >도도도dddddddddddddddddddddddddddddddddddddd</a
                >
              </p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">레레레</a></p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">미미미</a></p>
              <span>2024/03/20</span>
            </li>
          </ul>
        </li>
        <li class="w3-card faq">
          <h4>FAQ <a>자세히보기</a></h4>
          <ul class="adminDetailView">
            <li>
              <p>
                <a href="/notice"
                  >도도도dddddddddddddddddddddddddddddddddddddd</a
                >
              </p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">레레레</a></p>
              <span>2024/03/20</span>
            </li>
            <li>
              <p><a href="/notice">미미미</a></p>
              <span>2024/03/20</span>
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
      chartData: {
        labels: ["1번", "2번", "3번", "4번", "5번"],
        datasets: [{ data: [5, 6, 6, 6, 6] }],
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
  font-size: 15px;
}

h4 a {
  text-decoration: underline;
  font-size: 15px;
}
.adminDetailView li {
  display: flex;
  justify-content: space-between;
  margin-bottom: 7px;
  font-size: 18px;
}
.adminDetailView li p {
  width: 70%;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}
.adminDetailView li span {
  font-size: 18px;
  line-height: 1.5;
}
.adminDetailView li a {
  text-decoration: none;
  font-size: 18px;
}
.roomP {
  margin-bottom: 10px;
}
</style>
