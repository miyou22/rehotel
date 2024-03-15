<template>
  <div>
    <!-- <h2>선택된 방 정보</h2>
    <div>
      <p>방 제목: {{ selectedRoomTitle }}</p>
      <p>방 종류: {{ selectedRoomType }}</p>
      <p>최대 인원: {{ selectedRoomMember }}</p>
      <p>가격: {{ numberWithCommas(selectedRoomPrice) }}</p>
    </div>
    <p>Check in: {{ fromDate }}</p>
    <p>Check out: {{ fromDate2 }}</p> -->
    <h1 class="headtxt">Reservation</h1>

    <div class="pay-wrap">
      <div class="pay-cell">
        <div class="title">
          <h3>고객 정보 입력</h3>
        </div>
        <div class="inp-wrap">
          <div class="inp-list">
            <div class="first-inp">
              <input
                  name="name"
                  type="text"
                  placeholder="고객명 (필수)"
                  required
                  v-model="customerName"
              />
              <input
                  name="phoneNumber"
                  type="tel"
                  placeholder="연락처 (필수)"
                  required
                  v-model="phoneNumber"
              />
              <input
                  name="email"
                  type="email"
                  placeholder="이메일 (필수)"
                  required
                  v-model="email"
              />
            </div>
            <div class="want">
              <input name="notice" placeholder="요청사항" type="text" />
            </div>
          </div>

          <div class="rule">
            <div class="rule-head">공식 홈페이지 위약 규정</div>
            <div class="rule-content">
              <p>도착 7일 전 : 전액 환불</p>
              <p>도착 6~2일 전 : 위약 30%</p>
              <p>도착 1일 전 : 위약 50%</p>
              <p>당일 취소 및 미도착 : 환불 불가</p>
            </div>
          </div>

          <div class="agree">
            <div class="title">
              <h3>약관 동의</h3>
            </div>
            <div class="info">
              <div class="infohead">
                <p>개인정보처리방침 동의 <b>(필수)</b></p>
                <label for="privacycheck" class="infocheck">
                  <input
                      type="checkbox"
                      id="privacycheck"
                      required
                      class="infoinp"
                      v-model="info"
                  />
                  동의합니다
                </label>
              </div>
              <div class="info-box">
                소상공인명(은)는 개인정보 보호법 제30조에 따라 정보주체(고객)의
                개인정보를 보호하고 이와 관련한 고충을 신속하고 원활하게 처리할
                수 있도록 하기 위하여 다음과 같이 개인정보 처리지침을
                수립․공개합니다.<br />
                1. 개인정보의 처리목적 소상공인명은(는) 다음의 목적을 위하여
                개인정보를 처리하고 있으며, 다음의 목적 이외의 용도로는 이용하지
                않습니다.<br />
                - 고객 가입의사 확인, 고객에 대한 서비스 제공에 따른 본인
                식별․인증, 회원자격 유지․관리, 물품 또는 서비스 공급에 따른 금액
                결제, 물품 또는 서비스의 공급․배송 등<br />
                2. 개인정보의 처리 및 보유기간 ① 소상공인명은(는) 정보주체로부터
                개인정보를 수집할 때 동의받은 개인정보 보유․이용기간 또는 법령에
                따른 개인정보 보유․이용기간 내에서 개인정보를 처리․보유합니다.
                <br />
                ② 구체적인 개인정보 처리 및 보유 기간은 다음과 같습니다. <br />
                - 고객 가입 및 관리 : 서비스 이용계약 또는 회원가입 해지시까지,
                다만 채권․채무관계 잔존시에는 해당 채권․채무관계 정산시까지
                <br />
                - 전자상거래에서의 계약․청약철회, 대금결제, 재화 등 공급기록 :
                5년 <br />
                3. 개인정보의 제3자 제공 소상공인명은(는) 정보주체의 별도 동의,
                법률의 특별한 규정 등 개인정보 보호법 제17조에 해당하는 경우
                외에는 개인정보를 제3자에게 제공하지 않습니다. <br />
                4. 개인정보처리의 위탁 ① 소상공인명은(는) 원활한 개인정보
                업무처리를 위하여 다음과 같이 개인정보 처리업무를 외부에
                위탁하고 있습니다.<br />
                - A/S 센터 운영 <br />․위탁받는 자 (수탁자) : OO 전자
                <br />․위탁하는 업무의 내용 : 고객 대상 제품 A/S 제공 <br />②
                소상공인명은(는) 위탁계약 체결시 개인정보 보호법 제25조에 따라
                위탁업무 수행목적 외 개인정보 처리금지, 재위탁 제한, 수탁자에
                대한 관리․감독, 책임에 관한 사항을 문서에 명시하고, 수탁자가
                개인정보를 안전하게 처리하는지를 감독하고 있습니다. <br />
              </div>
            </div>
            <div class="info">
              <div class="infohead">
                <p>취소 환불 수수료에 관한 동의 <b>(필수)</b></p>
                <label for="privacycheck" class="infocheck">
                  <input
                      v-model="repay"
                      type="checkbox"
                      id="privacycheck"
                      required
                      class="infoinp"
                  />
                  동의합니다
                </label>
              </div>
              <div class="info-box">
                호텔의 각 상품에 대한 취소/환불 규정 및 수수료 정책은 아래와
                같습니다.<br />
                1. 입장권/이용권을 제외한 상품의 취소/환불 규정 및 수수료 정책
                <br />
                호텔객실 포함 상품, 시설 간 혜택이 결합된 상품 등의 취소 규정은
                아래와 같습니다.<br />
                ㆍ이용 예정일자 당일: 환불불가
                <br />
                ㆍ이용 예정일자 2일 전 15시 이후~1일전 15시 이전: 상품 요금의
                50%를 수수료로 부과<br />
                ㆍ이용 예정일자 1일 전 15시 이후: 홈페이지 상에서의 취소는 불가
                <br />
                - 단, 부득이한 사유로 인한 당일 취소 및 No-Show 발생 시 유선
                연락 바라며 별도의 증빙 서류 미존재 시 상품 요금의 100%를
                수수료로 부과합니다. <br />
                - 홈페이지 내 수수료 부과는 취소수수료 결제 후 예약 시 결제한
                금액을 전액 환불하는 순서로 진행됩니다. <br />
                2. 얼리버드, 슈퍼위크, 일부 프로모션 및 그룹예약링크를 통한
                예약의 취소/환불 규정 및 수수료 정책은 상이하며 이에 대한 상세한
                내역은 해당 상품 상세 페이지의 안내를 우선으로 합니다.<br />
                3. 홈페이지를 통한 결제 상품에 대한 부분 취소 불가 안내 <br />-
                홈페이지를 통하여 결제한 후에는 부분취소(결제한 상품 중 일부
                취소) 및 변경이 불가합니다. <br />- 일부 상품의 취소 및 변경이
                필요한 경우 일괄 취소 후 재결제를 원칙으로 합니다.<br />
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="pay-check">
        <h3 class="checkhead">선택한 객실</h3>
        <div class="checkContent">
          <div class="con-group">
            <h4 class="roomtype" id="tit">{{ selectedRoomTitle }}</h4>
            <ul class="checklist">
              <li>
                <div class="tit">체크인</div>
                <div class="con" id="checkin">{{ checkinDate }}</div>
              </li>
              <li>
                <div class="tit">체크아웃</div>
                <div class="con" id="checkout">{{ checkoutDate }}</div>
              </li>
              <li>
                <div class="tit">숙박일수</div>
                <div class="con">{{ calculateStayDuration() }}박</div>
              </li>
              <li>
                <div class="tit">인원수</div>
                <div class="con">2명</div>
              </li>
              <li>
                <div class="tit">객실타입</div>
                <div class="con">{{ selectedRoomType }}</div>
              </li>
            </ul>
          </div>
          <div class="con-group">
            <h4 class="tw-tit">객실/패키지</h4>
            <div class="img-wrap">
              <img :src="roomImageData" style="width: 253px" alt="객실 이미지" />
            </div>
            <ul>
              <li>
                <div class="con con2">
                  {{ numberWithCommas(selectedRoomPrice) }} 원
                </div>
              </li>
            </ul>
          </div>

          <div class="con-price">
            <ul class="price-final">
              <li>
                <div class="tit">
                  <p class="titsub">
                    합계 금액 <br />
                    (VAT포함)
                  </p>
                </div>
                <div class="con">
                  <strong id="price"
                  >{{ numberWithCommas(selectedRoomPrice) }} <b>원</b></strong
                  >
                </div>
              </li>
              <li></li>
            </ul>
          </div>
        </div>
        <button @click="KGpay" class="payment">예약 및 결제하기</button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";


export default {
  data() {
    return {
      customerName: "",
      phoneNumber: "",
      email: "",
      info: false,
      repay: false,
      // 나머지 입력값에 대한 데이터도 추가할 수 있습니다.
    };
  },
  methods: {
    calculateStayDuration() {
      // 체크인 날짜와 체크아웃 날짜를 받아옵니다.
      const checkinDate = new Date(this.checkinDate);
      const checkoutDate = new Date(this.checkoutDate);

      // 밀리초로 변환 후 일수 차이를 계산합니다.
      const millisecondsPerDay = 1000 * 60 * 60 * 24;
      const differenceInTime = checkoutDate.getTime() - checkinDate.getTime();
      const stayDuration = Math.ceil(differenceInTime / millisecondsPerDay);

      // 일수를 반환합니다.
      return stayDuration;
    },
    numberWithCommas(x) {
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    KGpay: function () {
      if (!this.customerName || !this.phoneNumber || !this.email) {
        alert("고객 정보를 모두 입력해주세요.");
        return;
      }
      if (!this.info || !this.repay) {
        alert("약관 동의에 체크해주세요");
        return;
      }
      var IMP = window.IMP; // 생략 가능
      var name2 = document.getElementById("tit").innerText;

      IMP.init("imp37045634");
      // IMP.request_pay(param, callback) 결제창 호출
      IMP.request_pay(
          {
            // param
            pg: "html5_inicis",
            pay_method: "card",
            merchant_uid: "merchant_" + new Date().getTime(),
            name: name2,
            amount: 1000,
            buyer_email: this.email,
            buyer_name: this.nickname,
          },
          (rsp) => {
            // callback
            if (rsp.success) {
              console.log(rsp.success);
              console.log(rsp);
              // 결제 성공 시 로직,
            } else {
              // 결제 실패 시 로직,
              console.log("실패");
            }
          }
      );
    },
  },
  computed: {
    // Vuex store에 저장된 데이터를 computed 속성에 추가
    ...mapState(["selectedRoomData"]),
    ...mapState(["roomImages"]),
    ...mapState(["fromDate", "fromDate2"]),
    ...mapState(["checkinDate", "checkoutDate"]),
    // 저장된 데이터에서 필요한 정보를 추출하는 computed 속성 정의
    selectedRoomTitle() {
      return this.selectedRoomData ? this.selectedRoomData.title : "";
    },
    selectedRoomType() {
      return this.selectedRoomData ? this.selectedRoomData.type : "";
    },
    selectedRoomMember() {
      return this.selectedRoomData ? this.selectedRoomData.member : "";
    },
    selectedRoomPrice() {
      return this.selectedRoomData ? this.selectedRoomData.price : "";
    },
    roomImageData() {
      return this.$store.state.selectedRoomImageData;
    },
  },
};
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  border: 0;
  box-sizing: border-box;
}
.payment {
  width: 100%;
  height: 50px;
  cursor: pointer;
  background-color: #d4af37;
}
.payment:hover {
  background-color: #e0ba3a;
}
.price-final li {
  display: flex;
  justify-content: space-between;
}
.con strong {
  font-size: 25px;
}
.con b {
  font-size: 14px;
}
.titsub {
  font-size: 14px;
}
.con-price {
  padding: 15px 20px;
}
.con2 {
  text-align: right;
}
ul {
  list-style: none;
}
.tit,
.con {
  font-size: 14px;
}
.tw-tit {
  font-size: 15px;
  font-weight: 500;
  color: #333;
  text-align: left;
  margin-bottom: 10px;
}
.checklist li {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}
.con-group .roomtype {
  text-align: right;
  font-size: 16px;
}
.con-group {
  padding: 18px 0;
  border-bottom: 1px solid #dfdfdf;
}
.checkContent {
  padding: 0 20px;
  border-bottom: 1px solid #8e9090;
}
.checkhead {
  font-size: 16px;
  font-weight: 500;
  overflow: hidden;
  padding: 20px;
  border-bottom: 1px solid #8e9090;
}
.pay-check {
  height: 100%;
  width: 25%;
  margin-left: 10px;
  background: #fff;
  border: 1px solid #858787;
  border-top: 4px solid #26252b;
}
.infoinp {
  border: 1px solid rgb(221, 221, 221);
  cursor: pointer;
  margin-right: 8px;
}
.infohead {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.infocheck {
  color: rgb(136, 136, 136);
  display: flex;
  align-items: center;
  cursor: pointer;
  font-size: 14px;
}
.info-box {
  font-size: 14px;
  color: rgb(102, 102, 102);
  border: 1px solid rgb(221, 221, 221);
  padding: 20px;
  margin-bottom: 16px;
  overflow-y: scroll;
  line-height: 1.6;
  background: rgb(247, 247, 247);
  height: 130px;
  margin-top: 10px;
}
.info {
  margin-top: 25px;
}
.info p {
  font-size: 14px;
}
.info b {
  font-size: 14px;
  color: red;
}
.rule-content {
  padding: 20px 25px;
}
.rule-content p {
  color: #666;
  font-size: 14px;
  line-height: 1.7em;
}
.rule-head {
  font-size: 16px;
  padding: 18px 25px;
  color: #323232;
  font-weight: 700;
  border-bottom: 1px solid #e5e5e5;
}
.rule {
  width: 100%;
  margin-bottom: 25px;
  background: #fbfbfb;
  border: 1px solid #eaeaea;
  text-align: left;
  margin-top: 25px;
}
.want input {
  width: 100%;
}
.first-inp {
  display: flex;
  justify-content: space-between;
  margin-bottom: 16px;
}
.first-inp input {
  width: 33%;
}
input {
  font-size: 15px;
  border: 1px solid #cccccc;
  height: 40px;
  padding: 8px 15px;
}
.inp-list {
  padding: 20px;
  border-bottom: 1px solid #e5e5e5;
  margin-bottom: 12px;
}
.inp-wrap {
  border-top: 3px solid #26252b;
  margin-bottom: 40px;
  padding-top: 10px;
}
.title {
  overflow: hidden;
}
.agree .title {
  border-bottom: 3px solid #26252b;
}
.headtxt {
  text-align: center;
  font-size: 38px;
  font-weight: bold;
  margin-bottom: 10px;
  margin-top: 85px;
}
.pay-wrap {
  display: flex;
  width: 1260px;
  margin: 0px auto;
  padding: 80px 35px 0px;
}
.pay-cell {
  background-color: white;
  font-size: 16px;
  font-weight: 500;
  margin-bottom: 30px;
  width: 75%;
  padding: 40px;
}
.pay-cell h3 {
  font-family: "Noto Sans KR", sans-serif;
  font-size: 20px;
  color: #323232;
  text-align: left;
  font-weight: 700;
  float: left;
  margin-bottom: 12px;
}
</style>
