<script setup>
//import HelloWorld from './components/HelloWorld.vue'
//import TheWelcome from './components/TheWelcome.vue'
//import MyWebpage from './components/MyWebpage.vue';
//import Reservation from './components/Reservation.vue';
import { ref } from 'vue';
import Login from './components/Login.vue';
import Reservation from './components/Reservation.vue';
// Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css'
// Bootstrap JS
import 'bootstrap/dist/js/bootstrap.bundle.min.js'

const isLoggedIn = ref(!!localStorage.getItem("access_token"));

function handleLoginSuccess(token) {
  localStorage.setItem("access_token", token);
  isLoggedIn.value = true;
}
</script>

<template>
  <header>
    <img
      alt="Vue logo"
      class="logo"
      src="./assets/logo.svg"
      width="125"
      height="125"
    />
  </header>
  <main>
    <Login v-if="!isLoggedIn" @login-success="handleLoginSuccess"/>
    <Reservation v-else />
  </main>
</template>

<style scoped>
header {
  line-height: 1.5;
}

.logo {
  display: block;
  margin: 0 auto 2rem;
}

@media (min-width: 1024px) {
  header {
    display: flex;
    place-items: center;
    padding-right: calc(var(--section-gap) / 2);
  }

  .logo {
    margin: 0 2rem 0 0;
  }

  header .wrapper {
    display: flex;
    place-items: flex-start;
    flex-wrap: wrap;
  }
}
</style>
