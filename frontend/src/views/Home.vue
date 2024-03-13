<template>
  <body class="scroll-bar">
    <div class="jumbotron-container">
      <div class="jumbotron-left">
        <h2 class="jumbotron-header">
          Discover the perfect balance <br />
          of hospitality, luxury and <br />comfort.
        </h2>
        <p>
          We are focused on providing clients with the highest level<br />
          of comfort and excellent affordable rates
        </p>
        <a
          href="https://timbu.com/search?query=hotel"
          class="btn btn-fill btn-large"
          >Book Now</a
        >
      </div>
      <div class="jumbotron-right">
        <form action="" class="jumbotron-form">
          <!-- Put the form here -->
          <h3>Scared you can't afford it?</h3>
          <br />
          <p>
            Don't worry, our hotel offers the best<br />
            affordable rates you can ever find.
          </p>
          <label class="hide" for="arrival">arrival date</label>
          <input
            type="text"
            id="arrival"
            name="arrival_date"
            placeholder="Arrival Date"
            onfocus="(this.type='date')"
          /><br />
          <label class="hide" for="departure">departure date</label>
          <input
            type="text"
            id="departure"
            name="departure_date"
            placeholder="Departure Date"
            onfocus="(this.type='date')"
          /><br />
          <label class="hide" for="guests">how many guests</label>
          <input
            type="text"
            id="guests"
            name="guests"
            placeholder="Guests"
          /><br />
          <label class="hide" for="children">children</label>
          <input
            type="text"
            id="children"
            name="children"
            placeholder="Children"
          /><br />
          <button type="button" class="rates">CHECK RATES</button>
        </form>
      </div>
    </div>

    <!-- Enjoy your stay in our hotel -->
    <div class="enjoy-container">
      <div class="enjoy-header">
        <h2 class="enjoy-heading">Enjoy your stay <br />at our hotel</h2>
        <hr class="horizontal" />
        <p>
          We are more than being a hotel because we are able<br />
          to combine the quality standard of a hotel with the<br />
          advantages of an apartment.
        </p>
      </div>
      <div class="enjoy-services">
        <div class="first-col">
          <div class="upper">
            <span>
              <img
                src="../assets/img/clock.svg"
                alt="clock icon"
                class="enjoy__clock-icon"
              />
            </span>
            <h3>24 hours Room Service</h3>
            <p>You have access to 24-hours a day room service at our hotel.</p>
          </div>
          <div class="lower">
            <span>
              <img
                src="../assets/img/database.svg"
                alt="fitness icon"
                class="enjoy__fitness-icon"
              />
            </span>
            <h3>Fitness and Spa</h3>
            <p>
              Access to fitness and Spa is part of our hotel package when you
              make a booking.
            </p>
          </div>
        </div>
        <div class="sec-col">
          <div class="upper">
            <span>
              <img
                src="../assets/img/coffee.svg"
                alt="coffee icon"
                class="enjoy__coffee-icon"
              />
            </span>
            <h3>Restaurant and Bars</h3>
            <p>
              You have access to the world state of art restaurants and bars at
              our hotel
            </p>
          </div>
          <div class="lower">
            <span>
              <img
                src="../assets/img/wifi.svg"
                alt="wifi icon"
                class="enjoy__wifi-icon"
              />
            </span>
            <h3>Free Wi-Fi Access</h3>
            <p>
              You have access to 24-hours free Wi-Fi services irrespective of
              any room.
            </p>
          </div>
        </div>
        <div class="third-col cont">
          <img
            src="../assets/img/ant-design_play-circle-filled.svg"
            alt="video play icon"
            class="enjoy__play-icon"
          />
          <img
            src="../assets/img/video link.webp"
            alt="women in swimming pool"
            class="third-col-video"
          />
        </div>
      </div>
    </div>
    <section class="special-offers">
      <!-- Top Text -->
      <div class="page-header-container">
        <h2 class="page-header">Simplicity is the ultimate <br />Watchword</h2>
      </div>
      <div class="row center-lg">
        <div class="col image-col right-marg">
          <img
            src="../assets/img/hotel-1.webp"
            alt="room-image"
            class="small-image"
          />
          <img
            src="../assets/img/hotel-2.webp"
            alt="room-image"
            class="small-image"
          />
          <img
            src="../assets/img/hotel-3.webp"
            alt="room-image"
            class="small-image img-hide"
          />
          <div class="side-by-side-container">
            <div class="large-image-container">
              <img
                src="../assets/img/hotel-4-large.webp"
                alt="room-image-large"
                class="large-image"
              />
            </div>
            <section class="stacked-image-container">
              <div>
                <img
                  src="../assets/img/hotel-5.webp"
                  alt="room-image"
                  class="small-image"
                />
              </div>
              <div>
                <img
                  src="../assets/img/hotel-6.webp"
                  alt="room-image"
                  class="small-image"
                />
              </div>
            </section>
          </div>
        </div>
        <div class="col">
          <p class="offers-sub-title">
            The fact that we are run by hospitality professionals<br />and
            equipped with the world best interior designers <br />
            is why our rooms and suites are second to none in <br />the universe
          </p>
          <ul class="offers-list">
            <li>
              <div>
                <img
                  src="../assets/img/check-square.svg"
                  alt="tick"
                  class="list-icon"
                />
                <p class="list-text">Standard Room</p>
              </div>
            </li>
            <li>
              <div>
                <img
                  src="../assets/img/check-square.svg"
                  alt="tick"
                  class="list-icon"
                />
                <p class="list-text">Executive Room</p>
              </div>
            </li>
            <li>
              <div>
                <img
                  src="../assets/img/check-square.svg"
                  alt="tick"
                  class="list-icon"
                />
                <p class="list-text">King Suite</p>
              </div>
            </li>
          </ul>
          <a
            href="https://timbu.com/search?query=hotel"
            class="btn btn-fill btn-large centered"
            >Book Now</a
          >
        </div>
      </div>
    </section>

    <!-- Client Reviews -->
    <div class="review-container">
      <div class="review-header">
        <h2 class="review-title">Client Reviews</h2>
        <hr class="horizontal" />
        <p class="">
          We are very proud of the services we offer to our customers.<br />Read
          every word from our happy customers.
        </p>
      </div>
      <div class="cards-container">
        <div class="card">
          <img src="../assets/img/customer1.webp" alt="" class="card-avi" />
          <h2 class="card-title">Mark Essien</h2>
          <h3 class="card-subtitle">Lagos, Nigeria.</h3>
          <p class="card-desc">
            Words can't explain the kind of treatment I received from the
            management of star hotels. They are the best in the country.
          </p>
        </div>
        <div class="card">
          <img src="../assets/img/customer2.webp" alt="" class="card-avi" />
          <h2 class="card-title">Seyi Onifade</h2>
          <h3 class="card-subtitle">Lagos, Nigeria.</h3>
          <p class="card-desc">
            Star hotels makes you feel the best room quality that makes you feel
            the comfort of a home.
          </p>
        </div>
        <div class="card">
          <img src="../assets/img/customer3.webp" alt="" class="card-avi" />
          <h2 class="card-title">Fayemi David</h2>
          <h3 class="card-subtitle">Lagos, Nigeria.</h3>
          <p class="card-desc">
            My Family and I are very happy when we lodge into star hotels. They
            are by far the best in the universe.
          </p>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
export default {};
</script>

<style scoped>
* {
  font-family: "Source Sans Pro";
}

/*Loader*/
#loader {
  background-color: #fff;
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100vh;
  z-index: 9999;
  display: flex;
  justify-content: center;
  align-items: center;
  transition: ease;
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

.horizontal {
  width: 10%;
  margin: 1em 0 2em 0;
  height: 1px;
  background-color: #d4af37;
  border: none;
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

.large-image {
  height: 227px;
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
  padding: 0 150px 0 0;
}

.page-header:after {
  display: block;
  height: 1px;
  background-color: #d4af37;
  content: "";
  width: 90px;
  margin: 0.5em auto 0 auto;
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
}

.jumbotron-left {
  flex: 3;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  padding-left: 10%;
  /* border: 1px solid white; */
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

  .horizontal {
    margin: 1em auto 2em auto;
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
